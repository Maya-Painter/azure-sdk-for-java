// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.netapp.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.netapp.models.UserAssignedIdentity;

public final class UserAssignedIdentityTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        UserAssignedIdentity model =
            BinaryData
                .fromString(
                    "{\"principalId\":\"cad3b7e9-0d0a-4978-9695-3392400ceb06\",\"clientId\":\"99e1f309-cb5d-4c5c-8738-50caff5cf3e4\"}")
                .toObject(UserAssignedIdentity.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        UserAssignedIdentity model = new UserAssignedIdentity();
        model = BinaryData.fromObject(model).toObject(UserAssignedIdentity.class);
    }
}
