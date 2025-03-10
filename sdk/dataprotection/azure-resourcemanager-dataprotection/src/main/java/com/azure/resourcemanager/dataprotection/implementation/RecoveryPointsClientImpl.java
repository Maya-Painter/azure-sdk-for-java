// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.dataprotection.implementation;

import com.azure.core.annotation.ExpectedResponses;
import com.azure.core.annotation.Get;
import com.azure.core.annotation.HeaderParam;
import com.azure.core.annotation.Headers;
import com.azure.core.annotation.Host;
import com.azure.core.annotation.HostParam;
import com.azure.core.annotation.PathParam;
import com.azure.core.annotation.QueryParam;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceInterface;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.annotation.UnexpectedResponseExceptionType;
import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.PagedResponse;
import com.azure.core.http.rest.PagedResponseBase;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.RestProxy;
import com.azure.core.management.exception.ManagementException;
import com.azure.core.util.Context;
import com.azure.core.util.FluxUtil;
import com.azure.resourcemanager.dataprotection.fluent.RecoveryPointsClient;
import com.azure.resourcemanager.dataprotection.fluent.models.AzureBackupRecoveryPointResourceInner;
import com.azure.resourcemanager.dataprotection.models.AzureBackupRecoveryPointResourceList;
import reactor.core.publisher.Mono;

/** An instance of this class provides access to all the operations defined in RecoveryPointsClient. */
public final class RecoveryPointsClientImpl implements RecoveryPointsClient {
    /** The proxy service used to perform REST calls. */
    private final RecoveryPointsService service;

    /** The service client containing this operation class. */
    private final DataProtectionClientImpl client;

    /**
     * Initializes an instance of RecoveryPointsClientImpl.
     *
     * @param client the instance of the service client containing this operation class.
     */
    RecoveryPointsClientImpl(DataProtectionClientImpl client) {
        this.service =
            RestProxy.create(RecoveryPointsService.class, client.getHttpPipeline(), client.getSerializerAdapter());
        this.client = client;
    }

    /**
     * The interface defining all the services for DataProtectionClientRecoveryPoints to be used by the proxy service to
     * perform REST calls.
     */
    @Host("{$host}")
    @ServiceInterface(name = "DataProtectionClient")
    public interface RecoveryPointsService {
        @Headers({"Content-Type: application/json"})
        @Get(
            "/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.DataProtection/backupVaults/{vaultName}/backupInstances/{backupInstanceName}/recoveryPoints")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<Response<AzureBackupRecoveryPointResourceList>> list(
            @HostParam("$host") String endpoint,
            @QueryParam("api-version") String apiVersion,
            @PathParam("subscriptionId") String subscriptionId,
            @PathParam("resourceGroupName") String resourceGroupName,
            @PathParam("vaultName") String vaultName,
            @PathParam("backupInstanceName") String backupInstanceName,
            @QueryParam("$filter") String filter,
            @QueryParam("$skipToken") String skipToken,
            @HeaderParam("Accept") String accept,
            Context context);

        @Headers({"Content-Type: application/json"})
        @Get(
            "/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.DataProtection/backupVaults/{vaultName}/backupInstances/{backupInstanceName}/recoveryPoints/{recoveryPointId}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<Response<AzureBackupRecoveryPointResourceInner>> get(
            @HostParam("$host") String endpoint,
            @QueryParam("api-version") String apiVersion,
            @PathParam("subscriptionId") String subscriptionId,
            @PathParam("resourceGroupName") String resourceGroupName,
            @PathParam("vaultName") String vaultName,
            @PathParam("backupInstanceName") String backupInstanceName,
            @PathParam("recoveryPointId") String recoveryPointId,
            @HeaderParam("Accept") String accept,
            Context context);

        @Headers({"Content-Type: application/json"})
        @Get("{nextLink}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<Response<AzureBackupRecoveryPointResourceList>> listNext(
            @PathParam(value = "nextLink", encoded = true) String nextLink,
            @HostParam("$host") String endpoint,
            @HeaderParam("Accept") String accept,
            Context context);
    }

