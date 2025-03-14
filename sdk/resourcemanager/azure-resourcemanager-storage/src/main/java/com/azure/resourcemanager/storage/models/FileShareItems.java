// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.storage.models;

import com.azure.core.annotation.Immutable;
import com.azure.resourcemanager.storage.fluent.models.FileShareItemInner;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Response schema. Contains list of shares returned, and if paging is requested or required, a URL to next page of
 * shares.
 */
@Immutable
public final class FileShareItems {
    /*
     * List of file shares returned.
     */
    @JsonProperty(value = "value", access = JsonProperty.Access.WRITE_ONLY)
    private List<FileShareItemInner> value;

    /*
     * Request URL that can be used to query next page of shares. Returned when total number of requested shares exceed
     * maximum page size.
     */
    @JsonProperty(value = "nextLink", access = JsonProperty.Access.WRITE_ONLY)
    private String nextLink;

    /**
     * Get the value property: List of file shares returned.
     *
     * @return the value value.
     */
    public List<FileShareItemInner> value() {
        return this.value;
    }

    /**
     * Get the nextLink property: Request URL that can be used to query next page of shares. Returned when total number
     * of requested shares exceed maximum page size.
     *
     * @return the nextLink value.
     */
    public String nextLink() {
        return this.nextLink;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (value() != null) {
            value().forEach(e -> e.validate());
        }
    }
}
