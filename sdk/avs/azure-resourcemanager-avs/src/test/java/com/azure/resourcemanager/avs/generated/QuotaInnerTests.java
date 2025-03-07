// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.avs.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.avs.fluent.models.QuotaInner;

public final class QuotaInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        QuotaInner model =
            BinaryData
                .fromString(
                    "{\"hostsRemaining\":{\"imexgstxgcpodgma\":1804797907,\"r\":600216788},\"quotaEnabled\":\"Enabled\"}")
                .toObject(QuotaInner.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        QuotaInner model = new QuotaInner();
        model = BinaryData.fromObject(model).toObject(QuotaInner.class);
    }
}
