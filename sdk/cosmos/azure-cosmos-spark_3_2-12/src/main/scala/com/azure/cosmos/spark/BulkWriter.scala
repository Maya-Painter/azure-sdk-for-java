// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.cosmos.spark

// scalastyle:off underscore.import
import com.azure.cosmos.{BridgeInternal, CosmosAsyncContainer, CosmosException}
import com.azure.cosmos.implementation.apachecommons.lang.StringUtils
import com.azure.cosmos.implementation.batch.{BatchRequestResponseConstants, ItemBulkOperation}
import com.azure.cosmos.models._
import com.azure.cosmos.spark.BulkWriter.{BulkOperationFailedException, bulkWriterBoundedElastic, getThreadInfo, readManyBoundedElastic}
import com.azure.cosmos.spark.diagnostics.DefaultDiagnostics
import reactor.core.publisher.Mono
import reactor.core.scheduler.Scheduler

import java.util
import scala.collection.concurrent.TrieMap
import scala.collection.convert.ImplicitConversions.`collection AsScalaIterable`
import scala.collection.mutable
import scala.concurrent.duration.Duration
// scalastyle:on underscore.import
import com.azure.cosmos.implementation.ImplementationBridgeHelpers
import com.azure.cosmos.implementation.guava25.base.Preconditions
import com.azure.cosmos.implementation.spark.{OperationContextAndListenerTuple, OperationListener}
import com.azure.cosmos.models.PartitionKey
import com.azure.cosmos.spark.BulkWriter.{DefaultMaxPendingOperationPerCore, emitFailureHandler}
import com.azure.cosmos.spark.diagnostics.{DiagnosticsContext, DiagnosticsLoader, LoggerHelper, SparkTaskContext}
import com.fasterxml.jackson.databind.node.ObjectNode
import org.apache.spark.TaskContext
import reactor.core.Disposable
import reactor.core.publisher.Sinks
import reactor.core.publisher.Sinks.{EmitFailureHandler, EmitResult}
import reactor.core.scala.publisher.SMono.PimpJFlux
import reactor.core.scala.publisher.{SFlux, SMono}
import reactor.core.scheduler.Schedulers

import java.util.UUID
import java.util.concurrent.atomic.{AtomicBoolean, AtomicInteger, AtomicLong, AtomicReference}
import java.util.concurrent.locks.ReentrantLock
import java.util.concurrent.{Semaphore, TimeUnit}
// scalastyle:off underscore.import
import scala.collection.JavaConverters._
// scalastyle:on underscore.import

