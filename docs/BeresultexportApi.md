# BeresultexportApi

All URIs are relative to *https://kraken.icure.dev*

Method | HTTP request | Description
------------- | ------------- | -------------
[**exportHealthOne**](BeresultexportApi.md#exportHealthOne) | **POST** /rest/v1/be_result_export/hl1/{fromHcpId}/{toHcpId}/{patId}/{date}/{ref} | Export data
[**exportKmehrReport**](BeresultexportApi.md#exportKmehrReport) | **POST** /rest/v1/be_result_export/kmehrreport/{fromHcpId}/{toHcpId}/{patId}/{date}/{ref} | Export data
[**exportMedidoc**](BeresultexportApi.md#exportMedidoc) | **POST** /rest/v1/be_result_export/medidoc/{fromHcpId}/{toHcpId}/{patId}/{date}/{ref} | Export data

<a name="exportHealthOne"></a>
# **exportHealthOne**
> kotlin.Array&lt;kotlin.Byte&gt; exportHealthOne(body, fromHcpId, toHcpId, patId, date, ref)

Export data

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BeresultexportApi()
val body : kotlin.Array<ByteArray> =  // kotlin.Array<ByteArray> | 
val fromHcpId : kotlin.String = fromHcpId_example // kotlin.String | 
val toHcpId : kotlin.String = toHcpId_example // kotlin.String | 
val patId : kotlin.String = patId_example // kotlin.String | 
val date : kotlin.Long = 789 // kotlin.Long | 
val ref : kotlin.String = ref_example // kotlin.String | 
try {
    val result : kotlin.Array<kotlin.Byte> = apiInstance.exportHealthOne(body, fromHcpId, toHcpId, patId, date, ref)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BeresultexportApi#exportHealthOne")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BeresultexportApi#exportHealthOne")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**kotlin.Array&lt;ByteArray&gt;**](ByteArray.md)|  |
 **fromHcpId** | **kotlin.String**|  |
 **toHcpId** | **kotlin.String**|  |
 **patId** | **kotlin.String**|  |
 **date** | **kotlin.Long**|  |
 **ref** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;kotlin.Byte&gt;**](kotlin.Array&lt;kotlin.Byte&gt;.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/octet-stream
 - **Accept**: application/octet-stream

<a name="exportKmehrReport"></a>
# **exportKmehrReport**
> kotlin.Array&lt;kotlin.Byte&gt; exportKmehrReport(body, fromHcpId, toHcpId, patId, date, ref, mimeType)

Export data

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BeresultexportApi()
val body : kotlin.Array<ByteArray> =  // kotlin.Array<ByteArray> | 
val fromHcpId : kotlin.String = fromHcpId_example // kotlin.String | 
val toHcpId : kotlin.String = toHcpId_example // kotlin.String | 
val patId : kotlin.String = patId_example // kotlin.String | 
val date : kotlin.Long = 789 // kotlin.Long | 
val ref : kotlin.String = ref_example // kotlin.String | 
val mimeType : kotlin.Boolean = true // kotlin.Boolean | 
try {
    val result : kotlin.Array<kotlin.Byte> = apiInstance.exportKmehrReport(body, fromHcpId, toHcpId, patId, date, ref, mimeType)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BeresultexportApi#exportKmehrReport")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BeresultexportApi#exportKmehrReport")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**kotlin.Array&lt;ByteArray&gt;**](ByteArray.md)|  |
 **fromHcpId** | **kotlin.String**|  |
 **toHcpId** | **kotlin.String**|  |
 **patId** | **kotlin.String**|  |
 **date** | **kotlin.Long**|  |
 **ref** | **kotlin.String**|  |
 **mimeType** | **kotlin.Boolean**|  | [optional]

### Return type

[**kotlin.Array&lt;kotlin.Byte&gt;**](kotlin.Array&lt;kotlin.Byte&gt;.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/octet-stream
 - **Accept**: application/octet-stream

<a name="exportMedidoc"></a>
# **exportMedidoc**
> kotlin.Array&lt;kotlin.Byte&gt; exportMedidoc(body, fromHcpId, toHcpId, patId, date, ref)

Export data

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BeresultexportApi()
val body : kotlin.Array<ByteArray> =  // kotlin.Array<ByteArray> | 
val fromHcpId : kotlin.String = fromHcpId_example // kotlin.String | 
val toHcpId : kotlin.String = toHcpId_example // kotlin.String | 
val patId : kotlin.String = patId_example // kotlin.String | 
val date : kotlin.Long = 789 // kotlin.Long | 
val ref : kotlin.String = ref_example // kotlin.String | 
try {
    val result : kotlin.Array<kotlin.Byte> = apiInstance.exportMedidoc(body, fromHcpId, toHcpId, patId, date, ref)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BeresultexportApi#exportMedidoc")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BeresultexportApi#exportMedidoc")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**kotlin.Array&lt;ByteArray&gt;**](ByteArray.md)|  |
 **fromHcpId** | **kotlin.String**|  |
 **toHcpId** | **kotlin.String**|  |
 **patId** | **kotlin.String**|  |
 **date** | **kotlin.Long**|  |
 **ref** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;kotlin.Byte&gt;**](kotlin.Array&lt;kotlin.Byte&gt;.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/octet-stream
 - **Accept**: application/octet-stream

