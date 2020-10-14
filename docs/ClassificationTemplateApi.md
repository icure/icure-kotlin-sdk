# ClassificationTemplateApi

All URIs are relative to *https://kraken.icure.dev*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createClassificationTemplate**](ClassificationTemplateApi.md#createClassificationTemplate) | **POST** /rest/v1/classificationTemplate | Create a classification Template with the current user
[**deleteClassificationTemplates**](ClassificationTemplateApi.md#deleteClassificationTemplates) | **DELETE** /rest/v1/classificationTemplate/{classificationTemplateIds} | Delete classification Templates.
[**findClassificationTemplatesByHCPartyPatientForeignKeys**](ClassificationTemplateApi.md#findClassificationTemplatesByHCPartyPatientForeignKeys) | **GET** /rest/v1/classificationTemplate/byHcPartySecretForeignKeys | List classification Templates found By Healthcare Party and secret foreign keyelementIds.
[**getClassificationTemplate**](ClassificationTemplateApi.md#getClassificationTemplate) | **GET** /rest/v1/classificationTemplate/{classificationTemplateId} | Get a classification Template
[**getClassificationTemplateByIds**](ClassificationTemplateApi.md#getClassificationTemplateByIds) | **GET** /rest/v1/classificationTemplate/byIds/{ids} | Get a list of classifications Templates
[**listClassificationTemplates**](ClassificationTemplateApi.md#listClassificationTemplates) | **GET** /rest/v1/classificationTemplate | List all classification templates with pagination
[**modifyClassificationTemplate**](ClassificationTemplateApi.md#modifyClassificationTemplate) | **PUT** /rest/v1/classificationTemplate | Modify a classification Template
[**newClassificationTemplateDelegations**](ClassificationTemplateApi.md#newClassificationTemplateDelegations) | **POST** /rest/v1/classificationTemplate/{classificationTemplateId}/delegate | Delegates a classification Template to a healthcare party

<a name="createClassificationTemplate"></a>
# **createClassificationTemplate**
> ClassificationTemplateDto createClassificationTemplate(body)

Create a classification Template with the current user

Returns an instance of created classification Template.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ClassificationTemplateApi()
val body : ClassificationTemplateDto =  // ClassificationTemplateDto | 
try {
    val result : ClassificationTemplateDto = apiInstance.createClassificationTemplate(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ClassificationTemplateApi#createClassificationTemplate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ClassificationTemplateApi#createClassificationTemplate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ClassificationTemplateDto**](ClassificationTemplateDto.md)|  |

### Return type

[**ClassificationTemplateDto**](ClassificationTemplateDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="deleteClassificationTemplates"></a>
# **deleteClassificationTemplates**
> kotlin.Array&lt;DocIdentifier&gt; deleteClassificationTemplates(classificationTemplateIds)

Delete classification Templates.

Response is a set containing the ID&#x27;s of deleted classification Templates.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ClassificationTemplateApi()
val classificationTemplateIds : kotlin.String = classificationTemplateIds_example // kotlin.String | 
try {
    val result : kotlin.Array<DocIdentifier> = apiInstance.deleteClassificationTemplates(classificationTemplateIds)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ClassificationTemplateApi#deleteClassificationTemplates")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ClassificationTemplateApi#deleteClassificationTemplates")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **classificationTemplateIds** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;DocIdentifier&gt;**](DocIdentifier.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="findClassificationTemplatesByHCPartyPatientForeignKeys"></a>
# **findClassificationTemplatesByHCPartyPatientForeignKeys**
> kotlin.Array&lt;ClassificationTemplateDto&gt; findClassificationTemplatesByHCPartyPatientForeignKeys(hcPartyId, secretFKeys)

List classification Templates found By Healthcare Party and secret foreign keyelementIds.

Keys hast to delimited by coma

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ClassificationTemplateApi()
val hcPartyId : kotlin.String = hcPartyId_example // kotlin.String | 
val secretFKeys : kotlin.String = secretFKeys_example // kotlin.String | 
try {
    val result : kotlin.Array<ClassificationTemplateDto> = apiInstance.findClassificationTemplatesByHCPartyPatientForeignKeys(hcPartyId, secretFKeys)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ClassificationTemplateApi#findClassificationTemplatesByHCPartyPatientForeignKeys")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ClassificationTemplateApi#findClassificationTemplatesByHCPartyPatientForeignKeys")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hcPartyId** | **kotlin.String**|  |
 **secretFKeys** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;ClassificationTemplateDto&gt;**](ClassificationTemplateDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getClassificationTemplate"></a>
# **getClassificationTemplate**
> ClassificationTemplateDto getClassificationTemplate(classificationTemplateId)

Get a classification Template

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ClassificationTemplateApi()
val classificationTemplateId : kotlin.String = classificationTemplateId_example // kotlin.String | 
try {
    val result : ClassificationTemplateDto = apiInstance.getClassificationTemplate(classificationTemplateId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ClassificationTemplateApi#getClassificationTemplate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ClassificationTemplateApi#getClassificationTemplate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **classificationTemplateId** | **kotlin.String**|  |

### Return type

[**ClassificationTemplateDto**](ClassificationTemplateDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getClassificationTemplateByIds"></a>
# **getClassificationTemplateByIds**
> kotlin.Array&lt;ClassificationTemplateDto&gt; getClassificationTemplateByIds(ids)

Get a list of classifications Templates

Ids are seperated by a coma

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ClassificationTemplateApi()
val ids : kotlin.String = ids_example // kotlin.String | 
try {
    val result : kotlin.Array<ClassificationTemplateDto> = apiInstance.getClassificationTemplateByIds(ids)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ClassificationTemplateApi#getClassificationTemplateByIds")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ClassificationTemplateApi#getClassificationTemplateByIds")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ids** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;ClassificationTemplateDto&gt;**](ClassificationTemplateDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="listClassificationTemplates"></a>
# **listClassificationTemplates**
> PaginatedListClassificationTemplateDto listClassificationTemplates(startKey, startDocumentId, limit)

List all classification templates with pagination

Returns a list of classification templates.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ClassificationTemplateApi()
val startKey : kotlin.String = startKey_example // kotlin.String | A label
val startDocumentId : kotlin.String = startDocumentId_example // kotlin.String | An classification template document ID
val limit : kotlin.Int = 56 // kotlin.Int | Number of rows
try {
    val result : PaginatedListClassificationTemplateDto = apiInstance.listClassificationTemplates(startKey, startDocumentId, limit)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ClassificationTemplateApi#listClassificationTemplates")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ClassificationTemplateApi#listClassificationTemplates")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **startKey** | **kotlin.String**| A label |
 **startDocumentId** | **kotlin.String**| An classification template document ID |
 **limit** | **kotlin.Int**| Number of rows |

### Return type

[**PaginatedListClassificationTemplateDto**](PaginatedListClassificationTemplateDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="modifyClassificationTemplate"></a>
# **modifyClassificationTemplate**
> ClassificationTemplateDto modifyClassificationTemplate(body)

Modify a classification Template

Returns the modified classification Template.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ClassificationTemplateApi()
val body : ClassificationTemplateDto =  // ClassificationTemplateDto | 
try {
    val result : ClassificationTemplateDto = apiInstance.modifyClassificationTemplate(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ClassificationTemplateApi#modifyClassificationTemplate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ClassificationTemplateApi#modifyClassificationTemplate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ClassificationTemplateDto**](ClassificationTemplateDto.md)|  |

### Return type

[**ClassificationTemplateDto**](ClassificationTemplateDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="newClassificationTemplateDelegations"></a>
# **newClassificationTemplateDelegations**
> ClassificationTemplateDto newClassificationTemplateDelegations(body, classificationTemplateId)

Delegates a classification Template to a healthcare party

It delegates a classification Template to a healthcare party (By current healthcare party). Returns the element with new delegations.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ClassificationTemplateApi()
val body : kotlin.Array<DelegationDto> =  // kotlin.Array<DelegationDto> | 
val classificationTemplateId : kotlin.String = classificationTemplateId_example // kotlin.String | 
try {
    val result : ClassificationTemplateDto = apiInstance.newClassificationTemplateDelegations(body, classificationTemplateId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ClassificationTemplateApi#newClassificationTemplateDelegations")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ClassificationTemplateApi#newClassificationTemplateDelegations")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**kotlin.Array&lt;DelegationDto&gt;**](DelegationDto.md)|  |
 **classificationTemplateId** | **kotlin.String**|  |

### Return type

[**ClassificationTemplateDto**](ClassificationTemplateDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

