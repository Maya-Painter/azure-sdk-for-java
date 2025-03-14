// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.network.generated;

import com.azure.core.management.SubResource;
import com.azure.resourcemanager.network.fluent.models.VirtualNetworkPeeringInner;
import com.azure.resourcemanager.network.models.SyncRemoteAddressSpace;

/** Samples for VirtualNetworkPeerings CreateOrUpdate. */
public final class VirtualNetworkPeeringsCreateOrUpdateSamples {
    /*
     * x-ms-original-file: specification/network/resource-manager/Microsoft.Network/stable/2023-02-01/examples/VirtualNetworkPeeringSync.json
     */
    /**
     * Sample code: Sync Peering.
     *
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void syncPeering(com.azure.resourcemanager.AzureResourceManager azure) {
        azure
            .networks()
            .manager()
            .serviceClient()
            .getVirtualNetworkPeerings()
            .createOrUpdate(
                "peerTest",
                "vnet1",
                "peer",
                new VirtualNetworkPeeringInner()
                    .withAllowVirtualNetworkAccess(true)
                    .withAllowForwardedTraffic(true)
                    .withAllowGatewayTransit(false)
                    .withUseRemoteGateways(false)
                    .withRemoteVirtualNetwork(
                        new SubResource()
                            .withId(
                                "/subscriptions/subid/resourceGroups/peerTest/providers/Microsoft.Network/virtualNetworks/vnet2")),
                SyncRemoteAddressSpace.TRUE,
                com.azure.core.util.Context.NONE);
    }

    /*
     * x-ms-original-file: specification/network/resource-manager/Microsoft.Network/stable/2023-02-01/examples/VirtualNetworkPeeringCreate.json
     */
    /**
     * Sample code: Create peering.
     *
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void createPeering(com.azure.resourcemanager.AzureResourceManager azure) {
        azure
            .networks()
            .manager()
            .serviceClient()
            .getVirtualNetworkPeerings()
            .createOrUpdate(
                "peerTest",
                "vnet1",
                "peer",
                new VirtualNetworkPeeringInner()
                    .withAllowVirtualNetworkAccess(true)
                    .withAllowForwardedTraffic(true)
                    .withAllowGatewayTransit(false)
                    .withUseRemoteGateways(false)
                    .withRemoteVirtualNetwork(
                        new SubResource()
                            .withId(
                                "/subscriptions/subid/resourceGroups/peerTest/providers/Microsoft.Network/virtualNetworks/vnet2")),
                null,
                com.azure.core.util.Context.NONE);
    }

    /*
     * x-ms-original-file: specification/network/resource-manager/Microsoft.Network/stable/2023-02-01/examples/VirtualNetworkPeeringCreateWithRemoteVirtualNetworkEncryption.json
     */
    /**
     * Sample code: Create peering with remote virtual network encryption.
     *
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void createPeeringWithRemoteVirtualNetworkEncryption(
        com.azure.resourcemanager.AzureResourceManager azure) {
        azure
            .networks()
            .manager()
            .serviceClient()
            .getVirtualNetworkPeerings()
            .createOrUpdate(
                "peerTest",
                "vnet1",
                "peer",
                new VirtualNetworkPeeringInner()
                    .withAllowVirtualNetworkAccess(true)
                    .withAllowForwardedTraffic(true)
                    .withAllowGatewayTransit(false)
                    .withUseRemoteGateways(false)
                    .withRemoteVirtualNetwork(
                        new SubResource()
                            .withId(
                                "/subscriptions/subid/resourceGroups/peerTest/providers/Microsoft.Network/virtualNetworks/vnet2")),
                null,
                com.azure.core.util.Context.NONE);
    }
}
