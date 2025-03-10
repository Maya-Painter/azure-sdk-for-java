// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apimanagement.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Contract defining the Tag property in the Tag Resource Contract. */
@Fluent
public final class TagResourceContractProperties {
    /*
     * Tag identifier
     */
    @JsonProperty(value = "id")
    private String id;

    /*
     * Tag Name
     */
    @JsonProperty(value = "name")
    private String name;

    /**
     * Get the id property: Tag identifier.
     *
     * @return the id value.
     */
    public String id() {
        return this.id;
    }

    /**
     * Set the id property: Tag identifier.
     *
     * @param id the id value to set.
     * @return the TagResourceContractProperties object itself.
     */
    public TagResourceContractProperties withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get the name property: Tag Name.
     *
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name property: Tag Name.
     *
     * @param name the name value to set.
     * @return the TagResourceContractProperties object itself.
     */
    public TagResourceContractProperties withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}
