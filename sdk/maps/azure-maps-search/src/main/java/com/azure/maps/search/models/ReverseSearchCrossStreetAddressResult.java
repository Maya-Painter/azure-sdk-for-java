// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.maps.search.models;

import com.azure.core.annotation.Immutable;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** This object is returned from a successful Search Address Reverse CrossStreet call. */
@Immutable
public final class ReverseSearchCrossStreetAddressResult {
    /*
     * Summary object for a Search Address Reverse Cross Street response
     */
    @JsonProperty(value = "summary", access = JsonProperty.Access.WRITE_ONLY)
    private SearchSummary summary;

    /*
     * Addresses array
     */
    @JsonProperty(value = "addresses", access = JsonProperty.Access.WRITE_ONLY)
    private List<ReverseSearchCrossStreetAddressResultItem> addresses;

    /** Creates an instance of ReverseSearchCrossStreetAddressResult class. */
    public ReverseSearchCrossStreetAddressResult() {}

    /**
     * Get the summary property: Summary object for a Search Address Reverse Cross Street response.
     *
     * @return the summary value.
     */
    public SearchSummary getSummary() {
        return this.summary;
    }

    /**
     * Get the addresses property: Addresses array.
     *
     * @return the addresses value.
     */
    public List<ReverseSearchCrossStreetAddressResultItem> getAddresses() {
        return this.addresses;
    }
}
