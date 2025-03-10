// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.containerservice.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Profile of the managed cluster load balancer. */
@Fluent
public final class ManagedClusterLoadBalancerProfile {
    /*
     * Desired managed outbound IPs for the cluster load balancer.
     */
    @JsonProperty(value = "managedOutboundIPs")
    private ManagedClusterLoadBalancerProfileManagedOutboundIPs managedOutboundIPs;

    /*
     * Desired outbound IP Prefix resources for the cluster load balancer.
     */
    @JsonProperty(value = "outboundIPPrefixes")
    private ManagedClusterLoadBalancerProfileOutboundIpPrefixes outboundIpPrefixes;

    /*
     * Desired outbound IP resources for the cluster load balancer.
     */
    @JsonProperty(value = "outboundIPs")
    private ManagedClusterLoadBalancerProfileOutboundIPs outboundIPs;

    /*
     * The effective outbound IP resources of the cluster load balancer.
     */
    @JsonProperty(value = "effectiveOutboundIPs")
    private List<ResourceReference> effectiveOutboundIPs;

    /*
     * The desired number of allocated SNAT ports per VM. Allowed values are in the range of 0 to 64000 (inclusive).
     * The default value is 0 which results in Azure dynamically allocating ports.
     */
    @JsonProperty(value = "allocatedOutboundPorts")
    private Integer allocatedOutboundPorts;

    /*
     * Desired outbound flow idle timeout in minutes. Allowed values are in the range of 4 to 120 (inclusive). The
     * default value is 30 minutes.
     */
    @JsonProperty(value = "idleTimeoutInMinutes")
    private Integer idleTimeoutInMinutes;

    /*
     * Enable multiple standard load balancers per AKS cluster or not.
     */
    @JsonProperty(value = "enableMultipleStandardLoadBalancers")
    private Boolean enableMultipleStandardLoadBalancers;

    /** Creates an instance of ManagedClusterLoadBalancerProfile class. */
    public ManagedClusterLoadBalancerProfile() {
    }

    /**
     * Get the managedOutboundIPs property: Desired managed outbound IPs for the cluster load balancer.
     *
     * @return the managedOutboundIPs value.
     */
    public ManagedClusterLoadBalancerProfileManagedOutboundIPs managedOutboundIPs() {
        return this.managedOutboundIPs;
    }

    /**
     * Set the managedOutboundIPs property: Desired managed outbound IPs for the cluster load balancer.
     *
     * @param managedOutboundIPs the managedOutboundIPs value to set.
     * @return the ManagedClusterLoadBalancerProfile object itself.
     */
    public ManagedClusterLoadBalancerProfile withManagedOutboundIPs(
        ManagedClusterLoadBalancerProfileManagedOutboundIPs managedOutboundIPs) {
        this.managedOutboundIPs = managedOutboundIPs;
        return this;
    }

    /**
     * Get the outboundIpPrefixes property: Desired outbound IP Prefix resources for the cluster load balancer.
     *
     * @return the outboundIpPrefixes value.
     */
    public ManagedClusterLoadBalancerProfileOutboundIpPrefixes outboundIpPrefixes() {
        return this.outboundIpPrefixes;
    }

    /**
     * Set the outboundIpPrefixes property: Desired outbound IP Prefix resources for the cluster load balancer.
     *
     * @param outboundIpPrefixes the outboundIpPrefixes value to set.
     * @return the ManagedClusterLoadBalancerProfile object itself.
     */
    public ManagedClusterLoadBalancerProfile withOutboundIpPrefixes(
        ManagedClusterLoadBalancerProfileOutboundIpPrefixes outboundIpPrefixes) {
        this.outboundIpPrefixes = outboundIpPrefixes;
        return this;
    }

    /**
     * Get the outboundIPs property: Desired outbound IP resources for the cluster load balancer.
     *
     * @return the outboundIPs value.
     */
    public ManagedClusterLoadBalancerProfileOutboundIPs outboundIPs() {
        return this.outboundIPs;
    }

    /**
     * Set the outboundIPs property: Desired outbound IP resources for the cluster load balancer.
     *
     * @param outboundIPs the outboundIPs value to set.
     * @return the ManagedClusterLoadBalancerProfile object itself.
     */
    public ManagedClusterLoadBalancerProfile withOutboundIPs(ManagedClusterLoadBalancerProfileOutboundIPs outboundIPs) {
        this.outboundIPs = outboundIPs;
        return this;
    }

