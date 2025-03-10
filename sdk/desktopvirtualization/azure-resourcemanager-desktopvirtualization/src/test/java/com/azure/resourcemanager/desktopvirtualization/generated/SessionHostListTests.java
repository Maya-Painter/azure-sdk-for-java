// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.desktopvirtualization.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.desktopvirtualization.fluent.models.SessionHostInner;
import com.azure.resourcemanager.desktopvirtualization.models.SessionHostList;
import com.azure.resourcemanager.desktopvirtualization.models.Status;
import com.azure.resourcemanager.desktopvirtualization.models.UpdateState;
import java.time.OffsetDateTime;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class SessionHostListTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        SessionHostList model =
            BinaryData
                .fromString(
                    "{\"value\":[{\"properties\":{\"objectId\":\"ugjhky\",\"lastHeartBeat\":\"2020-12-25T16:19:20Z\",\"sessions\":642347272,\"agentVersion\":\"gssofwq\",\"allowNewSession\":false,\"virtualMachineId\":\"lkrm\",\"resourceId\":\"i\",\"assignedUser\":\"xacqqudfnbyx\",\"friendlyName\":\"aabjyvayffimrz\",\"status\":\"SxSStackListenerNotReady\",\"statusTimestamp\":\"2021-04-17T19:16:23Z\",\"osVersion\":\"gsexne\",\"sxSStackVersion\":\"dnw\",\"updateState\":\"Failed\",\"lastUpdateTime\":\"2021-01-03T05:03:28Z\",\"updateErrorMessage\":\"syyceuzsoibjud\",\"sessionHostHealthCheckResults\":[]},\"id\":\"rx\",\"name\":\"rthzvaytdwkqbrqu\",\"type\":\"paxh\"}],\"nextLink\":\"iilivpdtiirqtd\"}")
                .toObject(SessionHostList.class);
        Assertions.assertEquals(OffsetDateTime.parse("2020-12-25T16:19:20Z"), model.value().get(0).lastHeartBeat());
        Assertions.assertEquals(642347272, model.value().get(0).sessions());
        Assertions.assertEquals("gssofwq", model.value().get(0).agentVersion());
        Assertions.assertEquals(false, model.value().get(0).allowNewSession());
        Assertions.assertEquals("xacqqudfnbyx", model.value().get(0).assignedUser());
        Assertions.assertEquals("aabjyvayffimrz", model.value().get(0).friendlyName());
        Assertions.assertEquals(Status.SX_SSTACK_LISTENER_NOT_READY, model.value().get(0).status());
        Assertions.assertEquals("gsexne", model.value().get(0).osVersion());
        Assertions.assertEquals("dnw", model.value().get(0).sxSStackVersion());
        Assertions.assertEquals(UpdateState.FAILED, model.value().get(0).updateState());
        Assertions.assertEquals("syyceuzsoibjud", model.value().get(0).updateErrorMessage());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        SessionHostList model =
            new SessionHostList()
                .withValue(
                    Arrays
                        .asList(
                            new SessionHostInner()
                                .withLastHeartBeat(OffsetDateTime.parse("2020-12-25T16:19:20Z"))
                                .withSessions(642347272)
                                .withAgentVersion("gssofwq")
                                .withAllowNewSession(false)
                                .withAssignedUser("xacqqudfnbyx")
                                .withFriendlyName("aabjyvayffimrz")
                                .withStatus(Status.SX_SSTACK_LISTENER_NOT_READY)
                                .withOsVersion("gsexne")
                                .withSxSStackVersion("dnw")
                                .withUpdateState(UpdateState.FAILED)
                                .withUpdateErrorMessage("syyceuzsoibjud")));
        model = BinaryData.fromObject(model).toObject(SessionHostList.class);
        Assertions.assertEquals(OffsetDateTime.parse("2020-12-25T16:19:20Z"), model.value().get(0).lastHeartBeat());
        Assertions.assertEquals(642347272, model.value().get(0).sessions());
        Assertions.assertEquals("gssofwq", model.value().get(0).agentVersion());
        Assertions.assertEquals(false, model.value().get(0).allowNewSession());
        Assertions.assertEquals("xacqqudfnbyx", model.value().get(0).assignedUser());
        Assertions.assertEquals("aabjyvayffimrz", model.value().get(0).friendlyName());
        Assertions.assertEquals(Status.SX_SSTACK_LISTENER_NOT_READY, model.value().get(0).status());
        Assertions.assertEquals("gsexne", model.value().get(0).osVersion());
        Assertions.assertEquals("dnw", model.value().get(0).sxSStackVersion());
        Assertions.assertEquals(UpdateState.FAILED, model.value().get(0).updateState());
        Assertions.assertEquals("syyceuzsoibjud", model.value().get(0).updateErrorMessage());
    }
}
