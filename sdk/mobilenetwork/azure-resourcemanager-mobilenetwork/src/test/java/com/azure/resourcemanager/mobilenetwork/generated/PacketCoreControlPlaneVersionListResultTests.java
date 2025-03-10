// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mobilenetwork.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.mobilenetwork.fluent.models.PacketCoreControlPlaneVersionInner;
import com.azure.resourcemanager.mobilenetwork.models.ObsoleteVersion;
import com.azure.resourcemanager.mobilenetwork.models.PacketCoreControlPlaneVersionListResult;
import com.azure.resourcemanager.mobilenetwork.models.Platform;
import com.azure.resourcemanager.mobilenetwork.models.PlatformType;
import com.azure.resourcemanager.mobilenetwork.models.RecommendedVersion;
import com.azure.resourcemanager.mobilenetwork.models.VersionState;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class PacketCoreControlPlaneVersionListResultTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        PacketCoreControlPlaneVersionListResult model =
            BinaryData
                .fromString(
                    "{\"value\":[{\"properties\":{\"provisioningState\":\"Succeeded\",\"platforms\":[{\"platformType\":\"3P-AZURE-STACK-HCI\",\"versionState\":\"Validating\",\"minimumPlatformSoftwareVersion\":\"oujmkcjhwqytj\",\"maximumPlatformSoftwareVersion\":\"bnw\",\"recommendedVersion\":\"NotRecommended\",\"obsoleteVersion\":\"NotObsolete\"},{\"platformType\":\"3P-AZURE-STACK-HCI\",\"versionState\":\"Unknown\",\"minimumPlatformSoftwareVersion\":\"naenqpehindo\",\"maximumPlatformSoftwareVersion\":\"mifthnzdnd\",\"recommendedVersion\":\"NotRecommended\",\"obsoleteVersion\":\"NotObsolete\"},{\"platformType\":\"AKS-HCI\",\"versionState\":\"Unknown\",\"minimumPlatformSoftwareVersion\":\"nduhavhqlkthum\",\"maximumPlatformSoftwareVersion\":\"olbgycduiertgccy\",\"recommendedVersion\":\"Recommended\",\"obsoleteVersion\":\"Obsolete\"},{\"platformType\":\"AKS-HCI\",\"versionState\":\"Validating\",\"minimumPlatformSoftwareVersion\":\"lfmmdnbbglzpswi\",\"maximumPlatformSoftwareVersion\":\"mcwyhzdxssadb\",\"recommendedVersion\":\"NotRecommended\",\"obsoleteVersion\":\"NotObsolete\"}]},\"id\":\"fznudaodvxzb\",\"name\":\"cblylpstdbhhxsr\",\"type\":\"dzu\"},{\"properties\":{\"provisioningState\":\"Deleted\",\"platforms\":[{\"platformType\":\"AKS-HCI\",\"versionState\":\"Preview\",\"minimumPlatformSoftwareVersion\":\"vfiwjmygtdss\",\"maximumPlatformSoftwareVersion\":\"wtmwerio\",\"recommendedVersion\":\"Recommended\",\"obsoleteVersion\":\"NotObsolete\"},{\"platformType\":\"AKS-HCI\",\"versionState\":\"Unknown\",\"minimumPlatformSoftwareVersion\":\"bnetshh\",\"maximumPlatformSoftwareVersion\":\"h\",\"recommendedVersion\":\"NotRecommended\",\"obsoleteVersion\":\"NotObsolete\"},{\"platformType\":\"3P-AZURE-STACK-HCI\",\"versionState\":\"Unknown\",\"minimumPlatformSoftwareVersion\":\"mwmbes\",\"maximumPlatformSoftwareVersion\":\"nkww\",\"recommendedVersion\":\"NotRecommended\",\"obsoleteVersion\":\"Obsolete\"},{\"platformType\":\"3P-AZURE-STACK-HCI\",\"versionState\":\"Preview\",\"minimumPlatformSoftwareVersion\":\"aokonzmnsik\",\"maximumPlatformSoftwareVersion\":\"kqze\",\"recommendedVersion\":\"NotRecommended\",\"obsoleteVersion\":\"Obsolete\"}]},\"id\":\"tfz\",\"name\":\"mhhv\",\"type\":\"gureodkwobdag\"},{\"properties\":{\"provisioningState\":\"Canceled\",\"platforms\":[{\"platformType\":\"AKS-HCI\",\"versionState\":\"ValidationFailed\",\"minimumPlatformSoftwareVersion\":\"akbogqxndlkzgxh\",\"maximumPlatformSoftwareVersion\":\"iplbpodxunkbebxm\",\"recommendedVersion\":\"Recommended\",\"obsoleteVersion\":\"NotObsolete\"},{\"platformType\":\"3P-AZURE-STACK-HCI\",\"versionState\":\"Deprecated\",\"minimumPlatformSoftwareVersion\":\"qtkoievs\",\"maximumPlatformSoftwareVersion\":\"tgqr\",\"recommendedVersion\":\"NotRecommended\",\"obsoleteVersion\":\"Obsolete\"}]},\"id\":\"wlauwzizxbmpg\",\"name\":\"jefuzmuvpbttdumo\",\"type\":\"p\"},{\"properties\":{\"provisioningState\":\"Deleting\",\"platforms\":[{\"platformType\":\"AKS-HCI\",\"versionState\":\"Preview\",\"minimumPlatformSoftwareVersion\":\"hjpglkf\",\"maximumPlatformSoftwareVersion\":\"hdneuelfph\",\"recommendedVersion\":\"NotRecommended\",\"obsoleteVersion\":\"Obsolete\"}]},\"id\":\"ozfikdowwq\",\"name\":\"uvxzxclvi\",\"type\":\"hhqzonosgg\"}],\"nextLink\":\"c\"}")
                .toObject(PacketCoreControlPlaneVersionListResult.class);
        Assertions
            .assertEquals(PlatformType.THREE_P_AZURE_STACK_HCI, model.value().get(0).platforms().get(0).platformType());
        Assertions.assertEquals(VersionState.VALIDATING, model.value().get(0).platforms().get(0).versionState());
        Assertions
            .assertEquals("oujmkcjhwqytj", model.value().get(0).platforms().get(0).minimumPlatformSoftwareVersion());
        Assertions.assertEquals("bnw", model.value().get(0).platforms().get(0).maximumPlatformSoftwareVersion());
        Assertions
            .assertEquals(
                RecommendedVersion.NOT_RECOMMENDED, model.value().get(0).platforms().get(0).recommendedVersion());
        Assertions
            .assertEquals(ObsoleteVersion.NOT_OBSOLETE, model.value().get(0).platforms().get(0).obsoleteVersion());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        PacketCoreControlPlaneVersionListResult model =
            new PacketCoreControlPlaneVersionListResult()
                .withValue(
                    Arrays
                        .asList(
                            new PacketCoreControlPlaneVersionInner()
                                .withPlatforms(
                                    Arrays
                                        .asList(
                                            new Platform()
                                                .withPlatformType(PlatformType.THREE_P_AZURE_STACK_HCI)
                                                .withVersionState(VersionState.VALIDATING)
                                                .withMinimumPlatformSoftwareVersion("oujmkcjhwqytj")
                                                .withMaximumPlatformSoftwareVersion("bnw")
                                                .withRecommendedVersion(RecommendedVersion.NOT_RECOMMENDED)
                                                .withObsoleteVersion(ObsoleteVersion.NOT_OBSOLETE),
                                            new Platform()
                                                .withPlatformType(PlatformType.THREE_P_AZURE_STACK_HCI)
                                                .withVersionState(VersionState.UNKNOWN)
                                                .withMinimumPlatformSoftwareVersion("naenqpehindo")
                                                .withMaximumPlatformSoftwareVersion("mifthnzdnd")
                                                .withRecommendedVersion(RecommendedVersion.NOT_RECOMMENDED)
                                                .withObsoleteVersion(ObsoleteVersion.NOT_OBSOLETE),
                                            new Platform()
                                                .withPlatformType(PlatformType.AKS_HCI)
                                                .withVersionState(VersionState.UNKNOWN)
                                                .withMinimumPlatformSoftwareVersion("nduhavhqlkthum")
                                                .withMaximumPlatformSoftwareVersion("olbgycduiertgccy")
                                                .withRecommendedVersion(RecommendedVersion.RECOMMENDED)
                                                .withObsoleteVersion(ObsoleteVersion.OBSOLETE),
                                            new Platform()
                                                .withPlatformType(PlatformType.AKS_HCI)
                                                .withVersionState(VersionState.VALIDATING)
                                                .withMinimumPlatformSoftwareVersion("lfmmdnbbglzpswi")
                                                .withMaximumPlatformSoftwareVersion("mcwyhzdxssadb")
                                                .withRecommendedVersion(RecommendedVersion.NOT_RECOMMENDED)
                                                .withObsoleteVersion(ObsoleteVersion.NOT_OBSOLETE))),
                            new PacketCoreControlPlaneVersionInner()
                                .withPlatforms(
                                    Arrays
                                        .asList(
                                            new Platform()
                                                .withPlatformType(PlatformType.AKS_HCI)
                                                .withVersionState(VersionState.PREVIEW)
                                                .withMinimumPlatformSoftwareVersion("vfiwjmygtdss")
                                                .withMaximumPlatformSoftwareVersion("wtmwerio")
                                                .withRecommendedVersion(RecommendedVersion.RECOMMENDED)
                                                .withObsoleteVersion(ObsoleteVersion.NOT_OBSOLETE),
                                            new Platform()
                                                .withPlatformType(PlatformType.AKS_HCI)
                                                .withVersionState(VersionState.UNKNOWN)
                                                .withMinimumPlatformSoftwareVersion("bnetshh")
                                                .withMaximumPlatformSoftwareVersion("h")
                                                .withRecommendedVersion(RecommendedVersion.NOT_RECOMMENDED)
                                                .withObsoleteVersion(ObsoleteVersion.NOT_OBSOLETE),
                                            new Platform()
                                                .withPlatformType(PlatformType.THREE_P_AZURE_STACK_HCI)
                                                .withVersionState(VersionState.UNKNOWN)
                                                .withMinimumPlatformSoftwareVersion("mwmbes")
                                                .withMaximumPlatformSoftwareVersion("nkww")
                                                .withRecommendedVersion(RecommendedVersion.NOT_RECOMMENDED)
                                                .withObsoleteVersion(ObsoleteVersion.OBSOLETE),
                                            new Platform()
                                                .withPlatformType(PlatformType.THREE_P_AZURE_STACK_HCI)
                                                .withVersionState(VersionState.PREVIEW)
                                                .withMinimumPlatformSoftwareVersion("aokonzmnsik")
                                                .withMaximumPlatformSoftwareVersion("kqze")
                                                .withRecommendedVersion(RecommendedVersion.NOT_RECOMMENDED)
                                                .withObsoleteVersion(ObsoleteVersion.OBSOLETE))),
                            new PacketCoreControlPlaneVersionInner()
                                .withPlatforms(
                                    Arrays
                                        .asList(
                                            new Platform()
                                                .withPlatformType(PlatformType.AKS_HCI)
                                                .withVersionState(VersionState.VALIDATION_FAILED)
                                                .withMinimumPlatformSoftwareVersion("akbogqxndlkzgxh")
                                                .withMaximumPlatformSoftwareVersion("iplbpodxunkbebxm")
                                                .withRecommendedVersion(RecommendedVersion.RECOMMENDED)
                                                .withObsoleteVersion(ObsoleteVersion.NOT_OBSOLETE),
                                            new Platform()
                                                .withPlatformType(PlatformType.THREE_P_AZURE_STACK_HCI)
                                                .withVersionState(VersionState.DEPRECATED)
                                                .withMinimumPlatformSoftwareVersion("qtkoievs")
                                                .withMaximumPlatformSoftwareVersion("tgqr")
                                                .withRecommendedVersion(RecommendedVersion.NOT_RECOMMENDED)
                                                .withObsoleteVersion(ObsoleteVersion.OBSOLETE))),
                            new PacketCoreControlPlaneVersionInner()
                                .withPlatforms(
                                    Arrays
                                        .asList(
                                            new Platform()
                                                .withPlatformType(PlatformType.AKS_HCI)
                                                .withVersionState(VersionState.PREVIEW)
                                                .withMinimumPlatformSoftwareVersion("hjpglkf")
                                                .withMaximumPlatformSoftwareVersion("hdneuelfph")
                                                .withRecommendedVersion(RecommendedVersion.NOT_RECOMMENDED)
                                                .withObsoleteVersion(ObsoleteVersion.OBSOLETE)))));
        model = BinaryData.fromObject(model).toObject(PacketCoreControlPlaneVersionListResult.class);
        Assertions
            .assertEquals(PlatformType.THREE_P_AZURE_STACK_HCI, model.value().get(0).platforms().get(0).platformType());
        Assertions.assertEquals(VersionState.VALIDATING, model.value().get(0).platforms().get(0).versionState());
        Assertions
            .assertEquals("oujmkcjhwqytj", model.value().get(0).platforms().get(0).minimumPlatformSoftwareVersion());
        Assertions.assertEquals("bnw", model.value().get(0).platforms().get(0).maximumPlatformSoftwareVersion());
        Assertions
            .assertEquals(
                RecommendedVersion.NOT_RECOMMENDED, model.value().get(0).platforms().get(0).recommendedVersion());
        Assertions
            .assertEquals(ObsoleteVersion.NOT_OBSOLETE, model.value().get(0).platforms().get(0).obsoleteVersion());
    }
}
