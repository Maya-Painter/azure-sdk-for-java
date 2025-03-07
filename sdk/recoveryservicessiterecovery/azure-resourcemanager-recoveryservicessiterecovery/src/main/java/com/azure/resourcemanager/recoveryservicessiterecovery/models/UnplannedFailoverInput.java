// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicessiterecovery.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Input definition for unplanned failover. */
@Fluent
public final class UnplannedFailoverInput {
    /*
     * Unplanned failover input properties.
     */
    @JsonProperty(value = "properties", required = true)
    private UnplannedFailoverInputProperties properties;

    /** Creates an instance of UnplannedFailoverInput class. */
    public UnplannedFailoverInput() {
    }

    /**
     * Get the properties property: Unplanned failover input properties.
     *
     * @return the properties value.
     */
    public UnplannedFailoverInputProperties properties() {
        return this.properties;
    }

    /**
     * Set the properties property: Unplanned failover input properties.
     *
     * @param properties the properties value to set.
     * @return the UnplannedFailoverInput object itself.
     */
    public UnplannedFailoverInput withProperties(UnplannedFailoverInputProperties properties) {
        this.properties = properties;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (properties() == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        "Missing required property properties in model UnplannedFailoverInput"));
        } else {
            properties().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(UnplannedFailoverInput.class);
}
