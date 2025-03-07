// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.networkcloud.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.networkcloud.fluent.models.BareMetalMachineInner;
import com.azure.resourcemanager.networkcloud.models.BareMetalMachineList;
import com.azure.resourcemanager.networkcloud.models.ExtendedLocation;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class BareMetalMachineListTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        BareMetalMachineList model =
            BinaryData
                .fromString(
                    "{\"nextLink\":\"a\",\"value\":[{\"extendedLocation\":{\"name\":\"hxqh\",\"type\":\"bifpikxwczb\"},\"properties\":{\"associatedResourceIds\":[],\"bmcConnectionString\":\"cnpqxuhivyqniwby\",\"bmcMacAddress\":\"rkxvdum\",\"bootMacAddress\":\"grtfwvu\",\"clusterId\":\"gaudcc\",\"cordonStatus\":\"Cordoned\",\"detailedStatus\":\"Available\",\"detailedStatusMessage\":\"nyejhkryhtnap\",\"hybridAksClustersAssociatedIds\":[],\"kubernetesNodeName\":\"kjyemkk\",\"kubernetesVersion\":\"ipjoxzjnchgejs\",\"machineDetails\":\"odmailzyd\",\"machineName\":\"h\",\"machineSkuId\":\"jwyahuxinpmqnja\",\"oamIpv4Address\":\"ixjsprozvcputeg\",\"oamIpv6Address\":\"wmfdatscmdvpjhul\",\"osImage\":\"uvm\",\"powerState\":\"Off\",\"provisioningState\":\"Canceled\",\"rackId\":\"rwfndiod\",\"rackSlot\":1798808176540213287,\"readyState\":\"True\",\"serialNumber\":\"ej\",\"serviceTag\":\"vwryoqpso\",\"virtualMachinesAssociatedIds\":[]},\"location\":\"tazak\",\"tags\":{\"yffdfdos\":\"ahbc\",\"hcrzevd\":\"gexpaojakhmsbz\",\"qjbpfzfsin\":\"hlxaolthqtr\"},\"id\":\"gvfcj\",\"name\":\"wzo\",\"type\":\"xjtfelluwfzit\"}]}")
                .toObject(BareMetalMachineList.class);
        Assertions.assertEquals("a", model.nextLink());
        Assertions.assertEquals("tazak", model.value().get(0).location());
        Assertions.assertEquals("ahbc", model.value().get(0).tags().get("yffdfdos"));
        Assertions.assertEquals("hxqh", model.value().get(0).extendedLocation().name());
        Assertions.assertEquals("bifpikxwczb", model.value().get(0).extendedLocation().type());
        Assertions.assertEquals("cnpqxuhivyqniwby", model.value().get(0).bmcConnectionString());
        Assertions.assertEquals("rkxvdum", model.value().get(0).bmcMacAddress());
        Assertions.assertEquals("grtfwvu", model.value().get(0).bootMacAddress());
        Assertions.assertEquals("odmailzyd", model.value().get(0).machineDetails());
        Assertions.assertEquals("h", model.value().get(0).machineName());
        Assertions.assertEquals("jwyahuxinpmqnja", model.value().get(0).machineSkuId());
        Assertions.assertEquals("rwfndiod", model.value().get(0).rackId());
        Assertions.assertEquals(1798808176540213287L, model.value().get(0).rackSlot());
        Assertions.assertEquals("ej", model.value().get(0).serialNumber());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        BareMetalMachineList model =
            new BareMetalMachineList()
                .withNextLink("a")
                .withValue(
                    Arrays
                        .asList(
                            new BareMetalMachineInner()
                                .withLocation("tazak")
                                .withTags(
                                    mapOf("yffdfdos", "ahbc", "hcrzevd", "gexpaojakhmsbz", "qjbpfzfsin", "hlxaolthqtr"))
                                .withExtendedLocation(new ExtendedLocation().withName("hxqh").withType("bifpikxwczb"))
                                .withBmcConnectionString("cnpqxuhivyqniwby")
                                .withBmcMacAddress("rkxvdum")
                                .withBootMacAddress("grtfwvu")
                                .withMachineDetails("odmailzyd")
                                .withMachineName("h")
                                .withMachineSkuId("jwyahuxinpmqnja")
                                .withRackId("rwfndiod")
                                .withRackSlot(1798808176540213287L)
                                .withSerialNumber("ej")));
        model = BinaryData.fromObject(model).toObject(BareMetalMachineList.class);
        Assertions.assertEquals("a", model.nextLink());
        Assertions.assertEquals("tazak", model.value().get(0).location());
        Assertions.assertEquals("ahbc", model.value().get(0).tags().get("yffdfdos"));
        Assertions.assertEquals("hxqh", model.value().get(0).extendedLocation().name());
        Assertions.assertEquals("bifpikxwczb", model.value().get(0).extendedLocation().type());
        Assertions.assertEquals("cnpqxuhivyqniwby", model.value().get(0).bmcConnectionString());
        Assertions.assertEquals("rkxvdum", model.value().get(0).bmcMacAddress());
        Assertions.assertEquals("grtfwvu", model.value().get(0).bootMacAddress());
        Assertions.assertEquals("odmailzyd", model.value().get(0).machineDetails());
        Assertions.assertEquals("h", model.value().get(0).machineName());
        Assertions.assertEquals("jwyahuxinpmqnja", model.value().get(0).machineSkuId());
        Assertions.assertEquals("rwfndiod", model.value().get(0).rackId());
        Assertions.assertEquals(1798808176540213287L, model.value().get(0).rackSlot());
        Assertions.assertEquals("ej", model.value().get(0).serialNumber());
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
