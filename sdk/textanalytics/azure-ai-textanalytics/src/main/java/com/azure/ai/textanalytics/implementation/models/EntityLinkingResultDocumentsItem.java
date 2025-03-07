// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.textanalytics.implementation.models;

import com.azure.core.annotation.Fluent;
import java.util.List;

/** The EntityLinkingResultDocumentsItem model. */
@Fluent
public final class EntityLinkingResultDocumentsItem extends LinkedEntitiesDocumentResult {
    /** Creates an instance of EntityLinkingResultDocumentsItem class. */
    public EntityLinkingResultDocumentsItem() {}

    /** {@inheritDoc} */
    @Override
    public EntityLinkingResultDocumentsItem setEntities(List<LinkedEntity> entities) {
        super.setEntities(entities);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public EntityLinkingResultDocumentsItem setId(String id) {
        super.setId(id);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public EntityLinkingResultDocumentsItem setWarnings(List<DocumentWarning> warnings) {
        super.setWarnings(warnings);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public EntityLinkingResultDocumentsItem setStatistics(DocumentStatistics statistics) {
        super.setStatistics(statistics);
        return this;
    }
}
