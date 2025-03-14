// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.communication.jobrouter.models;

import com.azure.communication.jobrouter.implementation.accesshelpers.LabelValueConstructorProxy;
import com.azure.communication.jobrouter.implementation.accesshelpers.RouterJobConstructorProxy;
import com.azure.communication.jobrouter.implementation.converters.JobAdapter;
import com.azure.communication.jobrouter.implementation.converters.LabelSelectorAdapter;
import com.azure.communication.jobrouter.implementation.models.RouterJobInternal;
import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/** A unit of work to be routed. */
@Fluent
public final class RouterJob {
    /**
     * Public constructor.
     *
     * @param id The id
     */
    public RouterJob(String id) {
        this.id = id;
    }

    /**
     * Package-private constructor of the class, used internally.
     *
     * @param internal The internal RouterJob
     */
    RouterJob(RouterJobInternal internal) {
        id = internal.getId();
        requestedWorkerSelectors = internal.getRequestedWorkerSelectors().stream()
            .map(ws -> LabelSelectorAdapter.convertWorkerSelectorToPublic(ws))
            .collect(Collectors.toList());
        attachedWorkerSelectors = internal.getAttachedWorkerSelectors().stream()
            .map(ws -> LabelSelectorAdapter.convertWorkerSelectorToPublic(ws))
            .collect(Collectors.toList());
        assignments = internal.getAssignments().entrySet().stream()
            .collect(Collectors.toMap(Map.Entry::getKey, entry -> JobAdapter.convertJobAssignmentToPublic(entry.getValue())));
        status = RouterJobStatus.fromString(internal.getStatus().toString());
        enqueuedAt = internal.getEnqueuedAt();
        scheduledAt = internal.getScheduledAt();

        setChannelId(internal.getChannelId());
        setChannelReference(internal.getChannelReference());
        setQueueId(internal.getQueueId());
        setLabels(internal.getLabels().entrySet().stream()
            .collect(Collectors.toMap(Map.Entry::getKey, entry -> LabelValueConstructorProxy.create(entry.getValue()))));
        setNotes(internal.getNotes());
        setPriority(internal.getPriority());
        setClassificationPolicyId(internal.getClassificationPolicyId());
        setDispositionCode(internal.getDispositionCode());
        setClassificationPolicyId(internal.getClassificationPolicyId());
        setTags(internal.getTags().entrySet().stream()
            .collect(Collectors.toMap(Map.Entry::getKey, entry -> LabelValueConstructorProxy.create(entry.getValue()))));
        setMatchingMode(JobAdapter.convertMatchingModeToPublic(internal.getMatchingMode()));
    }

    static {
        RouterJobConstructorProxy.setAccessor(internal -> new RouterJob(internal));
    }

    /*
     * The id of the job.
     */
    @JsonProperty(value = "id", access = JsonProperty.Access.WRITE_ONLY)
    private String id;

    /*
     * Reference to an external parent context, eg. call ID.
     */
    @JsonProperty(value = "channelReference")
    private String channelReference;

    /*
     * The status of the Job.
     */
    @JsonProperty(value = "status", access = JsonProperty.Access.WRITE_ONLY)
    private RouterJobStatus status;

    /*
     * The time a job was queued in UTC.
     */
    @JsonProperty(value = "enqueuedAt", access = JsonProperty.Access.WRITE_ONLY)
    private OffsetDateTime enqueuedAt;

    /*
     * The channel identifier. eg. voice, chat, etc.
     */
    @JsonProperty(value = "channelId")
    private String channelId;

    /*
     * The Id of the Classification policy used for classifying a job.
     */
    @JsonProperty(value = "classificationPolicyId")
    private String classificationPolicyId;

    /*
     * The Id of the Queue that this job is queued to.
     */
    @JsonProperty(value = "queueId")
    private String queueId;

    /*
     * The priority of this job.
     */
    @JsonProperty(value = "priority")
    private Integer priority;

    /*
     * Reason code for cancelled or closed jobs.
     */
    @JsonProperty(value = "dispositionCode")
    private String dispositionCode;

    /*
     * A collection of manually specified label selectors, which a worker must
     * satisfy in order to process this job.
     */
    @JsonProperty(value = "requestedWorkerSelectors")
    private List<RouterWorkerSelector> requestedWorkerSelectors;

