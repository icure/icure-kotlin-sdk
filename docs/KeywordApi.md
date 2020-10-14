# KeywordApi

All URIs are relative to *https://kraken.icure.dev*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createKeyword**](KeywordApi.md#createKeyword) | **POST** /rest/v1/keyword | Create a keyword with the current user
[**deleteKeywords**](KeywordApi.md#deleteKeywords) | **DELETE** /rest/v1/keyword/{keywordIds} | Delete keywords.
[**getKeyword**](KeywordApi.md#getKeyword) | **GET** /rest/v1/keyword/{keywordId} | Get a keyword
[**getKeywords**](KeywordApi.md#getKeywords) | **GET** /rest/v1/keyword | Gets all keywords
[**getKeywordsByUser**](KeywordApi.md#getKeywordsByUser) | **GET** /rest/v1/keyword/byUser/{userId} | Get keywords by user
[**modifyKeyword**](KeywordApi.md#modifyKeyword) | **PUT** /rest/v1/keyword | Modify a keyword

<a name="createKeyword"></a>
# **createKeyword**
> KeywordDto createKeyword(body)

Create a keyword with the current user

Returns an instance of created keyword.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = KeywordApi()
val body : KeywordDto =  // KeywordDto | 
try {
    val result : KeywordDto = apiInstance.createKeyword(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling KeywordApi#createKeyword")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling KeywordApi#createKeyword")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**KeywordDto**](KeywordDto.md)|  |

### Return type

[**KeywordDto**](KeywordDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="deleteKeywords"></a>
# **deleteKeywords**
> kotlin.Array&lt;DocIdentifier&gt; deleteKeywords(keywordIds)

Delete keywords.

Response is a set containing the ID&#x27;s of deleted keywords.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = KeywordApi()
val keywordIds : kotlin.String = keywordIds_example // kotlin.String | 
try {
    val result : kotlin.Array<DocIdentifier> = apiInstance.deleteKeywords(keywordIds)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling KeywordApi#deleteKeywords")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling KeywordApi#deleteKeywords")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **keywordIds** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;DocIdentifier&gt;**](DocIdentifier.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getKeyword"></a>
# **getKeyword**
> KeywordDto getKeyword(keywordId)

Get a keyword

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = KeywordApi()
val keywordId : kotlin.String = keywordId_example // kotlin.String | 
try {
    val result : KeywordDto = apiInstance.getKeyword(keywordId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling KeywordApi#getKeyword")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling KeywordApi#getKeyword")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **keywordId** | **kotlin.String**|  |

### Return type

[**KeywordDto**](KeywordDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getKeywords"></a>
# **getKeywords**
> kotlin.Array&lt;KeywordDto&gt; getKeywords()

Gets all keywords

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = KeywordApi()
try {
    val result : kotlin.Array<KeywordDto> = apiInstance.getKeywords()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling KeywordApi#getKeywords")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling KeywordApi#getKeywords")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.Array&lt;KeywordDto&gt;**](KeywordDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getKeywordsByUser"></a>
# **getKeywordsByUser**
> kotlin.Array&lt;KeywordDto&gt; getKeywordsByUser(userId)

Get keywords by user

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = KeywordApi()
val userId : kotlin.String = userId_example // kotlin.String | 
try {
    val result : kotlin.Array<KeywordDto> = apiInstance.getKeywordsByUser(userId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling KeywordApi#getKeywordsByUser")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling KeywordApi#getKeywordsByUser")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;KeywordDto&gt;**](KeywordDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="modifyKeyword"></a>
# **modifyKeyword**
> KeywordDto modifyKeyword(body)

Modify a keyword

Returns the modified keyword.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = KeywordApi()
val body : KeywordDto =  // KeywordDto | 
try {
    val result : KeywordDto = apiInstance.modifyKeyword(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling KeywordApi#modifyKeyword")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling KeywordApi#modifyKeyword")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**KeywordDto**](KeywordDto.md)|  |

### Return type

[**KeywordDto**](KeywordDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