//scalastyle:off null
//scalastyle:off multiple.string.literals
//scalastyle:off file.size.limit
class BulkWriter(container: CosmosAsyncContainer,
                 partitionKeyDefinition: PartitionKeyDefinition,
                 writeConfig: CosmosWriteConfig,
                 diagnosticsConfig: DiagnosticsConfig)
  extends AsyncItemWriter {

  private val log = LoggerHelper.getLogger(diagnosticsConfig, this.getClass)

  // TODO: moderakh add a mocking unit test for Bulk where CosmosClient is mocked to simulator failure/retry scenario

  // TODO: moderakh this requires tuning.
  // TODO: moderakh should we do a max on the max memory to ensure we don't run out of memory?
  private val cpuCount = SparkUtils.getNumberOfHostCPUCores
  // each bulk writer allows up to maxPendingOperations being buffered
  // there is one bulk writer per spark task/partition
  // and default config will create one executor per core on the executor host
  // so multiplying by cpuCount in the default config is too aggressive
  private val maxPendingOperations = writeConfig.bulkMaxPendingOperations
    .getOrElse(DefaultMaxPendingOperationPerCore)
  private val maxConcurrentPartitions = writeConfig.maxConcurrentCosmosPartitions match {
    // using the provided maximum of concurrent partitions per Spark partition on the input data
    // multiplied by 2 to leave space for partition splits during ingestion
    case Some(configuredMaxConcurrentPartitions) => 2 * configuredMaxConcurrentPartitions
    // using the total number of physical partitions
    // multiplied by 2 to leave space for partition splits during ingestion
    case None => 2 * ContainerFeedRangesCache.getFeedRanges(container).block().size
  }
  log.logInfo(
    s"BulkWriter instantiated (Host CPU count: $cpuCount, maxPendingOperations: $maxPendingOperations, " +
  s"maxConcurrentPartitions: $maxConcurrentPartitions ...")

  private val closed = new AtomicBoolean(false)
  private val lock = new ReentrantLock
  private val pendingTasksCompleted = lock.newCondition
  private val pendingRetries = new AtomicLong(0)
  private val activeTasks = new AtomicInteger(0)
  private val errorCaptureFirstException = new AtomicReference[Throwable]()
  private val bulkInputEmitter: Sinks.Many[CosmosItemOperation] = Sinks.many().unicast().onBackpressureBuffer()

  // TODO: fabianm - remove this later
  // Leaving activeOperations here primarily for debugging purposes (for example in case of hangs)
  private val activeBulkWriteOperations = java.util.concurrent.ConcurrentHashMap.newKeySet[CosmosItemOperation]().asScala
  private val activeReadManyOperations = java.util.concurrent.ConcurrentHashMap.newKeySet[ReadManyOperation]().asScala
  private val semaphore = new Semaphore(maxPendingOperations)

  private val totalScheduledMetrics = new AtomicLong(0)
  private val totalSuccessfulIngestionMetrics = new AtomicLong(0)

  private val cosmosBulkExecutionOptions = ImplementationBridgeHelpers.CosmosBulkExecutionOptionsHelper
    .getCosmosBulkExecutionOptionsAccessor
    .setMaxConcurrentCosmosPartitions(
      new CosmosBulkExecutionOptions(BulkWriter.bulkProcessingThresholds),
      maxConcurrentPartitions
    )
  ThroughputControlHelper.populateThroughputControlGroupName(cosmosBulkExecutionOptions, writeConfig.throughputControlConfig)

  writeConfig.maxMicroBatchPayloadSizeInBytes match {
    case Some(customMaxMicroBatchPayloadSizeInBytes) =>
      ImplementationBridgeHelpers.CosmosBulkExecutionOptionsHelper
        .getCosmosBulkExecutionOptionsAccessor
        .setMaxMicroBatchPayloadSizeInBytes(
          cosmosBulkExecutionOptions,
          customMaxMicroBatchPayloadSizeInBytes
        )
    case None =>
  }

  writeConfig.initialMicroBatchSize match {
    case Some(customInitialMicroBatchSize) =>
      ImplementationBridgeHelpers.CosmosBulkExecutionOptionsHelper
        .getCosmosBulkExecutionOptionsAccessor
        .setInitialMicroBatchSize(
          cosmosBulkExecutionOptions,
          customInitialMicroBatchSize
        )
    case None =>
  }

  private val operationContext = initializeOperationContext()
  private val cosmosPatchHelperOpt = writeConfig.itemWriteStrategy match {
    case ItemWriteStrategy.ItemPatch | ItemWriteStrategy.ItemBulkUpdate =>
        Some(new CosmosPatchHelper(diagnosticsConfig, writeConfig.patchConfigs.get))
    case _ => None
  }
  private val readManyInputEmitterOpt: Option[Sinks.Many[ReadManyOperation]] = {
      writeConfig.itemWriteStrategy match {
          case ItemWriteStrategy.ItemBulkUpdate => Some(Sinks.many().unicast().onBackpressureBuffer())
          case _ => None
      }
  }

    private def initializeOperationContext(): SparkTaskContext = {
    val taskContext = TaskContext.get

    val diagnosticsContext: DiagnosticsContext = DiagnosticsContext(UUID.randomUUID(), "BulkWriter")

    if (taskContext != null) {
      val taskDiagnosticsContext = SparkTaskContext(diagnosticsContext.correlationActivityId,
        taskContext.stageId(),
        taskContext.partitionId(),
        taskContext.taskAttemptId(),
        "")

      val listener: OperationListener =
        DiagnosticsLoader.getDiagnosticsProvider(diagnosticsConfig).getLogger(this.getClass)

      val operationContextAndListenerTuple = new OperationContextAndListenerTuple(taskDiagnosticsContext, listener)
      ImplementationBridgeHelpers.CosmosBulkExecutionOptionsHelper
        .getCosmosBulkExecutionOptionsAccessor
        .setOperationContext(cosmosBulkExecutionOptions, operationContextAndListenerTuple)

      taskDiagnosticsContext
    } else{
      SparkTaskContext(diagnosticsContext.correlationActivityId,
        -1,
        -1,
        -1,
        "")
    }
  }

  private val readManySubscriptionDisposableOpt: Option[Disposable] = {
      writeConfig.itemWriteStrategy match {
          case ItemWriteStrategy.ItemBulkUpdate => Some(createReadManySubscriptionDisposable())
          case  _ => None
      }
  }

  private def createReadManySubscriptionDisposable(): Disposable = {
      log.logTrace(s"readManySubscriptionDisposable, Context: ${operationContext.toString} ${getThreadInfo}")

      // We start from using the bulk batch size and interval and concurrency
      // If in the future, there is a need to separate the configuration, can re-consider
      val bulkBatchSize = BatchRequestResponseConstants.MAX_OPERATIONS_IN_DIRECT_MODE_BATCH_REQUEST

      val batchInterval = ImplementationBridgeHelpers
          .CosmosBulkExecutionOptionsHelper
          .getCosmosBulkExecutionOptionsAccessor
          .getMaxMicroBatchInterval(cosmosBulkExecutionOptions)
      val batchConcurrency = ImplementationBridgeHelpers
          .CosmosBulkExecutionOptionsHelper
          .getCosmosBulkExecutionOptionsAccessor
          .getMaxMicroBatchConcurrency(cosmosBulkExecutionOptions)

      readManyInputEmitterOpt
          .get
          .asFlux()
          .publishOn(readManyBoundedElastic)
          .bufferTimeout(bulkBatchSize, batchInterval)
          .subscribeOn(readManyBoundedElastic)
          .asScala
          .flatMap(readManyOperations => {

              if (readManyOperations.isEmpty) {
                  Mono.empty()
              } else {
                  val cosmosIdentitySet = readManyOperations.map(option => option.cosmosItemIdentity).toSet

                  // for each batch, use readMany to read items from cosmosdb
                  val requestOptions = new CosmosQueryRequestOptions()
                  ThroughputControlHelper.populateThroughputControlGroupName(requestOptions, writeConfig.throughputControlConfig)
                  ImplementationBridgeHelpers
                      .CosmosAsyncContainerHelper
                      .getCosmosAsyncContainerAccessor
                      .readMany(container, cosmosIdentitySet.toList.asJava, requestOptions, classOf[ObjectNode])
                      .switchIfEmpty(
                          // For Java SDK, empty pages will not be returned (this can happen when all the items does not exists yet)
                          // create a fake empty page response
                          Mono.just(
                              ImplementationBridgeHelpers
                                  .FeedResponseHelper
                                  .getFeedResponseAccessor
                                  .createFeedResponse(new util.ArrayList[ObjectNode](), null, null)))
                      .doOnNext(feedResponse => {
                          val resultMap = new TrieMap[CosmosItemIdentity, ObjectNode]()
                          for (itemNode: ObjectNode <- feedResponse.getResults.asScala) {
                              resultMap += (
                                  new CosmosItemIdentity(
                                      PartitionKeyHelper.getPartitionKeyPath(itemNode, partitionKeyDefinition),
                                      itemNode.get(CosmosConstants.Properties.Id).asText()) -> itemNode)
                          }

                          // It is possible that multiple cosmosPatchBulkUpdateOperations were targeting for the same item
                          // Currently, we are still creating one bulk item operation for each cosmosPatchBulkUpdateOperations
                          // for easier exception and semaphore handling
                          // However a consequences of it could be, the generated bulk item operation will fail due to conflicts or pre-condition failure
                          // If this turns out to be a problem, we can do more optimization here: merge multiple cosmosPatchBulkUpdateOperations into one bulkItemOperation
                          // But even the above approach can only work within the same batch but not for the whole spark partition processing.
                          for (readManyOperation <- readManyOperations) {
                              val cosmosPatchBulkUpdateOperations =
                                  cosmosPatchHelperOpt
                                      .get
                                      .createCosmosPatchBulkUpdateOperations(readManyOperation.objectNode)

                              val rootNode =
                                  cosmosPatchHelperOpt
                                      .get
                                      .patchBulkUpdateItem(resultMap.get(readManyOperation.cosmosItemIdentity), cosmosPatchBulkUpdateOperations)

                              // create bulk item operation
                              val etagOpt = Option.apply(rootNode.get(CosmosConstants.Properties.ETag))
                              val bulkItemOperation = etagOpt match {
                                  case Some(etag) =>
                                      CosmosBulkOperations.getReplaceItemOperation(
                                          readManyOperation.cosmosItemIdentity.getId,
                                          rootNode,
                                          readManyOperation.cosmosItemIdentity.getPartitionKey,
                                          new CosmosBulkItemRequestOptions().setIfMatchETag(etag.asText()),
                                          OperationContext(
                                              readManyOperation.operationContext.itemId,
                                              readManyOperation.operationContext.partitionKeyValue,
                                              Some(etag.asText()),
                                              readManyOperation.operationContext.attemptNumber,
                                              Some(readManyOperation.objectNode)
                                          ))
                                  case None => CosmosBulkOperations.getCreateItemOperation(
                                      rootNode,
                                      readManyOperation.cosmosItemIdentity.getPartitionKey,
                                      OperationContext(
                                          readManyOperation.operationContext.itemId,
                                          readManyOperation.operationContext.partitionKeyValue,
                                          eTag = None,
                                          readManyOperation.operationContext.attemptNumber,
                                          Some(readManyOperation.objectNode)
                                      ))
                              }

                              this.emitBulkInput(bulkItemOperation)
                          }
                      })
                      .onErrorResume(throwable => {
                          for (readManyOperation <- readManyOperations) {
                              handleReadManyExceptions(throwable, readManyOperation)
                          }

                          Mono.empty()
                      })
                      .doFinally(signalType => {
                          for (readManyOperation <- readManyOperations) {
                              activeReadManyOperations.remove(readManyOperation)
                              // for ItemBulkUpdate strategy, each active task includes two stages: ReadMany + BulkWrite
                              // so we are not going to make task complete here
                          }
                      })
                      .`then`(Mono.empty())
              }
          }, batchConcurrency)
          .subscribe()
  }

  private def handleReadManyExceptions(throwable: Throwable, ReadManyOperation: ReadManyOperation): Unit = {
      throwable match {
          case e: CosmosException =>
              val requestOperationContext = ReadManyOperation.operationContext
              if (shouldRetry(e.getStatusCode, e.getSubStatusCode, requestOperationContext)) {
                  log.logWarning(s"for itemId=[${requestOperationContext.itemId}], partitionKeyValue=[${requestOperationContext.partitionKeyValue}], " +
                      s"encountered status code '${e.getStatusCode}:${e.getSubStatusCode}' in read many, will retry! " +
                      s"attemptNumber=${requestOperationContext.attemptNumber}, exceptionMessage=${e.getMessage},  " +
                      s"Context: {${operationContext.toString}} ${getThreadInfo}")

                  // the task will be re-queued at the beginning of the flow, so mark it complete here
                  markTaskCompletion()

                  this.scheduleRetry(
                      ReadManyOperation.cosmosItemIdentity.getPartitionKey,
                      ReadManyOperation.objectNode,
                      ReadManyOperation.operationContext,
                      e.getStatusCode)

              } else {
                  // Non-retryable exception or has exceeded the max retry count
                  val requestOperationContext = ReadManyOperation.operationContext
                  log.logError(s"for itemId=[${requestOperationContext.itemId}], partitionKeyValue=[${requestOperationContext.partitionKeyValue}], " +
                      s"encountered status code '${e.getStatusCode}:${e.getSubStatusCode()}', all retries exhausted! " +
                      s"attemptNumber=${requestOperationContext.attemptNumber}, exceptionMessage=${e.getMessage}, " +
                      s"Context: {${operationContext.toString} ${getThreadInfo}")

                  val message = s"All retries exhausted for readMany - " +
                      s"statusCode=[${e.getStatusCode}:${e.getSubStatusCode}] " +
                      s"itemId=[${requestOperationContext.itemId}], partitionKeyValue=[${requestOperationContext.partitionKeyValue}]"

                  val exceptionToBeThrown = new BulkOperationFailedException(e.getStatusCode, e.getSubStatusCode, message, e)
                  captureIfFirstFailure(exceptionToBeThrown)
                  cancelWork()
                  markTaskCompletion()
              }
          case _ => // handle non cosmos exceptions
              log.logError(s"Unexpected failure code path in Bulk ingestion readMany stage, " +
                  s"Context: ${operationContext.toString} ${getThreadInfo}", throwable)
              captureIfFirstFailure(throwable)
              cancelWork()
              markTaskCompletion()
      }
  }

  private def scheduleRetry(
                               partitionKey: PartitionKey,
                               objectNode: ObjectNode,
                               operationContext: OperationContext,
                               statusCode: Int): Unit = {
      this.pendingRetries.incrementAndGet();
      // this is to ensure the submission will happen on a different thread in background
      // and doesn't block the active thread
      val deferredRetryMono = SMono.defer(() => {
          scheduleWriteInternal(
              partitionKey,
              objectNode,
              OperationContext(
                  operationContext.itemId,
                  operationContext.partitionKeyValue,
                  operationContext.eTag,
                  operationContext.attemptNumber + 1))
          this.pendingRetries.decrementAndGet()
          SMono.empty
      })

      if (Exceptions.isTimeout(statusCode)) {
          deferredRetryMono
              .delaySubscription(
                  Duration(
                      BulkWriter.minDelayOn408RequestTimeoutInMs +
                          scala.util.Random.nextInt(
                              BulkWriter.maxDelayOn408RequestTimeoutInMs - BulkWriter.minDelayOn408RequestTimeoutInMs),
                      TimeUnit.MILLISECONDS),
                  Schedulers.boundedElastic())
              .subscribeOn(Schedulers.boundedElastic())
              .subscribe()

      } else {
          deferredRetryMono
              .subscribeOn(Schedulers.boundedElastic())
              .subscribe()
      }
  }

  private val subscriptionDisposable: Disposable = {
    log.logTrace(s"subscriptionDisposable, Context: ${operationContext.toString} ${getThreadInfo}")

    val bulkOperationResponseFlux: SFlux[CosmosBulkOperationResponse[Object]] =
      container
          .executeBulkOperations[Object](
            bulkInputEmitter.asFlux().publishOn(bulkWriterBoundedElastic),
            cosmosBulkExecutionOptions)
          .publishOn(bulkWriterBoundedElastic)
          .asScala

    bulkOperationResponseFlux.subscribe(
      resp => {
        val isGettingRetried = new AtomicBoolean(false)
        try {
          val itemOperation = resp.getOperation
          val itemOperationFound = activeBulkWriteOperations.remove(itemOperation)
          assume(itemOperationFound) // can't find the item operation in list of active operations!
          val context = itemOperation.getContext[OperationContext]
          val itemResponse = resp.getResponse

          if (resp.getException != null) {
            Option(resp.getException) match {
              case Some(cosmosException: CosmosException) =>
                handleNonSuccessfulStatusCode(
                  context, itemOperation, itemResponse, isGettingRetried, Some(cosmosException))
              case _ =>
                log.logWarning(
                  s"unexpected failure: itemId=[${context.itemId}], partitionKeyValue=[" +
                    s"${context.partitionKeyValue}], encountered , attemptNumber=${context.attemptNumber}, " +
                    s"exceptionMessage=${resp.getException.getMessage}, " +
                  s"Context: ${operationContext.toString} ${getThreadInfo}", resp.getException)
                captureIfFirstFailure(resp.getException)
                cancelWork()
            }
          } else if (Option(itemResponse).isEmpty || !itemResponse.isSuccessStatusCode) {
            handleNonSuccessfulStatusCode(context, itemOperation, itemResponse, isGettingRetried, None)
          } else {
            // no error case
            totalSuccessfulIngestionMetrics.getAndIncrement()
          }
        }
        finally {
          if (!isGettingRetried.get) {
            semaphore.release()
          }
        }

        markTaskCompletion()
      },
      errorConsumer = Option.apply(
        ex => {
          log.logError(s"Unexpected failure code path in Bulk ingestion, " +
            s"Context: ${operationContext.toString} ${getThreadInfo}", ex)
          // if there is any failure this closes the bulk.
          // at this point bulk api doesn't allow any retrying
          // we don't know the list of failed item-operations
          // they only way to retry to keep a dictionary of pending operations outside
          // so we know which operations failed and which ones can be retried.
          // TODO: moderakh discuss the bulk API in the core SDK.
          // this is currently a kill scenario.
          captureIfFirstFailure(ex)
          cancelWork()
          markTaskCompletion()
        }
      )
    )
  }

  override def scheduleWrite(partitionKeyValue: PartitionKey, objectNode: ObjectNode): Unit = {
    Preconditions.checkState(!closed.get())
    throwIfCapturedExceptionExists()

    var acquisitionAttempt = 0
    val activeTasksSemaphoreTimeout = 10
    val operationContext = OperationContext(getId(objectNode), partitionKeyValue, getETag(objectNode), 1)
    val numberOfIntervalsWithIdenticalActiveOperationSnapshots = new AtomicLong(0)
    // Don't clone the activeOperations for the first iteration
    // to reduce perf impact before the Semaphore has been acquired
    // this means if the semaphore can't be acquired within 10 minutes
    // the first attempt will always assume it wasn't stale - so effectively we
    // allow staleness for ten additional minutes - which is perfectly fine
    var activeOperationsSnapshot = mutable.Set.empty[CosmosItemOperation]
    var activeReadManyOperationsSnapshot = mutable.Set.empty[ReadManyOperation]
    log.logTrace(
      s"Before TryAcquire ${totalScheduledMetrics.get}, Context: ${operationContext.toString} ${getThreadInfo}")
    while (!semaphore.tryAcquire(activeTasksSemaphoreTimeout, TimeUnit.MINUTES)) {
      log.logDebug(s"Not able to acquire semaphore, Context: ${operationContext.toString} ${getThreadInfo}")
      if (subscriptionDisposable.isDisposed ||
          (readManySubscriptionDisposableOpt.isDefined && readManySubscriptionDisposableOpt.get.isDisposed)) {
        captureIfFirstFailure(
          new IllegalStateException("Can't accept any new work - BulkWriter has been disposed already"))
      }

      throwIfProgressStaled(
        "Semaphore acquisition",
        activeOperationsSnapshot,
        activeReadManyOperationsSnapshot,
        numberOfIntervalsWithIdenticalActiveOperationSnapshots)

      activeOperationsSnapshot = activeBulkWriteOperations.clone()
      activeReadManyOperationsSnapshot = activeReadManyOperations.clone()
    }

    val cnt = totalScheduledMetrics.getAndIncrement()
    log.logTrace(s"total scheduled $cnt, Context: ${operationContext.toString} ${getThreadInfo}")

    scheduleWriteInternal(partitionKeyValue, objectNode, operationContext)
  }

  private def scheduleWriteInternal(partitionKeyValue: PartitionKey,
                                    objectNode: ObjectNode,
                                    operationContext: OperationContext): Unit = {
      activeTasks.incrementAndGet()
      if (operationContext.attemptNumber > 1) {
          log.logInfo(s"bulk scheduleWrite attemptCnt: ${operationContext.attemptNumber}, " +
              s"Context: ${operationContext.toString} ${getThreadInfo}")
      }

      // The handling will make sure that during retry:
      // For itemBulkUpdate -> the retry will go through readMany stage -> bulkWrite stage.
      // For other strategies -> the retry will only go through bulk write stage
      writeConfig.itemWriteStrategy match {
          case ItemWriteStrategy.ItemBulkUpdate => scheduleReadManyInternal(partitionKeyValue, objectNode, operationContext)
          case _ => scheduleBulkWriteInternal(partitionKeyValue, objectNode, operationContext)
      }
  }

  private def scheduleReadManyInternal(partitionKeyValue: PartitionKey,
                                       objectNode: ObjectNode,
                                       operationContext: OperationContext): Unit = {

      // For FAIL_NON_SERIALIZED, will keep retry, while for other errors, use the default behavior
      val readManyOperation = ReadManyOperation(new CosmosItemIdentity(partitionKeyValue, operationContext.itemId), objectNode, operationContext)
      activeReadManyOperations.add(readManyOperation)
      readManyInputEmitterOpt.get.emitNext(readManyOperation, emitFailureHandler)
  }

  private def scheduleBulkWriteInternal(partitionKeyValue: PartitionKey,
                                        objectNode: ObjectNode,
                                        operationContext: OperationContext): Unit = {

    val bulkItemOperation = writeConfig.itemWriteStrategy match {
      case ItemWriteStrategy.ItemOverwrite =>
        CosmosBulkOperations.getUpsertItemOperation(objectNode, partitionKeyValue, operationContext)
      case ItemWriteStrategy.ItemOverwriteIfNotModified =>
        operationContext.eTag match {
          case Some(eTag) =>
            CosmosBulkOperations.getReplaceItemOperation(
              operationContext.itemId,
              objectNode,
              partitionKeyValue,
              new CosmosBulkItemRequestOptions().setIfMatchETag(eTag),
              operationContext)
          case _ =>  CosmosBulkOperations.getCreateItemOperation(objectNode, partitionKeyValue, operationContext)
        }
      case ItemWriteStrategy.ItemAppend =>
        CosmosBulkOperations.getCreateItemOperation(objectNode, partitionKeyValue, operationContext)
      case ItemWriteStrategy.ItemDelete =>
        CosmosBulkOperations.getDeleteItemOperation(operationContext.itemId, partitionKeyValue, operationContext)
      case ItemWriteStrategy.ItemDeleteIfNotModified =>
        CosmosBulkOperations.getDeleteItemOperation(
          operationContext.itemId,
          partitionKeyValue,
          operationContext.eTag match {
            case Some(eTag) => new CosmosBulkItemRequestOptions().setIfMatchETag(eTag)
            case _ =>  new CosmosBulkItemRequestOptions()
          },
          operationContext)
      case ItemWriteStrategy.ItemPatch => getPatchItemOperation(operationContext.itemId, partitionKeyValue, partitionKeyDefinition, objectNode, operationContext)
      case _ =>
        throw new RuntimeException(s"${writeConfig.itemWriteStrategy} not supported")
    }

      this.emitBulkInput(bulkItemOperation)
  }

  private[this] def emitBulkInput(bulkItemOperation: CosmosItemOperation): Unit = {
      activeBulkWriteOperations.add(bulkItemOperation)
      // For FAIL_NON_SERIALIZED, will keep retry, while for other errors, use the default behavior
      bulkInputEmitter.emitNext(bulkItemOperation, emitFailureHandler)
  }

  private[this] def getPatchItemOperation(itemId: String,
                                          partitionKey: PartitionKey,
                                          partitionKeyDefinition: PartitionKeyDefinition,
                                          objectNode: ObjectNode,
                                          context: OperationContext): CosmosItemOperation = {

    assert(writeConfig.patchConfigs.isDefined)
    assert(cosmosPatchHelperOpt.isDefined)
    val patchConfigs = writeConfig.patchConfigs.get
    val cosmosPatchHelper = cosmosPatchHelperOpt.get

    val cosmosPatchOperations = cosmosPatchHelper.createCosmosPatchOperations(itemId, partitionKeyDefinition, objectNode)

    val requestOptions = new CosmosBulkPatchItemRequestOptions()
    if (patchConfigs.filter.isDefined && !StringUtils.isEmpty(patchConfigs.filter.get)) {
      requestOptions.setFilterPredicate(patchConfigs.filter.get)
    }

    CosmosBulkOperations.getPatchItemOperation(itemId, partitionKey, cosmosPatchOperations, requestOptions, context)
  }

  //scalastyle:off method.length
  //scalastyle:off cyclomatic.complexity
  private[this] def handleNonSuccessfulStatusCode
  (
    context: OperationContext,
    itemOperation: CosmosItemOperation,
    itemResponse: CosmosBulkItemResponse,
    isGettingRetried: AtomicBoolean,
    responseException: Option[CosmosException]
  ) : Unit = {

    val exceptionMessage = responseException match {
      case Some(e) => e.getMessage
      case None => ""
    }

    val effectiveStatusCode = Option(itemResponse) match {
      case Some(r) => r.getStatusCode
      case None => responseException match {
        case Some(e) => e.getStatusCode
        case None => CosmosConstants.StatusCodes.Timeout
      }
    }

    val effectiveSubStatusCode = Option(itemResponse) match {
      case Some(r) => r.getSubStatusCode
      case None => responseException match {
        case Some(e) => e.getSubStatusCode
        case None => 0
      }
    }

    log.logDebug(s"encountered item operation response with status code " +
      s"$effectiveStatusCode:$effectiveSubStatusCode, " +
      s"Context: ${operationContext.toString} ${getThreadInfo}")
    if (shouldIgnore(effectiveStatusCode, effectiveSubStatusCode, context)) {
      log.logDebug(s"for itemId=[${context.itemId}], partitionKeyValue=[${context.partitionKeyValue}], " +
        s"ignored encountered status code '$effectiveStatusCode:$effectiveSubStatusCode', " +
        s"Context: ${operationContext.toString}")
      totalSuccessfulIngestionMetrics.getAndIncrement()
      // work done
    } else if (shouldRetry(effectiveStatusCode, effectiveSubStatusCode, context)) {
      // requeue
      log.logWarning(s"for itemId=[${context.itemId}], partitionKeyValue=[${context.partitionKeyValue}], " +
        s"encountered status code '$effectiveStatusCode:$effectiveSubStatusCode', will retry! " +
        s"attemptNumber=${context.attemptNumber}, exceptionMessage=${exceptionMessage},  " +
        s"Context: {${operationContext.toString}} ${getThreadInfo}")

      // If the write strategy is patchBulkUpdate, the OperationContext.sourceItem will not be the original objectNode,
      // It is computed through read item from cosmosdb, and then patch the item locally.
      // During retry, it is important to use the original objectNode (for example for preCondition failure, it requires to go through the readMany step again)
      val sourceItem = itemOperation match {
          case _: ItemBulkOperation[ObjectNode, OperationContext] =>
              context.sourceItem match {
                  case Some(bulkOperationSourceItem) => bulkOperationSourceItem
                  case None => itemOperation.getItem.asInstanceOf[ObjectNode]
              }
          case _ => itemOperation.getItem.asInstanceOf[ObjectNode]
      }

      this.scheduleRetry(itemOperation.getPartitionKeyValue, sourceItem, context, effectiveStatusCode)
      isGettingRetried.set(true)
    } else {
      log.logError(s"for itemId=[${context.itemId}], partitionKeyValue=[${context.partitionKeyValue}], " +
        s"encountered status code '$effectiveStatusCode:$effectiveSubStatusCode', all retries exhausted! " +
        s"attemptNumber=${context.attemptNumber}, exceptionMessage=${exceptionMessage}, " +
        s"Context: {${operationContext.toString} ${getThreadInfo}")

      val message = s"All retries exhausted for '${itemOperation.getOperationType}' bulk operation - " +
        s"statusCode=[$effectiveStatusCode:$effectiveSubStatusCode] " +
        s"itemId=[${context.itemId}], partitionKeyValue=[${context.partitionKeyValue}]"

      val exceptionToBeThrown = responseException match {
        case Some(e) =>
          new BulkOperationFailedException(effectiveStatusCode, effectiveSubStatusCode, message, e)
        case None =>
          new BulkOperationFailedException(effectiveStatusCode, effectiveSubStatusCode, message, null)
      }

      captureIfFirstFailure(exceptionToBeThrown)
      cancelWork()
    }
  }
  //scalastyle:on method.length
  //scalastyle:on cyclomatic.complexity

  private[this] def throwIfCapturedExceptionExists(): Unit = {
    val errorSnapshot = errorCaptureFirstException.get()
    if (errorSnapshot != null) {
      log.logError(s"throw captured error ${errorSnapshot.getMessage}, " +
        s"Context: ${operationContext.toString} ${getThreadInfo}")
      throw errorSnapshot
    }
  }

  private[this] def getActiveOperationsLog(
                                              activeOperationsSnapshot: mutable.Set[CosmosItemOperation],
                                              activeReadManyOperationsSnapshot: mutable.Set[ReadManyOperation]): String = {
    val sb = new StringBuilder()

    activeOperationsSnapshot
      .take(BulkWriter.maxItemOperationsToShowInErrorMessage)
      .foreach(itemOperation => {
        if (sb.nonEmpty) {
          sb.append(", ")
        }

        sb.append(itemOperation.getOperationType)
        sb.append("->")
        val ctx = itemOperation.getContext[OperationContext]
        sb.append(s"${ctx.partitionKeyValue}/${ctx.itemId}/${ctx.eTag}(${ctx.attemptNumber})")
      })

    // add readMany snapshot logs
    activeReadManyOperationsSnapshot
        .take(BulkWriter.maxItemOperationsToShowInErrorMessage - activeOperationsSnapshot.size)
        .foreach(readManyOperation => {
            if (sb.nonEmpty) {
                sb.append(", ")
            }

            sb.append("ReadMany")
            sb.append("->")
            val ctx = readManyOperation.operationContext
            sb.append(s"${ctx.partitionKeyValue}/${ctx.itemId}/${ctx.eTag}(${ctx.attemptNumber})")
        })

    sb.toString()
  }

  private[this] def throwIfProgressStaled
  (
    operationName: String,
    activeOperationsSnapshot: mutable.Set[CosmosItemOperation],
    activeReadManyOperationsSnapshot: mutable.Set[ReadManyOperation],
    numberOfIntervalsWithIdenticalActiveOperationSnapshots: AtomicLong
  ) = {

    val operationsLog = getActiveOperationsLog(activeOperationsSnapshot, activeReadManyOperationsSnapshot)

    if (activeOperationsSnapshot.equals(activeBulkWriteOperations)
        && activeReadManyOperationsSnapshot.equals(activeReadManyOperations)) {
      numberOfIntervalsWithIdenticalActiveOperationSnapshots.incrementAndGet()
      log.logWarning(
        s"${operationName} has been waiting ${numberOfIntervalsWithIdenticalActiveOperationSnapshots} " +
          s"times for identical set of operations: ${operationsLog} " +
          s"Context: ${operationContext.toString} ${getThreadInfo}"
      )
    } else {
      numberOfIntervalsWithIdenticalActiveOperationSnapshots.set(0)
      log.logInfo(
        s"${operationName} is waiting for active bulkWrite operations: ${operationsLog} " +
          s"Context: ${operationContext.toString} ${getThreadInfo}"
      )
    }

    if (numberOfIntervalsWithIdenticalActiveOperationSnapshots.get >= BulkWriter.maxAllowedMinutesWithoutAnyProgress) {

      captureIfFirstFailure(
        new IllegalStateException(
          s"Stale bulk ingestion identified in ${operationName} - the following active operations have not been " +
            s"completed (first ${BulkWriter.maxItemOperationsToShowInErrorMessage} shown) or progressed after " +
            s"${BulkWriter.maxAllowedMinutesWithoutAnyProgress} minutes: $operationsLog"
        ))
      cancelWork()
    }

    throwIfCapturedExceptionExists()
  }

  // the caller has to ensure that after invoking this method scheduleWrite doesn't get invoked
  // scalastyle:off method.length
  // scalastyle:off cyclomatic.complexity
  override def flushAndClose(): Unit = {
    this.synchronized {
      try {
        if (!closed.get()) {
          log.logInfo(s"flushAndClose invoked, Context: ${operationContext.toString} ${getThreadInfo}")
          log.logInfo(s"completed so far ${totalSuccessfulIngestionMetrics.get()}, " +
            s"pending bulkWrite asks ${activeBulkWriteOperations.size}, pending readMany tasks ${activeReadManyOperations.size}," +
            s" Context: ${operationContext.toString} ${getThreadInfo}")

          // error handling, if there is any error and the subscription is cancelled
          // the remaining tasks will not be processed hence we never reach activeTasks = 0
          // once we do error handling we should think how to cover the scenario.
          lock.lock()
          try {
            val numberOfIntervalsWithIdenticalActiveOperationSnapshots = new AtomicLong(0)
            var activeTasksSnapshot = activeTasks.get()
            var pendingRetriesSnapshot = pendingRetries.get()
            while ((pendingRetriesSnapshot > 0 || activeTasksSnapshot > 0)
              && errorCaptureFirstException.get == null) {

              log.logInfo(
                s"Waiting for pending activeTasks $activeTasksSnapshot and/or pendingRetries " +
                  s"$pendingRetriesSnapshot,  Context: ${operationContext.toString} ${getThreadInfo}")
              val activeOperationsSnapshot = activeBulkWriteOperations.clone()
              val activeReadManyOperationsSnapshot = activeReadManyOperations.clone()
              val awaitCompleted = pendingTasksCompleted.await(1, TimeUnit.MINUTES)
              if (!awaitCompleted) {
                throwIfProgressStaled(
                  "FlushAndClose",
                  activeOperationsSnapshot,
                  activeReadManyOperationsSnapshot,
                  numberOfIntervalsWithIdenticalActiveOperationSnapshots
                )
              }
              activeTasksSnapshot = activeTasks.get()
              pendingRetriesSnapshot = pendingRetries.get()
              val semaphoreAvailablePermitsSnapshot = semaphore.availablePermits()

              if (awaitCompleted) {
                log.logInfo(s"Waiting completed for pending activeTasks $activeTasksSnapshot, pendingRetries " +
                  s"$pendingRetriesSnapshot Context: ${operationContext.toString} ${getThreadInfo}")
              } else {
                log.logInfo(s"Waiting interrupted for pending activeTasks $activeTasksSnapshot , pendingRetries " +
                  s"$pendingRetriesSnapshot - available permits ${semaphoreAvailablePermitsSnapshot}, " +
                  s"Context: ${operationContext.toString} ${getThreadInfo}")
              }
            }

            log.logInfo(s"Waiting completed for pending activeTasks $activeTasksSnapshot, pendingRetries " +
              s"$pendingRetriesSnapshot Context: ${operationContext.toString} ${getThreadInfo}")
          } finally {
            lock.unlock()
          }

          log.logInfo(s"invoking bulkInputEmitter.onComplete(), Context: ${operationContext.toString} ${getThreadInfo}")
          semaphore.release(activeTasks.get())
          val completeBulkWriteEmitResult = bulkInputEmitter.tryEmitComplete()
          if (completeBulkWriteEmitResult eq Sinks.EmitResult.OK) {
            log.logDebug(s"bulkInputEmitter sink completed, Context: ${operationContext.toString} ${getThreadInfo}")
          }
          else {
            log.logInfo(
              s"bulkInputEmitter sink completion failed. EmitResult: $completeBulkWriteEmitResult  +" +
                s"Context: ${operationContext.toString} ${getThreadInfo}")
          }

          // complete readManyInputEmitter
          if (readManyInputEmitterOpt.isDefined) {
              val completeReadManyEmitResult = readManyInputEmitterOpt.get.tryEmitComplete()
              if (completeReadManyEmitResult eq Sinks.EmitResult.OK) {
                  log.logDebug(s"bulkInputEmitter sink completed, Context: ${operationContext.toString} ${getThreadInfo}")
              }
              else {
                  log.logInfo(
                      s"bulkInputEmitter sink completion failed. EmitResult: $completeReadManyEmitResult  +" +
                          s"Context: ${operationContext.toString} ${getThreadInfo}")
              }
          }

          throwIfCapturedExceptionExists()

          assume(activeTasks.get() == 0)
          assume(activeBulkWriteOperations.isEmpty)
          assume(activeReadManyOperations.isEmpty)
          assume(semaphore.availablePermits() == maxPendingOperations)
          log.logInfo(s"flushAndClose completed with no error. " +
            s"totalSuccessfulIngestionMetrics=${totalSuccessfulIngestionMetrics.get()}, " +
            s"totalScheduled=$totalScheduledMetrics, Context: ${operationContext.toString} ${getThreadInfo}")
          assume(totalScheduledMetrics.get() == totalSuccessfulIngestionMetrics.get)
        }
      } finally {
        subscriptionDisposable.dispose()
        readManySubscriptionDisposableOpt match {
            case Some(readManySubscriptionDisposable) => readManySubscriptionDisposable.dispose()
            case _ =>
        }
        closed.set(true)
      }
    }
  }
  // scalastyle:on method.length
  // scalastyle:on cyclomatic.complexity

  private def markTaskCompletion(): Unit = {
    lock.lock()
    try {
      val activeTasksLeftSnapshot = activeTasks.decrementAndGet()
      val exceptionSnapshot = errorCaptureFirstException.get()
      log.logTrace(s"markTaskCompletion, Active tasks left: $activeTasksLeftSnapshot, " +
        s"error: $exceptionSnapshot, Context: ${operationContext.toString} ${getThreadInfo}")
      if (activeTasksLeftSnapshot == 0 || exceptionSnapshot != null) {
        pendingTasksCompleted.signal()
      }
    } finally {
      lock.unlock()
    }
  }

  private def captureIfFirstFailure(throwable: Throwable): Unit = {
    log.logError(s"capture failure, Context: {${operationContext.toString}} ${getThreadInfo}", throwable)
    lock.lock()
    try {
      errorCaptureFirstException.compareAndSet(null, throwable)
      pendingTasksCompleted.signal()
    } finally {
      lock.unlock()
    }
  }

  private def cancelWork(): Unit = {
    log.logInfo(s"cancelling remaining unprocessed tasks ${activeTasks.get} " +
        s"[bulkWrite tasks ${activeBulkWriteOperations.size}, readMany tasks ${activeReadManyOperations.size} ]" +
        s"Context: ${operationContext.toString}")
    subscriptionDisposable.dispose()
    if (readManySubscriptionDisposableOpt.isDefined) {
        readManySubscriptionDisposableOpt.get.dispose()
    }
  }

  private def shouldIgnore(statusCode: Int, subStatusCode: Int, operationContext: OperationContext): Boolean = {
    val returnValue = writeConfig.itemWriteStrategy match {
      case ItemWriteStrategy.ItemAppend => Exceptions.isResourceExistsException(statusCode)
      case ItemWriteStrategy.ItemDelete => Exceptions.isNotFoundExceptionCore(statusCode, subStatusCode)
      case ItemWriteStrategy.ItemDeleteIfNotModified => Exceptions.isNotFoundExceptionCore(statusCode, subStatusCode) ||
        Exceptions.isPreconditionFailedException(statusCode)
      case ItemWriteStrategy.ItemOverwriteIfNotModified =>
        Exceptions.isResourceExistsException(statusCode) ||
        Exceptions.isNotFoundExceptionCore(statusCode, subStatusCode) ||
        Exceptions.isPreconditionFailedException(statusCode)
      case _ => false
    }

    returnValue
  }

  private def shouldRetry(statusCode: Int, subStatusCode: Int, operationContext: OperationContext): Boolean = {
      var returnValue = false
      if (operationContext.attemptNumber < writeConfig.maxRetryCount) {
          returnValue = writeConfig.itemWriteStrategy match {
              case ItemWriteStrategy.ItemBulkUpdate =>
                  this.shouldRetryForItemPatchBulkUpdate(statusCode, subStatusCode)
              case _ => Exceptions.canBeTransientFailure(statusCode, subStatusCode)
          }
      }

    log.logDebug(s"Should retry statusCode '$statusCode:$subStatusCode' -> $returnValue, " +
      s"Context: ${operationContext.toString} ${getThreadInfo}")

    returnValue
  }

  private def shouldRetryForItemPatchBulkUpdate(statusCode: Int, subStatusCode: Int): Boolean = {
      Exceptions.canBeTransientFailure(statusCode, subStatusCode) ||
          Exceptions.isResourceExistsException(statusCode) ||
          Exceptions.isPreconditionFailedException(statusCode)
  }

  private case class OperationContext
  (
    itemId: String,
    partitionKeyValue: PartitionKey,
    eTag: Option[String],
    attemptNumber: Int /** starts from 1 * */,
    sourceItem: Option[ObjectNode] = None) // for patchBulkUpdate: source item refers to the original objectNode from which SDK constructs the final bulk item operation


    private case class ReadManyOperation(
                                       cosmosItemIdentity: CosmosItemIdentity,
                                       objectNode: ObjectNode,
                                       operationContext: OperationContext)

  private def getId(objectNode: ObjectNode) = {
    val idField = objectNode.get(CosmosConstants.Properties.Id)
    assume(idField != null && idField.isTextual)
    idField.textValue()
  }

  /**
   * Don't wait for any remaining work but signal to the writer the ungraceful close
   * Should not throw any exceptions
   */
  override def abort(): Unit = {
    log.logError(s"Abort, Context: ${operationContext.toString} ${getThreadInfo}")
    // signal an exception that will be thrown for any pending work/flushAndClose if no other exception has
    // been registered
    captureIfFirstFailure(
      new IllegalStateException(s"The Spark task was aborted, Context: ${operationContext.toString}"))
    cancelWork()
  }
}

