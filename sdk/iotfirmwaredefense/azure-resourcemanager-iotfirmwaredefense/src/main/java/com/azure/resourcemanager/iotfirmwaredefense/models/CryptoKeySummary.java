// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.iotfirmwaredefense.models;

import com.azure.resourcemanager.iotfirmwaredefense.fluent.models.CryptoKeySummaryInner;

/** An immutable client-side representation of CryptoKeySummary. */
public interface CryptoKeySummary {
    /**
     * Gets the totalKeys property: Total number of cryptographic keys found.
     *
     * @return the totalKeys value.
     */
    Long totalKeys();

    /**
     * Gets the publicKeys property: Total number of (non-certificate) public keys found.
     *
     * @return the publicKeys value.
     */
    Long publicKeys();

    /**
     * Gets the privateKeys property: Total number of private keys found.
     *
     * @return the privateKeys value.
     */
    Long privateKeys();

    /**
     * Gets the pairedKeys property: Total number of keys found that have a matching paired key or certificate.
     *
     * @return the pairedKeys value.
     */
    Long pairedKeys();

    /**
     * Gets the shortKeySize property: Total number of keys found that have an insecure key size for the algorithm.
     *
     * @return the shortKeySize value.
     */
    Long shortKeySize();

    /**
     * Gets the inner com.azure.resourcemanager.iotfirmwaredefense.fluent.models.CryptoKeySummaryInner object.
     *
     * @return the inner object.
     */
    CryptoKeySummaryInner innerModel();
}
