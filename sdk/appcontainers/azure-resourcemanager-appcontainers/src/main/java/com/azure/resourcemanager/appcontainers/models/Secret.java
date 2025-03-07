// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appcontainers.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Secret definition. */
@Fluent
public final class Secret {
    /*
     * Secret Name.
     */
    @JsonProperty(value = "name")
    private String name;

    /*
     * Secret Value.
     */
    @JsonProperty(value = "value")
    private String value;

    /*
     * Resource ID of a managed identity to authenticate with Azure Key Vault, or System to use a system-assigned
     * identity.
     */
    @JsonProperty(value = "identity")
    private String identity;

    /*
     * Azure Key Vault URL pointing to the secret referenced by the container app.
     */
    @JsonProperty(value = "keyVaultUrl")
    private String keyVaultUrl;

    /** Creates an instance of Secret class. */
    public Secret() {
    }

    /**
     * Get the name property: Secret Name.
     *
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name property: Secret Name.
     *
     * @param name the name value to set.
     * @return the Secret object itself.
     */
    public Secret withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the value property: Secret Value.
     *
     * @return the value value.
     */
    public String value() {
        return this.value;
    }

    /**
     * Set the value property: Secret Value.
     *
     * @param value the value value to set.
     * @return the Secret object itself.
     */
    public Secret withValue(String value) {
        this.value = value;
        return this;
    }

    /**
     * Get the identity property: Resource ID of a managed identity to authenticate with Azure Key Vault, or System to
     * use a system-assigned identity.
     *
     * @return the identity value.
     */
    public String identity() {
        return this.identity;
    }

    /**
     * Set the identity property: Resource ID of a managed identity to authenticate with Azure Key Vault, or System to
     * use a system-assigned identity.
     *
     * @param identity the identity value to set.
     * @return the Secret object itself.
     */
    public Secret withIdentity(String identity) {
        this.identity = identity;
        return this;
    }

    /**
     * Get the keyVaultUrl property: Azure Key Vault URL pointing to the secret referenced by the container app.
     *
     * @return the keyVaultUrl value.
     */
    public String keyVaultUrl() {
        return this.keyVaultUrl;
    }

    /**
     * Set the keyVaultUrl property: Azure Key Vault URL pointing to the secret referenced by the container app.
     *
     * @param keyVaultUrl the keyVaultUrl value to set.
     * @return the Secret object itself.
     */
    public Secret withKeyVaultUrl(String keyVaultUrl) {
        this.keyVaultUrl = keyVaultUrl;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}