private object BulkWriter {
  private val log = new DefaultDiagnostics().getLogger(this.getClass)
  //scalastyle:off magic.number
  val maxDelayOn408RequestTimeoutInMs = 10000
  val minDelayOn408RequestTimeoutInMs = 1000
  val maxItemOperationsToShowInErrorMessage = 10
  private val BULK_WRITER_BOUNDED_ELASTIC_THREAD_NAME = "bulk-writer-bounded-elastic"
  private val READ_MANY_BOUNDED_ELASTIC_THREAD_NAME = "read-many-bounded-elastic"
  private val TTL_FOR_SCHEDULER_WORKER_IN_SECONDS = 60 // same as BoundedElasticScheduler.DEFAULT_TTL_SECONDS

  // we used to use 15 minutes here - extending it because of several incidents where
  // backend returned 420/3088 (ThrottleDueToSplit) for >= 30 minutes
  // UPDATE - reverting back to 15 minutes - causing an unreasonably large delay/hang
  // due to a backend issue doesn't sound right for most customers (helpful during my own
  // long stress runs - but for customers 15 minutes is more reasonable)
  // UPDATE - TODO @fabianm - with 15 minutes the end-to-end sample fails too often - because the extensive 429/3088
  // intervals are around 2 hours. So I need to increase this threshold for now again - will move it
  // to 45 minutes - and when I am back from vacation will drive an investigation to improve the
  // end-to-end behavior on 429/3088 with the backend and monitoring teams.
  val maxAllowedMinutesWithoutAnyProgress = 45
  //scalastyle:on magic.number

