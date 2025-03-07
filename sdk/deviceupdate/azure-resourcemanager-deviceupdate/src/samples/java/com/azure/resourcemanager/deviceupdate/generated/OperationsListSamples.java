// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.deviceupdate.generated;

import com.azure.core.util.Context;

/** Samples for Operations List. */
public final class OperationsListSamples {
    /*
     * x-ms-original-file: specification/deviceupdate/resource-manager/Microsoft.DeviceUpdate/stable/2022-10-01/examples/Operations_List.json
     */
    /**
     * Sample code: Gets list of Operations.
     *
     * @param manager Entry point to DeviceUpdateManager.
     */
    public static void getsListOfOperations(com.azure.resourcemanager.deviceupdate.DeviceUpdateManager manager) {
        manager.operations().list(Context.NONE);
    }
}
