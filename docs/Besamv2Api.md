# Besamv2Api

All URIs are relative to *https://kraken.icure.dev*

Method | HTTP request | Description
------------- | ------------- | -------------
[**findAmpsByDmppCode**](Besamv2Api.md#findAmpsByDmppCode) | **GET** /rest/v1/be_samv2/amp/byDmppCode/{dmppCode} | Finding AMPs by dmpp code
[**findPaginatedAmpsByGroupCode**](Besamv2Api.md#findPaginatedAmpsByGroupCode) | **GET** /rest/v1/be_samv2/amp/byGroupCode/{vmpgCode} | Finding AMPs by group with pagination.
[**findPaginatedAmpsByGroupId**](Besamv2Api.md#findPaginatedAmpsByGroupId) | **GET** /rest/v1/be_samv2/amp/byGroupId/{vmpgId} | Finding AMPs by group with pagination.
[**findPaginatedAmpsByLabel**](Besamv2Api.md#findPaginatedAmpsByLabel) | **GET** /rest/v1/be_samv2/amp | Finding AMPs by label with pagination.
[**findPaginatedAmpsByVmpCode**](Besamv2Api.md#findPaginatedAmpsByVmpCode) | **GET** /rest/v1/be_samv2/amp/byVmpCode/{vmpCode} | Finding AMPs by vmp code with pagination.
[**findPaginatedAmpsByVmpId**](Besamv2Api.md#findPaginatedAmpsByVmpId) | **GET** /rest/v1/be_samv2/amp/byVmpId/{vmpId} | Finding AMPs by vmp id with pagination.
[**findPaginatedNmpsByLabel**](Besamv2Api.md#findPaginatedNmpsByLabel) | **GET** /rest/v1/be_samv2/nmp | Finding NMPs by label with pagination.
[**findPaginatedVmpGroupsByLabel**](Besamv2Api.md#findPaginatedVmpGroupsByLabel) | **GET** /rest/v1/be_samv2/vmpgroup | Finding codes by code, type and version with pagination.
[**findPaginatedVmpsByGroupCode**](Besamv2Api.md#findPaginatedVmpsByGroupCode) | **GET** /rest/v1/be_samv2/vmp/byGroupCode/{vmpgCode} | Finding VMPs by group with pagination.
[**findPaginatedVmpsByGroupId**](Besamv2Api.md#findPaginatedVmpsByGroupId) | **GET** /rest/v1/be_samv2/vmp/byGroupId/{vmpgId} | Finding VMPs by group with pagination.
[**findPaginatedVmpsByLabel**](Besamv2Api.md#findPaginatedVmpsByLabel) | **GET** /rest/v1/be_samv2/vmp | Finding VMPs by label with pagination.
[**getSamVersion**](Besamv2Api.md#getSamVersion) | **GET** /rest/v1/be_samv2/v | Get Samv2 version.
[**listPharmaceuticalForms**](Besamv2Api.md#listPharmaceuticalForms) | **GET** /rest/v1/be_samv2/pharmaform | List all pharmaceutical forms.
[**listSubstances**](Besamv2Api.md#listSubstances) | **GET** /rest/v1/be_samv2/substance | List all substances.

<a name="findAmpsByDmppCode"></a>
# **findAmpsByDmppCode**
> kotlin.Array&lt;AmpDto&gt; findAmpsByDmppCode(dmppCode)

Finding AMPs by dmpp code

Returns a list of amps matched with given input. If several types are provided, paginantion is not supported

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = Besamv2Api()
val dmppCode : kotlin.String = dmppCode_example // kotlin.String | dmppCode
try {
    val result : kotlin.Array<AmpDto> = apiInstance.findAmpsByDmppCode(dmppCode)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling Besamv2Api#findAmpsByDmppCode")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling Besamv2Api#findAmpsByDmppCode")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **dmppCode** | **kotlin.String**| dmppCode |

### Return type

[**kotlin.Array&lt;AmpDto&gt;**](AmpDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="findPaginatedAmpsByGroupCode"></a>
# **findPaginatedAmpsByGroupCode**
> PaginatedListAmpDto findPaginatedAmpsByGroupCode(vmpgCode, startKey, startDocumentId, limit)

Finding AMPs by group with pagination.

Returns a list of codes matched with given input. If several types are provided, paginantion is not supported

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = Besamv2Api()
val vmpgCode : kotlin.String = vmpgCode_example // kotlin.String | vmpgCode
val startKey : kotlin.String = startKey_example // kotlin.String | The start key for pagination: a JSON representation of an array containing all the necessary components to form the Complex Key's startKey
val startDocumentId : kotlin.String = startDocumentId_example // kotlin.String | A vmp document ID
val limit : kotlin.Int = 56 // kotlin.Int | Number of rows
try {
    val result : PaginatedListAmpDto = apiInstance.findPaginatedAmpsByGroupCode(vmpgCode, startKey, startDocumentId, limit)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling Besamv2Api#findPaginatedAmpsByGroupCode")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling Besamv2Api#findPaginatedAmpsByGroupCode")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **vmpgCode** | **kotlin.String**| vmpgCode |
 **startKey** | **kotlin.String**| The start key for pagination: a JSON representation of an array containing all the necessary components to form the Complex Key&#x27;s startKey | [optional]
 **startDocumentId** | **kotlin.String**| A vmp document ID | [optional]
 **limit** | **kotlin.Int**| Number of rows | [optional]

### Return type

[**PaginatedListAmpDto**](PaginatedListAmpDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="findPaginatedAmpsByGroupId"></a>
# **findPaginatedAmpsByGroupId**
> PaginatedListAmpDto findPaginatedAmpsByGroupId(vmpgId, startKey, startDocumentId, limit)

Finding AMPs by group with pagination.

Returns a list of codes matched with given input. If several types are provided, paginantion is not supported

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = Besamv2Api()
val vmpgId : kotlin.String = vmpgId_example // kotlin.String | vmpgCode
val startKey : kotlin.String = startKey_example // kotlin.String | The start key for pagination: a JSON representation of an array containing all the necessary components to form the Complex Key's startKey
val startDocumentId : kotlin.String = startDocumentId_example // kotlin.String | A vmp document ID
val limit : kotlin.Int = 56 // kotlin.Int | Number of rows
try {
    val result : PaginatedListAmpDto = apiInstance.findPaginatedAmpsByGroupId(vmpgId, startKey, startDocumentId, limit)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling Besamv2Api#findPaginatedAmpsByGroupId")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling Besamv2Api#findPaginatedAmpsByGroupId")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **vmpgId** | **kotlin.String**| vmpgCode |
 **startKey** | **kotlin.String**| The start key for pagination: a JSON representation of an array containing all the necessary components to form the Complex Key&#x27;s startKey | [optional]
 **startDocumentId** | **kotlin.String**| A vmp document ID | [optional]
 **limit** | **kotlin.Int**| Number of rows | [optional]

### Return type

[**PaginatedListAmpDto**](PaginatedListAmpDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="findPaginatedAmpsByLabel"></a>
# **findPaginatedAmpsByLabel**
> PaginatedListAmpDto findPaginatedAmpsByLabel(language, label, startKey, startDocumentId, limit)

Finding AMPs by label with pagination.

Returns a list of codes matched with given input. If several types are provided, paginantion is not supported

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = Besamv2Api()
val language : kotlin.String = language_example // kotlin.String | language
val label : kotlin.String = label_example // kotlin.String | label
val startKey : kotlin.String = startKey_example // kotlin.String | The start key for pagination: a JSON representation of an array containing all the necessary components to form the Complex Key's startKey
val startDocumentId : kotlin.String = startDocumentId_example // kotlin.String | An amp document ID
val limit : kotlin.Int = 56 // kotlin.Int | Number of rows
try {
    val result : PaginatedListAmpDto = apiInstance.findPaginatedAmpsByLabel(language, label, startKey, startDocumentId, limit)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling Besamv2Api#findPaginatedAmpsByLabel")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling Besamv2Api#findPaginatedAmpsByLabel")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **language** | **kotlin.String**| language | [optional]
 **label** | **kotlin.String**| label | [optional]
 **startKey** | **kotlin.String**| The start key for pagination: a JSON representation of an array containing all the necessary components to form the Complex Key&#x27;s startKey | [optional]
 **startDocumentId** | **kotlin.String**| An amp document ID | [optional]
 **limit** | **kotlin.Int**| Number of rows | [optional]

### Return type

[**PaginatedListAmpDto**](PaginatedListAmpDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="findPaginatedAmpsByVmpCode"></a>
# **findPaginatedAmpsByVmpCode**
> PaginatedListAmpDto findPaginatedAmpsByVmpCode(vmpCode, startKey, startDocumentId, limit)

Finding AMPs by vmp code with pagination.

Returns a list of codes matched with given input. If several types are provided, paginantion is not supported

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = Besamv2Api()
val vmpCode : kotlin.String = vmpCode_example // kotlin.String | vmpCode
val startKey : kotlin.String = startKey_example // kotlin.String | The start key for pagination: a JSON representation of an array containing all the necessary components to form the Complex Key's startKey
val startDocumentId : kotlin.String = startDocumentId_example // kotlin.String | A amp document ID
val limit : kotlin.Int = 56 // kotlin.Int | Number of rows
try {
    val result : PaginatedListAmpDto = apiInstance.findPaginatedAmpsByVmpCode(vmpCode, startKey, startDocumentId, limit)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling Besamv2Api#findPaginatedAmpsByVmpCode")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling Besamv2Api#findPaginatedAmpsByVmpCode")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **vmpCode** | **kotlin.String**| vmpCode |
 **startKey** | **kotlin.String**| The start key for pagination: a JSON representation of an array containing all the necessary components to form the Complex Key&#x27;s startKey | [optional]
 **startDocumentId** | **kotlin.String**| A amp document ID | [optional]
 **limit** | **kotlin.Int**| Number of rows | [optional]

### Return type

[**PaginatedListAmpDto**](PaginatedListAmpDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="findPaginatedAmpsByVmpId"></a>
# **findPaginatedAmpsByVmpId**
> PaginatedListAmpDto findPaginatedAmpsByVmpId(vmpId, startKey, startDocumentId, limit)

Finding AMPs by vmp id with pagination.

Returns a list of codes matched with given input. If several types are provided, paginantion is not supported

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = Besamv2Api()
val vmpId : kotlin.String = vmpId_example // kotlin.String | vmpgCode
val startKey : kotlin.String = startKey_example // kotlin.String | The start key for pagination: a JSON representation of an array containing all the necessary components to form the Complex Key's startKey
val startDocumentId : kotlin.String = startDocumentId_example // kotlin.String | A amp document ID
val limit : kotlin.Int = 56 // kotlin.Int | Number of rows
try {
    val result : PaginatedListAmpDto = apiInstance.findPaginatedAmpsByVmpId(vmpId, startKey, startDocumentId, limit)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling Besamv2Api#findPaginatedAmpsByVmpId")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling Besamv2Api#findPaginatedAmpsByVmpId")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **vmpId** | **kotlin.String**| vmpgCode |
 **startKey** | **kotlin.String**| The start key for pagination: a JSON representation of an array containing all the necessary components to form the Complex Key&#x27;s startKey | [optional]
 **startDocumentId** | **kotlin.String**| A amp document ID | [optional]
 **limit** | **kotlin.Int**| Number of rows | [optional]

### Return type

[**PaginatedListAmpDto**](PaginatedListAmpDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="findPaginatedNmpsByLabel"></a>
# **findPaginatedNmpsByLabel**
> PaginatedListNmpDto findPaginatedNmpsByLabel(language, label, startKey, startDocumentId, limit)

Finding NMPs by label with pagination.

Returns a paginated list of NMPs by matching label. Matches occur per word

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = Besamv2Api()
val language : kotlin.String = language_example // kotlin.String | language
val label : kotlin.String = label_example // kotlin.String | label
val startKey : kotlin.String = startKey_example // kotlin.String | The start key for pagination: a JSON representation of an array containing all the necessary components to form the Complex Key's startKey
val startDocumentId : kotlin.String = startDocumentId_example // kotlin.String | A vmp document ID
val limit : kotlin.Int = 56 // kotlin.Int | Number of rows
try {
    val result : PaginatedListNmpDto = apiInstance.findPaginatedNmpsByLabel(language, label, startKey, startDocumentId, limit)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling Besamv2Api#findPaginatedNmpsByLabel")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling Besamv2Api#findPaginatedNmpsByLabel")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **language** | **kotlin.String**| language | [optional]
 **label** | **kotlin.String**| label | [optional]
 **startKey** | **kotlin.String**| The start key for pagination: a JSON representation of an array containing all the necessary components to form the Complex Key&#x27;s startKey | [optional]
 **startDocumentId** | **kotlin.String**| A vmp document ID | [optional]
 **limit** | **kotlin.Int**| Number of rows | [optional]

### Return type

[**PaginatedListNmpDto**](PaginatedListNmpDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="findPaginatedVmpGroupsByLabel"></a>
# **findPaginatedVmpGroupsByLabel**
> PaginatedListVmpGroupDto findPaginatedVmpGroupsByLabel(language, label, startKey, startDocumentId, limit)

Finding codes by code, type and version with pagination.

Returns a list of codes matched with given input. If several types are provided, paginantion is not supported

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = Besamv2Api()
val language : kotlin.String = language_example // kotlin.String | language
val label : kotlin.String = label_example // kotlin.String | label
val startKey : kotlin.String = startKey_example // kotlin.String | The start key for pagination: a JSON representation of an array containing all the necessary components to form the Complex Key's startKey
val startDocumentId : kotlin.String = startDocumentId_example // kotlin.String | A vmpgroup document ID
val limit : kotlin.Int = 56 // kotlin.Int | Number of rows
try {
    val result : PaginatedListVmpGroupDto = apiInstance.findPaginatedVmpGroupsByLabel(language, label, startKey, startDocumentId, limit)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling Besamv2Api#findPaginatedVmpGroupsByLabel")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling Besamv2Api#findPaginatedVmpGroupsByLabel")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **language** | **kotlin.String**| language | [optional]
 **label** | **kotlin.String**| label | [optional]
 **startKey** | **kotlin.String**| The start key for pagination: a JSON representation of an array containing all the necessary components to form the Complex Key&#x27;s startKey | [optional]
 **startDocumentId** | **kotlin.String**| A vmpgroup document ID | [optional]
 **limit** | **kotlin.Int**| Number of rows | [optional]

### Return type

[**PaginatedListVmpGroupDto**](PaginatedListVmpGroupDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="findPaginatedVmpsByGroupCode"></a>
# **findPaginatedVmpsByGroupCode**
> PaginatedListVmpDto findPaginatedVmpsByGroupCode(vmpgCode, startKey, startDocumentId, limit)

Finding VMPs by group with pagination.

Returns a list of codes matched with given input. If several types are provided, paginantion is not supported

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = Besamv2Api()
val vmpgCode : kotlin.String = vmpgCode_example // kotlin.String | vmpgCode
val startKey : kotlin.String = startKey_example // kotlin.String | The start key for pagination: a JSON representation of an array containing all the necessary components to form the Complex Key's startKey
val startDocumentId : kotlin.String = startDocumentId_example // kotlin.String | A vmp document ID
val limit : kotlin.Int = 56 // kotlin.Int | Number of rows
try {
    val result : PaginatedListVmpDto = apiInstance.findPaginatedVmpsByGroupCode(vmpgCode, startKey, startDocumentId, limit)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling Besamv2Api#findPaginatedVmpsByGroupCode")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling Besamv2Api#findPaginatedVmpsByGroupCode")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **vmpgCode** | **kotlin.String**| vmpgCode |
 **startKey** | **kotlin.String**| The start key for pagination: a JSON representation of an array containing all the necessary components to form the Complex Key&#x27;s startKey | [optional]
 **startDocumentId** | **kotlin.String**| A vmp document ID | [optional]
 **limit** | **kotlin.Int**| Number of rows | [optional]

### Return type

[**PaginatedListVmpDto**](PaginatedListVmpDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="findPaginatedVmpsByGroupId"></a>
# **findPaginatedVmpsByGroupId**
> PaginatedListVmpDto findPaginatedVmpsByGroupId(vmpgId, startKey, startDocumentId, limit)

Finding VMPs by group with pagination.

Returns a list of codes matched with given input. If several types are provided, paginantion is not supported

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = Besamv2Api()
val vmpgId : kotlin.String = vmpgId_example // kotlin.String | vmpgId
val startKey : kotlin.String = startKey_example // kotlin.String | The start key for pagination: a JSON representation of an array containing all the necessary components to form the Complex Key's startKey
val startDocumentId : kotlin.String = startDocumentId_example // kotlin.String | A vmp document ID
val limit : kotlin.Int = 56 // kotlin.Int | Number of rows
try {
    val result : PaginatedListVmpDto = apiInstance.findPaginatedVmpsByGroupId(vmpgId, startKey, startDocumentId, limit)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling Besamv2Api#findPaginatedVmpsByGroupId")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling Besamv2Api#findPaginatedVmpsByGroupId")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **vmpgId** | **kotlin.String**| vmpgId |
 **startKey** | **kotlin.String**| The start key for pagination: a JSON representation of an array containing all the necessary components to form the Complex Key&#x27;s startKey | [optional]
 **startDocumentId** | **kotlin.String**| A vmp document ID | [optional]
 **limit** | **kotlin.Int**| Number of rows | [optional]

### Return type

[**PaginatedListVmpDto**](PaginatedListVmpDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="findPaginatedVmpsByLabel"></a>
# **findPaginatedVmpsByLabel**
> PaginatedListVmpDto findPaginatedVmpsByLabel(language, label, startKey, startDocumentId, limit)

Finding VMPs by label with pagination.

Returns a paginated list of VMPs by matching label. Matches occur per word

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = Besamv2Api()
val language : kotlin.String = language_example // kotlin.String | language
val label : kotlin.String = label_example // kotlin.String | label
val startKey : kotlin.String = startKey_example // kotlin.String | The start key for pagination: a JSON representation of an array containing all the necessary components to form the Complex Key's startKey
val startDocumentId : kotlin.String = startDocumentId_example // kotlin.String | A vmp document ID
val limit : kotlin.Int = 56 // kotlin.Int | Number of rows
try {
    val result : PaginatedListVmpDto = apiInstance.findPaginatedVmpsByLabel(language, label, startKey, startDocumentId, limit)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling Besamv2Api#findPaginatedVmpsByLabel")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling Besamv2Api#findPaginatedVmpsByLabel")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **language** | **kotlin.String**| language | [optional]
 **label** | **kotlin.String**| label | [optional]
 **startKey** | **kotlin.String**| The start key for pagination: a JSON representation of an array containing all the necessary components to form the Complex Key&#x27;s startKey | [optional]
 **startDocumentId** | **kotlin.String**| A vmp document ID | [optional]
 **limit** | **kotlin.Int**| Number of rows | [optional]

### Return type

[**PaginatedListVmpDto**](PaginatedListVmpDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getSamVersion"></a>
# **getSamVersion**
> SamVersionDto getSamVersion()

Get Samv2 version.

Returns a list of codes matched with given input. If several types are provided, paginantion is not supported

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = Besamv2Api()
try {
    val result : SamVersionDto = apiInstance.getSamVersion()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling Besamv2Api#getSamVersion")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling Besamv2Api#getSamVersion")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**SamVersionDto**](SamVersionDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="listPharmaceuticalForms"></a>
# **listPharmaceuticalForms**
> kotlin.Array&lt;PharmaceuticalFormDto&gt; listPharmaceuticalForms()

List all pharmaceutical forms.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = Besamv2Api()
try {
    val result : kotlin.Array<PharmaceuticalFormDto> = apiInstance.listPharmaceuticalForms()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling Besamv2Api#listPharmaceuticalForms")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling Besamv2Api#listPharmaceuticalForms")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.Array&lt;PharmaceuticalFormDto&gt;**](PharmaceuticalFormDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="listSubstances"></a>
# **listSubstances**
> kotlin.Array&lt;SubstanceDto&gt; listSubstances()

List all substances.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = Besamv2Api()
try {
    val result : kotlin.Array<SubstanceDto> = apiInstance.listSubstances()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling Besamv2Api#listSubstances")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling Besamv2Api#listSubstances")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.Array&lt;SubstanceDto&gt;**](SubstanceDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

