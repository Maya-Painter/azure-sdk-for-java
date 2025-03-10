// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.monitor.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.monitor.fluent.models.LocalizableStringInner;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * A collection of event categories. Currently possible values are: Administrative, Security, ServiceHealth, Alert,
 * Recommendation, Policy.
 */
@Fluent
public final class EventCategoryCollection {
    /*
     * the list that includes the Azure event categories.
     */
    @JsonProperty(value = "value", required = true)
    private List<LocalizableStringInner> value;

    /** Creates an instance of EventCategoryCollection class. */
    public EventCategoryCollection() {
    }

    /**
     * Get the value property: the list that includes the Azure event categories.
     *
     * @return the value value.
     */
    public List<LocalizableStringInner> value() {
        return this.value;
    }

    /**
     * Set the value property: the list that includes the Azure event categories.
     *
     * @param value the value value to set.
     * @return the EventCategoryCollection object itself.
     */
    public EventCategoryCollection withValue(List<LocalizableStringInner> value) {
        this.value = value;
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
                    new IllegalArgumentException("Missing required property value in model EventCategoryCollection"));
        } else {
            value().forEach(e -> e.validate());
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(EventCategoryCollection.class);
}