    /**
     * Returns a list of Recovery Points for a DataSource in a vault.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param vaultName The name of the backup vault.
     * @param backupInstanceName The name of the backup instance.
     * @param filter OData filter options.
     * @param skipToken skipToken Filter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return azureBackupRecoveryPointResourceList along with {@link PagedResponse} on successful completion of {@link
     *     Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<PagedResponse<AzureBackupRecoveryPointResourceInner>> listSinglePageAsync(
        String resourceGroupName, String vaultName, String backupInstanceName, String filter, String skipToken) {
        if (this.client.getEndpoint() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (resourceGroupName == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
        }
        if (vaultName == null) {
            return Mono.error(new IllegalArgumentException("Parameter vaultName is required and cannot be null."));
        }
        if (backupInstanceName == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter backupInstanceName is required and cannot be null."));
        }
        final String accept = "application/json";
        return FluxUtil
            .withContext(
                context ->
                    service
                        .list(
                            this.client.getEndpoint(),
                            this.client.getApiVersion(),
                            this.client.getSubscriptionId(),
                            resourceGroupName,
                            vaultName,
                            backupInstanceName,
                            filter,
                            skipToken,
                            accept,
                            context))
            .<PagedResponse<AzureBackupRecoveryPointResourceInner>>map(
                res ->
                    new PagedResponseBase<>(
                        res.getRequest(),
                        res.getStatusCode(),
                        res.getHeaders(),
                        res.getValue().value(),
                        res.getValue().nextLink(),
                        null))
            .contextWrite(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext()).readOnly()));
    }

    /**
     * Returns a list of Recovery Points for a DataSource in a vault.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param vaultName The name of the backup vault.
     * @param backupInstanceName The name of the backup instance.
     * @param filter OData filter options.
     * @param skipToken skipToken Filter.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return azureBackupRecoveryPointResourceList along with {@link PagedResponse} on successful completion of {@link
     *     Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<PagedResponse<AzureBackupRecoveryPointResourceInner>> listSinglePageAsync(
        String resourceGroupName,
        String vaultName,
        String backupInstanceName,
        String filter,
        String skipToken,
        Context context) {
        if (this.client.getEndpoint() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (resourceGroupName == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
        }
        if (vaultName == null) {
            return Mono.error(new IllegalArgumentException("Parameter vaultName is required and cannot be null."));
        }
        if (backupInstanceName == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter backupInstanceName is required and cannot be null."));
        }
        final String accept = "application/json";
        context = this.client.mergeContext(context);
        return service
            .list(
                this.client.getEndpoint(),
                this.client.getApiVersion(),
                this.client.getSubscriptionId(),
                resourceGroupName,
                vaultName,
                backupInstanceName,
                filter,
                skipToken,
                accept,
                context)
            .map(
                res ->
                    new PagedResponseBase<>(
                        res.getRequest(),
                        res.getStatusCode(),
                        res.getHeaders(),
                        res.getValue().value(),
                        res.getValue().nextLink(),
                        null));
    }

    /**
     * Returns a list of Recovery Points for a DataSource in a vault.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param vaultName The name of the backup vault.
     * @param backupInstanceName The name of the backup instance.
     * @param filter OData filter options.
     * @param skipToken skipToken Filter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return azureBackupRecoveryPointResourceList as paginated response with {@link PagedFlux}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    private PagedFlux<AzureBackupRecoveryPointResourceInner> listAsync(
        String resourceGroupName, String vaultName, String backupInstanceName, String filter, String skipToken) {
        return new PagedFlux<>(
            () -> listSinglePageAsync(resourceGroupName, vaultName, backupInstanceName, filter, skipToken),
            nextLink -> listNextSinglePageAsync(nextLink));
    }

    /**
     * Returns a list of Recovery Points for a DataSource in a vault.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param vaultName The name of the backup vault.
     * @param backupInstanceName The name of the backup instance.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return azureBackupRecoveryPointResourceList as paginated response with {@link PagedFlux}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    private PagedFlux<AzureBackupRecoveryPointResourceInner> listAsync(
        String resourceGroupName, String vaultName, String backupInstanceName) {
        final String filter = null;
        final String skipToken = null;
        return new PagedFlux<>(
            () -> listSinglePageAsync(resourceGroupName, vaultName, backupInstanceName, filter, skipToken),
            nextLink -> listNextSinglePageAsync(nextLink));
    }

    /**
     * Returns a list of Recovery Points for a DataSource in a vault.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param vaultName The name of the backup vault.
     * @param backupInstanceName The name of the backup instance.
     * @param filter OData filter options.
     * @param skipToken skipToken Filter.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return azureBackupRecoveryPointResourceList as paginated response with {@link PagedFlux}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    private PagedFlux<AzureBackupRecoveryPointResourceInner> listAsync(
        String resourceGroupName,
        String vaultName,
        String backupInstanceName,
        String filter,
        String skipToken,
        Context context) {
        return new PagedFlux<>(
            () -> listSinglePageAsync(resourceGroupName, vaultName, backupInstanceName, filter, skipToken, context),
            nextLink -> listNextSinglePageAsync(nextLink, context));
    }

    /**
     * Returns a list of Recovery Points for a DataSource in a vault.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param vaultName The name of the backup vault.
     * @param backupInstanceName The name of the backup instance.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return azureBackupRecoveryPointResourceList as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<AzureBackupRecoveryPointResourceInner> list(
        String resourceGroupName, String vaultName, String backupInstanceName) {
        final String filter = null;
        final String skipToken = null;
        return new PagedIterable<>(listAsync(resourceGroupName, vaultName, backupInstanceName, filter, skipToken));
    }

    /**
     * Returns a list of Recovery Points for a DataSource in a vault.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param vaultName The name of the backup vault.
     * @param backupInstanceName The name of the backup instance.
     * @param filter OData filter options.
     * @param skipToken skipToken Filter.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return azureBackupRecoveryPointResourceList as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<AzureBackupRecoveryPointResourceInner> list(
        String resourceGroupName,
        String vaultName,
        String backupInstanceName,
        String filter,
        String skipToken,
        Context context) {
        return new PagedIterable<>(
            listAsync(resourceGroupName, vaultName, backupInstanceName, filter, skipToken, context));
    }

    /**
     * Gets a Recovery Point using recoveryPointId for a Datasource.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param vaultName The name of the backup vault.
     * @param backupInstanceName The name of the backup instance.
     * @param recoveryPointId The recoveryPointId parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a Recovery Point using recoveryPointId for a Datasource along with {@link Response} on successful
     *     completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Response<AzureBackupRecoveryPointResourceInner>> getWithResponseAsync(
        String resourceGroupName, String vaultName, String backupInstanceName, String recoveryPointId) {
        if (this.client.getEndpoint() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (resourceGroupName == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
        }
        if (vaultName == null) {
            return Mono.error(new IllegalArgumentException("Parameter vaultName is required and cannot be null."));
        }
        if (backupInstanceName == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter backupInstanceName is required and cannot be null."));
        }
        if (recoveryPointId == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter recoveryPointId is required and cannot be null."));
        }
        final String accept = "application/json";
        return FluxUtil
            .withContext(
                context ->
                    service
                        .get(
                            this.client.getEndpoint(),
                            this.client.getApiVersion(),
                            this.client.getSubscriptionId(),
                            resourceGroupName,
                            vaultName,
                            backupInstanceName,
                            recoveryPointId,
                            accept,
                            context))
            .contextWrite(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext()).readOnly()));
    }

    /**
     * Gets a Recovery Point using recoveryPointId for a Datasource.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param vaultName The name of the backup vault.
     * @param backupInstanceName The name of the backup instance.
     * @param recoveryPointId The recoveryPointId parameter.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a Recovery Point using recoveryPointId for a Datasource along with {@link Response} on successful
     *     completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Response<AzureBackupRecoveryPointResourceInner>> getWithResponseAsync(
        String resourceGroupName,
        String vaultName,
        String backupInstanceName,
        String recoveryPointId,
        Context context) {
        if (this.client.getEndpoint() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (resourceGroupName == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
        }
        if (vaultName == null) {
            return Mono.error(new IllegalArgumentException("Parameter vaultName is required and cannot be null."));
        }
        if (backupInstanceName == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter backupInstanceName is required and cannot be null."));
        }
        if (recoveryPointId == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter recoveryPointId is required and cannot be null."));
        }
        final String accept = "application/json";
        context = this.client.mergeContext(context);
        return service
            .get(
                this.client.getEndpoint(),
                this.client.getApiVersion(),
                this.client.getSubscriptionId(),
                resourceGroupName,
                vaultName,
                backupInstanceName,
                recoveryPointId,
                accept,
                context);
    }

    /**
     * Gets a Recovery Point using recoveryPointId for a Datasource.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param vaultName The name of the backup vault.
     * @param backupInstanceName The name of the backup instance.
     * @param recoveryPointId The recoveryPointId parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a Recovery Point using recoveryPointId for a Datasource on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<AzureBackupRecoveryPointResourceInner> getAsync(
        String resourceGroupName, String vaultName, String backupInstanceName, String recoveryPointId) {
        return getWithResponseAsync(resourceGroupName, vaultName, backupInstanceName, recoveryPointId)
            .flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Gets a Recovery Point using recoveryPointId for a Datasource.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param vaultName The name of the backup vault.
     * @param backupInstanceName The name of the backup instance.
     * @param recoveryPointId The recoveryPointId parameter.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a Recovery Point using recoveryPointId for a Datasource along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<AzureBackupRecoveryPointResourceInner> getWithResponse(
        String resourceGroupName,
        String vaultName,
        String backupInstanceName,
        String recoveryPointId,
        Context context) {
        return getWithResponseAsync(resourceGroupName, vaultName, backupInstanceName, recoveryPointId, context).block();
    }

    /**
     * Gets a Recovery Point using recoveryPointId for a Datasource.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param vaultName The name of the backup vault.
     * @param backupInstanceName The name of the backup instance.
     * @param recoveryPointId The recoveryPointId parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a Recovery Point using recoveryPointId for a Datasource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public AzureBackupRecoveryPointResourceInner get(
        String resourceGroupName, String vaultName, String backupInstanceName, String recoveryPointId) {
        return getWithResponse(resourceGroupName, vaultName, backupInstanceName, recoveryPointId, Context.NONE)
            .getValue();
    }

    /**
     * Get the next page of items.
     *
     * @param nextLink The URL to get the next list of items
     *     <p>The nextLink parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return azureBackupRecoveryPointResourceList along with {@link PagedResponse} on successful completion of {@link
     *     Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<PagedResponse<AzureBackupRecoveryPointResourceInner>> listNextSinglePageAsync(String nextLink) {
        if (nextLink == null) {
            return Mono.error(new IllegalArgumentException("Parameter nextLink is required and cannot be null."));
        }
        if (this.client.getEndpoint() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        final String accept = "application/json";
        return FluxUtil
            .withContext(context -> service.listNext(nextLink, this.client.getEndpoint(), accept, context))
            .<PagedResponse<AzureBackupRecoveryPointResourceInner>>map(
                res ->
                    new PagedResponseBase<>(
                        res.getRequest(),
                        res.getStatusCode(),
                        res.getHeaders(),
                        res.getValue().value(),
                        res.getValue().nextLink(),
                        null))
            .contextWrite(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext()).readOnly()));
    }

    /**
     * Get the next page of items.
     *
     * @param nextLink The URL to get the next list of items
     *     <p>The nextLink parameter.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return azureBackupRecoveryPointResourceList along with {@link PagedResponse} on successful completion of {@link
     *     Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<PagedResponse<AzureBackupRecoveryPointResourceInner>> listNextSinglePageAsync(
        String nextLink, Context context) {
        if (nextLink == null) {
            return Mono.error(new IllegalArgumentException("Parameter nextLink is required and cannot be null."));
        }
        if (this.client.getEndpoint() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        final String accept = "application/json";
        context = this.client.mergeContext(context);
        return service
            .listNext(nextLink, this.client.getEndpoint(), accept, context)
            .map(
                res ->
                    new PagedResponseBase<>(
                        res.getRequest(),
                        res.getStatusCode(),
                        res.getHeaders(),
                        res.getValue().value(),
                        res.getValue().nextLink(),
                        null));
    }
}
