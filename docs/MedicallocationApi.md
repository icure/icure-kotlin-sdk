# MedicallocationApi

All URIs are relative to *https://kraken.icure.dev*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createMedicalLocation**](MedicallocationApi.md#createMedicalLocation) | **POST** /rest/v1/medicallocation | Creates a medical location
[**deleteMedicalLocation**](MedicallocationApi.md#deleteMedicalLocation) | **DELETE** /rest/v1/medicallocation/{locationIds} | Deletes a medical location
[**getMedicalLocation**](MedicallocationApi.md#getMedicalLocation) | **GET** /rest/v1/medicallocation/{locationId} | Gets a medical location
[**getMedicalLocations**](MedicallocationApi.md#getMedicalLocations) | **GET** /rest/v1/medicallocation | Gets all medical locations
[**modifyMedicalLocation**](MedicallocationApi.md#modifyMedicalLocation) | **PUT** /rest/v1/medicallocation | Modifies a medical location

<a name="createMedicalLocation"></a>
# **createMedicalLocation**
> MedicalLocationDto createMedicalLocation(body)

Creates a medical location

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = MedicallocationApi()
val body : MedicalLocationDto =  // MedicalLocationDto | 
try {
    val result : MedicalLocationDto = apiInstance.createMedicalLocation(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MedicallocationApi#createMedicalLocation")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MedicallocationApi#createMedicalLocation")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**MedicalLocationDto**](MedicalLocationDto.md)|  |

### Return type

[**MedicalLocationDto**](MedicalLocationDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="deleteMedicalLocation"></a>
# **deleteMedicalLocation**
> kotlin.Array&lt;DocIdentifier&gt; deleteMedicalLocation(locationIds)

Deletes a medical location

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = MedicallocationApi()
val locationIds : kotlin.String = locationIds_example // kotlin.String | 
try {
    val result : kotlin.Array<DocIdentifier> = apiInstance.deleteMedicalLocation(locationIds)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MedicallocationApi#deleteMedicalLocation")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MedicallocationApi#deleteMedicalLocation")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **locationIds** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;DocIdentifier&gt;**](DocIdentifier.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getMedicalLocation"></a>
# **getMedicalLocation**
> MedicalLocationDto getMedicalLocation(locationId)

Gets a medical location

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = MedicallocationApi()
val locationId : kotlin.String = locationId_example // kotlin.String | 
try {
    val result : MedicalLocationDto = apiInstance.getMedicalLocation(locationId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MedicallocationApi#getMedicalLocation")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MedicallocationApi#getMedicalLocation")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **locationId** | **kotlin.String**|  |

### Return type

[**MedicalLocationDto**](MedicalLocationDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getMedicalLocations"></a>
# **getMedicalLocations**
> kotlin.Array&lt;MedicalLocationDto&gt; getMedicalLocations()

Gets all medical locations

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = MedicallocationApi()
try {
    val result : kotlin.Array<MedicalLocationDto> = apiInstance.getMedicalLocations()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MedicallocationApi#getMedicalLocations")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MedicallocationApi#getMedicalLocations")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.Array&lt;MedicalLocationDto&gt;**](MedicalLocationDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="modifyMedicalLocation"></a>
# **modifyMedicalLocation**
> MedicalLocationDto modifyMedicalLocation(body)

Modifies a medical location

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = MedicallocationApi()
val body : MedicalLocationDto =  // MedicalLocationDto | 
try {
    val result : MedicalLocationDto = apiInstance.modifyMedicalLocation(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MedicallocationApi#modifyMedicalLocation")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MedicallocationApi#modifyMedicalLocation")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**MedicalLocationDto**](MedicalLocationDto.md)|  |

### Return type

[**MedicalLocationDto**](MedicalLocationDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

