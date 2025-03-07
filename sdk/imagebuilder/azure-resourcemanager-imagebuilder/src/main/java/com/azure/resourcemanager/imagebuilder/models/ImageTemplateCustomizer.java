// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.imagebuilder.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/** Describes a unit of image customization. */
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type",
    defaultImpl = ImageTemplateCustomizer.class)
@JsonTypeName("ImageTemplateCustomizer")
@JsonSubTypes({
    @JsonSubTypes.Type(name = "Shell", value = ImageTemplateShellCustomizer.class),
    @JsonSubTypes.Type(name = "WindowsRestart", value = ImageTemplateRestartCustomizer.class),
    @JsonSubTypes.Type(name = "WindowsUpdate", value = ImageTemplateWindowsUpdateCustomizer.class),
    @JsonSubTypes.Type(name = "PowerShell", value = ImageTemplatePowerShellCustomizer.class),
    @JsonSubTypes.Type(name = "File", value = ImageTemplateFileCustomizer.class)
})
@Fluent
public class ImageTemplateCustomizer {
    /*
     * Friendly Name to provide context on what this customization step does
     */
    @JsonProperty(value = "name")
    private String name;

    /** Creates an instance of ImageTemplateCustomizer class. */
    public ImageTemplateCustomizer() {
    }

    /**
     * Get the name property: Friendly Name to provide context on what this customization step does.
     *
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name property: Friendly Name to provide context on what this customization step does.
     *
     * @param name the name value to set.
     * @return the ImageTemplateCustomizer object itself.
     */
    public ImageTemplateCustomizer withName(String name) {
        this.name = name;
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