    /*
     * A collection of label selectors attached by a classification policy,
     * which a worker must satisfy in order to process this job.
     */
    @JsonProperty(value = "attachedWorkerSelectors", access = JsonProperty.Access.WRITE_ONLY)
    private List<RouterWorkerSelector> attachedWorkerSelectors;

    /*
     * A set of key/value pairs that are identifying attributes used by the
     * rules engines to make decisions.
     */
    @JsonProperty(value = "labels")
    private Map<String, LabelValue> labels;

    /*
     * A collection of the assignments of the job.
     * Key is AssignmentId.
     */
    @JsonProperty(value = "assignments", access = JsonProperty.Access.WRITE_ONLY)
    private Map<String, RouterJobAssignment> assignments;

    /*
     * A set of non-identifying attributes attached to this job
     */
    @JsonProperty(value = "tags")
    private Map<String, LabelValue> tags;

    /*
     * Notes attached to a job, sorted by timestamp
     */
    @JsonProperty(value = "notes")
    private Map<String, String> notes;

    /*
     * If set, job will be scheduled to be enqueued at a given time
     */
    @JsonProperty(value = "scheduledAt", access = JsonProperty.Access.WRITE_ONLY)
    private OffsetDateTime scheduledAt;

    /*
     * The matchingMode property.
     */
    @JsonProperty(value = "matchingMode")
    private RouterJobMatchingMode matchingMode;

    /**
     * Get the id property: The id of the job.
     *
     * @return the id value.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Get the channelReference property: Reference to an external parent context, eg. call ID.
     *
     * @return the channelReference value.
     */
    public String getChannelReference() {
        return this.channelReference;
    }

    /**
     * Set the channelReference property: Reference to an external parent context, eg. call ID.
     *
     * @param channelReference the channelReference value to set.
     * @return the RouterJob object itself.
     */
    public RouterJob setChannelReference(String channelReference) {
        this.channelReference = channelReference;
        return this;
    }

    /**
     * Get the status property: The status of the Job.
     *
     * @return the status value.
     */
    public RouterJobStatus getStatus() {
        return this.status;
    }

    /**
     * Get the enqueuedAt property: The time a job was queued in UTC.
     *
     * @return the enqueuedAt value.
     */
    public OffsetDateTime getEnqueuedAt() {
        return this.enqueuedAt;
    }

    /**
     * Get the channelId property: The channel identifier. eg. voice, chat, etc.
     *
     * @return the channelId value.
     */
    public String getChannelId() {
        return this.channelId;
    }

    /**
     * Set the channelId property: The channel identifier. eg. voice, chat, etc.
     *
     * @param channelId the channelId value to set.
     * @return the RouterJob object itself.
     */
    public RouterJob setChannelId(String channelId) {
        this.channelId = channelId;
        return this;
    }

    /**
     * Get the classificationPolicyId property: The Id of the Classification policy used for classifying a job.
     *
     * @return the classificationPolicyId value.
     */
    public String getClassificationPolicyId() {
        return this.classificationPolicyId;
    }

    /**
     * Set the classificationPolicyId property: The Id of the Classification policy used for classifying a job.
     *
     * @param classificationPolicyId the classificationPolicyId value to set.
     * @return the RouterJob object itself.
     */
    public RouterJob setClassificationPolicyId(String classificationPolicyId) {
        this.classificationPolicyId = classificationPolicyId;
        return this;
    }

    /**
     * Get the queueId property: The Id of the Queue that this job is queued to.
     *
     * @return the queueId value.
     */
    public String getQueueId() {
        return this.queueId;
    }

    /**
     * Set the queueId property: The Id of the Queue that this job is queued to.
     *
     * @param queueId the queueId value to set.
     * @return the RouterJob object itself.
     */
    public RouterJob setQueueId(String queueId) {
        this.queueId = queueId;
        return this;
    }

    /**
     * Get the priority property: The priority of this job.
     *
     * @return the priority value.
     */
    public Integer getPriority() {
        return this.priority;
    }

    /**
     * Set the priority property: The priority of this job.
     *
     * @param priority the priority value to set.
     * @return the RouterJob object itself.
     */
    public RouterJob setPriority(Integer priority) {
        this.priority = priority;
        return this;
    }

