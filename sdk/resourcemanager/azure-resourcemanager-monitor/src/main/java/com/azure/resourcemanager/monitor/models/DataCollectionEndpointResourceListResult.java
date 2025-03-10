// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.monitor.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.monitor.fluent.models.DataCollectionEndpointResourceInner;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** A pageable list of resources. */
@Fluent
public final class DataCollectionEndpointResourceListResult {
    /*
     * A list of resources.
     */
    @JsonProperty(value = "value", required = true)
    private List<DataCollectionEndpointResourceInner> value;

    /*
     * The URL to use for getting the next set of results.
     */
    @JsonProperty(value = "nextLink")
    private String nextLink;

    /** Creates an instance of DataCollectionEndpointResourceListResult class. */
    public DataCollectionEndpointResourceListResult() {
    }

    /**
     * Get the value property: A list of resources.
     *
     * @return the value value.
     */
    public List<DataCollectionEndpointResourceInner> value() {
        return this.value;
    }

    /**
     * Set the value property: A list of resources.
     *
     * @param value the value value to set.
     * @return the DataCollectionEndpointResourceListResult object itself.
     */
    public DataCollectionEndpointResourceListResult withValue(List<DataCollectionEndpointResourceInner> value) {
        this.value = value;
        return this;
    }

    /**
     * Get the nextLink property: The URL to use for getting the next set of results.
     *
     * @return the nextLink value.
     */
    public String nextLink() {
        return this.nextLink;
    }

    /**
     * Set the nextLink property: The URL to use for getting the next set of results.
     *
     * @param nextLink the nextLink value to set.
     * @return the DataCollectionEndpointResourceListResult object itself.
     */
    public DataCollectionEndpointResourceListResult withNextLink(String nextLink) {
        this.nextLink = nextLink;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (value() == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        "Missing required property value in model DataCollectionEndpointResourceListResult"));
        } else {
            value().forEach(e -> e.validate());
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(DataCollectionEndpointResourceListResult.class);
}
