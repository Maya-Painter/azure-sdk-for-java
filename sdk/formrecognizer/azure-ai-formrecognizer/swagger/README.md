# Azure Cognitive Service - Form Recognizer for Java

> see https://aka.ms/autorest

### Setup
```ps
Fork and clone https://github.com/Azure/autorest.java 
git checkout v4
git submodule update --init --recursive
mvn package -Dlocal
npm install
npm install -g autorest
```

### Generation
```ps
cd <swagger-folder>
autorest --java --use=C:/work/autorest.java
```

## Form Recognizer Service V2.1
### To run, use `autorest --tag:formrecognizer-v2.1 README.md`

``` yaml $(tag) == 'formrecognizer-v2.1'
use: '@autorest/java@4.1.13'
input-file: https://raw.githubusercontent.com/Azure/azure-rest-api-specs/master/specification/cognitiveservices/data-plane/FormRecognizer/stable/v2.1/FormRecognizer.json
java: true
output-folder: ..\
generate-client-as-impl: true
namespace: com.azure.ai.formrecognizer
generate-client-interfaces: false
sync-methods: all
license-header: MICROSOFT_MIT_SMALL
add-context-parameter: true
models-subpackage: implementation.models
context-client-method-parameter: true
custom-types-subpackage: models
custom-types: LengthUnit
service-interface-as-public: true
```

### Add multiple service API support
This is better to fixed in the swagger, but we are working around now.
``` yaml $(tag) == 'formrecognizer-v2.1'
directive:
- from: swagger-document
  where: $["x-ms-parameterized-host"]
  transform: >
    $.hostTemplate = "{endpoint}/formrecognizer/{ApiVersion}";
    $.parameters.push({
      "name": "ApiVersion",
      "description": "Form Recognizer API version.",
      "x-ms-parameter-location": "client",
      "required": true,
      "type": "string",
      "in": "path",
      "x-ms-skip-url-encoding": true
    });
```


## Form Recognizer Service 2023-07-31
### To run, use `autorest --tag:formrecognizer-documentanalysis README.md`
``` yaml $(tag) == 'formrecognizer-documentanalysis'
use: '@autorest/java@4.1.13'
input-file: https://raw.githubusercontent.com/Azure/azure-rest-api-specs/main/specification/cognitiveservices/data-plane/FormRecognizer/stable/2023-07-31/FormRecognizer.json
java: true
output-folder: ..\
generate-client-as-impl: true
namespace: com.azure.ai.formrecognizer.documentanalysis
generate-client-interfaces: false
sync-methods: all
license-header: MICROSOFT_MIT_SMALL
add-context-parameter: true
models-subpackage: implementation.models
context-client-method-parameter: true
service-interface-as-public: true
custom-strongly-typed-header-deserialization: true
generic-response-type: true
custom-types-subpackage: models
custom-types: DocumentFormulaKind,DocumentPageKind,DocumentBarcodeKind,FontStyle,FontWeight,ParagraphRole,DocumentAnalysisFeature
required-fields-as-ctor-args: true
enable-sync-stack: true
polling: {}
output-model-immutable: true
```

### Expose PathOperationId & PathResultId as String
``` yaml $(tag) == 'formrecognizer-documentanalysis'
directive:
  - from: swagger-document
    where: $.parameters
    transform: >
      delete $.PathOperationId["format"];
      delete $.PathResultId["format"];
```

