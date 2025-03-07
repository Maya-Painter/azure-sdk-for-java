// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.networkcloud.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.HttpResponse;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.resourcemanager.networkcloud.NetworkCloudManager;
import com.azure.resourcemanager.networkcloud.models.HybridAksPluginType;
import com.azure.resourcemanager.networkcloud.models.L2Network;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public final class L2NetworksListMockTests {
    @Test
    public void testList() throws Exception {
        HttpClient httpClient = Mockito.mock(HttpClient.class);
        HttpResponse httpResponse = Mockito.mock(HttpResponse.class);
        ArgumentCaptor<HttpRequest> httpRequest = ArgumentCaptor.forClass(HttpRequest.class);

        String responseStr =
            "{\"value\":[{\"extendedLocation\":{\"name\":\"qmbzmq\",\"type\":\"ratbnxwbjs\"},\"properties\":{\"associatedResourceIds\":[\"irkfpksokdgo\",\"ewijymrhbguz\",\"zkye\"],\"clusterId\":\"f\",\"detailedStatus\":\"Error\",\"detailedStatusMessage\":\"hqosmf\",\"hybridAksClustersAssociatedIds\":[\"utycyarnroohguab\",\"oghktdpycz\",\"coe\",\"cnhz\"],\"hybridAksPluginType\":\"DPDK\",\"interfaceName\":\"tjzcfyjzpt\",\"l2IsolationDomainId\":\"rl\",\"provisioningState\":\"Canceled\",\"virtualMachinesAssociatedIds\":[\"infsz\",\"yglqdhmrjzral\",\"xpjb\"]},\"location\":\"psjoqcjenk\",\"tags\":{\"xfxjelgcmpzqj\":\"qzvs\"},\"id\":\"hhqxuwyvcacoyviv\",\"name\":\"s\",\"type\":\"zusjsz\"}]}";

        Mockito.when(httpResponse.getStatusCode()).thenReturn(200);
        Mockito.when(httpResponse.getHeaders()).thenReturn(new HttpHeaders());
        Mockito
            .when(httpResponse.getBody())
            .thenReturn(Flux.just(ByteBuffer.wrap(responseStr.getBytes(StandardCharsets.UTF_8))));
        Mockito
            .when(httpResponse.getBodyAsByteArray())
            .thenReturn(Mono.just(responseStr.getBytes(StandardCharsets.UTF_8)));
        Mockito
            .when(httpClient.send(httpRequest.capture(), Mockito.any()))
            .thenReturn(
                Mono
                    .defer(
                        () -> {
                            Mockito.when(httpResponse.getRequest()).thenReturn(httpRequest.getValue());
                            return Mono.just(httpResponse);
                        }));

        NetworkCloudManager manager =
            NetworkCloudManager
                .configure()
                .withHttpClient(httpClient)
                .authenticate(
                    tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                    new AzureProfile("", "", AzureEnvironment.AZURE));

        PagedIterable<L2Network> response = manager.l2Networks().list(com.azure.core.util.Context.NONE);

        Assertions.assertEquals("psjoqcjenk", response.iterator().next().location());
        Assertions.assertEquals("qzvs", response.iterator().next().tags().get("xfxjelgcmpzqj"));
        Assertions.assertEquals("qmbzmq", response.iterator().next().extendedLocation().name());
        Assertions.assertEquals("ratbnxwbjs", response.iterator().next().extendedLocation().type());
        Assertions.assertEquals(HybridAksPluginType.DPDK, response.iterator().next().hybridAksPluginType());
        Assertions.assertEquals("tjzcfyjzpt", response.iterator().next().interfaceName());
        Assertions.assertEquals("rl", response.iterator().next().l2IsolationDomainId());
    }
}
