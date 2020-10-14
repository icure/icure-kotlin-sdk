# ReceiptApi

All URIs are relative to *https://kraken.icure.dev*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createReceipt**](ReceiptApi.md#createReceipt) | **POST** /rest/v1/receipt | Creates a receipt
[**deleteReceipt**](ReceiptApi.md#deleteReceipt) | **DELETE** /rest/v1/receipt/{receiptIds} | Deletes a receipt
[**getReceipt**](ReceiptApi.md#getReceipt) | **GET** /rest/v1/receipt/{receiptId} | Gets a receipt
[**getReceiptAttachment**](ReceiptApi.md#getReceiptAttachment) | **GET** /rest/v1/receipt/{receiptId}/attachment/{attachmentId} | Get an attachment
[**listByReference**](ReceiptApi.md#listByReference) | **GET** /rest/v1/receipt/byref/{ref} | Gets a receipt
[**modifyReceipt**](ReceiptApi.md#modifyReceipt) | **PUT** /rest/v1/receipt | Updates a receipt
[**setReceiptAttachment**](ReceiptApi.md#setReceiptAttachment) | **PUT** /rest/v1/receipt/{receiptId}/attachment/{blobType} | Creates a receipt&#x27;s attachment

<a name="createReceipt"></a>
# **createReceipt**
> ReceiptDto createReceipt(body)

Creates a receipt

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ReceiptApi()
val body : ReceiptDto =  // ReceiptDto | 
try {
    val result : ReceiptDto = apiInstance.createReceipt(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ReceiptApi#createReceipt")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ReceiptApi#createReceipt")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ReceiptDto**](ReceiptDto.md)|  |

### Return type

[**ReceiptDto**](ReceiptDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="deleteReceipt"></a>
# **deleteReceipt**
> kotlin.Array&lt;DocIdentifier&gt; deleteReceipt(receiptIds)

Deletes a receipt

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ReceiptApi()
val receiptIds : kotlin.String = receiptIds_example // kotlin.String | 
try {
    val result : kotlin.Array<DocIdentifier> = apiInstance.deleteReceipt(receiptIds)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ReceiptApi#deleteReceipt")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ReceiptApi#deleteReceipt")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **receiptIds** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;DocIdentifier&gt;**](DocIdentifier.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getReceipt"></a>
# **getReceipt**
> ReceiptDto getReceipt(receiptId)

Gets a receipt

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ReceiptApi()
val receiptId : kotlin.String = receiptId_example // kotlin.String | 
try {
    val result : ReceiptDto = apiInstance.getReceipt(receiptId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ReceiptApi#getReceipt")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ReceiptApi#getReceipt")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **receiptId** | **kotlin.String**|  |

### Return type

[**ReceiptDto**](ReceiptDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getReceiptAttachment"></a>
# **getReceiptAttachment**
> kotlin.Array&lt;kotlin.Byte&gt; getReceiptAttachment(receiptId, attachmentId, enckeys)

Get an attachment

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ReceiptApi()
val receiptId : kotlin.String = receiptId_example // kotlin.String | 
val attachmentId : kotlin.String = attachmentId_example // kotlin.String | 
val enckeys : kotlin.String = enckeys_example // kotlin.String | 
try {
    val result : kotlin.Array<kotlin.Byte> = apiInstance.getReceiptAttachment(receiptId, attachmentId, enckeys)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ReceiptApi#getReceiptAttachment")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ReceiptApi#getReceiptAttachment")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **receiptId** | **kotlin.String**|  |
 **attachmentId** | **kotlin.String**|  |
 **enckeys** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;kotlin.Byte&gt;**](kotlin.Array&lt;kotlin.Byte&gt;.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/octet-stream

<a name="listByReference"></a>
# **listByReference**
> kotlin.Array&lt;ReceiptDto&gt; listByReference(ref)

Gets a receipt

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ReceiptApi()
val ref : kotlin.String = ref_example // kotlin.String | 
try {
    val result : kotlin.Array<ReceiptDto> = apiInstance.listByReference(ref)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ReceiptApi#listByReference")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ReceiptApi#listByReference")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ref** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;ReceiptDto&gt;**](ReceiptDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="modifyReceipt"></a>
# **modifyReceipt**
> ReceiptDto modifyReceipt(body)

Updates a receipt

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ReceiptApi()
val body : ReceiptDto =  // ReceiptDto | 
try {
    val result : ReceiptDto = apiInstance.modifyReceipt(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ReceiptApi#modifyReceipt")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ReceiptApi#modifyReceipt")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ReceiptDto**](ReceiptDto.md)|  |

### Return type

[**ReceiptDto**](ReceiptDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="setReceiptAttachment"></a>
# **setReceiptAttachment**
> ReceiptDto setReceiptAttachment(body, receiptId, blobType, enckeys)

Creates a receipt&#x27;s attachment

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ReceiptApi()
val body : kotlin.Array<ByteArray> =  // kotlin.Array<ByteArray> | 
val receiptId : kotlin.String = receiptId_example // kotlin.String | 
val blobType : kotlin.String = blobType_example // kotlin.String | 
val enckeys : kotlin.String = enckeys_example // kotlin.String | 
try {
    val result : ReceiptDto = apiInstance.setReceiptAttachment(body, receiptId, blobType, enckeys)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ReceiptApi#setReceiptAttachment")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ReceiptApi#setReceiptAttachment")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**kotlin.Array&lt;ByteArray&gt;**](ByteArray.md)|  |
 **receiptId** | **kotlin.String**|  |
 **blobType** | **kotlin.String**|  |
 **enckeys** | **kotlin.String**|  | [optional]

### Return type

[**ReceiptDto**](ReceiptDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/octet-stream
 - **Accept**: */*

