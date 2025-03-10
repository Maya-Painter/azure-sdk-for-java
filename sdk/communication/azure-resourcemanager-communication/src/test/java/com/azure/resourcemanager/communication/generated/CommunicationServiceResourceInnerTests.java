// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.communication.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.communication.fluent.models.CommunicationServiceResourceInner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class CommunicationServiceResourceInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        CommunicationServiceResourceInner model =
            BinaryData
                .fromString(
                    "{\"properties\":{\"provisioningState\":\"Moving\",\"hostName\":\"xxwr\",\"dataLocation\":\"jdous\",\"notificationHubId\":\"qvkoc\",\"version\":\"jdkwtnhxbnjb\",\"immutableResourceId\":\"sqrglssainq\",\"linkedDomains\":[\"nzl\",\"jfm\",\"pee\",\"vmgxsab\"]},\"location\":\"qduujitcjczdz\",\"tags\":{\"wrwjfeu\":\"dhkrwpdappdsbdk\",\"zdatqxhocdg\":\"nhutjeltmrldhugj\"},\"id\":\"ablgphuticndvk\",\"name\":\"ozwyiftyhxhuro\",\"type\":\"ftyxolniw\"}")
                .toObject(CommunicationServiceResourceInner.class);
        Assertions.assertEquals("qduujitcjczdz", model.location());
        Assertions.assertEquals("dhkrwpdappdsbdk", model.tags().get("wrwjfeu"));
        Assertions.assertEquals("jdous", model.dataLocation());
        Assertions.assertEquals("nzl", model.linkedDomains().get(0));
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        CommunicationServiceResourceInner model =
            new CommunicationServiceResourceInner()
                .withLocation("qduujitcjczdz")
                .withTags(mapOf("wrwjfeu", "dhkrwpdappdsbdk", "zdatqxhocdg", "nhutjeltmrldhugj"))
                .withDataLocation("jdous")
                .withLinkedDomains(Arrays.asList("nzl", "jfm", "pee", "vmgxsab"));
        model = BinaryData.fromObject(model).toObject(CommunicationServiceResourceInner.class);
        Assertions.assertEquals("qduujitcjczdz", model.location());
        Assertions.assertEquals("dhkrwpdappdsbdk", model.tags().get("wrwjfeu"));
        Assertions.assertEquals("jdous", model.dataLocation());
        Assertions.assertEquals("nzl", model.linkedDomains().get(0));
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
