// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.hybridcontainerservice.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.hybridcontainerservice.models.ResourceProviderOperationDisplay;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Results of the request to list operations. */
@Fluent
public final class ResourceProviderOperationInner {
    /*
     * Indicates whether the operation applies to data-plane.
     */
    @JsonProperty(value = "isDataAction")
    private String isDataAction;

    /*
     * Operation name, in format of {provider}/{resource}/{operation}
     */
    @JsonProperty(value = "name")
    private String name;

    /*
     * Display metadata associated with the operation.
     */
    @JsonProperty(value = "display")
    private ResourceProviderOperationDisplay display;

    /** Creates an instance of ResourceProviderOperationInner class. */
    public ResourceProviderOperationInner() {
    }

    /**
     * Get the isDataAction property: Indicates whether the operation applies to data-plane.
     *
     * @return the isDataAction value.
     */
    public String isDataAction() {
        return this.isDataAction;
    }

    /**
     * Set the isDataAction property: Indicates whether the operation applies to data-plane.
     *
     * @param isDataAction the isDataAction value to set.
     * @return the ResourceProviderOperationInner object itself.
     */
    public ResourceProviderOperationInner withIsDataAction(String isDataAction) {
        this.isDataAction = isDataAction;
        return this;
    }

    /**
     * Get the name property: Operation name, in format of {provider}/{resource}/{operation}.
     *
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name property: Operation name, in format of {provider}/{resource}/{operation}.
     *
     * @param name the name value to set.
     * @return the ResourceProviderOperationInner object itself.
     */
    public ResourceProviderOperationInner withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the display property: Display metadata associated with the operation.
     *
     * @return the display value.
     */
    public ResourceProviderOperationDisplay display() {
        return this.display;
    }

    /**
     * Set the display property: Display metadata associated with the operation.
     *
     * @param display the display value to set.
     * @return the ResourceProviderOperationInner object itself.
     */
    public ResourceProviderOperationInner withDisplay(ResourceProviderOperationDisplay display) {
        this.display = display;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (display() != null) {
            display().validate();
        }
    }
}
