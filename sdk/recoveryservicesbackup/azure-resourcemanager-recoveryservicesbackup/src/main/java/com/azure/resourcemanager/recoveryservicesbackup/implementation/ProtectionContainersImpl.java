// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicesbackup.implementation;

import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.recoveryservicesbackup.fluent.ProtectionContainersClient;
import com.azure.resourcemanager.recoveryservicesbackup.fluent.models.ProtectionContainerResourceInner;
import com.azure.resourcemanager.recoveryservicesbackup.models.ProtectionContainerResource;
import com.azure.resourcemanager.recoveryservicesbackup.models.ProtectionContainers;

public final class ProtectionContainersImpl implements ProtectionContainers {
    private static final ClientLogger LOGGER = new ClientLogger(ProtectionContainersImpl.class);

    private final ProtectionContainersClient innerClient;

    private final com.azure.resourcemanager.recoveryservicesbackup.RecoveryServicesBackupManager serviceManager;

    public ProtectionContainersImpl(
        ProtectionContainersClient innerClient,
        com.azure.resourcemanager.recoveryservicesbackup.RecoveryServicesBackupManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public Response<ProtectionContainerResource> getWithResponse(
        String vaultName, String resourceGroupName, String fabricName, String containerName, Context context) {
        Response<ProtectionContainerResourceInner> inner =
            this.serviceClient().getWithResponse(vaultName, resourceGroupName, fabricName, containerName, context);
        if (inner != null) {
            return new SimpleResponse<>(
                inner.getRequest(),
                inner.getStatusCode(),
                inner.getHeaders(),
                new ProtectionContainerResourceImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public ProtectionContainerResource get(
        String vaultName, String resourceGroupName, String fabricName, String containerName) {
        ProtectionContainerResourceInner inner =
            this.serviceClient().get(vaultName, resourceGroupName, fabricName, containerName);
        if (inner != null) {
            return new ProtectionContainerResourceImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public Response<Void> unregisterWithResponse(
        String vaultName, String resourceGroupName, String fabricName, String containerName, Context context) {
        return this
            .serviceClient()
            .unregisterWithResponse(vaultName, resourceGroupName, fabricName, containerName, context);
    }

    public void unregister(String vaultName, String resourceGroupName, String fabricName, String containerName) {
        this.serviceClient().unregister(vaultName, resourceGroupName, fabricName, containerName);
    }

    public Response<Void> inquireWithResponse(
        String vaultName,
        String resourceGroupName,
        String fabricName,
        String containerName,
        String filter,
        Context context) {
        return this
            .serviceClient()
            .inquireWithResponse(vaultName, resourceGroupName, fabricName, containerName, filter, context);
    }

    public void inquire(String vaultName, String resourceGroupName, String fabricName, String containerName) {
        this.serviceClient().inquire(vaultName, resourceGroupName, fabricName, containerName);
    }

    public Response<Void> refreshWithResponse(
        String vaultName, String resourceGroupName, String fabricName, String filter, Context context) {
        return this.serviceClient().refreshWithResponse(vaultName, resourceGroupName, fabricName, filter, context);
    }

    public void refresh(String vaultName, String resourceGroupName, String fabricName) {
        this.serviceClient().refresh(vaultName, resourceGroupName, fabricName);
    }

    public ProtectionContainerResource getById(String id) {
        String vaultName = Utils.getValueFromIdByName(id, "vaults");
        if (vaultName == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String.format("The resource ID '%s' is not valid. Missing path segment 'vaults'.", id)));
        }
        String resourceGroupName = Utils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String fabricName = Utils.getValueFromIdByName(id, "backupFabrics");
        if (fabricName == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String.format("The resource ID '%s' is not valid. Missing path segment 'backupFabrics'.", id)));
        }
        String containerName = Utils.getValueFromIdByName(id, "protectionContainers");
        if (containerName == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format(
                                "The resource ID '%s' is not valid. Missing path segment 'protectionContainers'.",
                                id)));
        }
        return this.getWithResponse(vaultName, resourceGroupName, fabricName, containerName, Context.NONE).getValue();
    }

    public Response<ProtectionContainerResource> getByIdWithResponse(String id, Context context) {
        String vaultName = Utils.getValueFromIdByName(id, "vaults");
        if (vaultName == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String.format("The resource ID '%s' is not valid. Missing path segment 'vaults'.", id)));
        }
        String resourceGroupName = Utils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String fabricName = Utils.getValueFromIdByName(id, "backupFabrics");
        if (fabricName == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String.format("The resource ID '%s' is not valid. Missing path segment 'backupFabrics'.", id)));
        }
        String containerName = Utils.getValueFromIdByName(id, "protectionContainers");
        if (containerName == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format(
                                "The resource ID '%s' is not valid. Missing path segment 'protectionContainers'.",
                                id)));
        }
        return this.getWithResponse(vaultName, resourceGroupName, fabricName, containerName, context);
    }

    private ProtectionContainersClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.recoveryservicesbackup.RecoveryServicesBackupManager manager() {
        return this.serviceManager;
    }

    public ProtectionContainerResourceImpl define(String name) {
        return new ProtectionContainerResourceImpl(name, this.manager());
    }
}
