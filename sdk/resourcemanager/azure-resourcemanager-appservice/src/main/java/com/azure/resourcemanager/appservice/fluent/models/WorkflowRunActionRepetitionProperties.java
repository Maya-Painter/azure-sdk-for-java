// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appservice.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.appservice.models.OperationResult;
import com.azure.resourcemanager.appservice.models.RepetitionIndex;
import com.azure.resourcemanager.appservice.models.RetryHistory;
import com.azure.resourcemanager.appservice.models.RunActionCorrelation;
import com.azure.resourcemanager.appservice.models.WorkflowStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import java.util.List;

/** The workflow run action repetition properties definition. */
@Fluent
public final class WorkflowRunActionRepetitionProperties extends OperationResult {
    /*
     * The repetition indexes.
     */
    @JsonProperty(value = "repetitionIndexes")
    private List<RepetitionIndex> repetitionIndexes;

    /** Creates an instance of WorkflowRunActionRepetitionProperties class. */
    public WorkflowRunActionRepetitionProperties() {
    }

    /**
     * Get the repetitionIndexes property: The repetition indexes.
     *
     * @return the repetitionIndexes value.
     */
    public List<RepetitionIndex> repetitionIndexes() {
        return this.repetitionIndexes;
    }

    /**
     * Set the repetitionIndexes property: The repetition indexes.
     *
     * @param repetitionIndexes the repetitionIndexes value to set.
     * @return the WorkflowRunActionRepetitionProperties object itself.
     */
    public WorkflowRunActionRepetitionProperties withRepetitionIndexes(List<RepetitionIndex> repetitionIndexes) {
        this.repetitionIndexes = repetitionIndexes;
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public WorkflowRunActionRepetitionProperties withRetryHistory(List<RetryHistory> retryHistory) {
        super.withRetryHistory(retryHistory);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public WorkflowRunActionRepetitionProperties withIterationCount(Integer iterationCount) {
        super.withIterationCount(iterationCount);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public WorkflowRunActionRepetitionProperties withStartTime(OffsetDateTime startTime) {
        super.withStartTime(startTime);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public WorkflowRunActionRepetitionProperties withEndTime(OffsetDateTime endTime) {
        super.withEndTime(endTime);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public WorkflowRunActionRepetitionProperties withCorrelation(RunActionCorrelation correlation) {
        super.withCorrelation(correlation);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public WorkflowRunActionRepetitionProperties withStatus(WorkflowStatus status) {
        super.withStatus(status);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public WorkflowRunActionRepetitionProperties withCode(String code) {
        super.withCode(code);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public WorkflowRunActionRepetitionProperties withError(Object error) {
        super.withError(error);
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
        if (repetitionIndexes() != null) {
            repetitionIndexes().forEach(e -> e.validate());
        }
    }
}
