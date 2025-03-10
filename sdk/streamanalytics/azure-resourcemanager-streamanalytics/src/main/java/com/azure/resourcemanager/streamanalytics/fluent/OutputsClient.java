// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.streamanalytics.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.management.polling.PollResult;
import com.azure.core.util.Context;
import com.azure.core.util.polling.SyncPoller;
import com.azure.resourcemanager.streamanalytics.fluent.models.OutputInner;
import com.azure.resourcemanager.streamanalytics.fluent.models.ResourceTestStatusInner;
import com.azure.resourcemanager.streamanalytics.models.OutputsCreateOrReplaceResponse;
import com.azure.resourcemanager.streamanalytics.models.OutputsGetResponse;
import com.azure.resourcemanager.streamanalytics.models.OutputsUpdateResponse;

/** An instance of this class provides access to all the operations defined in OutputsClient. */
public interface OutputsClient {
    /**
     * Creates an output or replaces an already existing output under an existing streaming job.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param jobName The name of the streaming job.
     * @param outputName The name of the output.
     * @param output The definition of the output that will be used to create a new output or replace the existing one
     *     under the streaming job.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return an output object, containing all information associated with the named output.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    OutputInner createOrReplace(String resourceGroupName, String jobName, String outputName, OutputInner output);

    /**
     * Creates an output or replaces an already existing output under an existing streaming job.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param jobName The name of the streaming job.
     * @param outputName The name of the output.
     * @param output The definition of the output that will be used to create a new output or replace the existing one
     *     under the streaming job.
     * @param ifMatch The ETag of the output. Omit this value to always overwrite the current output. Specify the
     *     last-seen ETag value to prevent accidentally overwriting concurrent changes.
     * @param ifNoneMatch Set to '*' to allow a new output to be created, but to prevent updating an existing output.
     *     Other values will result in a 412 Pre-condition Failed response.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return an output object, containing all information associated with the named output.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    OutputsCreateOrReplaceResponse createOrReplaceWithResponse(
        String resourceGroupName,
        String jobName,
        String outputName,
        OutputInner output,
        String ifMatch,
        String ifNoneMatch,
        Context context);

    /**
     * Updates an existing output under an existing streaming job. This can be used to partially update (ie. update one
     * or two properties) an output without affecting the rest the job or output definition.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param jobName The name of the streaming job.
     * @param outputName The name of the output.
     * @param output An Output object. The properties specified here will overwrite the corresponding properties in the
     *     existing output (ie. Those properties will be updated). Any properties that are set to null here will mean
     *     that the corresponding property in the existing output will remain the same and not change as a result of
     *     this PATCH operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return an output object, containing all information associated with the named output.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    OutputInner update(String resourceGroupName, String jobName, String outputName, OutputInner output);

    /**
     * Updates an existing output under an existing streaming job. This can be used to partially update (ie. update one
     * or two properties) an output without affecting the rest the job or output definition.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param jobName The name of the streaming job.
     * @param outputName The name of the output.
     * @param output An Output object. The properties specified here will overwrite the corresponding properties in the
     *     existing output (ie. Those properties will be updated). Any properties that are set to null here will mean
     *     that the corresponding property in the existing output will remain the same and not change as a result of
     *     this PATCH operation.
     * @param ifMatch The ETag of the output. Omit this value to always overwrite the current output. Specify the
     *     last-seen ETag value to prevent accidentally overwriting concurrent changes.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return an output object, containing all information associated with the named output.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    OutputsUpdateResponse updateWithResponse(
        String resourceGroupName,
        String jobName,
        String outputName,
        OutputInner output,
        String ifMatch,
        Context context);

    /**
     * Deletes an output from the streaming job.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param jobName The name of the streaming job.
     * @param outputName The name of the output.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String jobName, String outputName);

    /**
     * Deletes an output from the streaming job.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param jobName The name of the streaming job.
     * @param outputName The name of the output.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<Void> deleteWithResponse(String resourceGroupName, String jobName, String outputName, Context context);

    /**
     * Gets details about the specified output.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param jobName The name of the streaming job.
     * @param outputName The name of the output.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return details about the specified output.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    OutputInner get(String resourceGroupName, String jobName, String outputName);

    /**
     * Gets details about the specified output.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param jobName The name of the streaming job.
     * @param outputName The name of the output.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return details about the specified output.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    OutputsGetResponse getWithResponse(String resourceGroupName, String jobName, String outputName, Context context);

    /**
     * Lists all of the outputs under the specified streaming job.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param jobName The name of the streaming job.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return object containing a list of outputs under a streaming job.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<OutputInner> listByStreamingJob(String resourceGroupName, String jobName);

    /**
     * Lists all of the outputs under the specified streaming job.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param jobName The name of the streaming job.
     * @param select The $select OData query parameter. This is a comma-separated list of structural properties to
     *     include in the response, or "*" to include all properties. By default, all properties are returned except
     *     diagnostics. Currently only accepts '*' as a valid value.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return object containing a list of outputs under a streaming job.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<OutputInner> listByStreamingJob(
        String resourceGroupName, String jobName, String select, Context context);

    /**
     * Tests whether an output’s datasource is reachable and usable by the Azure Stream Analytics service.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param jobName The name of the streaming job.
     * @param outputName The name of the output.
     * @param output If the output specified does not already exist, this parameter must contain the full output
     *     definition intended to be tested. If the output specified already exists, this parameter can be left null to
     *     test the existing output as is or if specified, the properties specified will overwrite the corresponding
     *     properties in the existing output (exactly like a PATCH operation) and the resulting output will be tested.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return describes the status of the test operation along with error information, if applicable.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<ResourceTestStatusInner>, ResourceTestStatusInner> beginTest(
        String resourceGroupName, String jobName, String outputName, OutputInner output);

    /**
     * Tests whether an output’s datasource is reachable and usable by the Azure Stream Analytics service.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param jobName The name of the streaming job.
     * @param outputName The name of the output.
     * @param output If the output specified does not already exist, this parameter must contain the full output
     *     definition intended to be tested. If the output specified already exists, this parameter can be left null to
     *     test the existing output as is or if specified, the properties specified will overwrite the corresponding
     *     properties in the existing output (exactly like a PATCH operation) and the resulting output will be tested.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return describes the status of the test operation along with error information, if applicable.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<ResourceTestStatusInner>, ResourceTestStatusInner> beginTest(
        String resourceGroupName, String jobName, String outputName, OutputInner output, Context context);

    /**
     * Tests whether an output’s datasource is reachable and usable by the Azure Stream Analytics service.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param jobName The name of the streaming job.
     * @param outputName The name of the output.
     * @param output If the output specified does not already exist, this parameter must contain the full output
     *     definition intended to be tested. If the output specified already exists, this parameter can be left null to
     *     test the existing output as is or if specified, the properties specified will overwrite the corresponding
     *     properties in the existing output (exactly like a PATCH operation) and the resulting output will be tested.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return describes the status of the test operation along with error information, if applicable.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    ResourceTestStatusInner test(String resourceGroupName, String jobName, String outputName, OutputInner output);

    /**
     * Tests whether an output’s datasource is reachable and usable by the Azure Stream Analytics service.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param jobName The name of the streaming job.
     * @param outputName The name of the output.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return describes the status of the test operation along with error information, if applicable.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    ResourceTestStatusInner test(String resourceGroupName, String jobName, String outputName);

    /**
     * Tests whether an output’s datasource is reachable and usable by the Azure Stream Analytics service.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param jobName The name of the streaming job.
     * @param outputName The name of the output.
     * @param output If the output specified does not already exist, this parameter must contain the full output
     *     definition intended to be tested. If the output specified already exists, this parameter can be left null to
     *     test the existing output as is or if specified, the properties specified will overwrite the corresponding
     *     properties in the existing output (exactly like a PATCH operation) and the resulting output will be tested.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return describes the status of the test operation along with error information, if applicable.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    ResourceTestStatusInner test(
        String resourceGroupName, String jobName, String outputName, OutputInner output, Context context);
}
