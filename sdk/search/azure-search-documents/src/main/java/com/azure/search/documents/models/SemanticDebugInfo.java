// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
//
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is regenerated.

package com.azure.search.documents.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/** The SemanticDebugInfo model. */
@Immutable
public final class SemanticDebugInfo implements JsonSerializable<SemanticDebugInfo> {
    /*
     * The title field that was sent to the semantic enrichment process, as well as how it was used
     */
    private QueryResultDocumentSemanticField titleField;

    /*
     * The content fields that were sent to the semantic enrichment process, as well as how they were used
     */
    private List<QueryResultDocumentSemanticField> contentFields;

    /*
     * The keyword fields that were sent to the semantic enrichment process, as well as how they were used
     */
    private List<QueryResultDocumentSemanticField> keywordFields;

    /*
     * The raw concatenated strings that were sent to the semantic enrichment process.
     */
    private QueryResultDocumentRerankerInput rerankerInput;

    /** Creates an instance of SemanticDebugInfo class. */
    public SemanticDebugInfo() {}

    /**
     * Get the titleField property: The title field that was sent to the semantic enrichment process, as well as how it
     * was used.
     *
     * @return the titleField value.
     */
    public QueryResultDocumentSemanticField getTitleField() {
        return this.titleField;
    }

    /**
     * Get the contentFields property: The content fields that were sent to the semantic enrichment process, as well as
     * how they were used.
     *
     * @return the contentFields value.
     */
    public List<QueryResultDocumentSemanticField> getContentFields() {
        return this.contentFields;
    }

    /**
     * Get the keywordFields property: The keyword fields that were sent to the semantic enrichment process, as well as
     * how they were used.
     *
     * @return the keywordFields value.
     */
    public List<QueryResultDocumentSemanticField> getKeywordFields() {
        return this.keywordFields;
    }

    /**
     * Get the rerankerInput property: The raw concatenated strings that were sent to the semantic enrichment process.
     *
     * @return the rerankerInput value.
     */
    public QueryResultDocumentRerankerInput getRerankerInput() {
        return this.rerankerInput;
    }

    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("titleField", this.titleField);
        jsonWriter.writeArrayField("contentFields", this.contentFields, (writer, element) -> writer.writeJson(element));
        jsonWriter.writeArrayField("keywordFields", this.keywordFields, (writer, element) -> writer.writeJson(element));
        jsonWriter.writeJsonField("rerankerInput", this.rerankerInput);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of SemanticDebugInfo from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of SemanticDebugInfo if the JsonReader was pointing to an instance of it, or null if it was
     *     pointing to JSON null.
     * @throws IOException If an error occurs while reading the SemanticDebugInfo.
     */
    public static SemanticDebugInfo fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(
                reader -> {
                    SemanticDebugInfo deserializedSemanticDebugInfo = new SemanticDebugInfo();
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        String fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("titleField".equals(fieldName)) {
                            deserializedSemanticDebugInfo.titleField =
                                    QueryResultDocumentSemanticField.fromJson(reader);
                        } else if ("contentFields".equals(fieldName)) {
                            List<QueryResultDocumentSemanticField> contentFields =
                                    reader.readArray(reader1 -> QueryResultDocumentSemanticField.fromJson(reader1));
                            deserializedSemanticDebugInfo.contentFields = contentFields;
                        } else if ("keywordFields".equals(fieldName)) {
                            List<QueryResultDocumentSemanticField> keywordFields =
                                    reader.readArray(reader1 -> QueryResultDocumentSemanticField.fromJson(reader1));
                            deserializedSemanticDebugInfo.keywordFields = keywordFields;
                        } else if ("rerankerInput".equals(fieldName)) {
                            deserializedSemanticDebugInfo.rerankerInput =
                                    QueryResultDocumentRerankerInput.fromJson(reader);
                        } else {
                            reader.skipChildren();
                        }
                    }

                    return deserializedSemanticDebugInfo;
                });
    }
}
