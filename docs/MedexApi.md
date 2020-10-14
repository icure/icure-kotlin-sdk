# MedexApi

All URIs are relative to *https://kraken.icure.dev*

Method | HTTP request | Description
------------- | ------------- | -------------
[**generateMedex**](MedexApi.md#generateMedex) | **POST** /rest/v1/medex/generate | Generate a Medex XML String

<a name="generateMedex"></a>
# **generateMedex**
> kotlin.String generateMedex(body)

Generate a Medex XML String

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = MedexApi()
val body : MedexInfoDto =  // MedexInfoDto | 
try {
    val result : kotlin.String = apiInstance.generateMedex(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MedexApi#generateMedex")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MedexApi#generateMedex")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**MedexInfoDto**](MedexInfoDto.md)|  |

### Return type

**kotlin.String**

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/xml

