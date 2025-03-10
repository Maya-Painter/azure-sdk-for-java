// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.servicenetworking.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.servicenetworking.fluent.models.TrafficControllerProperties;

public final class TrafficControllerPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        TrafficControllerProperties model =
            BinaryData
                .fromString(
                    "{\"configurationEndpoints\":[\"eqfpj\",\"jlxofpdvhpfxxyp\",\"ninmayhuyb\"],\"frontends\":[{\"id\":\"odepoogin\"},{\"id\":\"vamih\"}],\"associations\":[{\"id\":\"narxzxtheotus\"},{\"id\":\"vyevcciqi\"},{\"id\":\"nhungbw\"}],\"provisioningState\":\"Updating\"}")
                .toObject(TrafficControllerProperties.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        TrafficControllerProperties model = new TrafficControllerProperties();
        model = BinaryData.fromObject(model).toObject(TrafficControllerProperties.class);
    }
}
