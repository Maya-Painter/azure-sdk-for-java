// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.compute.generated;

/** Samples for SshPublicKeys GenerateKeyPair. */
public final class SshPublicKeysGenerateKeyPairSamples {
    /*
     * x-ms-original-file: specification/compute/resource-manager/Microsoft.Compute/ComputeRP/stable/2023-03-01/examples/sshPublicKeyExamples/SshPublicKey_GenerateKeyPair.json
     */
    /**
     * Sample code: Generate an SSH key pair.
     *
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void generateAnSSHKeyPair(com.azure.resourcemanager.AzureResourceManager azure) {
        azure
            .virtualMachines()
            .manager()
            .serviceClient()
            .getSshPublicKeys()
            .generateKeyPairWithResponse("myResourceGroup", "mySshPublicKeyName", com.azure.core.util.Context.NONE);
    }
}
