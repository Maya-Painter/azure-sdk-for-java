// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apimanagement.generated;

import com.azure.core.util.Context;

/** Samples for Gateway Delete. */
public final class GatewayDeleteSamples {
    /*
     * x-ms-original-file: specification/apimanagement/resource-manager/Microsoft.ApiManagement/stable/2021-08-01/examples/ApiManagementDeleteGateway.json
     */
    /**
     * Sample code: ApiManagementDeleteGateway.
     *
     * @param manager Entry point to ApiManagementManager.
     */
    public static void apiManagementDeleteGateway(
        com.azure.resourcemanager.apimanagement.ApiManagementManager manager) {
        manager.gateways().deleteWithResponse("rg1", "apimService1", "gw1", "*", Context.NONE);
    }
}
