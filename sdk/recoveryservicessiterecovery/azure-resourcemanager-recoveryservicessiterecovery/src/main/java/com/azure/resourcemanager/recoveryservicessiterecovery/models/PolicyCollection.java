// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicessiterecovery.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.recoveryservicessiterecovery.fluent.models.PolicyInner;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Protection Profile Collection details. */
@Fluent
public final class PolicyCollection {
    /*
     * The policy details.
     */
    @JsonProperty(value = "value")
    private List<PolicyInner> value;

    /*
     * The value of next link.
     */
    @JsonProperty(value = "nextLink")
    private String nextLink;

    /** Creates an instance of PolicyCollection class. */
    public PolicyCollection() {
    }

    /**
     * Get the value property: The policy details.
     *
     * @return the value value.
     */
    public List<PolicyInner> value() {
        return this.value;
    }

    /**
     * Set the value property: The policy details.
     *
     * @param value the value value to set.
     * @return the PolicyCollection object itself.
     */
    public PolicyCollection withValue(List<PolicyInner> value) {
        this.value = value;
        return this;
    }

    /**
     * Get the nextLink property: The value of next link.
     *
     * @return the nextLink value.
     */
    public String nextLink() {
        return this.nextLink;
    }

    /**
     * Set the nextLink property: The value of next link.
     *
     * @param nextLink the nextLink value to set.
     * @return the PolicyCollection object itself.
     */
    public PolicyCollection withNextLink(String nextLink) {
        this.nextLink = nextLink;
        return this;
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
