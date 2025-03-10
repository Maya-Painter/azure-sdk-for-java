// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
//
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is regenerated.

package com.azure.search.documents.indexes.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/** Contains configuration options specific to the algorithm used during indexing time. */
@Immutable
public class VectorSearchAlgorithmConfiguration implements JsonSerializable<VectorSearchAlgorithmConfiguration> {
    /*
     * The name to associate with this particular configuration.
     */
    private final String name;

    /**
     * Creates an instance of VectorSearchAlgorithmConfiguration class.
     *
     * @param name the name value to set.
     */
    public VectorSearchAlgorithmConfiguration(String name) {
        this.name = name;
    }

    /**
     * Get the name property: The name to associate with this particular configuration.
     *
     * @return the name value.
     */
    public String getName() {
        return this.name;
    }

    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("name", this.name);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of VectorSearchAlgorithmConfiguration from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of VectorSearchAlgorithmConfiguration if the JsonReader was pointing to an instance of it, or
     *     null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties or the
     *     polymorphic discriminator.
     * @throws IOException If an error occurs while reading the VectorSearchAlgorithmConfiguration.
     */
    public static VectorSearchAlgorithmConfiguration fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(
                reader -> {
                    String discriminatorValue = null;
                    JsonReader readerToUse = reader.bufferObject();

                    readerToUse.nextToken(); // Prepare for reading
                    while (readerToUse.nextToken() != JsonToken.END_OBJECT) {
                        String fieldName = readerToUse.getFieldName();
                        readerToUse.nextToken();
                        if ("kind".equals(fieldName)) {
                            discriminatorValue = readerToUse.getString();
                            break;
                        } else {
                            readerToUse.skipChildren();
                        }
                    }

                    if (discriminatorValue != null) {
                        readerToUse = readerToUse.reset();
                    }
                    // Use the discriminator value to determine which subtype should be deserialized.
                    if ("hnsw".equals(discriminatorValue)) {
                        return HnswVectorSearchAlgorithmConfiguration.fromJson(readerToUse);
                    } else {
                        throw new IllegalStateException(
                                "Discriminator field 'kind' didn't match one of the expected values 'hnsw'");
                    }
                });
    }
}
