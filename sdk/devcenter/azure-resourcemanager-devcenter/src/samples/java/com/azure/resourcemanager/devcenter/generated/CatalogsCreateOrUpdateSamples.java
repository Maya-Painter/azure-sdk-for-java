// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.devcenter.generated;

import com.azure.resourcemanager.devcenter.models.GitCatalog;

/** Samples for Catalogs CreateOrUpdate. */
public final class CatalogsCreateOrUpdateSamples {
    /*
     * x-ms-original-file: specification/devcenter/resource-manager/Microsoft.DevCenter/stable/2023-04-01/examples/Catalogs_CreateAdo.json
     */
    /**
     * Sample code: Catalogs_CreateOrUpdateAdo.
     *
     * @param manager Entry point to DevCenterManager.
     */
    public static void catalogsCreateOrUpdateAdo(com.azure.resourcemanager.devcenter.DevCenterManager manager) {
        manager
            .catalogs()
            .define("CentralCatalog")
            .withExistingDevcenter("rg1", "Contoso")
            .withAdoGit(
                new GitCatalog()
                    .withUri("https://contoso@dev.azure.com/contoso/contosoOrg/_git/centralrepo-fakecontoso")
                    .withBranch("main")
                    .withSecretIdentifier("fakeTokenPlaceholder")
                    .withPath("/templates"))
            .create();
    }

    /*
     * x-ms-original-file: specification/devcenter/resource-manager/Microsoft.DevCenter/stable/2023-04-01/examples/Catalogs_CreateGitHub.json
     */
    /**
     * Sample code: Catalogs_CreateOrUpdateGitHub.
     *
     * @param manager Entry point to DevCenterManager.
     */
    public static void catalogsCreateOrUpdateGitHub(com.azure.resourcemanager.devcenter.DevCenterManager manager) {
        manager
            .catalogs()
            .define("CentralCatalog")
            .withExistingDevcenter("rg1", "Contoso")
            .withGitHub(
                new GitCatalog()
                    .withUri("https://github.com/Contoso/centralrepo-fake.git")
                    .withBranch("main")
                    .withSecretIdentifier("fakeTokenPlaceholder")
                    .withPath("/templates"))
            .create();
    }
}
