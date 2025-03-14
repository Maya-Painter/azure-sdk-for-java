// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.networkcloud.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.networkcloud.fluent.models.ClusterMetricsConfigurationPatchProperties;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class ClusterMetricsConfigurationPatchPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ClusterMetricsConfigurationPatchProperties model =
            BinaryData
                .fromString(
                    "{\"collectionInterval\":1385586736295567708,\"enabledMetrics\":[\"yirdhlisngwflqq\",\"pizruwnpqxpxiw\",\"cng\"]}")
                .toObject(ClusterMetricsConfigurationPatchProperties.class);
        Assertions.assertEquals(1385586736295567708L, model.collectionInterval());
        Assertions.assertEquals("yirdhlisngwflqq", model.enabledMetrics().get(0));
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ClusterMetricsConfigurationPatchProperties model =
            new ClusterMetricsConfigurationPatchProperties()
                .withCollectionInterval(1385586736295567708L)
                .withEnabledMetrics(Arrays.asList("yirdhlisngwflqq", "pizruwnpqxpxiw", "cng"));
        model = BinaryData.fromObject(model).toObject(ClusterMetricsConfigurationPatchProperties.class);
        Assertions.assertEquals(1385586736295567708L, model.collectionInterval());
        Assertions.assertEquals("yirdhlisngwflqq", model.enabledMetrics().get(0));
    }
}
