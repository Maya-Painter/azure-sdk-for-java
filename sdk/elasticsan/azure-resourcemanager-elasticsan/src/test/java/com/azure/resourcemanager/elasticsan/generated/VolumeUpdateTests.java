// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.elasticsan.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.elasticsan.models.VolumeUpdate;
import org.junit.jupiter.api.Assertions;

public final class VolumeUpdateTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        VolumeUpdate model =
            BinaryData.fromString("{\"properties\":{\"sizeGiB\":3301208873451353508}}").toObject(VolumeUpdate.class);
        Assertions.assertEquals(3301208873451353508L, model.sizeGiB());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        VolumeUpdate model = new VolumeUpdate().withSizeGiB(3301208873451353508L);
        model = BinaryData.fromObject(model).toObject(VolumeUpdate.class);
        Assertions.assertEquals(3301208873451353508L, model.sizeGiB());
    }
}
