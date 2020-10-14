# ApplicationsettingsApi

All URIs are relative to *https://kraken.icure.dev*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getApplicationSettings**](ApplicationsettingsApi.md#getApplicationSettings) | **GET** /rest/v1/appsettings | Gets all application settings

<a name="getApplicationSettings"></a>
# **getApplicationSettings**
> kotlin.Array&lt;ApplicationSettingsDto&gt; getApplicationSettings()

Gets all application settings

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ApplicationsettingsApi()
try {
    val result : kotlin.Array<ApplicationSettingsDto> = apiInstance.getApplicationSettings()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationsettingsApi#getApplicationSettings")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationsettingsApi#getApplicationSettings")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.Array&lt;ApplicationSettingsDto&gt;**](ApplicationSettingsDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

