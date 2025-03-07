// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.communication.callautomation.implementation.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The request payload for adding participant to the call. */
@Fluent
public final class AddParticipantRequestInternal {
    /*
     * The source caller Id, a phone number, that's shown to the PSTN
     * participant being invited.
     * Required only when inviting a PSTN participant.
     */
    @JsonProperty(value = "sourceCallerIdNumber")
    private PhoneNumberIdentifierModel sourceCallerIdNumber;

    /*
     * (Optional) The display name of the source that is associated with this
     * invite operation when
     * adding a PSTN participant or teams user.  Note: Will not update the
     * display name in the roster.
     */
    @JsonProperty(value = "sourceDisplayName")
    private String sourceDisplayName;

    /*
     * The participant to invite.
     */
    @JsonProperty(value = "participantToAdd", required = true)
    private CommunicationIdentifierModel participantToAdd;

    /*
     * Gets or sets the timeout to wait for the invited participant to pickup.
     * The maximum value of this is 180 seconds
     */
    @JsonProperty(value = "invitationTimeoutInSeconds")
    private Integer invitationTimeoutInSeconds;

    /*
     * Used by customers when calling mid-call actions to correlate the request
     * to the response event.
     */
    @JsonProperty(value = "operationContext")
    private String operationContext;

    /*
     * Used by customer to send custom context to targets
     */
    @JsonProperty(value = "customContext")
    private CustomContext customContext;

    /*
     * The callback URI override.
     */
    @JsonProperty(value = "callbackUriOverride")
    private String callbackUriOverride;

    /**
     * Get the sourceCallerIdNumber property: The source caller Id, a phone number, that's shown to the PSTN participant
     * being invited. Required only when inviting a PSTN participant.
     *
     * @return the sourceCallerIdNumber value.
     */
    public PhoneNumberIdentifierModel getSourceCallerIdNumber() {
        return this.sourceCallerIdNumber;
    }

    /**
     * Set the sourceCallerIdNumber property: The source caller Id, a phone number, that's shown to the PSTN participant
     * being invited. Required only when inviting a PSTN participant.
     *
     * @param sourceCallerIdNumber the sourceCallerIdNumber value to set.
     * @return the AddParticipantRequestInternal object itself.
     */
    public AddParticipantRequestInternal setSourceCallerIdNumber(PhoneNumberIdentifierModel sourceCallerIdNumber) {
        this.sourceCallerIdNumber = sourceCallerIdNumber;
        return this;
    }

    /**
     * Get the sourceDisplayName property: (Optional) The display name of the source that is associated with this invite
     * operation when adding a PSTN participant or teams user. Note: Will not update the display name in the roster.
     *
     * @return the sourceDisplayName value.
     */
    public String getSourceDisplayName() {
        return this.sourceDisplayName;
    }

    /**
     * Set the sourceDisplayName property: (Optional) The display name of the source that is associated with this invite
     * operation when adding a PSTN participant or teams user. Note: Will not update the display name in the roster.
     *
     * @param sourceDisplayName the sourceDisplayName value to set.
     * @return the AddParticipantRequestInternal object itself.
     */
    public AddParticipantRequestInternal setSourceDisplayName(String sourceDisplayName) {
        this.sourceDisplayName = sourceDisplayName;
        return this;
    }

    /**
     * Get the participantToAdd property: The participant to invite.
     *
     * @return the participantToAdd value.
     */
    public CommunicationIdentifierModel getParticipantToAdd() {
        return this.participantToAdd;
    }

    /**
     * Set the participantToAdd property: The participant to invite.
     *
     * @param participantToAdd the participantToAdd value to set.
     * @return the AddParticipantRequestInternal object itself.
     */
    public AddParticipantRequestInternal setParticipantToAdd(CommunicationIdentifierModel participantToAdd) {
        this.participantToAdd = participantToAdd;
        return this;
    }

    /**
     * Get the invitationTimeoutInSeconds property: Gets or sets the timeout to wait for the invited participant to
     * pickup. The maximum value of this is 180 seconds.
     *
     * @return the invitationTimeoutInSeconds value.
     */
    public Integer getInvitationTimeoutInSeconds() {
        return this.invitationTimeoutInSeconds;
    }

    /**
     * Set the invitationTimeoutInSeconds property: Gets or sets the timeout to wait for the invited participant to
     * pickup. The maximum value of this is 180 seconds.
     *
     * @param invitationTimeoutInSeconds the invitationTimeoutInSeconds value to set.
     * @return the AddParticipantRequestInternal object itself.
     */
    public AddParticipantRequestInternal setInvitationTimeoutInSeconds(Integer invitationTimeoutInSeconds) {
        this.invitationTimeoutInSeconds = invitationTimeoutInSeconds;
        return this;
    }

    /**
     * Get the operationContext property: Used by customers when calling mid-call actions to correlate the request to
     * the response event.
     *
     * @return the operationContext value.
     */
    public String getOperationContext() {
        return this.operationContext;
    }

    /**
     * Set the operationContext property: Used by customers when calling mid-call actions to correlate the request to
     * the response event.
     *
     * @param operationContext the operationContext value to set.
     * @return the AddParticipantRequestInternal object itself.
     */
    public AddParticipantRequestInternal setOperationContext(String operationContext) {
        this.operationContext = operationContext;
        return this;
    }

    /**
     * Get the customContext property: Used by customer to send custom context to targets.
     *
     * @return the customContext value.
     */
    public CustomContext getCustomContext() {
        return this.customContext;
    }

    /**
     * Set the customContext property: Used by customer to send custom context to targets.
     *
     * @param customContext the customContext value to set.
     * @return the AddParticipantRequestInternal object itself.
     */
    public AddParticipantRequestInternal setCustomContext(CustomContext customContext) {
        this.customContext = customContext;
        return this;
    }

    /**
     * Get the callbackUriOverride property: The callback URI override.
     *
     * @return the callbackUriOverride value.
     */
    public String getCallbackUriOverride() {
        return this.callbackUriOverride;
    }

    /**
     * Set the callbackUriOverride property: The callback URI override.
     *
     * @param callbackUriOverride the callbackUriOverride value to set.
     * @return the AddParticipantRequestInternal object itself.
     */
    public AddParticipantRequestInternal setCallbackUriOverride(String callbackUriOverride) {
        this.callbackUriOverride = callbackUriOverride;
        return this;
    }
}