  // let's say the spark executor VM has 16 CPU cores.
  // let's say we have a cosmos container with 1M RU which is 167 partitions
  // let's say we are ingesting items of size 1KB
  // let's say max request size is 1MB
  // hence we want 1MB/ 1KB items per partition to be buffered
  // 1024 * 167 items should get buffered on a 16 CPU core VM
  // so per CPU core we want (1024 * 167 / 16) max items to be buffered
  // Reduced the targeted buffer from 2MB per partition and core to 1 MB because
  // we had a few customers seeing to high CPU usage with the previous setting
  // Reason is that several customers use larger than 1 KB documents so we need
  // to be less aggressive with the buffering
  val DefaultMaxPendingOperationPerCore: Int = 1024 * 167 / 16

  val emitFailureHandler: EmitFailureHandler =
    (signalType, emitResult) => {
      if (emitResult.equals(EmitResult.FAIL_NON_SERIALIZED)) {
        log.logDebug(s"emitFailureHandler - Signal: ${signalType.toString}, Result: ${emitResult.toString}")
        true
      } else {
        log.logError(s"emitFailureHandler - Signal: ${signalType.toString}, Result: ${emitResult.toString}")
        false
      }
    }

  val bulkProcessingThresholds = new CosmosBulkExecutionThresholdsState()

