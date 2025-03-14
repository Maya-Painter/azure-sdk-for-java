// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appcontainers.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.appcontainers.models.VolumeMount;
import org.junit.jupiter.api.Assertions;

public final class VolumeMountTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        VolumeMount model =
            BinaryData
                .fromString("{\"volumeName\":\"areqna\",\"mountPath\":\"qugjhkycube\"}")
                .toObject(VolumeMount.class);
        Assertions.assertEquals("areqna", model.volumeName());
        Assertions.assertEquals("qugjhkycube", model.mountPath());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        VolumeMount model = new VolumeMount().withVolumeName("areqna").withMountPath("qugjhkycube");
        model = BinaryData.fromObject(model).toObject(VolumeMount.class);
        Assertions.assertEquals("areqna", model.volumeName());
        Assertions.assertEquals("qugjhkycube", model.mountPath());
    }
}
