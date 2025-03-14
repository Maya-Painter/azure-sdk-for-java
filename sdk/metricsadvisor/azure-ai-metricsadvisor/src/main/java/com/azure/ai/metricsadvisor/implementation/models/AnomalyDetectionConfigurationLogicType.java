// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.metricsadvisor.implementation.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/**
 * condition operator
 *
 * <p>should be specified when combining multiple detection conditions.
 */
public final class AnomalyDetectionConfigurationLogicType
        extends ExpandableStringEnum<AnomalyDetectionConfigurationLogicType> {
    /** Static value AND for AnomalyDetectionConfigurationLogicType. */
    public static final AnomalyDetectionConfigurationLogicType AND = fromString("AND");

    /** Static value OR for AnomalyDetectionConfigurationLogicType. */
    public static final AnomalyDetectionConfigurationLogicType OR = fromString("OR");

    /**
     * Creates a new instance of AnomalyDetectionConfigurationLogicType value.
     *
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public AnomalyDetectionConfigurationLogicType() {}

    /**
     * Creates or finds a AnomalyDetectionConfigurationLogicType from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding AnomalyDetectionConfigurationLogicType.
     */
    @JsonCreator
    public static AnomalyDetectionConfigurationLogicType fromString(String name) {
        return fromString(name, AnomalyDetectionConfigurationLogicType.class);
    }

    /**
     * Gets known AnomalyDetectionConfigurationLogicType values.
     *
     * @return known AnomalyDetectionConfigurationLogicType values.
     */
    public static Collection<AnomalyDetectionConfigurationLogicType> values() {
        return values(AnomalyDetectionConfigurationLogicType.class);
    }
}
