# PlaceApi

All URIs are relative to *https://kraken.icure.dev*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createPlace**](PlaceApi.md#createPlace) | **POST** /rest/v1/place | Creates a place
[**deletePlace**](PlaceApi.md#deletePlace) | **DELETE** /rest/v1/place/{placeIds} | Deletes an place
[**getPlace**](PlaceApi.md#getPlace) | **GET** /rest/v1/place/{placeId} | Gets an place
[**getPlaces**](PlaceApi.md#getPlaces) | **GET** /rest/v1/place | Gets all places
[**modifyPlace**](PlaceApi.md#modifyPlace) | **PUT** /rest/v1/place | Modifies an place

<a name="createPlace"></a>
# **createPlace**
> PlaceDto createPlace(body)

Creates a place

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = PlaceApi()
val body : PlaceDto =  // PlaceDto | 
try {
    val result : PlaceDto = apiInstance.createPlace(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PlaceApi#createPlace")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PlaceApi#createPlace")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**PlaceDto**](PlaceDto.md)|  |

### Return type

[**PlaceDto**](PlaceDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="deletePlace"></a>
# **deletePlace**
> kotlin.Array&lt;DocIdentifier&gt; deletePlace(placeIds)

Deletes an place

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = PlaceApi()
val placeIds : kotlin.String = placeIds_example // kotlin.String | 
try {
    val result : kotlin.Array<DocIdentifier> = apiInstance.deletePlace(placeIds)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PlaceApi#deletePlace")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PlaceApi#deletePlace")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **placeIds** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;DocIdentifier&gt;**](DocIdentifier.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getPlace"></a>
# **getPlace**
> PlaceDto getPlace(placeId)

Gets an place

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = PlaceApi()
val placeId : kotlin.String = placeId_example // kotlin.String | 
try {
    val result : PlaceDto = apiInstance.getPlace(placeId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PlaceApi#getPlace")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PlaceApi#getPlace")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **placeId** | **kotlin.String**|  |

### Return type

[**PlaceDto**](PlaceDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getPlaces"></a>
# **getPlaces**
> kotlin.Array&lt;PlaceDto&gt; getPlaces()

Gets all places

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = PlaceApi()
try {
    val result : kotlin.Array<PlaceDto> = apiInstance.getPlaces()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PlaceApi#getPlaces")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PlaceApi#getPlaces")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.Array&lt;PlaceDto&gt;**](PlaceDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="modifyPlace"></a>
# **modifyPlace**
> PlaceDto modifyPlace(body)

Modifies an place

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = PlaceApi()
val body : PlaceDto =  // PlaceDto | 
try {
    val result : PlaceDto = apiInstance.modifyPlace(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PlaceApi#modifyPlace")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PlaceApi#modifyPlace")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**PlaceDto**](PlaceDto.md)|  |

### Return type

[**PlaceDto**](PlaceDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

