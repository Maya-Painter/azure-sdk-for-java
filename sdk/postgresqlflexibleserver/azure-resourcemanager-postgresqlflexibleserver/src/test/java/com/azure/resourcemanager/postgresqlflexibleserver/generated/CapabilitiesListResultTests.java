// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.postgresqlflexibleserver.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.postgresqlflexibleserver.models.CapabilitiesListResult;

public final class CapabilitiesListResultTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        CapabilitiesListResult model =
            BinaryData
                .fromString(
                    "{\"value\":[{\"name\":\"wyahuxinpmqnja\",\"supportedServerEditions\":[],\"supportedServerVersions\":[],\"fastProvisioningSupported\":\"Disabled\",\"supportedFastProvisioningEditions\":[],\"geoBackupSupported\":\"Enabled\",\"zoneRedundantHaSupported\":\"Disabled\",\"zoneRedundantHaAndGeoBackupSupported\":\"Enabled\",\"storageAutoGrowthSupported\":\"Enabled\",\"onlineResizeSupported\":\"Enabled\",\"restricted\":\"Disabled\",\"status\":\"Available\",\"reason\":\"t\"}],\"nextLink\":\"mdvpjhulsu\"}")
                .toObject(CapabilitiesListResult.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        CapabilitiesListResult model = new CapabilitiesListResult();
        model = BinaryData.fromObject(model).toObject(CapabilitiesListResult.class);
    }
}
