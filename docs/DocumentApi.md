# DocumentApi

All URIs are relative to *https://kraken.icure.dev*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createDocument**](DocumentApi.md#createDocument) | **POST** /rest/v1/document | Creates a document
[**deleteAttachment**](DocumentApi.md#deleteAttachment) | **DELETE** /rest/v1/document/{documentId}/attachment | Deletes a document&#x27;s attachment
[**deleteDocument**](DocumentApi.md#deleteDocument) | **DELETE** /rest/v1/document/{documentIds} | Deletes a document
[**findByTypeHCPartyMessageSecretFKeys**](DocumentApi.md#findByTypeHCPartyMessageSecretFKeys) | **GET** /rest/v1/document/byTypeHcPartySecretForeignKeys | List documents found By type, By Healthcare Party and secret foreign keys.
[**findDocumentsByHCPartyPatientForeignKeys**](DocumentApi.md#findDocumentsByHCPartyPatientForeignKeys) | **GET** /rest/v1/document/byHcPartySecretForeignKeys | List documents found By Healthcare Party and secret foreign keys.
[**findWithoutDelegation**](DocumentApi.md#findWithoutDelegation) | **GET** /rest/v1/document/woDelegation | List documents with no delegation
[**getDocument**](DocumentApi.md#getDocument) | **GET** /rest/v1/document/{documentId} | Gets a document
[**getDocumentAttachment**](DocumentApi.md#getDocumentAttachment) | **GET** /rest/v1/document/{documentId}/attachment/{attachmentId} | Creates a document
[**getDocuments**](DocumentApi.md#getDocuments) | **POST** /rest/v1/document/batch | Gets a document
[**modifyDocument**](DocumentApi.md#modifyDocument) | **PUT** /rest/v1/document | Updates a document
[**modifyDocuments**](DocumentApi.md#modifyDocuments) | **PUT** /rest/v1/document/batch | Updates a batch of documents
[**setDocumentAttachment**](DocumentApi.md#setDocumentAttachment) | **PUT** /rest/v1/document/{documentId}/attachment | Creates a document&#x27;s attachment
[**setDocumentAttachmentMulti**](DocumentApi.md#setDocumentAttachmentMulti) | **PUT** /rest/v1/document/{documentId}/attachment/multipart | Creates a document&#x27;s attachment
[**setDocumentsDelegations**](DocumentApi.md#setDocumentsDelegations) | **POST** /rest/v1/document/delegations | Update delegations in healthElements.

<a name="createDocument"></a>
# **createDocument**
> DocumentDto createDocument(body)

Creates a document

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = DocumentApi()
val body : DocumentDto =  // DocumentDto | 
try {
    val result : DocumentDto = apiInstance.createDocument(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DocumentApi#createDocument")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DocumentApi#createDocument")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**DocumentDto**](DocumentDto.md)|  |

### Return type

[**DocumentDto**](DocumentDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="deleteAttachment"></a>
# **deleteAttachment**
> DocumentDto deleteAttachment(documentId)

Deletes a document&#x27;s attachment

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = DocumentApi()
val documentId : kotlin.String = documentId_example // kotlin.String | 
try {
    val result : DocumentDto = apiInstance.deleteAttachment(documentId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DocumentApi#deleteAttachment")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DocumentApi#deleteAttachment")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **documentId** | **kotlin.String**|  |

### Return type

[**DocumentDto**](DocumentDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="deleteDocument"></a>
# **deleteDocument**
> kotlin.Array&lt;DocIdentifier&gt; deleteDocument(documentIds)

Deletes a document

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = DocumentApi()
val documentIds : kotlin.String = documentIds_example // kotlin.String | 
try {
    val result : kotlin.Array<DocIdentifier> = apiInstance.deleteDocument(documentIds)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DocumentApi#deleteDocument")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DocumentApi#deleteDocument")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **documentIds** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;DocIdentifier&gt;**](DocIdentifier.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="findByTypeHCPartyMessageSecretFKeys"></a>
# **findByTypeHCPartyMessageSecretFKeys**
> kotlin.Array&lt;DocumentDto&gt; findByTypeHCPartyMessageSecretFKeys(documentTypeCode, hcPartyId, secretFKeys)

List documents found By type, By Healthcare Party and secret foreign keys.

Keys must be delimited by coma

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = DocumentApi()
val documentTypeCode : kotlin.String = documentTypeCode_example // kotlin.String | 
val hcPartyId : kotlin.String = hcPartyId_example // kotlin.String | 
val secretFKeys : kotlin.String = secretFKeys_example // kotlin.String | 
try {
    val result : kotlin.Array<DocumentDto> = apiInstance.findByTypeHCPartyMessageSecretFKeys(documentTypeCode, hcPartyId, secretFKeys)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DocumentApi#findByTypeHCPartyMessageSecretFKeys")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DocumentApi#findByTypeHCPartyMessageSecretFKeys")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **documentTypeCode** | **kotlin.String**|  |
 **hcPartyId** | **kotlin.String**|  |
 **secretFKeys** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;DocumentDto&gt;**](DocumentDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="findDocumentsByHCPartyPatientForeignKeys"></a>
# **findDocumentsByHCPartyPatientForeignKeys**
> kotlin.Array&lt;DocumentDto&gt; findDocumentsByHCPartyPatientForeignKeys(hcPartyId, secretFKeys)

List documents found By Healthcare Party and secret foreign keys.

Keys must be delimited by coma

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = DocumentApi()
val hcPartyId : kotlin.String = hcPartyId_example // kotlin.String | 
val secretFKeys : kotlin.String = secretFKeys_example // kotlin.String | 
try {
    val result : kotlin.Array<DocumentDto> = apiInstance.findDocumentsByHCPartyPatientForeignKeys(hcPartyId, secretFKeys)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DocumentApi#findDocumentsByHCPartyPatientForeignKeys")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DocumentApi#findDocumentsByHCPartyPatientForeignKeys")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hcPartyId** | **kotlin.String**|  |
 **secretFKeys** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;DocumentDto&gt;**](DocumentDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="findWithoutDelegation"></a>
# **findWithoutDelegation**
> kotlin.Array&lt;DocumentDto&gt; findWithoutDelegation(limit)

List documents with no delegation

Keys must be delimited by coma

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = DocumentApi()
val limit : kotlin.Int = 56 // kotlin.Int | 
try {
    val result : kotlin.Array<DocumentDto> = apiInstance.findWithoutDelegation(limit)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DocumentApi#findWithoutDelegation")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DocumentApi#findWithoutDelegation")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **kotlin.Int**|  | [optional]

### Return type

[**kotlin.Array&lt;DocumentDto&gt;**](DocumentDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getDocument"></a>
# **getDocument**
> DocumentDto getDocument(documentId)

Gets a document

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = DocumentApi()
val documentId : kotlin.String = documentId_example // kotlin.String | 
try {
    val result : DocumentDto = apiInstance.getDocument(documentId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DocumentApi#getDocument")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DocumentApi#getDocument")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **documentId** | **kotlin.String**|  |

### Return type

[**DocumentDto**](DocumentDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getDocumentAttachment"></a>
# **getDocumentAttachment**
> kotlin.Array&lt;kotlin.Byte&gt; getDocumentAttachment(documentId, attachmentId, enckeys, fileName)

Creates a document

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = DocumentApi()
val documentId : kotlin.String = documentId_example // kotlin.String | 
val attachmentId : kotlin.String = attachmentId_example // kotlin.String | 
val enckeys : kotlin.String = enckeys_example // kotlin.String | 
val fileName : kotlin.String = fileName_example // kotlin.String | 
try {
    val result : kotlin.Array<kotlin.Byte> = apiInstance.getDocumentAttachment(documentId, attachmentId, enckeys, fileName)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DocumentApi#getDocumentAttachment")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DocumentApi#getDocumentAttachment")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **documentId** | **kotlin.String**|  |
 **attachmentId** | **kotlin.String**|  |
 **enckeys** | **kotlin.String**|  | [optional]
 **fileName** | **kotlin.String**|  | [optional]

### Return type

[**kotlin.Array&lt;kotlin.Byte&gt;**](kotlin.Array&lt;kotlin.Byte&gt;.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/octet-stream

<a name="getDocuments"></a>
# **getDocuments**
> kotlin.Array&lt;DocumentDto&gt; getDocuments(body)

Gets a document

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = DocumentApi()
val body : ListOfIdsDto =  // ListOfIdsDto | 
try {
    val result : kotlin.Array<DocumentDto> = apiInstance.getDocuments(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DocumentApi#getDocuments")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DocumentApi#getDocuments")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ListOfIdsDto**](ListOfIdsDto.md)|  |

### Return type

[**kotlin.Array&lt;DocumentDto&gt;**](DocumentDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="modifyDocument"></a>
# **modifyDocument**
> DocumentDto modifyDocument(body)

Updates a document

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = DocumentApi()
val body : DocumentDto =  // DocumentDto | 
try {
    val result : DocumentDto = apiInstance.modifyDocument(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DocumentApi#modifyDocument")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DocumentApi#modifyDocument")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**DocumentDto**](DocumentDto.md)|  |

### Return type

[**DocumentDto**](DocumentDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="modifyDocuments"></a>
# **modifyDocuments**
> kotlin.Array&lt;DocumentDto&gt; modifyDocuments(body)

Updates a batch of documents

Returns the modified documents.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = DocumentApi()
val body : kotlin.Array<DocumentDto> =  // kotlin.Array<DocumentDto> | 
try {
    val result : kotlin.Array<DocumentDto> = apiInstance.modifyDocuments(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DocumentApi#modifyDocuments")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DocumentApi#modifyDocuments")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**kotlin.Array&lt;DocumentDto&gt;**](DocumentDto.md)|  |

### Return type

[**kotlin.Array&lt;DocumentDto&gt;**](DocumentDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="setDocumentAttachment"></a>
# **setDocumentAttachment**
> DocumentDto setDocumentAttachment(body, documentId, enckeys)

Creates a document&#x27;s attachment

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = DocumentApi()
val body : kotlin.Array<ByteArray> =  // kotlin.Array<ByteArray> | 
val documentId : kotlin.String = documentId_example // kotlin.String | 
val enckeys : kotlin.String = enckeys_example // kotlin.String | 
try {
    val result : DocumentDto = apiInstance.setDocumentAttachment(body, documentId, enckeys)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DocumentApi#setDocumentAttachment")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DocumentApi#setDocumentAttachment")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**kotlin.Array&lt;ByteArray&gt;**](ByteArray.md)|  |
 **documentId** | **kotlin.String**|  |
 **enckeys** | **kotlin.String**|  | [optional]

### Return type

[**DocumentDto**](DocumentDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/octet-stream
 - **Accept**: */*

<a name="setDocumentAttachmentMulti"></a>
# **setDocumentAttachmentMulti**
> DocumentDto setDocumentAttachmentMulti(documentId, enckeys)

Creates a document&#x27;s attachment

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = DocumentApi()
val documentId : kotlin.String = documentId_example // kotlin.String | 
val enckeys : kotlin.String = enckeys_example // kotlin.String | 
try {
    val result : DocumentDto = apiInstance.setDocumentAttachmentMulti(documentId, enckeys)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DocumentApi#setDocumentAttachmentMulti")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DocumentApi#setDocumentAttachmentMulti")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **documentId** | **kotlin.String**|  |
 **enckeys** | **kotlin.String**|  | [optional]

### Return type

[**DocumentDto**](DocumentDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: */*

<a name="setDocumentsDelegations"></a>
# **setDocumentsDelegations**
> kotlin.Array&lt;IcureStubDto&gt; setDocumentsDelegations(body)

Update delegations in healthElements.

Keys must be delimited by coma

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = DocumentApi()
val body : kotlin.Array<IcureStubDto> =  // kotlin.Array<IcureStubDto> | 
try {
    val result : kotlin.Array<IcureStubDto> = apiInstance.setDocumentsDelegations(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DocumentApi#setDocumentsDelegations")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DocumentApi#setDocumentsDelegations")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**kotlin.Array&lt;IcureStubDto&gt;**](IcureStubDto.md)|  |

### Return type

[**kotlin.Array&lt;IcureStubDto&gt;**](IcureStubDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

