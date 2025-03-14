// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.implementation;

import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.security.fluent.AdvancedThreatProtectionsClient;
import com.azure.resourcemanager.security.fluent.models.AdvancedThreatProtectionSettingInner;
import com.azure.resourcemanager.security.models.AdvancedThreatProtectionSetting;
import com.azure.resourcemanager.security.models.AdvancedThreatProtections;

public final class AdvancedThreatProtectionsImpl implements AdvancedThreatProtections {
    private static final ClientLogger LOGGER = new ClientLogger(AdvancedThreatProtectionsImpl.class);

    private final AdvancedThreatProtectionsClient innerClient;

    private final com.azure.resourcemanager.security.SecurityManager serviceManager;

    public AdvancedThreatProtectionsImpl(
        AdvancedThreatProtectionsClient innerClient,
        com.azure.resourcemanager.security.SecurityManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public Response<AdvancedThreatProtectionSetting> getWithResponse(String resourceId, Context context) {
        Response<AdvancedThreatProtectionSettingInner> inner =
            this.serviceClient().getWithResponse(resourceId, context);
        if (inner != null) {
            return new SimpleResponse<>(
                inner.getRequest(),
                inner.getStatusCode(),
                inner.getHeaders(),
                new AdvancedThreatProtectionSettingImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public AdvancedThreatProtectionSetting get(String resourceId) {
        AdvancedThreatProtectionSettingInner inner = this.serviceClient().get(resourceId);
        if (inner != null) {
            return new AdvancedThreatProtectionSettingImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public AdvancedThreatProtectionSetting getById(String id) {
        String resourceId =
            Utils
                .getValueFromIdByParameterName(
                    id,
                    "/{resourceId}/providers/Microsoft.Security/advancedThreatProtectionSettings/{settingName}",
                    "resourceId");
        if (resourceId == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String.format("The resource ID '%s' is not valid. Missing path segment 'resourceId'.", id)));
        }
        return this.getWithResponse(resourceId, Context.NONE).getValue();
    }

    public Response<AdvancedThreatProtectionSetting> getByIdWithResponse(String id, Context context) {
        String resourceId =
            Utils
                .getValueFromIdByParameterName(
                    id,
                    "/{resourceId}/providers/Microsoft.Security/advancedThreatProtectionSettings/{settingName}",
                    "resourceId");
        if (resourceId == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String.format("The resource ID '%s' is not valid. Missing path segment 'resourceId'.", id)));
        }
        return this.getWithResponse(resourceId, context);
    }

    private AdvancedThreatProtectionsClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.security.SecurityManager manager() {
        return this.serviceManager;
    }

    public AdvancedThreatProtectionSettingImpl define() {
        return new AdvancedThreatProtectionSettingImpl(this.manager());
    }
}
