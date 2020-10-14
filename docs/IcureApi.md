# IcureApi

All URIs are relative to *https://kraken.icure.dev*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getIndexingInfo**](IcureApi.md#getIndexingInfo) | **GET** /rest/v1/icure/i | Get index info
[**getProcessInfo**](IcureApi.md#getProcessInfo) | **GET** /rest/v1/icure/p | Get process info
[**getPropertyTypes**](IcureApi.md#getPropertyTypes) | **GET** /rest/v1/icure/propertytypes/{type} | Get property types
[**getReplicationInfo**](IcureApi.md#getReplicationInfo) | **GET** /rest/v1/icure/r | Get index info
[**getUsers**](IcureApi.md#getUsers) | **GET** /rest/v1/icure/u | Get users stubs
[**getVersion**](IcureApi.md#getVersion) | **GET** /rest/v1/icure/v | Get version
[**isPatientReady**](IcureApi.md#isPatientReady) | **GET** /rest/v1/icure/pok | Check if a patient exists
[**isReady**](IcureApi.md#isReady) | **GET** /rest/v1/icure/ok | Check if a user exists
[**resolveContactsConflicts**](IcureApi.md#resolveContactsConflicts) | **POST** /rest/v1/icure/conflicts/contact | Resolve contacts conflicts
[**resolveDocumentsConflicts**](IcureApi.md#resolveDocumentsConflicts) | **POST** /rest/v1/icure/conflicts/document | resolve documents conflicts
[**resolveFormsConflicts**](IcureApi.md#resolveFormsConflicts) | **POST** /rest/v1/icure/conflicts/form | resolve forms conflicts
[**resolveHealthElementsConflicts**](IcureApi.md#resolveHealthElementsConflicts) | **POST** /rest/v1/icure/conflicts/healthelement | resolve health elements conflicts
[**resolveInvoicesConflicts**](IcureApi.md#resolveInvoicesConflicts) | **POST** /rest/v1/icure/conflicts/invoice | resolve invoices conflicts
[**resolveMessagesConflicts**](IcureApi.md#resolveMessagesConflicts) | **POST** /rest/v1/icure/conflicts/message | resolve messages conflicts
[**resolvePatientsConflicts**](IcureApi.md#resolvePatientsConflicts) | **POST** /rest/v1/icure/conflicts/patient | Resolve patients conflicts
[**updateDesignDoc**](IcureApi.md#updateDesignDoc) | **POST** /rest/v1/icure/dd/{entityName} | Force update design doc

<a name="getIndexingInfo"></a>
# **getIndexingInfo**
> IndexingInfoDto getIndexingInfo()

Get index info

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = IcureApi()
try {
    val result : IndexingInfoDto = apiInstance.getIndexingInfo()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling IcureApi#getIndexingInfo")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling IcureApi#getIndexingInfo")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**IndexingInfoDto**](IndexingInfoDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getProcessInfo"></a>
# **getProcessInfo**
> kotlin.String getProcessInfo()

Get process info

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = IcureApi()
try {
    val result : kotlin.String = apiInstance.getProcessInfo()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling IcureApi#getProcessInfo")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling IcureApi#getProcessInfo")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**kotlin.String**

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain

<a name="getPropertyTypes"></a>
# **getPropertyTypes**
> kotlin.Array&lt;kotlin.String&gt; getPropertyTypes(type)

Get property types

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = IcureApi()
val type : kotlin.String = type_example // kotlin.String | 
try {
    val result : kotlin.Array<kotlin.String> = apiInstance.getPropertyTypes(type)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling IcureApi#getPropertyTypes")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling IcureApi#getPropertyTypes")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **type** | **kotlin.String**|  |

### Return type

**kotlin.Array&lt;kotlin.String&gt;**

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getReplicationInfo"></a>
# **getReplicationInfo**
> ReplicationInfoDto getReplicationInfo()

Get index info

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = IcureApi()
try {
    val result : ReplicationInfoDto = apiInstance.getReplicationInfo()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling IcureApi#getReplicationInfo")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling IcureApi#getReplicationInfo")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ReplicationInfoDto**](ReplicationInfoDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getUsers"></a>
# **getUsers**
> kotlin.Array&lt;UserDto&gt; getUsers()

Get users stubs

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = IcureApi()
try {
    val result : kotlin.Array<UserDto> = apiInstance.getUsers()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling IcureApi#getUsers")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling IcureApi#getUsers")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.Array&lt;UserDto&gt;**](UserDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getVersion"></a>
# **getVersion**
> kotlin.String getVersion()

Get version

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = IcureApi()
try {
    val result : kotlin.String = apiInstance.getVersion()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling IcureApi#getVersion")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling IcureApi#getVersion")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**kotlin.String**

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain

<a name="isPatientReady"></a>
# **isPatientReady**
> kotlin.String isPatientReady()

Check if a patient exists

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = IcureApi()
try {
    val result : kotlin.String = apiInstance.isPatientReady()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling IcureApi#isPatientReady")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling IcureApi#isPatientReady")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**kotlin.String**

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain

<a name="isReady"></a>
# **isReady**
> kotlin.String isReady()

Check if a user exists

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = IcureApi()
try {
    val result : kotlin.String = apiInstance.isReady()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling IcureApi#isReady")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling IcureApi#isReady")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**kotlin.String**

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain

<a name="resolveContactsConflicts"></a>
# **resolveContactsConflicts**
> Unit resolveContactsConflicts()

Resolve contacts conflicts

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = IcureApi()
try {
    val result : Unit = apiInstance.resolveContactsConflicts()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling IcureApi#resolveContactsConflicts")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling IcureApi#resolveContactsConflicts")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Unit**](Unit.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="resolveDocumentsConflicts"></a>
# **resolveDocumentsConflicts**
> Unit resolveDocumentsConflicts(ids)

resolve documents conflicts

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = IcureApi()
val ids : kotlin.String = ids_example // kotlin.String | 
try {
    val result : Unit = apiInstance.resolveDocumentsConflicts(ids)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling IcureApi#resolveDocumentsConflicts")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling IcureApi#resolveDocumentsConflicts")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ids** | **kotlin.String**|  | [optional]

### Return type

[**Unit**](Unit.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="resolveFormsConflicts"></a>
# **resolveFormsConflicts**
> Unit resolveFormsConflicts()

resolve forms conflicts

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = IcureApi()
try {
    val result : Unit = apiInstance.resolveFormsConflicts()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling IcureApi#resolveFormsConflicts")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling IcureApi#resolveFormsConflicts")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Unit**](Unit.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="resolveHealthElementsConflicts"></a>
# **resolveHealthElementsConflicts**
> Unit resolveHealthElementsConflicts()

resolve health elements conflicts

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = IcureApi()
try {
    val result : Unit = apiInstance.resolveHealthElementsConflicts()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling IcureApi#resolveHealthElementsConflicts")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling IcureApi#resolveHealthElementsConflicts")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Unit**](Unit.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="resolveInvoicesConflicts"></a>
# **resolveInvoicesConflicts**
> Unit resolveInvoicesConflicts()

resolve invoices conflicts

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = IcureApi()
try {
    val result : Unit = apiInstance.resolveInvoicesConflicts()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling IcureApi#resolveInvoicesConflicts")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling IcureApi#resolveInvoicesConflicts")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Unit**](Unit.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="resolveMessagesConflicts"></a>
# **resolveMessagesConflicts**
> Unit resolveMessagesConflicts()

resolve messages conflicts

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = IcureApi()
try {
    val result : Unit = apiInstance.resolveMessagesConflicts()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling IcureApi#resolveMessagesConflicts")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling IcureApi#resolveMessagesConflicts")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Unit**](Unit.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="resolvePatientsConflicts"></a>
# **resolvePatientsConflicts**
> Unit resolvePatientsConflicts()

Resolve patients conflicts

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = IcureApi()
try {
    val result : Unit = apiInstance.resolvePatientsConflicts()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling IcureApi#resolvePatientsConflicts")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling IcureApi#resolvePatientsConflicts")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Unit**](Unit.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="updateDesignDoc"></a>
# **updateDesignDoc**
> kotlin.Boolean updateDesignDoc(entityName, warmup)

Force update design doc

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = IcureApi()
val entityName : kotlin.String = entityName_example // kotlin.String | 
val warmup : kotlin.Boolean = true // kotlin.Boolean | 
try {
    val result : kotlin.Boolean = apiInstance.updateDesignDoc(entityName, warmup)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling IcureApi#updateDesignDoc")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling IcureApi#updateDesignDoc")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityName** | **kotlin.String**|  |
 **warmup** | **kotlin.Boolean**|  | [optional]

### Return type

**kotlin.Boolean**

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