    /**
     * Get the dispositionCode property: Reason code for cancelled or closed jobs.
     *
     * @return the dispositionCode value.
     */
    public String getDispositionCode() {
        return this.dispositionCode;
    }

    /**
     * Set the dispositionCode property: Reason code for cancelled or closed jobs.
     *
     * @param dispositionCode the dispositionCode value to set.
     * @return the RouterJob object itself.
     */
    public RouterJob setDispositionCode(String dispositionCode) {
        this.dispositionCode = dispositionCode;
        return this;
    }

    /**
     * Get the requestedWorkerSelectors property: A collection of manually specified label selectors, which a worker
     * must satisfy in order to process this job.
     *
     * @return the requestedWorkerSelectors value.
     */
    public List<RouterWorkerSelector> getRequestedWorkerSelectors() {
        return this.requestedWorkerSelectors;
    }

    /**
     * Set the requestedWorkerSelectors property: A collection of manually specified label selectors, which a worker
     * must satisfy in order to process this job.
     *
     * @param requestedWorkerSelectors the requestedWorkerSelectors value to set.
     * @return the RouterJob object itself.
     */
    public RouterJob setRequestedWorkerSelectors(List<RouterWorkerSelector> requestedWorkerSelectors) {
        this.requestedWorkerSelectors = requestedWorkerSelectors;
        return this;
    }

    /**
     * Get the attachedWorkerSelectors property: A collection of label selectors attached by a classification policy,
     * which a worker must satisfy in order to process this job.
     *
     * @return the attachedWorkerSelectors value.
     */
    public List<RouterWorkerSelector> getAttachedWorkerSelectors() {
        return this.attachedWorkerSelectors;
    }

    /**
     * Get the labels property: A set of key/value pairs that are identifying attributes used by the rules engines to
     * make decisions.
     *
     * @return the labels value.
     */
    public Map<String, LabelValue> getLabels() {
        return this.labels;
    }

    /**
     * Set the labels property: A set of key/value pairs that are identifying attributes used by the rules engines to
     * make decisions.
     *
     * @param labels the labels value to set.
     * @return the RouterJob object itself.
     */
    public RouterJob setLabels(Map<String, LabelValue> labels) {
        this.labels = labels;
        return this;
    }

    /**
     * Get the assignments property: A collection of the assignments of the job. Key is AssignmentId.
     *
     * @return the assignments value.
     */
    public Map<String, RouterJobAssignment> getAssignments() {
        return this.assignments;
    }

    /**
     * Get the tags property: A set of non-identifying attributes attached to this job.
     *
     * @return the tags value.
     */
    public Map<String, LabelValue> getTags() {
        return this.tags;
    }

    /**
     * Set the tags property: A set of non-identifying attributes attached to this job.
     *
     * @param tags the tags value to set.
     * @return the RouterJob object itself.
     */
    public RouterJob setTags(Map<String, LabelValue> tags) {
        this.tags = tags;
        return this;
    }

    /**
     * Get the notes property: Notes attached to a job, sorted by timestamp.
     *
     * @return the notes value.
     */
    public Map<String, String> getNotes() {
        return this.notes;
    }

    /**
     * Set the notes property: Notes attached to a job, sorted by timestamp.
     *
     * @param notes the notes value to set.
     * @return the RouterJob object itself.
     */
    public RouterJob setNotes(Map<String, String> notes) {
        this.notes = notes;
        return this;
    }

    /**
     * Get the scheduledAt property: If set, job will be scheduled to be enqueued at a given time.
     *
     * @return the scheduledAt value.
     */
    public OffsetDateTime getScheduledAt() {
        return this.scheduledAt;
    }

    /**
     * Get the matchingMode property: The matchingMode property.
     *
     * @return the matchingMode value.
     */
    public RouterJobMatchingMode getMatchingMode() {
        return this.matchingMode;
    }

    /**
     * Set the matchingMode property: The matchingMode property.
     *
     * @param matchingMode the matchingMode value to set.
     * @return the RouterJob object itself.
     */
    public RouterJob setMatchingMode(RouterJobMatchingMode matchingMode) {
        this.matchingMode = matchingMode;
        return this;
    }
}
