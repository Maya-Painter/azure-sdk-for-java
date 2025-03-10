// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicessiterecovery.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.List;
import java.util.Map;

/** HyperV replica Azure input to update replication protected item. */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "instanceType")
@JsonTypeName("HyperVReplicaAzure")
@Fluent
public final class HyperVReplicaAzureUpdateReplicationProtectedItemInput
    extends UpdateReplicationProtectedItemProviderInput {
    /*
     * The recovery Azure resource group Id for classic deployment.
     */
    @JsonProperty(value = "recoveryAzureV1ResourceGroupId")
    private String recoveryAzureV1ResourceGroupId;

    /*
     * The recovery Azure resource group Id for resource manager deployment.
     */
    @JsonProperty(value = "recoveryAzureV2ResourceGroupId")
    private String recoveryAzureV2ResourceGroupId;

    /*
     * A value indicating whether managed disks should be used during failover.
     */
    @JsonProperty(value = "useManagedDisks")
    private String useManagedDisks;

    /*
     * The dictionary of disk resource Id to disk encryption set ARM Id.
     */
    @JsonProperty(value = "diskIdToDiskEncryptionMap")
    @JsonInclude(value = JsonInclude.Include.NON_NULL, content = JsonInclude.Include.ALWAYS)
    private Map<String, String> diskIdToDiskEncryptionMap;

    /*
     * The target proximity placement group Id.
     */
    @JsonProperty(value = "targetProximityPlacementGroupId")
    private String targetProximityPlacementGroupId;

    /*
     * The target availability zone.
     */
    @JsonProperty(value = "targetAvailabilityZone")
    private String targetAvailabilityZone;

    /*
     * The target VM tags.
     */
    @JsonProperty(value = "targetVmTags")
    @JsonInclude(value = JsonInclude.Include.NON_NULL, content = JsonInclude.Include.ALWAYS)
    private Map<String, String> targetVmTags;

    /*
     * The tags for the target managed disks.
     */
    @JsonProperty(value = "targetManagedDiskTags")
    @JsonInclude(value = JsonInclude.Include.NON_NULL, content = JsonInclude.Include.ALWAYS)
    private Map<String, String> targetManagedDiskTags;

    /*
     * The tags for the target NICs.
     */
    @JsonProperty(value = "targetNicTags")
    @JsonInclude(value = JsonInclude.Include.NON_NULL, content = JsonInclude.Include.ALWAYS)
    private Map<String, String> targetNicTags;

    /*
     * The SQL Server license type.
     */
    @JsonProperty(value = "sqlServerLicenseType")
    private SqlServerLicenseType sqlServerLicenseType;

    /*
     * The list of disk update properties.
     */
    @JsonProperty(value = "vmDisks")
    private List<UpdateDiskInput> vmDisks;

    /** Creates an instance of HyperVReplicaAzureUpdateReplicationProtectedItemInput class. */
    public HyperVReplicaAzureUpdateReplicationProtectedItemInput() {
    }

    /**
     * Get the recoveryAzureV1ResourceGroupId property: The recovery Azure resource group Id for classic deployment.
     *
     * @return the recoveryAzureV1ResourceGroupId value.
     */
    public String recoveryAzureV1ResourceGroupId() {
        return this.recoveryAzureV1ResourceGroupId;
    }

    /**
     * Set the recoveryAzureV1ResourceGroupId property: The recovery Azure resource group Id for classic deployment.
     *
     * @param recoveryAzureV1ResourceGroupId the recoveryAzureV1ResourceGroupId value to set.
     * @return the HyperVReplicaAzureUpdateReplicationProtectedItemInput object itself.
     */
    public HyperVReplicaAzureUpdateReplicationProtectedItemInput withRecoveryAzureV1ResourceGroupId(
        String recoveryAzureV1ResourceGroupId) {
        this.recoveryAzureV1ResourceGroupId = recoveryAzureV1ResourceGroupId;
        return this;
    }

    /**
     * Get the recoveryAzureV2ResourceGroupId property: The recovery Azure resource group Id for resource manager
     * deployment.
     *
     * @return the recoveryAzureV2ResourceGroupId value.
     */
    public String recoveryAzureV2ResourceGroupId() {
        return this.recoveryAzureV2ResourceGroupId;
    }

    /**
     * Set the recoveryAzureV2ResourceGroupId property: The recovery Azure resource group Id for resource manager
     * deployment.
     *
     * @param recoveryAzureV2ResourceGroupId the recoveryAzureV2ResourceGroupId value to set.
     * @return the HyperVReplicaAzureUpdateReplicationProtectedItemInput object itself.
     */
    public HyperVReplicaAzureUpdateReplicationProtectedItemInput withRecoveryAzureV2ResourceGroupId(
        String recoveryAzureV2ResourceGroupId) {
        this.recoveryAzureV2ResourceGroupId = recoveryAzureV2ResourceGroupId;
        return this;
    }

    /**
     * Get the useManagedDisks property: A value indicating whether managed disks should be used during failover.
     *
     * @return the useManagedDisks value.
     */
    public String useManagedDisks() {
        return this.useManagedDisks;
    }

    /**
     * Set the useManagedDisks property: A value indicating whether managed disks should be used during failover.
     *
     * @param useManagedDisks the useManagedDisks value to set.
     * @return the HyperVReplicaAzureUpdateReplicationProtectedItemInput object itself.
     */
    public HyperVReplicaAzureUpdateReplicationProtectedItemInput withUseManagedDisks(String useManagedDisks) {
        this.useManagedDisks = useManagedDisks;
        return this;
    }

    /**
     * Get the diskIdToDiskEncryptionMap property: The dictionary of disk resource Id to disk encryption set ARM Id.
     *
     * @return the diskIdToDiskEncryptionMap value.
     */
    public Map<String, String> diskIdToDiskEncryptionMap() {
        return this.diskIdToDiskEncryptionMap;
    }

    /**
     * Set the diskIdToDiskEncryptionMap property: The dictionary of disk resource Id to disk encryption set ARM Id.
     *
     * @param diskIdToDiskEncryptionMap the diskIdToDiskEncryptionMap value to set.
     * @return the HyperVReplicaAzureUpdateReplicationProtectedItemInput object itself.
     */
    public HyperVReplicaAzureUpdateReplicationProtectedItemInput withDiskIdToDiskEncryptionMap(
        Map<String, String> diskIdToDiskEncryptionMap) {
        this.diskIdToDiskEncryptionMap = diskIdToDiskEncryptionMap;
        return this;
    }

    /**
     * Get the targetProximityPlacementGroupId property: The target proximity placement group Id.
     *
     * @return the targetProximityPlacementGroupId value.
     */
    public String targetProximityPlacementGroupId() {
        return this.targetProximityPlacementGroupId;
    }

    /**
     * Set the targetProximityPlacementGroupId property: The target proximity placement group Id.
     *
     * @param targetProximityPlacementGroupId the targetProximityPlacementGroupId value to set.
     * @return the HyperVReplicaAzureUpdateReplicationProtectedItemInput object itself.
     */
    public HyperVReplicaAzureUpdateReplicationProtectedItemInput withTargetProximityPlacementGroupId(
        String targetProximityPlacementGroupId) {
        this.targetProximityPlacementGroupId = targetProximityPlacementGroupId;
        return this;
    }

    /**
     * Get the targetAvailabilityZone property: The target availability zone.
     *
     * @return the targetAvailabilityZone value.
     */
    public String targetAvailabilityZone() {
        return this.targetAvailabilityZone;
    }

    /**
     * Set the targetAvailabilityZone property: The target availability zone.
     *
     * @param targetAvailabilityZone the targetAvailabilityZone value to set.
     * @return the HyperVReplicaAzureUpdateReplicationProtectedItemInput object itself.
     */
    public HyperVReplicaAzureUpdateReplicationProtectedItemInput withTargetAvailabilityZone(
        String targetAvailabilityZone) {
        this.targetAvailabilityZone = targetAvailabilityZone;
        return this;
    }

    /**
     * Get the targetVmTags property: The target VM tags.
     *
     * @return the targetVmTags value.
     */
    public Map<String, String> targetVmTags() {
        return this.targetVmTags;
    }

    /**
     * Set the targetVmTags property: The target VM tags.
     *
     * @param targetVmTags the targetVmTags value to set.
     * @return the HyperVReplicaAzureUpdateReplicationProtectedItemInput object itself.
     */
    public HyperVReplicaAzureUpdateReplicationProtectedItemInput withTargetVmTags(Map<String, String> targetVmTags) {
        this.targetVmTags = targetVmTags;
        return this;
    }

    /**
     * Get the targetManagedDiskTags property: The tags for the target managed disks.
     *
     * @return the targetManagedDiskTags value.
     */
    public Map<String, String> targetManagedDiskTags() {
        return this.targetManagedDiskTags;
    }

    /**
     * Set the targetManagedDiskTags property: The tags for the target managed disks.
     *
     * @param targetManagedDiskTags the targetManagedDiskTags value to set.
     * @return the HyperVReplicaAzureUpdateReplicationProtectedItemInput object itself.
     */
    public HyperVReplicaAzureUpdateReplicationProtectedItemInput withTargetManagedDiskTags(
        Map<String, String> targetManagedDiskTags) {
        this.targetManagedDiskTags = targetManagedDiskTags;
        return this;
    }

    /**
     * Get the targetNicTags property: The tags for the target NICs.
     *
     * @return the targetNicTags value.
     */
    public Map<String, String> targetNicTags() {
        return this.targetNicTags;
    }

    /**
     * Set the targetNicTags property: The tags for the target NICs.
     *
     * @param targetNicTags the targetNicTags value to set.
     * @return the HyperVReplicaAzureUpdateReplicationProtectedItemInput object itself.
     */
    public HyperVReplicaAzureUpdateReplicationProtectedItemInput withTargetNicTags(Map<String, String> targetNicTags) {
        this.targetNicTags = targetNicTags;
        return this;
    }

    /**
     * Get the sqlServerLicenseType property: The SQL Server license type.
     *
     * @return the sqlServerLicenseType value.
     */
    public SqlServerLicenseType sqlServerLicenseType() {
        return this.sqlServerLicenseType;
    }

    /**
     * Set the sqlServerLicenseType property: The SQL Server license type.
     *
     * @param sqlServerLicenseType the sqlServerLicenseType value to set.
     * @return the HyperVReplicaAzureUpdateReplicationProtectedItemInput object itself.
     */
    public HyperVReplicaAzureUpdateReplicationProtectedItemInput withSqlServerLicenseType(
        SqlServerLicenseType sqlServerLicenseType) {
        this.sqlServerLicenseType = sqlServerLicenseType;
        return this;
    }

    /**
     * Get the vmDisks property: The list of disk update properties.
     *
     * @return the vmDisks value.
     */
    public List<UpdateDiskInput> vmDisks() {
        return this.vmDisks;
    }

    /**
     * Set the vmDisks property: The list of disk update properties.
     *
     * @param vmDisks the vmDisks value to set.
     * @return the HyperVReplicaAzureUpdateReplicationProtectedItemInput object itself.
     */
    public HyperVReplicaAzureUpdateReplicationProtectedItemInput withVmDisks(List<UpdateDiskInput> vmDisks) {
        this.vmDisks = vmDisks;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
        if (vmDisks() != null) {
            vmDisks().forEach(e -> e.validate());
        }
    }
}
