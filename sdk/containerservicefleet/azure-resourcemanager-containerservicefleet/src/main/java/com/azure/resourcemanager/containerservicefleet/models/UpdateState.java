// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.containerservicefleet.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** The state of the UpdateRun, UpdateStage, UpdateGroup, or MemberUpdate. */
public final class UpdateState extends ExpandableStringEnum<UpdateState> {
    /** Static value NotStarted for UpdateState. */
    public static final UpdateState NOT_STARTED = fromString("NotStarted");

    /** Static value Running for UpdateState. */
    public static final UpdateState RUNNING = fromString("Running");

    /** Static value Stopping for UpdateState. */
    public static final UpdateState STOPPING = fromString("Stopping");

    /** Static value Stopped for UpdateState. */
    public static final UpdateState STOPPED = fromString("Stopped");

    /** Static value Failed for UpdateState. */
    public static final UpdateState FAILED = fromString("Failed");

    /** Static value Completed for UpdateState. */
    public static final UpdateState COMPLETED = fromString("Completed");

    /**
     * Creates a new instance of UpdateState value.
     *
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public UpdateState() {
    }

    /**
     * Creates or finds a UpdateState from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding UpdateState.
     */
    @JsonCreator
    public static UpdateState fromString(String name) {
        return fromString(name, UpdateState.class);
    }

    /**
     * Gets known UpdateState values.
     *
     * @return known UpdateState values.
     */
    public static Collection<UpdateState> values() {
        return values(UpdateState.class);
    }
}
