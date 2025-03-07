// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.compute.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.SubResource;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Describes a image disk. */
@Fluent
public class ImageDisk {
    /*
     * The snapshot.
     */
    @JsonProperty(value = "snapshot")
    private SubResource snapshot;

    /*
     * The managedDisk.
     */
    @JsonProperty(value = "managedDisk")
    private SubResource managedDisk;

    /*
     * The Virtual Hard Disk.
     */
    @JsonProperty(value = "blobUri")
    private String blobUri;

    /*
     * Specifies the caching requirements. Possible values are: **None,** **ReadOnly,** **ReadWrite.** The default
     * values are: **None for Standard storage. ReadOnly for Premium storage.**
     */
    @JsonProperty(value = "caching")
    private CachingTypes caching;

    /*
     * Specifies the size of empty data disks in gigabytes. This element can be used to overwrite the name of the disk
     * in a virtual machine image. This value cannot be larger than 1023 GB.
     */
    @JsonProperty(value = "diskSizeGB")
    private Integer diskSizeGB;

    /*
     * Specifies the storage account type for the managed disk. NOTE: UltraSSD_LRS can only be used with data disks, it
     * cannot be used with OS Disk.
     */
    @JsonProperty(value = "storageAccountType")
    private StorageAccountTypes storageAccountType;

    /*
     * Specifies the customer managed disk encryption set resource id for the managed image disk.
     */
    @JsonProperty(value = "diskEncryptionSet")
    private DiskEncryptionSetParameters diskEncryptionSet;

    /** Creates an instance of ImageDisk class. */
    public ImageDisk() {
    }

    /**
     * Get the snapshot property: The snapshot.
     *
     * @return the snapshot value.
     */
    public SubResource snapshot() {
        return this.snapshot;
    }

    /**
     * Set the snapshot property: The snapshot.
     *
     * @param snapshot the snapshot value to set.
     * @return the ImageDisk object itself.
     */
    public ImageDisk withSnapshot(SubResource snapshot) {
        this.snapshot = snapshot;
        return this;
    }

    /**
     * Get the managedDisk property: The managedDisk.
     *
     * @return the managedDisk value.
     */
    public SubResource managedDisk() {
        return this.managedDisk;
    }

    /**
     * Set the managedDisk property: The managedDisk.
     *
     * @param managedDisk the managedDisk value to set.
     * @return the ImageDisk object itself.
     */
    public ImageDisk withManagedDisk(SubResource managedDisk) {
        this.managedDisk = managedDisk;
        return this;
    }

    /**
     * Get the blobUri property: The Virtual Hard Disk.
     *
     * @return the blobUri value.
     */
    public String blobUri() {
        return this.blobUri;
    }

    /**
     * Set the blobUri property: The Virtual Hard Disk.
     *
     * @param blobUri the blobUri value to set.
     * @return the ImageDisk object itself.
     */
    public ImageDisk withBlobUri(String blobUri) {
        this.blobUri = blobUri;
        return this;
    }

    /**
     * Get the caching property: Specifies the caching requirements. Possible values are: **None,** **ReadOnly,**
     * **ReadWrite.** The default values are: **None for Standard storage. ReadOnly for Premium storage.**.
     *
     * @return the caching value.
     */
    public CachingTypes caching() {
        return this.caching;
    }

    /**
     * Set the caching property: Specifies the caching requirements. Possible values are: **None,** **ReadOnly,**
     * **ReadWrite.** The default values are: **None for Standard storage. ReadOnly for Premium storage.**.
     *
     * @param caching the caching value to set.
     * @return the ImageDisk object itself.
     */
    public ImageDisk withCaching(CachingTypes caching) {
        this.caching = caching;
        return this;
    }

    /**
     * Get the diskSizeGB property: Specifies the size of empty data disks in gigabytes. This element can be used to
     * overwrite the name of the disk in a virtual machine image. This value cannot be larger than 1023 GB.
     *
     * @return the diskSizeGB value.
     */
    public Integer diskSizeGB() {
        return this.diskSizeGB;
    }

    /**
     * Set the diskSizeGB property: Specifies the size of empty data disks in gigabytes. This element can be used to
     * overwrite the name of the disk in a virtual machine image. This value cannot be larger than 1023 GB.
     *
     * @param diskSizeGB the diskSizeGB value to set.
     * @return the ImageDisk object itself.
     */
    public ImageDisk withDiskSizeGB(Integer diskSizeGB) {
        this.diskSizeGB = diskSizeGB;
        return this;
    }

    /**
     * Get the storageAccountType property: Specifies the storage account type for the managed disk. NOTE: UltraSSD_LRS
     * can only be used with data disks, it cannot be used with OS Disk.
     *
     * @return the storageAccountType value.
     */
    public StorageAccountTypes storageAccountType() {
        return this.storageAccountType;
    }

    /**
     * Set the storageAccountType property: Specifies the storage account type for the managed disk. NOTE: UltraSSD_LRS
     * can only be used with data disks, it cannot be used with OS Disk.
     *
     * @param storageAccountType the storageAccountType value to set.
     * @return the ImageDisk object itself.
     */
    public ImageDisk withStorageAccountType(StorageAccountTypes storageAccountType) {
        this.storageAccountType = storageAccountType;
        return this;
    }

    /**
     * Get the diskEncryptionSet property: Specifies the customer managed disk encryption set resource id for the
     * managed image disk.
     *
     * @return the diskEncryptionSet value.
     */
    public DiskEncryptionSetParameters diskEncryptionSet() {
        return this.diskEncryptionSet;
    }

    /**
     * Set the diskEncryptionSet property: Specifies the customer managed disk encryption set resource id for the
     * managed image disk.
     *
     * @param diskEncryptionSet the diskEncryptionSet value to set.
     * @return the ImageDisk object itself.
     */
    public ImageDisk withDiskEncryptionSet(DiskEncryptionSetParameters diskEncryptionSet) {
        this.diskEncryptionSet = diskEncryptionSet;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (diskEncryptionSet() != null) {
            diskEncryptionSet().validate();
        }
    }
}
