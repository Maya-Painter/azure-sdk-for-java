// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.messaging.servicebus.administration.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Access rights of an authorization. */
public final class AccessRights extends ExpandableStringEnum<AccessRights> {
    /** Static value Manage for AccessRights. */
    public static final AccessRights MANAGE = fromString("Manage");

    /** Static value Send for AccessRights. */
    public static final AccessRights SEND = fromString("Send");

    /** Static value Listen for AccessRights. */
    public static final AccessRights LISTEN = fromString("Listen");

    /**
     * Creates a new instance of AccessRights value.
     *
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public AccessRights() {}

    /**
     * Creates or finds a AccessRights from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding AccessRights.
     */
    @JsonCreator
    public static AccessRights fromString(String name) {
        return fromString(name, AccessRights.class);
    }

    /**
     * Gets known AccessRights values.
     *
     * @return known AccessRights values.
     */
    public static Collection<AccessRights> values() {
        return values(AccessRights.class);
    }
}
