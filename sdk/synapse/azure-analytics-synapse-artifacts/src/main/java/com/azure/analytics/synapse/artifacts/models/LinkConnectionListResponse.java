// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.synapse.artifacts.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** The LinkConnectionListResponse model. */
@Fluent
public final class LinkConnectionListResponse {
    /*
     * List link connection value
     */
    @JsonProperty(value = "value", required = true)
    private List<LinkConnectionResource> value;

    /*
     * List link connections next link
     */
    @JsonProperty(value = "nextLink")
    private String nextLink;

    /** Creates an instance of LinkConnectionListResponse class. */
    public LinkConnectionListResponse() {}

    /**
     * Get the value property: List link connection value.
     *
     * @return the value value.
     */
    public List<LinkConnectionResource> getValue() {
        return this.value;
    }

    /**
     * Set the value property: List link connection value.
     *
     * @param value the value value to set.
     * @return the LinkConnectionListResponse object itself.
     */
    public LinkConnectionListResponse setValue(List<LinkConnectionResource> value) {
        this.value = value;
        return this;
    }

    /**
     * Get the nextLink property: List link connections next link.
     *
     * @return the nextLink value.
     */
    public String getNextLink() {
        return this.nextLink;
    }

    /**
     * Set the nextLink property: List link connections next link.
     *
     * @param nextLink the nextLink value to set.
     * @return the LinkConnectionListResponse object itself.
     */
    public LinkConnectionListResponse setNextLink(String nextLink) {
        this.nextLink = nextLink;
        return this;
    }
}
