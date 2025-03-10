// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicessiterecovery.models;

import com.azure.resourcemanager.recoveryservicessiterecovery.fluent.models.TargetComputeSizeInner;

/** An immutable client-side representation of TargetComputeSize. */
public interface TargetComputeSize {
    /**
     * Gets the id property: The Id.
     *
     * @return the id value.
     */
    String id();

    /**
     * Gets the name property: The name.
     *
     * @return the name value.
     */
    String name();

    /**
     * Gets the type property: The Type of the object.
     *
     * @return the type value.
     */
    String type();

    /**
     * Gets the properties property: The custom data.
     *
     * @return the properties value.
     */
    TargetComputeSizeProperties properties();

    /**
     * Gets the inner com.azure.resourcemanager.recoveryservicessiterecovery.fluent.models.TargetComputeSizeInner
     * object.
     *
     * @return the inner object.
     */
    TargetComputeSizeInner innerModel();
}
