// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.imagebuilder.generated;

/** Samples for VirtualMachineImageTemplates Cancel. */
public final class VirtualMachineImageTemplatesCancelSamples {
    /*
     * x-ms-original-file: specification/imagebuilder/resource-manager/Microsoft.VirtualMachineImages/stable/2022-07-01/examples/CancelImageBuild.json
     */
    /**
     * Sample code: Cancel the image build based on the imageTemplate.
     *
     * @param manager Entry point to ImageBuilderManager.
     */
    public static void cancelTheImageBuildBasedOnTheImageTemplate(
        com.azure.resourcemanager.imagebuilder.ImageBuilderManager manager) {
        manager
            .virtualMachineImageTemplates()
            .cancel("myResourceGroup", "myImageTemplate", com.azure.core.util.Context.NONE);
    }
}
