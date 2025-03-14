// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cosmos.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.cosmos.fluent.models.SqlRoleDefinitionResource;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Parameters to create and update an Azure Cosmos DB SQL Role Definition. */
@Fluent
public final class SqlRoleDefinitionCreateUpdateParameters {
    /*
     * Properties to create and update an Azure Cosmos DB SQL Role Definition.
     */
    @JsonProperty(value = "properties")
    private SqlRoleDefinitionResource innerProperties;

    /** Creates an instance of SqlRoleDefinitionCreateUpdateParameters class. */
    public SqlRoleDefinitionCreateUpdateParameters() {
    }

    /**
     * Get the innerProperties property: Properties to create and update an Azure Cosmos DB SQL Role Definition.
     *
     * @return the innerProperties value.
     */
    private SqlRoleDefinitionResource innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the roleName property: A user-friendly name for the Role Definition. Must be unique for the database account.
     *
     * @return the roleName value.
     */
    public String roleName() {
        return this.innerProperties() == null ? null : this.innerProperties().roleName();
    }

    /**
     * Set the roleName property: A user-friendly name for the Role Definition. Must be unique for the database account.
     *
     * @param roleName the roleName value to set.
     * @return the SqlRoleDefinitionCreateUpdateParameters object itself.
     */
    public SqlRoleDefinitionCreateUpdateParameters withRoleName(String roleName) {
        if (this.innerProperties() == null) {
            this.innerProperties = new SqlRoleDefinitionResource();
        }
        this.innerProperties().withRoleName(roleName);
        return this;
    }

    /**
     * Get the type property: Indicates whether the Role Definition was built-in or user created.
     *
     * @return the type value.
     */
    public RoleDefinitionType type() {
        return this.innerProperties() == null ? null : this.innerProperties().type();
    }

    /**
     * Set the type property: Indicates whether the Role Definition was built-in or user created.
     *
     * @param type the type value to set.
     * @return the SqlRoleDefinitionCreateUpdateParameters object itself.
     */
    public SqlRoleDefinitionCreateUpdateParameters withType(RoleDefinitionType type) {
        if (this.innerProperties() == null) {
            this.innerProperties = new SqlRoleDefinitionResource();
        }
        this.innerProperties().withType(type);
        return this;
    }

    /**
     * Get the assignableScopes property: A set of fully qualified Scopes at or below which Role Assignments may be
     * created using this Role Definition. This will allow application of this Role Definition on the entire database
     * account or any underlying Database / Collection. Must have at least one element. Scopes higher than Database
     * account are not enforceable as assignable Scopes. Note that resources referenced in assignable Scopes need not
     * exist.
     *
     * @return the assignableScopes value.
     */
    public List<String> assignableScopes() {
        return this.innerProperties() == null ? null : this.innerProperties().assignableScopes();
    }

    /**
     * Set the assignableScopes property: A set of fully qualified Scopes at or below which Role Assignments may be
     * created using this Role Definition. This will allow application of this Role Definition on the entire database
     * account or any underlying Database / Collection. Must have at least one element. Scopes higher than Database
     * account are not enforceable as assignable Scopes. Note that resources referenced in assignable Scopes need not
     * exist.
     *
     * @param assignableScopes the assignableScopes value to set.
     * @return the SqlRoleDefinitionCreateUpdateParameters object itself.
     */
    public SqlRoleDefinitionCreateUpdateParameters withAssignableScopes(List<String> assignableScopes) {
        if (this.innerProperties() == null) {
            this.innerProperties = new SqlRoleDefinitionResource();
        }
        this.innerProperties().withAssignableScopes(assignableScopes);
        return this;
    }

    /**
     * Get the permissions property: The set of operations allowed through this Role Definition.
     *
     * @return the permissions value.
     */
    public List<Permission> permissions() {
        return this.innerProperties() == null ? null : this.innerProperties().permissions();
    }

    /**
     * Set the permissions property: The set of operations allowed through this Role Definition.
     *
     * @param permissions the permissions value to set.
     * @return the SqlRoleDefinitionCreateUpdateParameters object itself.
     */
    public SqlRoleDefinitionCreateUpdateParameters withPermissions(List<Permission> permissions) {
        if (this.innerProperties() == null) {
            this.innerProperties = new SqlRoleDefinitionResource();
        }
        this.innerProperties().withPermissions(permissions);
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (innerProperties() != null) {
            innerProperties().validate();
        }
    }
}
