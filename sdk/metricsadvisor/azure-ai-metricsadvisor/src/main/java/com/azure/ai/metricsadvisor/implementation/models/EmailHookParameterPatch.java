// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.metricsadvisor.implementation.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** The EmailHookParameterPatch model. */
@Fluent
public final class EmailHookParameterPatch {
    /*
     * Email TO: list.
     */
    @JsonProperty(value = "toList")
    private List<String> toList;

    /** Creates an instance of EmailHookParameterPatch class. */
    public EmailHookParameterPatch() {}

    /**
     * Get the toList property: Email TO: list.
     *
     * @return the toList value.
     */
    public List<String> getToList() {
        return this.toList;
    }

    /**
     * Set the toList property: Email TO: list.
     *
     * @param toList the toList value to set.
     * @return the EmailHookParameterPatch object itself.
     */
    public EmailHookParameterPatch setToList(List<String> toList) {
        this.toList = toList;
        return this;
    }
}
