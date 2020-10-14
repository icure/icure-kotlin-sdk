# ClassificationApi

All URIs are relative to *https://kraken.icure.dev*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createClassification**](ClassificationApi.md#createClassification) | **POST** /rest/v1/classification | Create a classification with the current user
[**deleteClassifications**](ClassificationApi.md#deleteClassifications) | **DELETE** /rest/v1/classification/{classificationIds} | Delete classification Templates.
[**findClassificationsByHCPartyPatientForeignKeys**](ClassificationApi.md#findClassificationsByHCPartyPatientForeignKeys) | **GET** /rest/v1/classification/byHcPartySecretForeignKeys | List classification Templates found By Healthcare Party and secret foreign keyelementIds.
[**getClassification**](ClassificationApi.md#getClassification) | **GET** /rest/v1/classification/{classificationId} | Get a classification Template
[**getClassificationByHcPartyId**](ClassificationApi.md#getClassificationByHcPartyId) | **GET** /rest/v1/classification/byIds/{ids} | Get a list of classifications
[**modifyClassification**](ClassificationApi.md#modifyClassification) | **PUT** /rest/v1/classification | Modify a classification Template
[**newClassificationDelegations**](ClassificationApi.md#newClassificationDelegations) | **POST** /rest/v1/classification/{classificationId}/delegate | Delegates a classification to a healthcare party
[**setClassificationsDelegations**](ClassificationApi.md#setClassificationsDelegations) | **POST** /rest/v1/classification/delegations | Update delegations in classification

<a name="createClassification"></a>
# **createClassification**
> ClassificationDto createClassification(body)

Create a classification with the current user

Returns an instance of created classification Template.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ClassificationApi()
val body : ClassificationDto =  // ClassificationDto | 
try {
    val result : ClassificationDto = apiInstance.createClassification(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ClassificationApi#createClassification")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ClassificationApi#createClassification")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ClassificationDto**](ClassificationDto.md)|  |

### Return type

[**ClassificationDto**](ClassificationDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="deleteClassifications"></a>
# **deleteClassifications**
> kotlin.Array&lt;DocIdentifier&gt; deleteClassifications(classificationIds)

Delete classification Templates.

Response is a set containing the ID&#x27;s of deleted classification Templates.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ClassificationApi()
val classificationIds : kotlin.String = classificationIds_example // kotlin.String | 
try {
    val result : kotlin.Array<DocIdentifier> = apiInstance.deleteClassifications(classificationIds)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ClassificationApi#deleteClassifications")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ClassificationApi#deleteClassifications")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **classificationIds** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;DocIdentifier&gt;**](DocIdentifier.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="findClassificationsByHCPartyPatientForeignKeys"></a>
# **findClassificationsByHCPartyPatientForeignKeys**
> kotlin.Array&lt;ClassificationDto&gt; findClassificationsByHCPartyPatientForeignKeys(hcPartyId, secretFKeys)

List classification Templates found By Healthcare Party and secret foreign keyelementIds.

Keys hast to delimited by coma

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ClassificationApi()
val hcPartyId : kotlin.String = hcPartyId_example // kotlin.String | 
val secretFKeys : kotlin.String = secretFKeys_example // kotlin.String | 
try {
    val result : kotlin.Array<ClassificationDto> = apiInstance.findClassificationsByHCPartyPatientForeignKeys(hcPartyId, secretFKeys)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ClassificationApi#findClassificationsByHCPartyPatientForeignKeys")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ClassificationApi#findClassificationsByHCPartyPatientForeignKeys")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hcPartyId** | **kotlin.String**|  |
 **secretFKeys** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;ClassificationDto&gt;**](ClassificationDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getClassification"></a>
# **getClassification**
> ClassificationDto getClassification(classificationId)

Get a classification Template

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ClassificationApi()
val classificationId : kotlin.String = classificationId_example // kotlin.String | 
try {
    val result : ClassificationDto = apiInstance.getClassification(classificationId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ClassificationApi#getClassification")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ClassificationApi#getClassification")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **classificationId** | **kotlin.String**|  |

### Return type

[**ClassificationDto**](ClassificationDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getClassificationByHcPartyId"></a>
# **getClassificationByHcPartyId**
> kotlin.Array&lt;ClassificationDto&gt; getClassificationByHcPartyId(ids)

Get a list of classifications

Ids are seperated by a coma

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ClassificationApi()
val ids : kotlin.String = ids_example // kotlin.String | 
try {
    val result : kotlin.Array<ClassificationDto> = apiInstance.getClassificationByHcPartyId(ids)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ClassificationApi#getClassificationByHcPartyId")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ClassificationApi#getClassificationByHcPartyId")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ids** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;ClassificationDto&gt;**](ClassificationDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="modifyClassification"></a>
# **modifyClassification**
> ClassificationDto modifyClassification(body)

Modify a classification Template

Returns the modified classification Template.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ClassificationApi()
val body : ClassificationDto =  // ClassificationDto | 
try {
    val result : ClassificationDto = apiInstance.modifyClassification(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ClassificationApi#modifyClassification")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ClassificationApi#modifyClassification")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ClassificationDto**](ClassificationDto.md)|  |

### Return type

[**ClassificationDto**](ClassificationDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="newClassificationDelegations"></a>
# **newClassificationDelegations**
> ClassificationDto newClassificationDelegations(body, classificationId)

Delegates a classification to a healthcare party

It delegates a classification to a healthcare party (By current healthcare party). Returns the element with new delegations.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ClassificationApi()
val body : kotlin.Array<DelegationDto> =  // kotlin.Array<DelegationDto> | 
val classificationId : kotlin.String = classificationId_example // kotlin.String | 
try {
    val result : ClassificationDto = apiInstance.newClassificationDelegations(body, classificationId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ClassificationApi#newClassificationDelegations")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ClassificationApi#newClassificationDelegations")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**kotlin.Array&lt;DelegationDto&gt;**](DelegationDto.md)|  |
 **classificationId** | **kotlin.String**|  |

### Return type

[**ClassificationDto**](ClassificationDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="setClassificationsDelegations"></a>
# **setClassificationsDelegations**
> kotlin.Array&lt;IcureStubDto&gt; setClassificationsDelegations(body)

Update delegations in classification

Keys must be delimited by coma

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ClassificationApi()
val body : kotlin.Array<IcureStubDto> =  // kotlin.Array<IcureStubDto> | 
try {
    val result : kotlin.Array<IcureStubDto> = apiInstance.setClassificationsDelegations(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ClassificationApi#setClassificationsDelegations")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ClassificationApi#setClassificationsDelegations")
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

