# FrontendmigrationApi

All URIs are relative to *https://kraken.icure.dev*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createFrontEndMigration**](FrontendmigrationApi.md#createFrontEndMigration) | **POST** /rest/v1/frontendmigration | Creates a front end migration
[**deleteFrontEndMigration**](FrontendmigrationApi.md#deleteFrontEndMigration) | **DELETE** /rest/v1/frontendmigration/{frontEndMigrationId} | Deletes a front end migration
[**getFrontEndMigration**](FrontendmigrationApi.md#getFrontEndMigration) | **GET** /rest/v1/frontendmigration/{frontEndMigrationId} | Gets a front end migration
[**getFrontEndMigrationByName**](FrontendmigrationApi.md#getFrontEndMigrationByName) | **GET** /rest/v1/frontendmigration/byName/{frontEndMigrationName} | Gets an front end migration
[**getFrontEndMigrations**](FrontendmigrationApi.md#getFrontEndMigrations) | **GET** /rest/v1/frontendmigration | Gets a front end migration
[**modifyFrontEndMigration**](FrontendmigrationApi.md#modifyFrontEndMigration) | **PUT** /rest/v1/frontendmigration | Modifies a front end migration

<a name="createFrontEndMigration"></a>
# **createFrontEndMigration**
> FrontEndMigrationDto createFrontEndMigration(body)

Creates a front end migration

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = FrontendmigrationApi()
val body : FrontEndMigrationDto =  // FrontEndMigrationDto | 
try {
    val result : FrontEndMigrationDto = apiInstance.createFrontEndMigration(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling FrontendmigrationApi#createFrontEndMigration")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling FrontendmigrationApi#createFrontEndMigration")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**FrontEndMigrationDto**](FrontEndMigrationDto.md)|  |

### Return type

[**FrontEndMigrationDto**](FrontEndMigrationDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="deleteFrontEndMigration"></a>
# **deleteFrontEndMigration**
> DocIdentifier deleteFrontEndMigration(frontEndMigrationId)

Deletes a front end migration

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = FrontendmigrationApi()
val frontEndMigrationId : kotlin.String = frontEndMigrationId_example // kotlin.String | 
try {
    val result : DocIdentifier = apiInstance.deleteFrontEndMigration(frontEndMigrationId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling FrontendmigrationApi#deleteFrontEndMigration")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling FrontendmigrationApi#deleteFrontEndMigration")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **frontEndMigrationId** | **kotlin.String**|  |

### Return type

[**DocIdentifier**](DocIdentifier.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getFrontEndMigration"></a>
# **getFrontEndMigration**
> FrontEndMigrationDto getFrontEndMigration(frontEndMigrationId)

Gets a front end migration

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = FrontendmigrationApi()
val frontEndMigrationId : kotlin.String = frontEndMigrationId_example // kotlin.String | 
try {
    val result : FrontEndMigrationDto = apiInstance.getFrontEndMigration(frontEndMigrationId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling FrontendmigrationApi#getFrontEndMigration")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling FrontendmigrationApi#getFrontEndMigration")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **frontEndMigrationId** | **kotlin.String**|  |

### Return type

[**FrontEndMigrationDto**](FrontEndMigrationDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getFrontEndMigrationByName"></a>
# **getFrontEndMigrationByName**
> kotlin.Array&lt;FrontEndMigrationDto&gt; getFrontEndMigrationByName(frontEndMigrationName)

Gets an front end migration

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = FrontendmigrationApi()
val frontEndMigrationName : kotlin.String = frontEndMigrationName_example // kotlin.String | 
try {
    val result : kotlin.Array<FrontEndMigrationDto> = apiInstance.getFrontEndMigrationByName(frontEndMigrationName)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling FrontendmigrationApi#getFrontEndMigrationByName")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling FrontendmigrationApi#getFrontEndMigrationByName")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **frontEndMigrationName** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;FrontEndMigrationDto&gt;**](FrontEndMigrationDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getFrontEndMigrations"></a>
# **getFrontEndMigrations**
> kotlin.Array&lt;FrontEndMigrationDto&gt; getFrontEndMigrations()

Gets a front end migration

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = FrontendmigrationApi()
try {
    val result : kotlin.Array<FrontEndMigrationDto> = apiInstance.getFrontEndMigrations()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling FrontendmigrationApi#getFrontEndMigrations")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling FrontendmigrationApi#getFrontEndMigrations")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.Array&lt;FrontEndMigrationDto&gt;**](FrontEndMigrationDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="modifyFrontEndMigration"></a>
# **modifyFrontEndMigration**
> FrontEndMigrationDto modifyFrontEndMigration(body)

Modifies a front end migration

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = FrontendmigrationApi()
val body : FrontEndMigrationDto =  // FrontEndMigrationDto | 
try {
    val result : FrontEndMigrationDto = apiInstance.modifyFrontEndMigration(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling FrontendmigrationApi#modifyFrontEndMigration")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling FrontendmigrationApi#modifyFrontEndMigration")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**FrontEndMigrationDto**](FrontEndMigrationDto.md)|  |

### Return type

[**FrontEndMigrationDto**](FrontEndMigrationDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

