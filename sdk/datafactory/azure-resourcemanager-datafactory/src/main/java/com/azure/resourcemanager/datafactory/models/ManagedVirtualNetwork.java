// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.Map;

/** A managed Virtual Network associated with the Azure Data Factory. */
@Fluent
public final class ManagedVirtualNetwork {
    /*
     * Managed Virtual Network ID.
     */
    @JsonProperty(value = "vNetId", access = JsonProperty.Access.WRITE_ONLY)
    private String vNetId;

    /*
     * Managed Virtual Network alias.
     */
    @JsonProperty(value = "alias", access = JsonProperty.Access.WRITE_ONLY)
    private String alias;

    /*
     * A managed Virtual Network associated with the Azure Data Factory
     */
    @JsonIgnore private Map<String, Object> additionalProperties;

    /** Creates an instance of ManagedVirtualNetwork class. */
    public ManagedVirtualNetwork() {
    }

    /**
     * Get the vNetId property: Managed Virtual Network ID.
     *
     * @return the vNetId value.
     */
    public String vNetId() {
        return this.vNetId;
    }

    /**
     * Get the alias property: Managed Virtual Network alias.
     *
     * @return the alias value.
     */
    public String alias() {
        return this.alias;
    }

    /**
     * Get the additionalProperties property: A managed Virtual Network associated with the Azure Data Factory.
     *
     * @return the additionalProperties value.
     */
    @JsonAnyGetter
    public Map<String, Object> additionalProperties() {
        return this.additionalProperties;
    }

    /**
     * Set the additionalProperties property: A managed Virtual Network associated with the Azure Data Factory.
     *
     * @param additionalProperties the additionalProperties value to set.
     * @return the ManagedVirtualNetwork object itself.
     */
    public ManagedVirtualNetwork withAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
        return this;
    }

    @JsonAnySetter
    void withAdditionalProperties(String key, Object value) {
        if (additionalProperties == null) {
            additionalProperties = new HashMap<>();
        }
        additionalProperties.put(key, value);
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}
