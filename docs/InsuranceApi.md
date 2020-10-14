# InsuranceApi

All URIs are relative to *https://kraken.icure.dev*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createInsurance**](InsuranceApi.md#createInsurance) | **POST** /rest/v1/insurance | Creates an insurance
[**deleteInsurance**](InsuranceApi.md#deleteInsurance) | **DELETE** /rest/v1/insurance/{insuranceId} | Deletes an insurance
[**getInsurance**](InsuranceApi.md#getInsurance) | **GET** /rest/v1/insurance/{insuranceId} | Gets an insurance
[**getInsurances**](InsuranceApi.md#getInsurances) | **POST** /rest/v1/insurance/byIds | Gets insurances by id
[**listInsurancesByCode**](InsuranceApi.md#listInsurancesByCode) | **GET** /rest/v1/insurance/byCode/{insuranceCode} | Gets an insurance
[**listInsurancesByName**](InsuranceApi.md#listInsurancesByName) | **GET** /rest/v1/insurance/byName/{insuranceName} | Gets an insurance
[**modifyInsurance**](InsuranceApi.md#modifyInsurance) | **PUT** /rest/v1/insurance | Modifies an insurance

<a name="createInsurance"></a>
# **createInsurance**
> InsuranceDto createInsurance(body)

Creates an insurance

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = InsuranceApi()
val body : InsuranceDto =  // InsuranceDto | 
try {
    val result : InsuranceDto = apiInstance.createInsurance(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling InsuranceApi#createInsurance")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling InsuranceApi#createInsurance")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**InsuranceDto**](InsuranceDto.md)|  |

### Return type

[**InsuranceDto**](InsuranceDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="deleteInsurance"></a>
# **deleteInsurance**
> DocIdentifier deleteInsurance(insuranceId)

Deletes an insurance

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = InsuranceApi()
val insuranceId : kotlin.String = insuranceId_example // kotlin.String | 
try {
    val result : DocIdentifier = apiInstance.deleteInsurance(insuranceId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling InsuranceApi#deleteInsurance")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling InsuranceApi#deleteInsurance")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **insuranceId** | **kotlin.String**|  |

### Return type

[**DocIdentifier**](DocIdentifier.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getInsurance"></a>
# **getInsurance**
> InsuranceDto getInsurance(insuranceId)

Gets an insurance

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = InsuranceApi()
val insuranceId : kotlin.String = insuranceId_example // kotlin.String | 
try {
    val result : InsuranceDto = apiInstance.getInsurance(insuranceId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling InsuranceApi#getInsurance")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling InsuranceApi#getInsurance")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **insuranceId** | **kotlin.String**|  |

### Return type

[**InsuranceDto**](InsuranceDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getInsurances"></a>
# **getInsurances**
> kotlin.Array&lt;InsuranceDto&gt; getInsurances(body)

Gets insurances by id

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = InsuranceApi()
val body : ListOfIdsDto =  // ListOfIdsDto | 
try {
    val result : kotlin.Array<InsuranceDto> = apiInstance.getInsurances(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling InsuranceApi#getInsurances")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling InsuranceApi#getInsurances")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ListOfIdsDto**](ListOfIdsDto.md)|  |

### Return type

[**kotlin.Array&lt;InsuranceDto&gt;**](InsuranceDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="listInsurancesByCode"></a>
# **listInsurancesByCode**
> kotlin.Array&lt;InsuranceDto&gt; listInsurancesByCode(insuranceCode)

Gets an insurance

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = InsuranceApi()
val insuranceCode : kotlin.String = insuranceCode_example // kotlin.String | 
try {
    val result : kotlin.Array<InsuranceDto> = apiInstance.listInsurancesByCode(insuranceCode)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling InsuranceApi#listInsurancesByCode")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling InsuranceApi#listInsurancesByCode")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **insuranceCode** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;InsuranceDto&gt;**](InsuranceDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="listInsurancesByName"></a>
# **listInsurancesByName**
> kotlin.Array&lt;InsuranceDto&gt; listInsurancesByName(insuranceName)

Gets an insurance

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = InsuranceApi()
val insuranceName : kotlin.String = insuranceName_example // kotlin.String | 
try {
    val result : kotlin.Array<InsuranceDto> = apiInstance.listInsurancesByName(insuranceName)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling InsuranceApi#listInsurancesByName")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling InsuranceApi#listInsurancesByName")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **insuranceName** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;InsuranceDto&gt;**](InsuranceDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="modifyInsurance"></a>
# **modifyInsurance**
> InsuranceDto modifyInsurance(body)

Modifies an insurance

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = InsuranceApi()
val body : InsuranceDto =  // InsuranceDto | 
try {
    val result : InsuranceDto = apiInstance.modifyInsurance(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling InsuranceApi#modifyInsurance")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling InsuranceApi#modifyInsurance")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**InsuranceDto**](InsuranceDto.md)|  |

### Return type

[**InsuranceDto**](InsuranceDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

