// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datadog.models;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.management.Region;
import com.azure.core.management.SystemData;
import com.azure.core.util.Context;
import com.azure.resourcemanager.datadog.fluent.models.DatadogApiKeyInner;
import com.azure.resourcemanager.datadog.fluent.models.DatadogMonitorResourceInner;
import java.util.Map;

/** An immutable client-side representation of DatadogMonitorResource. */
public interface DatadogMonitorResource {
    /**
     * Gets the id property: Fully qualified resource Id for the resource.
     *
     * @return the id value.
     */
    String id();

    /**
     * Gets the name property: The name of the resource.
     *
     * @return the name value.
     */
    String name();

    /**
     * Gets the type property: The type of the resource.
     *
     * @return the type value.
     */
    String type();

    /**
     * Gets the location property: The geo-location where the resource lives.
     *
     * @return the location value.
     */
    String location();

    /**
     * Gets the tags property: Resource tags.
     *
     * @return the tags value.
     */
    Map<String, String> tags();

    /**
     * Gets the sku property: The sku property.
     *
     * @return the sku value.
     */
    ResourceSku sku();

    /**
     * Gets the properties property: Properties specific to the monitor resource.
     *
     * @return the properties value.
     */
    MonitorProperties properties();

    /**
     * Gets the identity property: The identity property.
     *
     * @return the identity value.
     */
    IdentityProperties identity();

    /**
     * Gets the systemData property: Metadata pertaining to creation and last modification of the resource.
     *
     * @return the systemData value.
     */
    SystemData systemData();

    /**
     * Gets the region of the resource.
     *
     * @return the region of the resource.
     */
    Region region();

    /**
     * Gets the name of the resource region.
     *
     * @return the name of the resource region.
     */
    String regionName();

    /**
     * Gets the name of the resource group.
     *
     * @return the name of the resource group.
     */
    String resourceGroupName();

    /**
     * Gets the inner com.azure.resourcemanager.datadog.fluent.models.DatadogMonitorResourceInner object.
     *
     * @return the inner object.
     */
    DatadogMonitorResourceInner innerModel();

    /** The entirety of the DatadogMonitorResource definition. */
    interface Definition
        extends DefinitionStages.Blank,
            DefinitionStages.WithLocation,
            DefinitionStages.WithResourceGroup,
            DefinitionStages.WithCreate {
    }
    /** The DatadogMonitorResource definition stages. */
    interface DefinitionStages {
        /** The first stage of the DatadogMonitorResource definition. */
        interface Blank extends WithLocation {
        }
        /** The stage of the DatadogMonitorResource definition allowing to specify location. */
        interface WithLocation {
            /**
             * Specifies the region for the resource.
             *
             * @param location The geo-location where the resource lives.
             * @return the next definition stage.
             */
            WithResourceGroup withRegion(Region location);

            /**
             * Specifies the region for the resource.
             *
             * @param location The geo-location where the resource lives.
             * @return the next definition stage.
             */
            WithResourceGroup withRegion(String location);
        }
        /** The stage of the DatadogMonitorResource definition allowing to specify parent resource. */
        interface WithResourceGroup {
            /**
             * Specifies resourceGroupName.
             *
             * @param resourceGroupName The name of the resource group. The name is case insensitive.
             * @return the next definition stage.
             */
            WithCreate withExistingResourceGroup(String resourceGroupName);
        }
        /**
         * The stage of the DatadogMonitorResource definition which contains all the minimum required properties for the
         * resource to be created, but also allows for any other optional properties to be specified.
         */
        interface WithCreate
            extends DefinitionStages.WithTags,
                DefinitionStages.WithSku,
                DefinitionStages.WithProperties,
                DefinitionStages.WithIdentity {
            /**
             * Executes the create request.
             *
             * @return the created resource.
             */
            DatadogMonitorResource create();

            /**
             * Executes the create request.
             *
             * @param context The context to associate with this operation.
             * @return the created resource.
             */
            DatadogMonitorResource create(Context context);
        }
        /** The stage of the DatadogMonitorResource definition allowing to specify tags. */
        interface WithTags {
            /**
             * Specifies the tags property: Resource tags..
             *
             * @param tags Resource tags.
             * @return the next definition stage.
             */
            WithCreate withTags(Map<String, String> tags);
        }
        /** The stage of the DatadogMonitorResource definition allowing to specify sku. */
        interface WithSku {
            /**
             * Specifies the sku property: The sku property..
             *
             * @param sku The sku property.
             * @return the next definition stage.
             */
            WithCreate withSku(ResourceSku sku);
        }
        /** The stage of the DatadogMonitorResource definition allowing to specify properties. */
        interface WithProperties {
            /**
             * Specifies the properties property: Properties specific to the monitor resource..
             *
             * @param properties Properties specific to the monitor resource.
             * @return the next definition stage.
             */
            WithCreate withProperties(MonitorProperties properties);
        }
        /** The stage of the DatadogMonitorResource definition allowing to specify identity. */
        interface WithIdentity {
            /**
             * Specifies the identity property: The identity property..
             *
             * @param identity The identity property.
             * @return the next definition stage.
             */
            WithCreate withIdentity(IdentityProperties identity);
        }
    }
    /**
     * Begins update for the DatadogMonitorResource resource.
     *
     * @return the stage of resource update.
     */
    DatadogMonitorResource.Update update();

