// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.network.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.management.polling.PollResult;
import com.azure.core.util.Context;
import com.azure.core.util.polling.PollerFlux;
import com.azure.core.util.polling.SyncPoller;
import com.azure.resourcemanager.network.fluent.models.NetworkVirtualApplianceConnectionInner;
import java.nio.ByteBuffer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * An instance of this class provides access to all the operations defined in NetworkVirtualApplianceConnectionsClient.
 */
public interface NetworkVirtualApplianceConnectionsClient {
    /**
     * Creates a connection to Network Virtual Appliance, if it doesn't exist else updates the existing NVA connection'.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkVirtualApplianceName The name of the Network Virtual Appliance.
     * @param connectionName The name of the NVA connection.
     * @param networkVirtualApplianceConnectionParameters Parameters supplied in an NetworkVirtualApplianceConnection
     *     PUT operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return networkVirtualApplianceConnection resource along with {@link Response} on successful completion of {@link
     *     Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<Flux<ByteBuffer>>> createOrUpdateWithResponseAsync(
        String resourceGroupName,
        String networkVirtualApplianceName,
        String connectionName,
        NetworkVirtualApplianceConnectionInner networkVirtualApplianceConnectionParameters);

    /**
     * Creates a connection to Network Virtual Appliance, if it doesn't exist else updates the existing NVA connection'.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkVirtualApplianceName The name of the Network Virtual Appliance.
     * @param connectionName The name of the NVA connection.
     * @param networkVirtualApplianceConnectionParameters Parameters supplied in an NetworkVirtualApplianceConnection
     *     PUT operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link PollerFlux} for polling of networkVirtualApplianceConnection resource.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    PollerFlux<PollResult<NetworkVirtualApplianceConnectionInner>, NetworkVirtualApplianceConnectionInner>
        beginCreateOrUpdateAsync(
            String resourceGroupName,
            String networkVirtualApplianceName,
            String connectionName,
            NetworkVirtualApplianceConnectionInner networkVirtualApplianceConnectionParameters);

    /**
     * Creates a connection to Network Virtual Appliance, if it doesn't exist else updates the existing NVA connection'.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkVirtualApplianceName The name of the Network Virtual Appliance.
     * @param connectionName The name of the NVA connection.
     * @param networkVirtualApplianceConnectionParameters Parameters supplied in an NetworkVirtualApplianceConnection
     *     PUT operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of networkVirtualApplianceConnection resource.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<NetworkVirtualApplianceConnectionInner>, NetworkVirtualApplianceConnectionInner>
        beginCreateOrUpdate(
            String resourceGroupName,
            String networkVirtualApplianceName,
            String connectionName,
            NetworkVirtualApplianceConnectionInner networkVirtualApplianceConnectionParameters);

    /**
     * Creates a connection to Network Virtual Appliance, if it doesn't exist else updates the existing NVA connection'.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkVirtualApplianceName The name of the Network Virtual Appliance.
     * @param connectionName The name of the NVA connection.
     * @param networkVirtualApplianceConnectionParameters Parameters supplied in an NetworkVirtualApplianceConnection
     *     PUT operation.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of networkVirtualApplianceConnection resource.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<NetworkVirtualApplianceConnectionInner>, NetworkVirtualApplianceConnectionInner>
        beginCreateOrUpdate(
            String resourceGroupName,
            String networkVirtualApplianceName,
            String connectionName,
            NetworkVirtualApplianceConnectionInner networkVirtualApplianceConnectionParameters,
            Context context);

    /**
     * Creates a connection to Network Virtual Appliance, if it doesn't exist else updates the existing NVA connection'.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkVirtualApplianceName The name of the Network Virtual Appliance.
     * @param connectionName The name of the NVA connection.
     * @param networkVirtualApplianceConnectionParameters Parameters supplied in an NetworkVirtualApplianceConnection
     *     PUT operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return networkVirtualApplianceConnection resource on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<NetworkVirtualApplianceConnectionInner> createOrUpdateAsync(
        String resourceGroupName,
        String networkVirtualApplianceName,
        String connectionName,
        NetworkVirtualApplianceConnectionInner networkVirtualApplianceConnectionParameters);

    /**
     * Creates a connection to Network Virtual Appliance, if it doesn't exist else updates the existing NVA connection'.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkVirtualApplianceName The name of the Network Virtual Appliance.
     * @param connectionName The name of the NVA connection.
     * @param networkVirtualApplianceConnectionParameters Parameters supplied in an NetworkVirtualApplianceConnection
     *     PUT operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return networkVirtualApplianceConnection resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    NetworkVirtualApplianceConnectionInner createOrUpdate(
        String resourceGroupName,
        String networkVirtualApplianceName,
        String connectionName,
        NetworkVirtualApplianceConnectionInner networkVirtualApplianceConnectionParameters);

    /**
     * Creates a connection to Network Virtual Appliance, if it doesn't exist else updates the existing NVA connection'.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkVirtualApplianceName The name of the Network Virtual Appliance.
     * @param connectionName The name of the NVA connection.
     * @param networkVirtualApplianceConnectionParameters Parameters supplied in an NetworkVirtualApplianceConnection
     *     PUT operation.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return networkVirtualApplianceConnection resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    NetworkVirtualApplianceConnectionInner createOrUpdate(
        String resourceGroupName,
        String networkVirtualApplianceName,
        String connectionName,
        NetworkVirtualApplianceConnectionInner networkVirtualApplianceConnectionParameters,
        Context context);

    /**
     * Retrieves the details of specified NVA connection.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkVirtualApplianceName The name of the Network Virtual Appliance.
     * @param connectionName The name of the NVA connection.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return networkVirtualApplianceConnection resource along with {@link Response} on successful completion of {@link
     *     Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<NetworkVirtualApplianceConnectionInner>> getWithResponseAsync(
        String resourceGroupName, String networkVirtualApplianceName, String connectionName);

    /**
     * Retrieves the details of specified NVA connection.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkVirtualApplianceName The name of the Network Virtual Appliance.
     * @param connectionName The name of the NVA connection.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return networkVirtualApplianceConnection resource on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<NetworkVirtualApplianceConnectionInner> getAsync(
        String resourceGroupName, String networkVirtualApplianceName, String connectionName);

    /**
     * Retrieves the details of specified NVA connection.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkVirtualApplianceName The name of the Network Virtual Appliance.
     * @param connectionName The name of the NVA connection.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return networkVirtualApplianceConnection resource along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<NetworkVirtualApplianceConnectionInner> getWithResponse(
        String resourceGroupName, String networkVirtualApplianceName, String connectionName, Context context);

    /**
     * Retrieves the details of specified NVA connection.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkVirtualApplianceName The name of the Network Virtual Appliance.
     * @param connectionName The name of the NVA connection.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return networkVirtualApplianceConnection resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    NetworkVirtualApplianceConnectionInner get(
        String resourceGroupName, String networkVirtualApplianceName, String connectionName);

    /**
     * Deletes a NVA connection.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkVirtualApplianceName The name of the Network Virtual Appliance.
     * @param connectionName The name of the NVA connection.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<Flux<ByteBuffer>>> deleteWithResponseAsync(
        String resourceGroupName, String networkVirtualApplianceName, String connectionName);

    /**
     * Deletes a NVA connection.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkVirtualApplianceName The name of the Network Virtual Appliance.
     * @param connectionName The name of the NVA connection.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link PollerFlux} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    PollerFlux<PollResult<Void>, Void> beginDeleteAsync(
        String resourceGroupName, String networkVirtualApplianceName, String connectionName);

    /**
     * Deletes a NVA connection.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkVirtualApplianceName The name of the Network Virtual Appliance.
     * @param connectionName The name of the NVA connection.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<Void>, Void> beginDelete(
        String resourceGroupName, String networkVirtualApplianceName, String connectionName);

    /**
     * Deletes a NVA connection.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkVirtualApplianceName The name of the Network Virtual Appliance.
     * @param connectionName The name of the NVA connection.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<Void>, Void> beginDelete(
        String resourceGroupName, String networkVirtualApplianceName, String connectionName, Context context);

    /**
     * Deletes a NVA connection.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkVirtualApplianceName The name of the Network Virtual Appliance.
     * @param connectionName The name of the NVA connection.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return A {@link Mono} that completes when a successful response is received.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Void> deleteAsync(String resourceGroupName, String networkVirtualApplianceName, String connectionName);

    /**
     * Deletes a NVA connection.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkVirtualApplianceName The name of the Network Virtual Appliance.
     * @param connectionName The name of the NVA connection.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String networkVirtualApplianceName, String connectionName);

    /**
     * Deletes a NVA connection.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkVirtualApplianceName The name of the Network Virtual Appliance.
     * @param connectionName The name of the NVA connection.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String networkVirtualApplianceName, String connectionName, Context context);

    /**
     * Lists NetworkVirtualApplianceConnections under the NVA.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkVirtualApplianceName The name of the Network Virtual Appliance.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return networkVirtualApplianceConnection list as paginated response with {@link PagedFlux}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedFlux<NetworkVirtualApplianceConnectionInner> listAsync(
        String resourceGroupName, String networkVirtualApplianceName);

    /**
     * Lists NetworkVirtualApplianceConnections under the NVA.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkVirtualApplianceName The name of the Network Virtual Appliance.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return networkVirtualApplianceConnection list as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<NetworkVirtualApplianceConnectionInner> list(
        String resourceGroupName, String networkVirtualApplianceName);

    /**
     * Lists NetworkVirtualApplianceConnections under the NVA.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkVirtualApplianceName The name of the Network Virtual Appliance.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return networkVirtualApplianceConnection list as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<NetworkVirtualApplianceConnectionInner> list(
        String resourceGroupName, String networkVirtualApplianceName, Context context);
}