  // Custom bounded elastic scheduler to switch off IO thread to process response.
  val bulkWriterBoundedElastic: Scheduler = Schedulers.newBoundedElastic(
    2 * Schedulers.DEFAULT_BOUNDED_ELASTIC_SIZE,
    Schedulers.DEFAULT_BOUNDED_ELASTIC_QUEUESIZE,
    BULK_WRITER_BOUNDED_ELASTIC_THREAD_NAME,
    TTL_FOR_SCHEDULER_WORKER_IN_SECONDS, true)

  // Custom bounded elastic scheduler to switch off IO thread to process response.
  val readManyBoundedElastic: Scheduler = Schedulers.newBoundedElastic(
      2 * Schedulers.DEFAULT_BOUNDED_ELASTIC_SIZE,
      Schedulers.DEFAULT_BOUNDED_ELASTIC_QUEUESIZE,
      READ_MANY_BOUNDED_ELASTIC_THREAD_NAME,
      TTL_FOR_SCHEDULER_WORKER_IN_SECONDS, true)

  def getThreadInfo: String = {
    val t = Thread.currentThread()
    val group = Option.apply(t.getThreadGroup) match {
      case Some(group) => group.getName
      case None => "n/a"
    }
    s"Thread[Name: ${t.getName}, Group: $group, IsDaemon: ${t.isDaemon} Id: ${t.getId}]"
  }

  private class BulkOperationFailedException(statusCode: Int, subStatusCode: Int, message:String, cause: Throwable)
    extends CosmosException(statusCode, message, null, cause) {
      BridgeInternal.setSubStatusCode(this, subStatusCode)
  }
}

//scalastyle:on multiple.string.literals
//scalastyle:on null
//scalastyle:on file.size.limit
