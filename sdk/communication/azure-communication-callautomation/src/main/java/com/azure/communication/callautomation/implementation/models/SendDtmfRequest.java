// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.communication.callautomation.implementation.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** The SendDtmfRequest model. */
@Fluent
public final class SendDtmfRequest {
    /*
     * Target participant of Send DTMF tone.
     */
    @JsonProperty(value = "targetParticipant", required = true)
    private CommunicationIdentifierModel targetParticipant;

    /*
     * The captured tones.
     */
    @JsonProperty(value = "tones", required = true)
    private List<DtmfToneInternal> tones;

    /*
     * The value to identify context of the operation.
     */
    @JsonProperty(value = "operationContext")
    private String operationContext;

    /**
     * Get the targetParticipant property: Target participant of Send DTMF tone.
     *
     * @return the targetParticipant value.
     */
    public CommunicationIdentifierModel getTargetParticipant() {
        return this.targetParticipant;
    }

    /**
     * Set the targetParticipant property: Target participant of Send DTMF tone.
     *
     * @param targetParticipant the targetParticipant value to set.
     * @return the SendDtmfRequest object itself.
     */
    public SendDtmfRequest setTargetParticipant(CommunicationIdentifierModel targetParticipant) {
        this.targetParticipant = targetParticipant;
        return this;
    }

    /**
     * Get the tones property: The captured tones.
     *
     * @return the tones value.
     */
    public List<DtmfToneInternal> getTones() {
        return this.tones;
    }

    /**
     * Set the tones property: The captured tones.
     *
     * @param tones the tones value to set.
     * @return the SendDtmfRequest object itself.
     */
    public SendDtmfRequest setTones(List<DtmfToneInternal> tones) {
        this.tones = tones;
        return this;
    }

    /**
     * Get the operationContext property: The value to identify context of the operation.
     *
     * @return the operationContext value.
     */
    public String getOperationContext() {
        return this.operationContext;
    }

    /**
     * Set the operationContext property: The value to identify context of the operation.
     *
     * @param operationContext the operationContext value to set.
     * @return the SendDtmfRequest object itself.
     */
    public SendDtmfRequest setOperationContext(String operationContext) {
        this.operationContext = operationContext;
        return this;
    }
}
