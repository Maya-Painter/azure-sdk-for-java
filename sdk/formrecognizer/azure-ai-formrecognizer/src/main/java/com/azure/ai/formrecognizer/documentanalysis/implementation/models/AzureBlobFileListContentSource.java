// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.formrecognizer.documentanalysis.implementation.models;

import com.azure.core.annotation.Immutable;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/** File list in Azure Blob Storage. */
@Immutable
public final class AzureBlobFileListContentSource {
    /*
     * Azure Blob Storage container URL.
     */
    @JsonProperty(value = "containerUrl", required = true)
    private String containerUrl;

    /*
     * Path to a JSONL file within the container specifying a subset of documents for training.
     */
    @JsonProperty(value = "fileList", required = true)
    private String fileList;

    /**
     * Creates an instance of AzureBlobFileListContentSource class.
     *
     * @param containerUrl the containerUrl value to set.
     * @param fileList the fileList value to set.
     */
    @JsonCreator
    public AzureBlobFileListContentSource(
            @JsonProperty(value = "containerUrl", required = true) String containerUrl,
            @JsonProperty(value = "fileList", required = true) String fileList) {
        this.containerUrl = containerUrl;
        this.fileList = fileList;
    }

    /**
     * Get the containerUrl property: Azure Blob Storage container URL.
     *
     * @return the containerUrl value.
     */
    public String getContainerUrl() {
        return this.containerUrl;
    }

    /**
     * Get the fileList property: Path to a JSONL file within the container specifying a subset of documents for
     * training.
     *
     * @return the fileList value.
     */
    public String getFileList() {
        return this.fileList;
    }
}
