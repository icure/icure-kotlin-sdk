# PubsubApi

All URIs are relative to *https://kraken.icure.dev*

Method | HTTP request | Description
------------- | ------------- | -------------
[**offerAuth**](PubsubApi.md#offerAuth) | **PUT** /rest/v1/pubsub/auth/{bucket} | Offer auth data on secret bucket
[**pub**](PubsubApi.md#pub) | **PUT** /rest/v1/pubsub/pub/{key} | publish data
[**recoverAuth**](PubsubApi.md#recoverAuth) | **GET** /rest/v1/pubsub/auth/recover/{bucket} | Recover auth data from secret bucket
[**sub**](PubsubApi.md#sub) | **GET** /rest/v1/pubsub/sub/{key} | subscribe to data

<a name="offerAuth"></a>
# **offerAuth**
> kotlin.collections.Map&lt;kotlin.String, kotlin.Boolean&gt; offerAuth(body, bucket)

Offer auth data on secret bucket

Offer auth data on previously agreed on secret bucket, data should be encrypted

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = PubsubApi()
val body : kotlin.Array<ByteArray> =  // kotlin.Array<ByteArray> | 
val bucket : kotlin.String = bucket_example // kotlin.String | 
try {
    val result : kotlin.collections.Map<kotlin.String, kotlin.Boolean> = apiInstance.offerAuth(body, bucket)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PubsubApi#offerAuth")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PubsubApi#offerAuth")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**kotlin.Array&lt;ByteArray&gt;**](ByteArray.md)|  |
 **bucket** | **kotlin.String**|  |

### Return type

**kotlin.collections.Map&lt;kotlin.String, kotlin.Boolean&gt;**

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/octet-stream
 - **Accept**: */*

<a name="pub"></a>
# **pub**
> kotlin.collections.Map&lt;kotlin.String, kotlin.Boolean&gt; pub(body, key)

publish data

Publish value with key

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = PubsubApi()
val body : kotlin.Array<ByteArray> =  // kotlin.Array<ByteArray> | 
val key : kotlin.String = key_example // kotlin.String | 
try {
    val result : kotlin.collections.Map<kotlin.String, kotlin.Boolean> = apiInstance.pub(body, key)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PubsubApi#pub")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PubsubApi#pub")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**kotlin.Array&lt;ByteArray&gt;**](ByteArray.md)|  |
 **key** | **kotlin.String**|  |

### Return type

**kotlin.collections.Map&lt;kotlin.String, kotlin.Boolean&gt;**

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/octet-stream
 - **Accept**: */*

<a name="recoverAuth"></a>
# **recoverAuth**
> kotlin.Array&lt;kotlin.Byte&gt; recoverAuth(bucket)

Recover auth data from secret bucket

Recover auth data from bucket, data should be encrypted

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = PubsubApi()
val bucket : kotlin.String = bucket_example // kotlin.String | 
try {
    val result : kotlin.Array<kotlin.Byte> = apiInstance.recoverAuth(bucket)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PubsubApi#recoverAuth")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PubsubApi#recoverAuth")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **bucket** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;kotlin.Byte&gt;**](kotlin.Array&lt;kotlin.Byte&gt;.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/octet-stream

<a name="sub"></a>
# **sub**
> kotlin.Array&lt;kotlin.Byte&gt; sub(key)

subscribe to data

Try to get published data

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = PubsubApi()
val key : kotlin.String = key_example // kotlin.String | 
try {
    val result : kotlin.Array<kotlin.Byte> = apiInstance.sub(key)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PubsubApi#sub")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PubsubApi#sub")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **key** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;kotlin.Byte&gt;**](kotlin.Array&lt;kotlin.Byte&gt;.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/octet-stream

