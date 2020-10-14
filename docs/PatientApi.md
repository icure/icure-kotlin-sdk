# PatientApi

All URIs are relative to *https://kraken.icure.dev*

Method | HTTP request | Description
------------- | ------------- | -------------
[**bulkUpdatePatients**](PatientApi.md#bulkUpdatePatients) | **POST** /rest/v1/patient/bulk | Modify a patient
[**countOfPatients**](PatientApi.md#countOfPatients) | **GET** /rest/v1/patient/hcParty/{hcPartyId}/count | Get count of patients for a specific HcParty or for the current HcParty 
[**createPatient**](PatientApi.md#createPatient) | **POST** /rest/v1/patient | Create a patient
[**deletePatient**](PatientApi.md#deletePatient) | **DELETE** /rest/v1/patient/{patientIds} | Delete patients.
[**filterPatientsBy**](PatientApi.md#filterPatientsBy) | **POST** /rest/v1/patient/filter | Filter patients for the current user (HcParty) 
[**findByAccessLogUserAfterDate**](PatientApi.md#findByAccessLogUserAfterDate) | **GET** /rest/v1/patient/byAccess/{userId} | Get Paginated List of Patients sorted by Access logs descending
[**findByExternalId**](PatientApi.md#findByExternalId) | **GET** /rest/v1/patient/byExternalId/{externalId} | Get Paginated List of Patients sorted by Access logs descending
[**findByNameBirthSsinAuto**](PatientApi.md#findByNameBirthSsinAuto) | **GET** /rest/v1/patient/byNameBirthSsinAuto | Find patients for the current user (HcParty) 
[**fuzzySearch**](PatientApi.md#fuzzySearch) | **GET** /rest/v1/patient/fuzzy | Filter patients for the current user (HcParty) 
[**getPatient**](PatientApi.md#getPatient) | **GET** /rest/v1/patient/{patientId} | Get patient
[**getPatientHcPartyKeysForDelegate**](PatientApi.md#getPatientHcPartyKeysForDelegate) | **GET** /rest/v1/patient/{patientId}/keys | Get the patient (identified by patientId) hcparty keys. Those keys are AES keys (encrypted) used to share information between HCPs and a patient.
[**getPatients**](PatientApi.md#getPatients) | **POST** /rest/v1/patient/byIds | Get patients by id
[**listDeletedPatients**](PatientApi.md#listDeletedPatients) | **GET** /rest/v1/patient/deleted/by_date | Find deleted patients
[**listDeletedPatientsByName**](PatientApi.md#listDeletedPatientsByName) | **GET** /rest/v1/patient/deleted/by_name | Find deleted patients
[**listOfMergesAfter**](PatientApi.md#listOfMergesAfter) | **GET** /rest/v1/patient/merges/{date} | List patients that have been merged towards another patient 
[**listOfPatientsModifiedAfter**](PatientApi.md#listOfPatientsModifiedAfter) | **GET** /rest/v1/patient/modifiedAfter/{date} | List patients that have been modified after the provided date
[**listPatients**](PatientApi.md#listPatients) | **GET** /rest/v1/patient | List patients for a specific HcParty
[**listPatientsByHcParty**](PatientApi.md#listPatientsByHcParty) | **GET** /rest/v1/patient/hcParty/{hcPartyId} | List patients for a specific HcParty or for the current HcParty 
[**listPatientsIds**](PatientApi.md#listPatientsIds) | **GET** /rest/v1/patient/idsPages | List patients by pages for a specific HcParty
[**listPatientsOfHcParty**](PatientApi.md#listPatientsOfHcParty) | **GET** /rest/v1/patient/ofHcParty/{hcPartyId} | List patients of a specific HcParty or of the current HcParty 
[**matchPatientsBy**](PatientApi.md#matchPatientsBy) | **POST** /rest/v1/patient/match | Get ids of patients matching the provided filter for the current user (HcParty) 
[**mergeInto**](PatientApi.md#mergeInto) | **PUT** /rest/v1/patient/mergeInto/{toId}/from/{fromIds} | Merge a series of patients into another patient
[**modifyPatient**](PatientApi.md#modifyPatient) | **PUT** /rest/v1/patient | Modify a patient
[**modifyPatientReferral**](PatientApi.md#modifyPatientReferral) | **PUT** /rest/v1/patient/{patientId}/referral/{referralId} | Set a patient referral doctor
[**newPatientDelegations**](PatientApi.md#newPatientDelegations) | **POST** /rest/v1/patient/{patientId}/delegate | Delegates a patients to a healthcare party
[**undeletePatient**](PatientApi.md#undeletePatient) | **PUT** /rest/v1/patient/undelete/{patientIds} | undelete previously deleted patients

<a name="bulkUpdatePatients"></a>
# **bulkUpdatePatients**
> kotlin.Array&lt;IdWithRevDto&gt; bulkUpdatePatients(body)

Modify a patient

Returns the id and _rev of created patients

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = PatientApi()
val body : kotlin.Array<PatientDto> =  // kotlin.Array<PatientDto> | 
try {
    val result : kotlin.Array<IdWithRevDto> = apiInstance.bulkUpdatePatients(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PatientApi#bulkUpdatePatients")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PatientApi#bulkUpdatePatients")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**kotlin.Array&lt;PatientDto&gt;**](PatientDto.md)|  |

### Return type

[**kotlin.Array&lt;IdWithRevDto&gt;**](IdWithRevDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="countOfPatients"></a>
# **countOfPatients**
> ContentDto countOfPatients(hcPartyId)

Get count of patients for a specific HcParty or for the current HcParty 

Returns the count of patients

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = PatientApi()
val hcPartyId : kotlin.String = hcPartyId_example // kotlin.String | Healthcare party id
try {
    val result : ContentDto = apiInstance.countOfPatients(hcPartyId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PatientApi#countOfPatients")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PatientApi#countOfPatients")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hcPartyId** | **kotlin.String**| Healthcare party id |

### Return type

[**ContentDto**](ContentDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="createPatient"></a>
# **createPatient**
> PatientDto createPatient(body)

Create a patient

Name, last name, date of birth, and gender are required. After creation of the patient and obtaining the ID, you need to create an initial delegation.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = PatientApi()
val body : PatientDto =  // PatientDto | 
try {
    val result : PatientDto = apiInstance.createPatient(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PatientApi#createPatient")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PatientApi#createPatient")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**PatientDto**](PatientDto.md)|  |

### Return type

[**PatientDto**](PatientDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="deletePatient"></a>
# **deletePatient**
> kotlin.Array&lt;DocIdentifier&gt; deletePatient(patientIds)

Delete patients.

Response is an array containing the ID of deleted patient..

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = PatientApi()
val patientIds : kotlin.String = patientIds_example // kotlin.String | 
try {
    val result : kotlin.Array<DocIdentifier> = apiInstance.deletePatient(patientIds)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PatientApi#deletePatient")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PatientApi#deletePatient")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **patientIds** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;DocIdentifier&gt;**](DocIdentifier.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="filterPatientsBy"></a>
# **filterPatientsBy**
> PaginatedListPatientDto filterPatientsBy(body, startKey, startDocumentId, limit, skip, sort, desc)

Filter patients for the current user (HcParty) 

Returns a list of patients along with next start keys and Document ID. If the nextStartKey is Null it means that this is the last page.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = PatientApi()
val body : FilterChainPatient =  // FilterChainPatient | 
val startKey : kotlin.String = startKey_example // kotlin.String | The start key for pagination, depends on the filters used
val startDocumentId : kotlin.String = startDocumentId_example // kotlin.String | A patient document ID
val limit : kotlin.Int = 56 // kotlin.Int | Number of rows
val skip : kotlin.Int = 56 // kotlin.Int | Skip rows
val sort : kotlin.String = sort_example // kotlin.String | Sort key
val desc : kotlin.Boolean = true // kotlin.Boolean | Descending
try {
    val result : PaginatedListPatientDto = apiInstance.filterPatientsBy(body, startKey, startDocumentId, limit, skip, sort, desc)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PatientApi#filterPatientsBy")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PatientApi#filterPatientsBy")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**FilterChainPatient**](FilterChainPatient.md)|  |
 **startKey** | **kotlin.String**| The start key for pagination, depends on the filters used | [optional]
 **startDocumentId** | **kotlin.String**| A patient document ID | [optional]
 **limit** | **kotlin.Int**| Number of rows | [optional]
 **skip** | **kotlin.Int**| Skip rows | [optional]
 **sort** | **kotlin.String**| Sort key | [optional]
 **desc** | **kotlin.Boolean**| Descending | [optional]

### Return type

[**PaginatedListPatientDto**](PaginatedListPatientDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="findByAccessLogUserAfterDate"></a>
# **findByAccessLogUserAfterDate**
> PaginatedListPatientDto findByAccessLogUserAfterDate(userId, accessType, startDate, startKey, startDocumentId, limit)

Get Paginated List of Patients sorted by Access logs descending

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = PatientApi()
val userId : kotlin.String = userId_example // kotlin.String | A User ID
val accessType : kotlin.String = accessType_example // kotlin.String | The type of access (COMPUTER or USER)
val startDate : kotlin.Long = 789 // kotlin.Long | The start search epoch
val startKey : kotlin.String = startKey_example // kotlin.String | The start key for pagination
val startDocumentId : kotlin.String = startDocumentId_example // kotlin.String | A patient document ID
val limit : kotlin.Int = 56 // kotlin.Int | Number of rows
try {
    val result : PaginatedListPatientDto = apiInstance.findByAccessLogUserAfterDate(userId, accessType, startDate, startKey, startDocumentId, limit)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PatientApi#findByAccessLogUserAfterDate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PatientApi#findByAccessLogUserAfterDate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **kotlin.String**| A User ID |
 **accessType** | **kotlin.String**| The type of access (COMPUTER or USER) | [optional]
 **startDate** | **kotlin.Long**| The start search epoch | [optional]
 **startKey** | **kotlin.String**| The start key for pagination | [optional]
 **startDocumentId** | **kotlin.String**| A patient document ID | [optional]
 **limit** | **kotlin.Int**| Number of rows | [optional] [default to 1000]

### Return type

[**PaginatedListPatientDto**](PaginatedListPatientDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="findByExternalId"></a>
# **findByExternalId**
> PatientDto findByExternalId(externalId)

Get Paginated List of Patients sorted by Access logs descending

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = PatientApi()
val externalId : kotlin.String = externalId_example // kotlin.String | A external ID
try {
    val result : PatientDto = apiInstance.findByExternalId(externalId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PatientApi#findByExternalId")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PatientApi#findByExternalId")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **externalId** | **kotlin.String**| A external ID |

### Return type

[**PatientDto**](PatientDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="findByNameBirthSsinAuto"></a>
# **findByNameBirthSsinAuto**
> PaginatedListPatientDto findByNameBirthSsinAuto(healthcarePartyId, filterValue, startKey, startDocumentId, limit, sortDirection)

Find patients for the current user (HcParty) 

Returns a list of patients along with next start keys and Document ID. If the nextStartKey is Null it means that this is the last page.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = PatientApi()
val healthcarePartyId : kotlin.String = healthcarePartyId_example // kotlin.String | HealthcareParty Id, if unset will user user's hcpId
val filterValue : kotlin.String = filterValue_example // kotlin.String | Optional value for filtering results
val startKey : kotlin.String = startKey_example // kotlin.String | The start key for pagination: a JSON representation of an array containing all the necessary components to form the Complex Key's startKey
val startDocumentId : kotlin.String = startDocumentId_example // kotlin.String | A patient document ID
val limit : kotlin.Int = 56 // kotlin.Int | Number of rows
val sortDirection : kotlin.String = sortDirection_example // kotlin.String | Optional value for providing a sorting direction ('asc', 'desc'). Set to 'asc' by default.
try {
    val result : PaginatedListPatientDto = apiInstance.findByNameBirthSsinAuto(healthcarePartyId, filterValue, startKey, startDocumentId, limit, sortDirection)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PatientApi#findByNameBirthSsinAuto")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PatientApi#findByNameBirthSsinAuto")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **healthcarePartyId** | **kotlin.String**| HealthcareParty Id, if unset will user user&#x27;s hcpId | [optional]
 **filterValue** | **kotlin.String**| Optional value for filtering results | [optional]
 **startKey** | **kotlin.String**| The start key for pagination: a JSON representation of an array containing all the necessary components to form the Complex Key&#x27;s startKey | [optional]
 **startDocumentId** | **kotlin.String**| A patient document ID | [optional]
 **limit** | **kotlin.Int**| Number of rows | [optional]
 **sortDirection** | **kotlin.String**| Optional value for providing a sorting direction (&#x27;asc&#x27;, &#x27;desc&#x27;). Set to &#x27;asc&#x27; by default. | [optional] [default to asc]

### Return type

[**PaginatedListPatientDto**](PaginatedListPatientDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="fuzzySearch"></a>
# **fuzzySearch**
> kotlin.Array&lt;PatientDto&gt; fuzzySearch(firstName, lastName, dateOfBirth)

Filter patients for the current user (HcParty) 

Returns a list of patients

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = PatientApi()
val firstName : kotlin.String = firstName_example // kotlin.String | The first name
val lastName : kotlin.String = lastName_example // kotlin.String | The last name
val dateOfBirth : kotlin.Int = 56 // kotlin.Int | The date of birth
try {
    val result : kotlin.Array<PatientDto> = apiInstance.fuzzySearch(firstName, lastName, dateOfBirth)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PatientApi#fuzzySearch")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PatientApi#fuzzySearch")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **firstName** | **kotlin.String**| The first name | [optional]
 **lastName** | **kotlin.String**| The last name | [optional]
 **dateOfBirth** | **kotlin.Int**| The date of birth | [optional]

### Return type

[**kotlin.Array&lt;PatientDto&gt;**](PatientDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getPatient"></a>
# **getPatient**
> PatientDto getPatient(patientId)

Get patient

It gets patient administrative data.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = PatientApi()
val patientId : kotlin.String = patientId_example // kotlin.String | 
try {
    val result : PatientDto = apiInstance.getPatient(patientId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PatientApi#getPatient")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PatientApi#getPatient")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **patientId** | **kotlin.String**|  |

### Return type

[**PatientDto**](PatientDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getPatientHcPartyKeysForDelegate"></a>
# **getPatientHcPartyKeysForDelegate**
> kotlin.String getPatientHcPartyKeysForDelegate(patientId)

Get the patient (identified by patientId) hcparty keys. Those keys are AES keys (encrypted) used to share information between HCPs and a patient.

This endpoint is used to recover all keys that have already been created and that can be used to share information with this patient. It returns a map with the following structure: ID of the owner of the encrypted AES key -&gt; encrypted AES key. The returned encrypted AES keys will have to be decrypted using the patient&#x27;s private key.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = PatientApi()
val patientId : kotlin.String = patientId_example // kotlin.String | The patient Id for which information is shared
try {
    val result : kotlin.String = apiInstance.getPatientHcPartyKeysForDelegate(patientId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PatientApi#getPatientHcPartyKeysForDelegate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PatientApi#getPatientHcPartyKeysForDelegate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **patientId** | **kotlin.String**| The patient Id for which information is shared |

### Return type

**kotlin.String**

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getPatients"></a>
# **getPatients**
> kotlin.Array&lt;PatientDto&gt; getPatients(body)

Get patients by id

It gets patient administrative data.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = PatientApi()
val body : ListOfIdsDto =  // ListOfIdsDto | 
try {
    val result : kotlin.Array<PatientDto> = apiInstance.getPatients(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PatientApi#getPatients")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PatientApi#getPatients")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ListOfIdsDto**](ListOfIdsDto.md)|  |

### Return type

[**kotlin.Array&lt;PatientDto&gt;**](PatientDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="listDeletedPatients"></a>
# **listDeletedPatients**
> PaginatedListPatientDto listDeletedPatients(startDate, endDate, desc, startDocumentId, limit)

Find deleted patients

Returns a list of deleted patients, within the specified time period, if any.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = PatientApi()
val startDate : kotlin.Long = 789 // kotlin.Long | Filter deletions after this date (unix epoch), included
val endDate : kotlin.Long = 789 // kotlin.Long | Filter deletions before this date (unix epoch), included
val desc : kotlin.Boolean = true // kotlin.Boolean | Descending
val startDocumentId : kotlin.String = startDocumentId_example // kotlin.String | A patient document ID
val limit : kotlin.Int = 56 // kotlin.Int | Number of rows
try {
    val result : PaginatedListPatientDto = apiInstance.listDeletedPatients(startDate, endDate, desc, startDocumentId, limit)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PatientApi#listDeletedPatients")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PatientApi#listDeletedPatients")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **startDate** | **kotlin.Long**| Filter deletions after this date (unix epoch), included | [optional]
 **endDate** | **kotlin.Long**| Filter deletions before this date (unix epoch), included | [optional]
 **desc** | **kotlin.Boolean**| Descending | [optional]
 **startDocumentId** | **kotlin.String**| A patient document ID | [optional]
 **limit** | **kotlin.Int**| Number of rows | [optional]

### Return type

[**PaginatedListPatientDto**](PaginatedListPatientDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="listDeletedPatientsByName"></a>
# **listDeletedPatientsByName**
> kotlin.Array&lt;PatientDto&gt; listDeletedPatientsByName(firstName, lastName)

Find deleted patients

Returns a list of deleted patients, by name and/or firstname prefix, if any.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = PatientApi()
val firstName : kotlin.String = firstName_example // kotlin.String | First name prefix
val lastName : kotlin.String = lastName_example // kotlin.String | Last name prefix
try {
    val result : kotlin.Array<PatientDto> = apiInstance.listDeletedPatientsByName(firstName, lastName)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PatientApi#listDeletedPatientsByName")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PatientApi#listDeletedPatientsByName")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **firstName** | **kotlin.String**| First name prefix | [optional]
 **lastName** | **kotlin.String**| Last name prefix | [optional]

### Return type

[**kotlin.Array&lt;PatientDto&gt;**](PatientDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="listOfMergesAfter"></a>
# **listOfMergesAfter**
> kotlin.Array&lt;PatientDto&gt; listOfMergesAfter(date)

List patients that have been merged towards another patient 

Returns a list of patients that have been merged after the provided date

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = PatientApi()
val date : kotlin.Long = 789 // kotlin.Long | 
try {
    val result : kotlin.Array<PatientDto> = apiInstance.listOfMergesAfter(date)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PatientApi#listOfMergesAfter")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PatientApi#listOfMergesAfter")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **date** | **kotlin.Long**|  |

### Return type

[**kotlin.Array&lt;PatientDto&gt;**](PatientDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="listOfPatientsModifiedAfter"></a>
# **listOfPatientsModifiedAfter**
> PaginatedListPatientDto listOfPatientsModifiedAfter(date, startKey, startDocumentId, limit)

List patients that have been modified after the provided date

Returns a list of patients that have been modified after the provided date

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = PatientApi()
val date : kotlin.Long = 789 // kotlin.Long | 
val startKey : kotlin.Long = 789 // kotlin.Long | The start key for pagination the date of the first element of the new page
val startDocumentId : kotlin.String = startDocumentId_example // kotlin.String | A patient document ID
val limit : kotlin.Int = 56 // kotlin.Int | Number of rows
try {
    val result : PaginatedListPatientDto = apiInstance.listOfPatientsModifiedAfter(date, startKey, startDocumentId, limit)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PatientApi#listOfPatientsModifiedAfter")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PatientApi#listOfPatientsModifiedAfter")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **date** | **kotlin.Long**|  |
 **startKey** | **kotlin.Long**| The start key for pagination the date of the first element of the new page | [optional]
 **startDocumentId** | **kotlin.String**| A patient document ID | [optional]
 **limit** | **kotlin.Int**| Number of rows | [optional]

### Return type

[**PaginatedListPatientDto**](PaginatedListPatientDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="listPatients"></a>
# **listPatients**
> PaginatedListPatientDto listPatients(hcPartyId, sortField, startKey, startDocumentId, limit, sortDirection)

List patients for a specific HcParty

Returns a list of patients along with next start keys and Document ID. If the nextStartKey is Null it means that this is the last page.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = PatientApi()
val hcPartyId : kotlin.String = hcPartyId_example // kotlin.String | Healthcare party id
val sortField : kotlin.String = sortField_example // kotlin.String | Optional value for sorting results by a given field ('name', 'ssin', 'dateOfBirth'). Specifying this deactivates filtering
val startKey : kotlin.String = startKey_example // kotlin.String | The start key for pagination: a JSON representation of an array containing all the necessary components to form the Complex Key's startKey
val startDocumentId : kotlin.String = startDocumentId_example // kotlin.String | A patient document ID
val limit : kotlin.Int = 56 // kotlin.Int | Number of rows
val sortDirection : kotlin.String = sortDirection_example // kotlin.String | Optional value for providing a sorting direction ('asc', 'desc'). Set to 'asc' by default.
try {
    val result : PaginatedListPatientDto = apiInstance.listPatients(hcPartyId, sortField, startKey, startDocumentId, limit, sortDirection)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PatientApi#listPatients")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PatientApi#listPatients")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hcPartyId** | **kotlin.String**| Healthcare party id | [optional]
 **sortField** | **kotlin.String**| Optional value for sorting results by a given field (&#x27;name&#x27;, &#x27;ssin&#x27;, &#x27;dateOfBirth&#x27;). Specifying this deactivates filtering | [optional]
 **startKey** | **kotlin.String**| The start key for pagination: a JSON representation of an array containing all the necessary components to form the Complex Key&#x27;s startKey | [optional]
 **startDocumentId** | **kotlin.String**| A patient document ID | [optional]
 **limit** | **kotlin.Int**| Number of rows | [optional]
 **sortDirection** | **kotlin.String**| Optional value for providing a sorting direction (&#x27;asc&#x27;, &#x27;desc&#x27;). Set to &#x27;asc&#x27; by default. | [optional] [default to asc]

### Return type

[**PaginatedListPatientDto**](PaginatedListPatientDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="listPatientsByHcParty"></a>
# **listPatientsByHcParty**
> PaginatedListPatientDto listPatientsByHcParty(hcPartyId, sortField, startKey, startDocumentId, limit, sortDirection)

List patients for a specific HcParty or for the current HcParty 

Returns a list of patients along with next start keys and Document ID. If the nextStartKey is Null it means that this is the last page.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = PatientApi()
val hcPartyId : kotlin.String = hcPartyId_example // kotlin.String | 
val sortField : kotlin.String = sortField_example // kotlin.String | Optional value for sorting results by a given field ('name', 'ssin', 'dateOfBirth'). Specifying this deactivates filtering
val startKey : kotlin.String = startKey_example // kotlin.String | The start key for pagination: a JSON representation of an array containing all the necessary components to form the Complex Key's startKey
val startDocumentId : kotlin.String = startDocumentId_example // kotlin.String | A patient document ID
val limit : kotlin.Int = 56 // kotlin.Int | Number of rows
val sortDirection : kotlin.String = sortDirection_example // kotlin.String | Optional value for providing a sorting direction ('asc', 'desc'). Set to 'asc' by default.
try {
    val result : PaginatedListPatientDto = apiInstance.listPatientsByHcParty(hcPartyId, sortField, startKey, startDocumentId, limit, sortDirection)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PatientApi#listPatientsByHcParty")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PatientApi#listPatientsByHcParty")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hcPartyId** | **kotlin.String**|  |
 **sortField** | **kotlin.String**| Optional value for sorting results by a given field (&#x27;name&#x27;, &#x27;ssin&#x27;, &#x27;dateOfBirth&#x27;). Specifying this deactivates filtering | [optional]
 **startKey** | **kotlin.String**| The start key for pagination: a JSON representation of an array containing all the necessary components to form the Complex Key&#x27;s startKey | [optional]
 **startDocumentId** | **kotlin.String**| A patient document ID | [optional]
 **limit** | **kotlin.Int**| Number of rows | [optional]
 **sortDirection** | **kotlin.String**| Optional value for providing a sorting direction (&#x27;asc&#x27;, &#x27;desc&#x27;). Set to &#x27;asc&#x27; by default. | [optional]

### Return type

[**PaginatedListPatientDto**](PaginatedListPatientDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="listPatientsIds"></a>
# **listPatientsIds**
> PaginatedListString listPatientsIds(hcPartyId, startKey, startDocumentId, limit)

List patients by pages for a specific HcParty

Returns a list of patients along with next start keys and Document ID. If the nextStartKey is Null it means that this is the last page.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = PatientApi()
val hcPartyId : kotlin.String = hcPartyId_example // kotlin.String | Healthcare party id
val startKey : kotlin.String = startKey_example // kotlin.String | The page first id
val startDocumentId : kotlin.String = startDocumentId_example // kotlin.String | A patient document ID
val limit : kotlin.Int = 56 // kotlin.Int | Page size
try {
    val result : PaginatedListString = apiInstance.listPatientsIds(hcPartyId, startKey, startDocumentId, limit)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PatientApi#listPatientsIds")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PatientApi#listPatientsIds")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hcPartyId** | **kotlin.String**| Healthcare party id |
 **startKey** | **kotlin.String**| The page first id | [optional]
 **startDocumentId** | **kotlin.String**| A patient document ID | [optional]
 **limit** | **kotlin.Int**| Page size | [optional]

### Return type

[**PaginatedListString**](PaginatedListString.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="listPatientsOfHcParty"></a>
# **listPatientsOfHcParty**
> PaginatedListPatientDto listPatientsOfHcParty(hcPartyId, sortField, startKey, startDocumentId, limit, sortDirection)

List patients of a specific HcParty or of the current HcParty 

Returns a list of patients along with next start keys and Document ID. If the nextStartKey is Null it means that this is the last page.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = PatientApi()
val hcPartyId : kotlin.String = hcPartyId_example // kotlin.String | 
val sortField : kotlin.String = sortField_example // kotlin.String | Optional value for sorting results by a given field ('name', 'ssin', 'dateOfBirth'). Specifying this deactivates filtering
val startKey : kotlin.String = startKey_example // kotlin.String | The start key for pagination: a JSON representation of an array containing all the necessary components to form the Complex Key's startKey
val startDocumentId : kotlin.String = startDocumentId_example // kotlin.String | A patient document ID
val limit : kotlin.Int = 56 // kotlin.Int | Number of rows
val sortDirection : kotlin.String = sortDirection_example // kotlin.String | Optional value for providing a sorting direction ('asc', 'desc'). Set to 'asc' by default.
try {
    val result : PaginatedListPatientDto = apiInstance.listPatientsOfHcParty(hcPartyId, sortField, startKey, startDocumentId, limit, sortDirection)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PatientApi#listPatientsOfHcParty")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PatientApi#listPatientsOfHcParty")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hcPartyId** | **kotlin.String**|  |
 **sortField** | **kotlin.String**| Optional value for sorting results by a given field (&#x27;name&#x27;, &#x27;ssin&#x27;, &#x27;dateOfBirth&#x27;). Specifying this deactivates filtering | [optional]
 **startKey** | **kotlin.String**| The start key for pagination: a JSON representation of an array containing all the necessary components to form the Complex Key&#x27;s startKey | [optional]
 **startDocumentId** | **kotlin.String**| A patient document ID | [optional]
 **limit** | **kotlin.Int**| Number of rows | [optional]
 **sortDirection** | **kotlin.String**| Optional value for providing a sorting direction (&#x27;asc&#x27;, &#x27;desc&#x27;). Set to &#x27;asc&#x27; by default. | [optional] [default to asc]

### Return type

[**PaginatedListPatientDto**](PaginatedListPatientDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="matchPatientsBy"></a>
# **matchPatientsBy**
> kotlin.Array&lt;kotlin.String&gt; matchPatientsBy(body)

Get ids of patients matching the provided filter for the current user (HcParty) 

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = PatientApi()
val body : AbstractFilterDtoPatient =  // AbstractFilterDtoPatient | 
try {
    val result : kotlin.Array<kotlin.String> = apiInstance.matchPatientsBy(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PatientApi#matchPatientsBy")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PatientApi#matchPatientsBy")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**AbstractFilterDtoPatient**](AbstractFilterDtoPatient.md)|  |

### Return type

**kotlin.Array&lt;kotlin.String&gt;**

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="mergeInto"></a>
# **mergeInto**
> PatientDto mergeInto(toId, fromIds)

Merge a series of patients into another patient

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = PatientApi()
val toId : kotlin.String = toId_example // kotlin.String | 
val fromIds : kotlin.String = fromIds_example // kotlin.String | 
try {
    val result : PatientDto = apiInstance.mergeInto(toId, fromIds)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PatientApi#mergeInto")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PatientApi#mergeInto")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **toId** | **kotlin.String**|  |
 **fromIds** | **kotlin.String**|  |

### Return type

[**PatientDto**](PatientDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="modifyPatient"></a>
# **modifyPatient**
> PatientDto modifyPatient(body)

Modify a patient

No particular return value. It&#x27;s just a message.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = PatientApi()
val body : PatientDto =  // PatientDto | 
try {
    val result : PatientDto = apiInstance.modifyPatient(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PatientApi#modifyPatient")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PatientApi#modifyPatient")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**PatientDto**](PatientDto.md)|  |

### Return type

[**PatientDto**](PatientDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="modifyPatientReferral"></a>
# **modifyPatientReferral**
> PatientDto modifyPatientReferral(patientId, referralId, start, end)

Set a patient referral doctor

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = PatientApi()
val patientId : kotlin.String = patientId_example // kotlin.String | 
val referralId : kotlin.String = referralId_example // kotlin.String | The referal id. Accepts 'none' for referral removal.
val start : kotlin.Long = 789 // kotlin.Long | Optional value for start of referral
val end : kotlin.Long = 789 // kotlin.Long | Optional value for end of referral
try {
    val result : PatientDto = apiInstance.modifyPatientReferral(patientId, referralId, start, end)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PatientApi#modifyPatientReferral")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PatientApi#modifyPatientReferral")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **patientId** | **kotlin.String**|  |
 **referralId** | **kotlin.String**| The referal id. Accepts &#x27;none&#x27; for referral removal. |
 **start** | **kotlin.Long**| Optional value for start of referral | [optional]
 **end** | **kotlin.Long**| Optional value for end of referral | [optional]

### Return type

[**PatientDto**](PatientDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="newPatientDelegations"></a>
# **newPatientDelegations**
> PatientDto newPatientDelegations(body, patientId)

Delegates a patients to a healthcare party

It delegates a patient to a healthcare party (By current healthcare party). A modified patient with new delegation gets returned.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = PatientApi()
val body : kotlin.Array<DelegationDto> =  // kotlin.Array<DelegationDto> | 
val patientId : kotlin.String = patientId_example // kotlin.String | 
try {
    val result : PatientDto = apiInstance.newPatientDelegations(body, patientId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PatientApi#newPatientDelegations")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PatientApi#newPatientDelegations")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**kotlin.Array&lt;DelegationDto&gt;**](DelegationDto.md)|  |
 **patientId** | **kotlin.String**|  |

### Return type

[**PatientDto**](PatientDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="undeletePatient"></a>
# **undeletePatient**
> kotlin.Array&lt;DocIdentifier&gt; undeletePatient(patientIds)

undelete previously deleted patients

Response is an array containing the ID of undeleted patient..

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = PatientApi()
val patientIds : kotlin.String = patientIds_example // kotlin.String | 
try {
    val result : kotlin.Array<DocIdentifier> = apiInstance.undeletePatient(patientIds)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PatientApi#undeletePatient")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PatientApi#undeletePatient")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **patientIds** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;DocIdentifier&gt;**](DocIdentifier.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

