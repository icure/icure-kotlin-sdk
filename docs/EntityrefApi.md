# EntityrefApi

All URIs are relative to *https://kraken.icure.dev*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createEntityReference**](EntityrefApi.md#createEntityReference) | **POST** /rest/v1/entityref | Create an entity reference
[**getLatest**](EntityrefApi.md#getLatest) | **GET** /rest/v1/entityref/latest/{prefix} | Find latest reference for a prefix 

<a name="createEntityReference"></a>
# **createEntityReference**
> EntityReferenceDto createEntityReference(body)

Create an entity reference

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = EntityrefApi()
val body : EntityReferenceDto =  // EntityReferenceDto | 
try {
    val result : EntityReferenceDto = apiInstance.createEntityReference(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EntityrefApi#createEntityReference")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EntityrefApi#createEntityReference")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**EntityReferenceDto**](EntityReferenceDto.md)|  |

### Return type

[**EntityReferenceDto**](EntityReferenceDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="getLatest"></a>
# **getLatest**
> EntityReferenceDto getLatest(prefix)

Find latest reference for a prefix 

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = EntityrefApi()
val prefix : kotlin.String = prefix_example // kotlin.String | 
try {
    val result : EntityReferenceDto = apiInstance.getLatest(prefix)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EntityrefApi#getLatest")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EntityrefApi#getLatest")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **prefix** | **kotlin.String**|  |

### Return type

[**EntityReferenceDto**](EntityReferenceDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

