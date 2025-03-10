// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.eventgrid.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Type of client authentication. */
public final class PartnerClientAuthenticationType extends ExpandableStringEnum<PartnerClientAuthenticationType> {
    /** Static value AzureAD for PartnerClientAuthenticationType. */
    public static final PartnerClientAuthenticationType AZURE_AD = fromString("AzureAD");

    /**
     * Creates a new instance of PartnerClientAuthenticationType value.
     *
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public PartnerClientAuthenticationType() {
    }

    /**
     * Creates or finds a PartnerClientAuthenticationType from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding PartnerClientAuthenticationType.
     */
    @JsonCreator
    public static PartnerClientAuthenticationType fromString(String name) {
        return fromString(name, PartnerClientAuthenticationType.class);
    }

    /**
     * Gets known PartnerClientAuthenticationType values.
     *
     * @return known PartnerClientAuthenticationType values.
     */
    public static Collection<PartnerClientAuthenticationType> values() {
        return values(PartnerClientAuthenticationType.class);
    }
}
