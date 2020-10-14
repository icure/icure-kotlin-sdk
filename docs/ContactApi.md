# ContactApi

All URIs are relative to *https://kraken.icure.dev*

Method | HTTP request | Description
------------- | ------------- | -------------
[**closeForHCPartyPatientForeignKeys**](ContactApi.md#closeForHCPartyPatientForeignKeys) | **PUT** /rest/v1/contact/byHcPartySecretForeignKeys/close | Close contacts for Healthcare Party and secret foreign keys.
[**createContact**](ContactApi.md#createContact) | **POST** /rest/v1/contact | Create a contact with the current user
[**deleteContacts**](ContactApi.md#deleteContacts) | **DELETE** /rest/v1/contact/{contactIds} | Delete contacts.
[**filterContactsBy**](ContactApi.md#filterContactsBy) | **POST** /rest/v1/contact/filter | List contacts for the current user (HcParty) or the given hcparty in the filter 
[**filterServicesBy**](ContactApi.md#filterServicesBy) | **POST** /rest/v1/contact/service/filter | List services for the current user (HcParty) or the given hcparty in the filter 
[**findByHCPartyFormId**](ContactApi.md#findByHCPartyFormId) | **GET** /rest/v1/contact/byHcPartyFormId | List contacts found By Healthcare Party and form Id.
[**findByHCPartyFormIds**](ContactApi.md#findByHCPartyFormIds) | **POST** /rest/v1/contact/byHcPartyFormIds | List contacts found By Healthcare Party and form Id.
[**findByHCPartyPatientSecretFKeys**](ContactApi.md#findByHCPartyPatientSecretFKeys) | **GET** /rest/v1/contact/byHcPartySecretForeignKeys | List contacts found By Healthcare Party and secret foreign keys.
[**findContactsByHCPartyPatientForeignKeys**](ContactApi.md#findContactsByHCPartyPatientForeignKeys) | **POST** /rest/v1/contact/byHcPartyPatientForeignKeys | List contacts found By Healthcare Party and Patient foreign keys.
[**findContactsDelegationsStubsByHCPartyPatientForeignKeys**](ContactApi.md#findContactsDelegationsStubsByHCPartyPatientForeignKeys) | **GET** /rest/v1/contact/byHcPartySecretForeignKeys/delegations | List contacts found By Healthcare Party and secret foreign keys.
[**getContact**](ContactApi.md#getContact) | **GET** /rest/v1/contact/{contactId} | Get a contact
[**getContacts**](ContactApi.md#getContacts) | **POST** /rest/v1/contact/byIds | Get contacts
[**getEmptyContent**](ContactApi.md#getEmptyContent) | **GET** /rest/v1/contact/service/content/empty | Get an empty content
[**getServiceCodesOccurences**](ContactApi.md#getServiceCodesOccurences) | **GET** /rest/v1/contact/service/codes/{codeType}/{minOccurences} | Get the list of all used codes frequencies in services
[**listContactsByOpeningDate**](ContactApi.md#listContactsByOpeningDate) | **GET** /rest/v1/contact/byOpeningDate | List contacts bu opening date parties with(out) pagination
[**matchContactsBy**](ContactApi.md#matchContactsBy) | **POST** /rest/v1/contact/match | Get ids of contacts matching the provided filter for the current user (HcParty) 
[**modifyContact**](ContactApi.md#modifyContact) | **PUT** /rest/v1/contact | Modify a contact
[**modifyContacts**](ContactApi.md#modifyContacts) | **PUT** /rest/v1/contact/batch | Modify a batch of contacts
[**newContactDelegations**](ContactApi.md#newContactDelegations) | **POST** /rest/v1/contact/{contactId}/delegate | Delegates a contact to a healthcare party
[**setContactsDelegations**](ContactApi.md#setContactsDelegations) | **POST** /rest/v1/contact/delegations | Update delegations in healthElements.

<a name="closeForHCPartyPatientForeignKeys"></a>
# **closeForHCPartyPatientForeignKeys**
> kotlin.Array&lt;ContactDto&gt; closeForHCPartyPatientForeignKeys(hcPartyId, secretFKeys)

Close contacts for Healthcare Party and secret foreign keys.

Keys must be delimited by coma

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ContactApi()
val hcPartyId : kotlin.String = hcPartyId_example // kotlin.String | 
val secretFKeys : kotlin.String = secretFKeys_example // kotlin.String | 
try {
    val result : kotlin.Array<ContactDto> = apiInstance.closeForHCPartyPatientForeignKeys(hcPartyId, secretFKeys)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#closeForHCPartyPatientForeignKeys")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#closeForHCPartyPatientForeignKeys")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hcPartyId** | **kotlin.String**|  |
 **secretFKeys** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;ContactDto&gt;**](ContactDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="createContact"></a>
# **createContact**
> ContactDto createContact(body)

Create a contact with the current user

Returns an instance of created contact.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ContactApi()
val body : ContactDto =  // ContactDto | 
try {
    val result : ContactDto = apiInstance.createContact(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#createContact")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#createContact")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ContactDto**](ContactDto.md)|  |

### Return type

[**ContactDto**](ContactDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="deleteContacts"></a>
# **deleteContacts**
> kotlin.Array&lt;DocIdentifier&gt; deleteContacts(contactIds)

Delete contacts.

Response is a set containing the ID&#x27;s of deleted contacts.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ContactApi()
val contactIds : kotlin.String = contactIds_example // kotlin.String | 
try {
    val result : kotlin.Array<DocIdentifier> = apiInstance.deleteContacts(contactIds)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#deleteContacts")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#deleteContacts")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contactIds** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;DocIdentifier&gt;**](DocIdentifier.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="filterContactsBy"></a>
# **filterContactsBy**
> PaginatedListContactDto filterContactsBy(body, startDocumentId, limit)

List contacts for the current user (HcParty) or the given hcparty in the filter 

Returns a list of contacts along with next start keys and Document ID. If the nextStartKey is Null it means that this is the last page.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ContactApi()
val body : FilterChainContact =  // FilterChainContact | 
val startDocumentId : kotlin.String = startDocumentId_example // kotlin.String | A Contact document ID
val limit : kotlin.Int = 56 // kotlin.Int | Number of rows
try {
    val result : PaginatedListContactDto = apiInstance.filterContactsBy(body, startDocumentId, limit)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#filterContactsBy")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#filterContactsBy")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**FilterChainContact**](FilterChainContact.md)|  |
 **startDocumentId** | **kotlin.String**| A Contact document ID | [optional]
 **limit** | **kotlin.Int**| Number of rows | [optional]

### Return type

[**PaginatedListContactDto**](PaginatedListContactDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="filterServicesBy"></a>
# **filterServicesBy**
> PaginatedListServiceDto filterServicesBy(body, startDocumentId, limit)

List services for the current user (HcParty) or the given hcparty in the filter 

Returns a list of contacts along with next start keys and Document ID. If the nextStartKey is Null it means that this is the last page.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ContactApi()
val body : FilterChainService =  // FilterChainService | 
val startDocumentId : kotlin.String = startDocumentId_example // kotlin.String | A Contact document ID
val limit : kotlin.Int = 56 // kotlin.Int | Number of rows
try {
    val result : PaginatedListServiceDto = apiInstance.filterServicesBy(body, startDocumentId, limit)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#filterServicesBy")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#filterServicesBy")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**FilterChainService**](FilterChainService.md)|  |
 **startDocumentId** | **kotlin.String**| A Contact document ID | [optional]
 **limit** | **kotlin.Int**| Number of rows | [optional]

### Return type

[**PaginatedListServiceDto**](PaginatedListServiceDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="findByHCPartyFormId"></a>
# **findByHCPartyFormId**
> kotlin.Array&lt;ContactDto&gt; findByHCPartyFormId(hcPartyId, formId)

List contacts found By Healthcare Party and form Id.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ContactApi()
val hcPartyId : kotlin.String = hcPartyId_example // kotlin.String | 
val formId : kotlin.String = formId_example // kotlin.String | 
try {
    val result : kotlin.Array<ContactDto> = apiInstance.findByHCPartyFormId(hcPartyId, formId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#findByHCPartyFormId")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#findByHCPartyFormId")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hcPartyId** | **kotlin.String**|  |
 **formId** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;ContactDto&gt;**](ContactDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="findByHCPartyFormIds"></a>
# **findByHCPartyFormIds**
> kotlin.Array&lt;ContactDto&gt; findByHCPartyFormIds(body, hcPartyId)

List contacts found By Healthcare Party and form Id.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ContactApi()
val body : ListOfIdsDto =  // ListOfIdsDto | 
val hcPartyId : kotlin.String = hcPartyId_example // kotlin.String | 
try {
    val result : kotlin.Array<ContactDto> = apiInstance.findByHCPartyFormIds(body, hcPartyId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#findByHCPartyFormIds")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#findByHCPartyFormIds")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ListOfIdsDto**](ListOfIdsDto.md)|  |
 **hcPartyId** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;ContactDto&gt;**](ContactDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="findByHCPartyPatientSecretFKeys"></a>
# **findByHCPartyPatientSecretFKeys**
> kotlin.Array&lt;ContactDto&gt; findByHCPartyPatientSecretFKeys(hcPartyId, secretFKeys, planOfActionsIds, skipClosedContacts)

List contacts found By Healthcare Party and secret foreign keys.

Keys must be delimited by coma

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ContactApi()
val hcPartyId : kotlin.String = hcPartyId_example // kotlin.String | 
val secretFKeys : kotlin.String = secretFKeys_example // kotlin.String | 
val planOfActionsIds : kotlin.String = planOfActionsIds_example // kotlin.String | 
val skipClosedContacts : kotlin.Boolean = true // kotlin.Boolean | 
try {
    val result : kotlin.Array<ContactDto> = apiInstance.findByHCPartyPatientSecretFKeys(hcPartyId, secretFKeys, planOfActionsIds, skipClosedContacts)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#findByHCPartyPatientSecretFKeys")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#findByHCPartyPatientSecretFKeys")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hcPartyId** | **kotlin.String**|  |
 **secretFKeys** | **kotlin.String**|  |
 **planOfActionsIds** | **kotlin.String**|  | [optional]
 **skipClosedContacts** | **kotlin.Boolean**|  | [optional]

### Return type

[**kotlin.Array&lt;ContactDto&gt;**](ContactDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="findContactsByHCPartyPatientForeignKeys"></a>
# **findContactsByHCPartyPatientForeignKeys**
> kotlin.Array&lt;ContactDto&gt; findContactsByHCPartyPatientForeignKeys(body, hcPartyId)

List contacts found By Healthcare Party and Patient foreign keys.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ContactApi()
val body : ListOfIdsDto =  // ListOfIdsDto | 
val hcPartyId : kotlin.String = hcPartyId_example // kotlin.String | 
try {
    val result : kotlin.Array<ContactDto> = apiInstance.findContactsByHCPartyPatientForeignKeys(body, hcPartyId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#findContactsByHCPartyPatientForeignKeys")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#findContactsByHCPartyPatientForeignKeys")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ListOfIdsDto**](ListOfIdsDto.md)|  |
 **hcPartyId** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;ContactDto&gt;**](ContactDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="findContactsDelegationsStubsByHCPartyPatientForeignKeys"></a>
# **findContactsDelegationsStubsByHCPartyPatientForeignKeys**
> kotlin.Array&lt;IcureStubDto&gt; findContactsDelegationsStubsByHCPartyPatientForeignKeys(hcPartyId, secretFKeys)

List contacts found By Healthcare Party and secret foreign keys.

Keys must be delimited by coma

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ContactApi()
val hcPartyId : kotlin.String = hcPartyId_example // kotlin.String | 
val secretFKeys : kotlin.String = secretFKeys_example // kotlin.String | 
try {
    val result : kotlin.Array<IcureStubDto> = apiInstance.findContactsDelegationsStubsByHCPartyPatientForeignKeys(hcPartyId, secretFKeys)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#findContactsDelegationsStubsByHCPartyPatientForeignKeys")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#findContactsDelegationsStubsByHCPartyPatientForeignKeys")
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

<a name="getContact"></a>
# **getContact**
> ContactDto getContact(contactId)

Get a contact

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ContactApi()
val contactId : kotlin.String = contactId_example // kotlin.String | 
try {
    val result : ContactDto = apiInstance.getContact(contactId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#getContact")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#getContact")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contactId** | **kotlin.String**|  |

### Return type

[**ContactDto**](ContactDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getContacts"></a>
# **getContacts**
> kotlin.Array&lt;ContactDto&gt; getContacts(body)

Get contacts

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ContactApi()
val body : ListOfIdsDto =  // ListOfIdsDto | 
try {
    val result : kotlin.Array<ContactDto> = apiInstance.getContacts(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#getContacts")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#getContacts")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ListOfIdsDto**](ListOfIdsDto.md)|  |

### Return type

[**kotlin.Array&lt;ContactDto&gt;**](ContactDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="getEmptyContent"></a>
# **getEmptyContent**
> ContentDto getEmptyContent()

Get an empty content

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ContactApi()
try {
    val result : ContentDto = apiInstance.getEmptyContent()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#getEmptyContent")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#getEmptyContent")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ContentDto**](ContentDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getServiceCodesOccurences"></a>
# **getServiceCodesOccurences**
> kotlin.Array&lt;LabelledOccurenceDto&gt; getServiceCodesOccurences(codeType, minOccurences)

Get the list of all used codes frequencies in services

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ContactApi()
val codeType : kotlin.String = codeType_example // kotlin.String | 
val minOccurences : kotlin.Long = 789 // kotlin.Long | 
try {
    val result : kotlin.Array<LabelledOccurenceDto> = apiInstance.getServiceCodesOccurences(codeType, minOccurences)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#getServiceCodesOccurences")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#getServiceCodesOccurences")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **codeType** | **kotlin.String**|  |
 **minOccurences** | **kotlin.Long**|  |

### Return type

[**kotlin.Array&lt;LabelledOccurenceDto&gt;**](LabelledOccurenceDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="listContactsByOpeningDate"></a>
# **listContactsByOpeningDate**
> PaginatedListContactDto listContactsByOpeningDate(startKey, endKey, hcpartyid, startDocumentId, limit)

List contacts bu opening date parties with(out) pagination

Returns a list of contacts.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ContactApi()
val startKey : kotlin.Long = 789 // kotlin.Long | The contact openingDate
val endKey : kotlin.Long = 789 // kotlin.Long | The contact max openingDate
val hcpartyid : kotlin.String = hcpartyid_example // kotlin.String | hcpartyid
val startDocumentId : kotlin.String = startDocumentId_example // kotlin.String | A contact party document ID
val limit : kotlin.Int = 56 // kotlin.Int | Number of rows
try {
    val result : PaginatedListContactDto = apiInstance.listContactsByOpeningDate(startKey, endKey, hcpartyid, startDocumentId, limit)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#listContactsByOpeningDate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#listContactsByOpeningDate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **startKey** | **kotlin.Long**| The contact openingDate |
 **endKey** | **kotlin.Long**| The contact max openingDate |
 **hcpartyid** | **kotlin.String**| hcpartyid |
 **startDocumentId** | **kotlin.String**| A contact party document ID | [optional]
 **limit** | **kotlin.Int**| Number of rows | [optional]

### Return type

[**PaginatedListContactDto**](PaginatedListContactDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="matchContactsBy"></a>
# **matchContactsBy**
> kotlin.Array&lt;kotlin.String&gt; matchContactsBy(body)

Get ids of contacts matching the provided filter for the current user (HcParty) 

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ContactApi()
val body : AbstractFilterDtoContact =  // AbstractFilterDtoContact | 
try {
    val result : kotlin.Array<kotlin.String> = apiInstance.matchContactsBy(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#matchContactsBy")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#matchContactsBy")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**AbstractFilterDtoContact**](AbstractFilterDtoContact.md)|  |

### Return type

**kotlin.Array&lt;kotlin.String&gt;**

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="modifyContact"></a>
# **modifyContact**
> ContactDto modifyContact(body)

Modify a contact

Returns the modified contact.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ContactApi()
val body : ContactDto =  // ContactDto | 
try {
    val result : ContactDto = apiInstance.modifyContact(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#modifyContact")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#modifyContact")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ContactDto**](ContactDto.md)|  |

### Return type

[**ContactDto**](ContactDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="modifyContacts"></a>
# **modifyContacts**
> kotlin.Array&lt;ContactDto&gt; modifyContacts(body)

Modify a batch of contacts

Returns the modified contacts.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ContactApi()
val body : kotlin.Array<ContactDto> =  // kotlin.Array<ContactDto> | 
try {
    val result : kotlin.Array<ContactDto> = apiInstance.modifyContacts(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#modifyContacts")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#modifyContacts")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**kotlin.Array&lt;ContactDto&gt;**](ContactDto.md)|  |

### Return type

[**kotlin.Array&lt;ContactDto&gt;**](ContactDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="newContactDelegations"></a>
# **newContactDelegations**
> ContactDto newContactDelegations(body, contactId)

Delegates a contact to a healthcare party

It delegates a contact to a healthcare party (By current healthcare party). Returns the contact with new delegations.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ContactApi()
val body : DelegationDto =  // DelegationDto | 
val contactId : kotlin.String = contactId_example // kotlin.String | 
try {
    val result : ContactDto = apiInstance.newContactDelegations(body, contactId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#newContactDelegations")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#newContactDelegations")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**DelegationDto**](DelegationDto.md)|  |
 **contactId** | **kotlin.String**|  |

### Return type

[**ContactDto**](ContactDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="setContactsDelegations"></a>
# **setContactsDelegations**
> kotlin.Array&lt;ContactDto&gt; setContactsDelegations(body)

Update delegations in healthElements.

Keys must be delimited by coma

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ContactApi()
val body : kotlin.Array<IcureStubDto> =  // kotlin.Array<IcureStubDto> | 
try {
    val result : kotlin.Array<ContactDto> = apiInstance.setContactsDelegations(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#setContactsDelegations")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#setContactsDelegations")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**kotlin.Array&lt;IcureStubDto&gt;**](IcureStubDto.md)|  |

### Return type

[**kotlin.Array&lt;ContactDto&gt;**](ContactDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