    /** The template for DatadogMonitorResource update. */
    interface Update extends UpdateStages.WithTags, UpdateStages.WithProperties, UpdateStages.WithSku {
        /**
         * Executes the update request.
         *
         * @return the updated resource.
         */
        DatadogMonitorResource apply();

        /**
         * Executes the update request.
         *
         * @param context The context to associate with this operation.
         * @return the updated resource.
         */
        DatadogMonitorResource apply(Context context);
    }
    /** The DatadogMonitorResource update stages. */
    interface UpdateStages {
        /** The stage of the DatadogMonitorResource update allowing to specify tags. */
        interface WithTags {
            /**
             * Specifies the tags property: The new tags of the monitor resource..
             *
             * @param tags The new tags of the monitor resource.
             * @return the next definition stage.
             */
            Update withTags(Map<String, String> tags);
        }
        /** The stage of the DatadogMonitorResource update allowing to specify properties. */
        interface WithProperties {
            /**
             * Specifies the properties property: The set of properties that can be update in a PATCH request to a
             * monitor resource..
             *
             * @param properties The set of properties that can be update in a PATCH request to a monitor resource.
             * @return the next definition stage.
             */
            Update withProperties(MonitorUpdateProperties properties);
        }
        /** The stage of the DatadogMonitorResource update allowing to specify sku. */
        interface WithSku {
            /**
             * Specifies the sku property: The sku property..
             *
             * @param sku The sku property.
             * @return the next definition stage.
             */
            Update withSku(ResourceSku sku);
        }
    }
    /**
     * Refreshes the resource to sync with Azure.
     *
     * @return the refreshed resource.
     */
    DatadogMonitorResource refresh();

    /**
     * Refreshes the resource to sync with Azure.
     *
     * @param context The context to associate with this operation.
     * @return the refreshed resource.
     */
    DatadogMonitorResource refresh(Context context);

    /**
     * List the api keys for a given monitor resource.
     *
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return response of a list operation as paginated response with {@link PagedIterable}.
     */
    PagedIterable<DatadogApiKey> listApiKeys();

    /**
     * List the api keys for a given monitor resource.
     *
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return response of a list operation as paginated response with {@link PagedIterable}.
     */
    PagedIterable<DatadogApiKey> listApiKeys(Context context);

    /**
     * Get the default api key.
     *
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the default api key along with {@link Response}.
     */
    Response<DatadogApiKey> getDefaultKeyWithResponse(Context context);

    /**
     * Get the default api key.
     *
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the default api key.
     */
    DatadogApiKey getDefaultKey();

    /**
     * Set the default api key.
     *
     * @param body The body parameter.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response}.
     */
    Response<Void> setDefaultKeyWithResponse(DatadogApiKeyInner body, Context context);

    /**
     * Set the default api key.
     *
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void setDefaultKey();

    /**
     * List the hosts for a given monitor resource.
     *
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return response of a list operation as paginated response with {@link PagedIterable}.
     */
    PagedIterable<DatadogHost> listHosts();

    /**
     * List the hosts for a given monitor resource.
     *
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return response of a list operation as paginated response with {@link PagedIterable}.
     */
    PagedIterable<DatadogHost> listHosts(Context context);

    /**
     * List all Azure resources associated to the same Datadog organization as the target resource.
     *
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return response of a list operation as paginated response with {@link PagedIterable}.
     */
    PagedIterable<LinkedResource> listLinkedResources();

    /**
     * List all Azure resources associated to the same Datadog organization as the target resource.
     *
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return response of a list operation as paginated response with {@link PagedIterable}.
     */
    PagedIterable<LinkedResource> listLinkedResources(Context context);

    /**
     * List the resources currently being monitored by the Datadog monitor resource.
     *
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return response of a list operation as paginated response with {@link PagedIterable}.
     */
    PagedIterable<MonitoredResource> listMonitoredResources();

    /**
     * List the resources currently being monitored by the Datadog monitor resource.
     *
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return response of a list operation as paginated response with {@link PagedIterable}.
     */
    PagedIterable<MonitoredResource> listMonitoredResources(Context context);

    /**
     * Refresh the set password link and return a latest one.
     *
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response body along with {@link Response}.
     */
    Response<DatadogSetPasswordLink> refreshSetPasswordLinkWithResponse(Context context);

    /**
     * Refresh the set password link and return a latest one.
     *
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    DatadogSetPasswordLink refreshSetPasswordLink();
}
