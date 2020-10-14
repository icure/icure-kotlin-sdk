# BeefactApi

All URIs are relative to *https://kraken.icure.dev*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createBatchAndMessage**](BeefactApi.md#createBatchAndMessage) | **POST** /rest/v1/be_efact/{insuranceId}/{newMessageId}/{numericalRef} | create batch and message

<a name="createBatchAndMessage"></a>
# **createBatchAndMessage**
> MessageWithBatch createBatchAndMessage(body, insuranceId, newMessageId, numericalRef)

create batch and message

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BeefactApi()
val body : MapOfIdsDto =  // MapOfIdsDto | 
val insuranceId : kotlin.String = insuranceId_example // kotlin.String | 
val newMessageId : kotlin.String = newMessageId_example // kotlin.String | 
val numericalRef : kotlin.Long = 789 // kotlin.Long | 
try {
    val result : MessageWithBatch = apiInstance.createBatchAndMessage(body, insuranceId, newMessageId, numericalRef)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BeefactApi#createBatchAndMessage")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BeefactApi#createBatchAndMessage")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**MapOfIdsDto**](MapOfIdsDto.md)|  |
 **insuranceId** | **kotlin.String**|  |
 **newMessageId** | **kotlin.String**|  |
 **numericalRef** | **kotlin.Long**|  |

### Return type

[**MessageWithBatch**](MessageWithBatch.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

