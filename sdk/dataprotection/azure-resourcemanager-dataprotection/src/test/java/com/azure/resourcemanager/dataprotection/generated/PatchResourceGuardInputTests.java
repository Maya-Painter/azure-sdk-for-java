// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.dataprotection.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.dataprotection.models.PatchResourceGuardInput;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class PatchResourceGuardInputTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        PatchResourceGuardInput model =
            BinaryData
                .fromString("{\"tags\":{\"mrv\":\"kdwbwhkszz\",\"owtlmnguxawqald\":\"xztvbtqgsfraoyzk\"}}")
                .toObject(PatchResourceGuardInput.class);
        Assertions.assertEquals("kdwbwhkszz", model.tags().get("mrv"));
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        PatchResourceGuardInput model =
            new PatchResourceGuardInput().withTags(mapOf("mrv", "kdwbwhkszz", "owtlmnguxawqald", "xztvbtqgsfraoyzk"));
        model = BinaryData.fromObject(model).toObject(PatchResourceGuardInput.class);
        Assertions.assertEquals("kdwbwhkszz", model.tags().get("mrv"));
    }

    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}