    /**
     * Get the effectiveOutboundIPs property: The effective outbound IP resources of the cluster load balancer.
     *
     * @return the effectiveOutboundIPs value.
     */
    public List<ResourceReference> effectiveOutboundIPs() {
        return this.effectiveOutboundIPs;
    }

    /**
     * Set the effectiveOutboundIPs property: The effective outbound IP resources of the cluster load balancer.
     *
     * @param effectiveOutboundIPs the effectiveOutboundIPs value to set.
     * @return the ManagedClusterLoadBalancerProfile object itself.
     */
    public ManagedClusterLoadBalancerProfile withEffectiveOutboundIPs(List<ResourceReference> effectiveOutboundIPs) {
        this.effectiveOutboundIPs = effectiveOutboundIPs;
        return this;
    }

    /**
     * Get the allocatedOutboundPorts property: The desired number of allocated SNAT ports per VM. Allowed values are in
     * the range of 0 to 64000 (inclusive). The default value is 0 which results in Azure dynamically allocating ports.
     *
     * @return the allocatedOutboundPorts value.
     */
    public Integer allocatedOutboundPorts() {
        return this.allocatedOutboundPorts;
    }

    /**
     * Set the allocatedOutboundPorts property: The desired number of allocated SNAT ports per VM. Allowed values are in
     * the range of 0 to 64000 (inclusive). The default value is 0 which results in Azure dynamically allocating ports.
     *
     * @param allocatedOutboundPorts the allocatedOutboundPorts value to set.
     * @return the ManagedClusterLoadBalancerProfile object itself.
     */
    public ManagedClusterLoadBalancerProfile withAllocatedOutboundPorts(Integer allocatedOutboundPorts) {
        this.allocatedOutboundPorts = allocatedOutboundPorts;
        return this;
    }

    /**
     * Get the idleTimeoutInMinutes property: Desired outbound flow idle timeout in minutes. Allowed values are in the
     * range of 4 to 120 (inclusive). The default value is 30 minutes.
     *
     * @return the idleTimeoutInMinutes value.
     */
    public Integer idleTimeoutInMinutes() {
        return this.idleTimeoutInMinutes;
    }

    /**
     * Set the idleTimeoutInMinutes property: Desired outbound flow idle timeout in minutes. Allowed values are in the
     * range of 4 to 120 (inclusive). The default value is 30 minutes.
     *
     * @param idleTimeoutInMinutes the idleTimeoutInMinutes value to set.
     * @return the ManagedClusterLoadBalancerProfile object itself.
     */
    public ManagedClusterLoadBalancerProfile withIdleTimeoutInMinutes(Integer idleTimeoutInMinutes) {
        this.idleTimeoutInMinutes = idleTimeoutInMinutes;
        return this;
    }

    /**
     * Get the enableMultipleStandardLoadBalancers property: Enable multiple standard load balancers per AKS cluster or
     * not.
     *
     * @return the enableMultipleStandardLoadBalancers value.
     */
    public Boolean enableMultipleStandardLoadBalancers() {
        return this.enableMultipleStandardLoadBalancers;
    }

    /**
     * Set the enableMultipleStandardLoadBalancers property: Enable multiple standard load balancers per AKS cluster or
     * not.
     *
     * @param enableMultipleStandardLoadBalancers the enableMultipleStandardLoadBalancers value to set.
     * @return the ManagedClusterLoadBalancerProfile object itself.
     */
    public ManagedClusterLoadBalancerProfile withEnableMultipleStandardLoadBalancers(
        Boolean enableMultipleStandardLoadBalancers) {
        this.enableMultipleStandardLoadBalancers = enableMultipleStandardLoadBalancers;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (managedOutboundIPs() != null) {
            managedOutboundIPs().validate();
        }
        if (outboundIpPrefixes() != null) {
            outboundIpPrefixes().validate();
        }
        if (outboundIPs() != null) {
            outboundIPs().validate();
        }
        if (effectiveOutboundIPs() != null) {
            effectiveOutboundIPs().forEach(e -> e.validate());
        }
    }
}
