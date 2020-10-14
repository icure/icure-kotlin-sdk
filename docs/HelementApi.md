# HelementApi

All URIs are relative to *https://kraken.icure.dev*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createHealthElement**](HelementApi.md#createHealthElement) | **POST** /rest/v1/helement | Create a health element with the current user
[**deleteHealthElements**](HelementApi.md#deleteHealthElements) | **DELETE** /rest/v1/helement/{healthElementIds} | Delete health elements.
[**filterHealthElementsBy**](HelementApi.md#filterHealthElementsBy) | **POST** /rest/v1/helement/filter | Filter health elements for the current user (HcParty)
[**findHealthElementsByHCPartyPatientForeignKeys**](HelementApi.md#findHealthElementsByHCPartyPatientForeignKeys) | **GET** /rest/v1/helement/byHcPartySecretForeignKeys | List health elements found By Healthcare Party and secret foreign keyelementIds.
[**findHealthElementsDelegationsStubsByHCPartyPatientForeignKeys**](HelementApi.md#findHealthElementsDelegationsStubsByHCPartyPatientForeignKeys) | **GET** /rest/v1/helement/byHcPartySecretForeignKeys/delegations | List helement stubs found By Healthcare Party and secret foreign keys.
[**getHealthElement**](HelementApi.md#getHealthElement) | **GET** /rest/v1/helement/{healthElementId} | Get a health element
[**modifyHealthElement**](HelementApi.md#modifyHealthElement) | **PUT** /rest/v1/helement | Modify a health element
[**modifyHealthElements**](HelementApi.md#modifyHealthElements) | **PUT** /rest/v1/helement/batch | Modify a batch of health elements
[**newHealthElementDelegations**](HelementApi.md#newHealthElementDelegations) | **POST** /rest/v1/helement/{healthElementId}/delegate | Delegates a health element to a healthcare party
[**setHealthElementsDelegations**](HelementApi.md#setHealthElementsDelegations) | **POST** /rest/v1/helement/delegations | Update delegations in healthElements.

<a name="createHealthElement"></a>
# **createHealthElement**
> HealthElementDto createHealthElement(body)

Create a health element with the current user

Returns an instance of created health element.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = HelementApi()
val body : HealthElementDto =  // HealthElementDto | 
try {
    val result : HealthElementDto = apiInstance.createHealthElement(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling HelementApi#createHealthElement")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HelementApi#createHealthElement")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**HealthElementDto**](HealthElementDto.md)|  |

### Return type

[**HealthElementDto**](HealthElementDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="deleteHealthElements"></a>
# **deleteHealthElements**
> kotlin.Array&lt;DocIdentifier&gt; deleteHealthElements(healthElementIds)

Delete health elements.

Response is a set containing the ID&#x27;s of deleted health elements.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = HelementApi()
val healthElementIds : kotlin.String = healthElementIds_example // kotlin.String | 
try {
    val result : kotlin.Array<DocIdentifier> = apiInstance.deleteHealthElements(healthElementIds)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling HelementApi#deleteHealthElements")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HelementApi#deleteHealthElements")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **healthElementIds** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;DocIdentifier&gt;**](DocIdentifier.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="filterHealthElementsBy"></a>
# **filterHealthElementsBy**
> kotlin.Array&lt;HealthElementDto&gt; filterHealthElementsBy(body)

Filter health elements for the current user (HcParty)

Returns a list of health elements along with next start keys and Document ID. If the nextStartKey is Null it means that this is the last page.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = HelementApi()
val body : FilterChainHealthElement =  // FilterChainHealthElement | 
try {
    val result : kotlin.Array<HealthElementDto> = apiInstance.filterHealthElementsBy(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling HelementApi#filterHealthElementsBy")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HelementApi#filterHealthElementsBy")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**FilterChainHealthElement**](FilterChainHealthElement.md)|  |

### Return type

[**kotlin.Array&lt;HealthElementDto&gt;**](HealthElementDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="findHealthElementsByHCPartyPatientForeignKeys"></a>
# **findHealthElementsByHCPartyPatientForeignKeys**
> kotlin.Array&lt;HealthElementDto&gt; findHealthElementsByHCPartyPatientForeignKeys(hcPartyId, secretFKeys)

List health elements found By Healthcare Party and secret foreign keyelementIds.

Keys hast to delimited by coma

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = HelementApi()
val hcPartyId : kotlin.String = hcPartyId_example // kotlin.String | 
val secretFKeys : kotlin.String = secretFKeys_example // kotlin.String | 
try {
    val result : kotlin.Array<HealthElementDto> = apiInstance.findHealthElementsByHCPartyPatientForeignKeys(hcPartyId, secretFKeys)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling HelementApi#findHealthElementsByHCPartyPatientForeignKeys")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HelementApi#findHealthElementsByHCPartyPatientForeignKeys")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hcPartyId** | **kotlin.String**|  |
 **secretFKeys** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;HealthElementDto&gt;**](HealthElementDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="findHealthElementsDelegationsStubsByHCPartyPatientForeignKeys"></a>
# **findHealthElementsDelegationsStubsByHCPartyPatientForeignKeys**
> kotlin.Array&lt;IcureStubDto&gt; findHealthElementsDelegationsStubsByHCPartyPatientForeignKeys(hcPartyId, secretFKeys)

List helement stubs found By Healthcare Party and secret foreign keys.

Keys must be delimited by coma

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = HelementApi()
val hcPartyId : kotlin.String = hcPartyId_example // kotlin.String | 
val secretFKeys : kotlin.String = secretFKeys_example // kotlin.String | 
try {
    val result : kotlin.Array<IcureStubDto> = apiInstance.findHealthElementsDelegationsStubsByHCPartyPatientForeignKeys(hcPartyId, secretFKeys)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling HelementApi#findHealthElementsDelegationsStubsByHCPartyPatientForeignKeys")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HelementApi#findHealthElementsDelegationsStubsByHCPartyPatientForeignKeys")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hcPartyId** | **kotlin.String**|  |
 **secretFKeys** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;IcureStubDto&gt;**](IcureStubDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getHealthElement"></a>
# **getHealthElement**
> HealthElementDto getHealthElement(healthElementId)

Get a health element

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = HelementApi()
val healthElementId : kotlin.String = healthElementId_example // kotlin.String | 
try {
    val result : HealthElementDto = apiInstance.getHealthElement(healthElementId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling HelementApi#getHealthElement")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HelementApi#getHealthElement")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **healthElementId** | **kotlin.String**|  |

### Return type

[**HealthElementDto**](HealthElementDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="modifyHealthElement"></a>
# **modifyHealthElement**
> HealthElementDto modifyHealthElement(body)

Modify a health element

Returns the modified health element.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = HelementApi()
val body : HealthElementDto =  // HealthElementDto | 
try {
    val result : HealthElementDto = apiInstance.modifyHealthElement(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling HelementApi#modifyHealthElement")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HelementApi#modifyHealthElement")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**HealthElementDto**](HealthElementDto.md)|  |

### Return type

[**HealthElementDto**](HealthElementDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="modifyHealthElements"></a>
# **modifyHealthElements**
> kotlin.Array&lt;HealthElementDto&gt; modifyHealthElements(body)

Modify a batch of health elements

Returns the modified health elements.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = HelementApi()
val body : kotlin.Array<HealthElementDto> =  // kotlin.Array<HealthElementDto> | 
try {
    val result : kotlin.Array<HealthElementDto> = apiInstance.modifyHealthElements(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling HelementApi#modifyHealthElements")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HelementApi#modifyHealthElements")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**kotlin.Array&lt;HealthElementDto&gt;**](HealthElementDto.md)|  |

### Return type

[**kotlin.Array&lt;HealthElementDto&gt;**](HealthElementDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="newHealthElementDelegations"></a>
# **newHealthElementDelegations**
> HealthElementDto newHealthElementDelegations(body, healthElementId)

Delegates a health element to a healthcare party

It delegates a health element to a healthcare party (By current healthcare party). Returns the element with new delegations.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = HelementApi()
val body : kotlin.Array<DelegationDto> =  // kotlin.Array<DelegationDto> | 
val healthElementId : kotlin.String = healthElementId_example // kotlin.String | 
try {
    val result : HealthElementDto = apiInstance.newHealthElementDelegations(body, healthElementId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling HelementApi#newHealthElementDelegations")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HelementApi#newHealthElementDelegations")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**kotlin.Array&lt;DelegationDto&gt;**](DelegationDto.md)|  |
 **healthElementId** | **kotlin.String**|  |

### Return type

[**HealthElementDto**](HealthElementDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="setHealthElementsDelegations"></a>
# **setHealthElementsDelegations**
> kotlin.Array&lt;HealthElementDto&gt; setHealthElementsDelegations(body)

Update delegations in healthElements.

Keys must be delimited by coma

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = HelementApi()
val body : kotlin.Array<IcureStubDto> =  // kotlin.Array<IcureStubDto> | 
try {
    val result : kotlin.Array<HealthElementDto> = apiInstance.setHealthElementsDelegations(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling HelementApi#setHealthElementsDelegations")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HelementApi#setHealthElementsDelegations")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**kotlin.Array&lt;IcureStubDto&gt;**](IcureStubDto.md)|  |

### Return type

[**kotlin.Array&lt;HealthElementDto&gt;**](HealthElementDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

