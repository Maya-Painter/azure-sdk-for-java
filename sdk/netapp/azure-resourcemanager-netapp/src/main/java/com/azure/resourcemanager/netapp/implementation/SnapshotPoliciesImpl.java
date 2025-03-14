// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.netapp.implementation;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.netapp.fluent.SnapshotPoliciesClient;
import com.azure.resourcemanager.netapp.fluent.models.SnapshotPolicyInner;
import com.azure.resourcemanager.netapp.fluent.models.SnapshotPolicyVolumeListInner;
import com.azure.resourcemanager.netapp.models.SnapshotPolicies;
import com.azure.resourcemanager.netapp.models.SnapshotPolicy;
import com.azure.resourcemanager.netapp.models.SnapshotPolicyVolumeList;

public final class SnapshotPoliciesImpl implements SnapshotPolicies {
    private static final ClientLogger LOGGER = new ClientLogger(SnapshotPoliciesImpl.class);

    private final SnapshotPoliciesClient innerClient;

    private final com.azure.resourcemanager.netapp.NetAppFilesManager serviceManager;

    public SnapshotPoliciesImpl(
        SnapshotPoliciesClient innerClient, com.azure.resourcemanager.netapp.NetAppFilesManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public PagedIterable<SnapshotPolicy> list(String resourceGroupName, String accountName) {
        PagedIterable<SnapshotPolicyInner> inner = this.serviceClient().list(resourceGroupName, accountName);
        return Utils.mapPage(inner, inner1 -> new SnapshotPolicyImpl(inner1, this.manager()));
    }

    public PagedIterable<SnapshotPolicy> list(String resourceGroupName, String accountName, Context context) {
        PagedIterable<SnapshotPolicyInner> inner = this.serviceClient().list(resourceGroupName, accountName, context);
        return Utils.mapPage(inner, inner1 -> new SnapshotPolicyImpl(inner1, this.manager()));
    }

    public Response<SnapshotPolicy> getWithResponse(
        String resourceGroupName, String accountName, String snapshotPolicyName, Context context) {
        Response<SnapshotPolicyInner> inner =
            this.serviceClient().getWithResponse(resourceGroupName, accountName, snapshotPolicyName, context);
        if (inner != null) {
            return new SimpleResponse<>(
                inner.getRequest(),
                inner.getStatusCode(),
                inner.getHeaders(),
                new SnapshotPolicyImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public SnapshotPolicy get(String resourceGroupName, String accountName, String snapshotPolicyName) {
        SnapshotPolicyInner inner = this.serviceClient().get(resourceGroupName, accountName, snapshotPolicyName);
        if (inner != null) {
            return new SnapshotPolicyImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public void delete(String resourceGroupName, String accountName, String snapshotPolicyName) {
        this.serviceClient().delete(resourceGroupName, accountName, snapshotPolicyName);
    }

    public void delete(String resourceGroupName, String accountName, String snapshotPolicyName, Context context) {
        this.serviceClient().delete(resourceGroupName, accountName, snapshotPolicyName, context);
    }

    public Response<SnapshotPolicyVolumeList> listVolumesWithResponse(
        String resourceGroupName, String accountName, String snapshotPolicyName, Context context) {
        Response<SnapshotPolicyVolumeListInner> inner =
            this.serviceClient().listVolumesWithResponse(resourceGroupName, accountName, snapshotPolicyName, context);
        if (inner != null) {
            return new SimpleResponse<>(
                inner.getRequest(),
                inner.getStatusCode(),
                inner.getHeaders(),
                new SnapshotPolicyVolumeListImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public SnapshotPolicyVolumeList listVolumes(
        String resourceGroupName, String accountName, String snapshotPolicyName) {
        SnapshotPolicyVolumeListInner inner =
            this.serviceClient().listVolumes(resourceGroupName, accountName, snapshotPolicyName);
        if (inner != null) {
            return new SnapshotPolicyVolumeListImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public SnapshotPolicy getById(String id) {
        String resourceGroupName = Utils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String accountName = Utils.getValueFromIdByName(id, "netAppAccounts");
        if (accountName == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format("The resource ID '%s' is not valid. Missing path segment 'netAppAccounts'.", id)));
        }
        String snapshotPolicyName = Utils.getValueFromIdByName(id, "snapshotPolicies");
        if (snapshotPolicyName == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format(
                                "The resource ID '%s' is not valid. Missing path segment 'snapshotPolicies'.", id)));
        }
        return this.getWithResponse(resourceGroupName, accountName, snapshotPolicyName, Context.NONE).getValue();
    }

    public Response<SnapshotPolicy> getByIdWithResponse(String id, Context context) {
        String resourceGroupName = Utils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String accountName = Utils.getValueFromIdByName(id, "netAppAccounts");
        if (accountName == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format("The resource ID '%s' is not valid. Missing path segment 'netAppAccounts'.", id)));
        }
        String snapshotPolicyName = Utils.getValueFromIdByName(id, "snapshotPolicies");
        if (snapshotPolicyName == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format(
                                "The resource ID '%s' is not valid. Missing path segment 'snapshotPolicies'.", id)));
        }
        return this.getWithResponse(resourceGroupName, accountName, snapshotPolicyName, context);
    }

    public void deleteById(String id) {
        String resourceGroupName = Utils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String accountName = Utils.getValueFromIdByName(id, "netAppAccounts");
        if (accountName == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format("The resource ID '%s' is not valid. Missing path segment 'netAppAccounts'.", id)));
        }
        String snapshotPolicyName = Utils.getValueFromIdByName(id, "snapshotPolicies");
        if (snapshotPolicyName == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format(
                                "The resource ID '%s' is not valid. Missing path segment 'snapshotPolicies'.", id)));
        }
        this.delete(resourceGroupName, accountName, snapshotPolicyName, Context.NONE);
    }

    public void deleteByIdWithResponse(String id, Context context) {
        String resourceGroupName = Utils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String accountName = Utils.getValueFromIdByName(id, "netAppAccounts");
        if (accountName == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format("The resource ID '%s' is not valid. Missing path segment 'netAppAccounts'.", id)));
        }
        String snapshotPolicyName = Utils.getValueFromIdByName(id, "snapshotPolicies");
        if (snapshotPolicyName == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format(
                                "The resource ID '%s' is not valid. Missing path segment 'snapshotPolicies'.", id)));
        }
        this.delete(resourceGroupName, accountName, snapshotPolicyName, context);
    }

    private SnapshotPoliciesClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.netapp.NetAppFilesManager manager() {
        return this.serviceManager;
    }

    public SnapshotPolicyImpl define(String name) {
        return new SnapshotPolicyImpl(name, this.manager());
    }
}
