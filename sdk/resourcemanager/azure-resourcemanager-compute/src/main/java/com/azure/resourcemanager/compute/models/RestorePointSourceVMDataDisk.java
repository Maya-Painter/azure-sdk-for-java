// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.compute.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Describes a data disk. */
@Fluent
public final class RestorePointSourceVMDataDisk {
    /*
     * Gets the logical unit number.
     */
    @JsonProperty(value = "lun", access = JsonProperty.Access.WRITE_ONLY)
    private Integer lun;

    /*
     * Gets the disk name.
     */
    @JsonProperty(value = "name", access = JsonProperty.Access.WRITE_ONLY)
    private String name;

    /*
     * Gets the caching type.
     */
    @JsonProperty(value = "caching", access = JsonProperty.Access.WRITE_ONLY)
    private CachingTypes caching;

    /*
     * Gets the initial disk size in GB for blank data disks, and the new desired size for existing OS and Data disks.
     */
    @JsonProperty(value = "diskSizeGB", access = JsonProperty.Access.WRITE_ONLY)
    private Integer diskSizeGB;

    /*
     * Contains the managed disk details.
     */
    @JsonProperty(value = "managedDisk")
    private ManagedDiskParameters managedDisk;

    /*
     * Contains Disk Restore Point properties.
     */
    @JsonProperty(value = "diskRestorePoint")
    private DiskRestorePointAttributes diskRestorePoint;

    /*
     * Shows true if the disk is write-accelerator enabled.
     */
    @JsonProperty(value = "writeAcceleratorEnabled", access = JsonProperty.Access.WRITE_ONLY)
    private Boolean writeAcceleratorEnabled;

    /** Creates an instance of RestorePointSourceVMDataDisk class. */
    public RestorePointSourceVMDataDisk() {
    }

    /**
     * Get the lun property: Gets the logical unit number.
     *
     * @return the lun value.
     */
    public Integer lun() {
        return this.lun;
    }

    /**
     * Get the name property: Gets the disk name.
     *
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Get the caching property: Gets the caching type.
     *
     * @return the caching value.
     */
    public CachingTypes caching() {
        return this.caching;
    }

    /**
     * Get the diskSizeGB property: Gets the initial disk size in GB for blank data disks, and the new desired size for
     * existing OS and Data disks.
     *
     * @return the diskSizeGB value.
     */
    public Integer diskSizeGB() {
        return this.diskSizeGB;
    }

    /**
     * Get the managedDisk property: Contains the managed disk details.
     *
     * @return the managedDisk value.
     */
    public ManagedDiskParameters managedDisk() {
        return this.managedDisk;
    }

    /**
     * Set the managedDisk property: Contains the managed disk details.
     *
     * @param managedDisk the managedDisk value to set.
     * @return the RestorePointSourceVMDataDisk object itself.
     */
    public RestorePointSourceVMDataDisk withManagedDisk(ManagedDiskParameters managedDisk) {
        this.managedDisk = managedDisk;
        return this;
    }

    /**
     * Get the diskRestorePoint property: Contains Disk Restore Point properties.
     *
     * @return the diskRestorePoint value.
     */
    public DiskRestorePointAttributes diskRestorePoint() {
        return this.diskRestorePoint;
    }

    /**
     * Set the diskRestorePoint property: Contains Disk Restore Point properties.
     *
     * @param diskRestorePoint the diskRestorePoint value to set.
     * @return the RestorePointSourceVMDataDisk object itself.
     */
    public RestorePointSourceVMDataDisk withDiskRestorePoint(DiskRestorePointAttributes diskRestorePoint) {
        this.diskRestorePoint = diskRestorePoint;
        return this;
    }

    /**
     * Get the writeAcceleratorEnabled property: Shows true if the disk is write-accelerator enabled.
     *
     * @return the writeAcceleratorEnabled value.
     */
    public Boolean writeAcceleratorEnabled() {
        return this.writeAcceleratorEnabled;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (managedDisk() != null) {
            managedDisk().validate();
        }
        if (diskRestorePoint() != null) {
            diskRestorePoint().validate();
        }
    }
}
