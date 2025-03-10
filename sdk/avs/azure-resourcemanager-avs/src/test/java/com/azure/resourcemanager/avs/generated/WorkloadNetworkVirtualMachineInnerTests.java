// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.avs.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.avs.fluent.models.WorkloadNetworkVirtualMachineInner;
import org.junit.jupiter.api.Assertions;

public final class WorkloadNetworkVirtualMachineInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        WorkloadNetworkVirtualMachineInner model =
            BinaryData
                .fromString(
                    "{\"properties\":{\"displayName\":\"riofzpyqse\",\"vmType\":\"REGULAR\"},\"id\":\"bnetshh\",\"name\":\"zhedplvwiw\",\"type\":\"bmwmbesldnkw\"}")
                .toObject(WorkloadNetworkVirtualMachineInner.class);
        Assertions.assertEquals("riofzpyqse", model.displayName());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        WorkloadNetworkVirtualMachineInner model =
            new WorkloadNetworkVirtualMachineInner().withDisplayName("riofzpyqse");
        model = BinaryData.fromObject(model).toObject(WorkloadNetworkVirtualMachineInner.class);
        Assertions.assertEquals("riofzpyqse", model.displayName());
    }
}
