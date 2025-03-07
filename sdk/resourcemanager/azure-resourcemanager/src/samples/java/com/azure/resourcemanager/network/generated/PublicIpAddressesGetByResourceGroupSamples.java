// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.network.generated;

/** Samples for PublicIpAddresses GetByResourceGroup. */
public final class PublicIpAddressesGetByResourceGroupSamples {
    /*
     * x-ms-original-file: specification/network/resource-manager/Microsoft.Network/stable/2023-02-01/examples/PublicIpAddressGet.json
     */
    /**
     * Sample code: Get public IP address.
     *
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void getPublicIPAddress(com.azure.resourcemanager.AzureResourceManager azure) {
        azure
            .networks()
            .manager()
            .serviceClient()
            .getPublicIpAddresses()
            .getByResourceGroupWithResponse("rg1", "testDNS-ip", null, com.azure.core.util.Context.NONE);
    }
}
