# MessageApi

All URIs are relative to *https://kraken.icure.dev*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createMessage**](MessageApi.md#createMessage) | **POST** /rest/v1/message | Creates a message
[**deleteDelegation**](MessageApi.md#deleteDelegation) | **DELETE** /rest/v1/message/{messageId}/delegate/{delegateId} | Deletes a message delegation
[**deleteMessages**](MessageApi.md#deleteMessages) | **DELETE** /rest/v1/message/{messageIds} | Deletes multiple messages
[**deleteMessagesBatch**](MessageApi.md#deleteMessagesBatch) | **POST** /rest/v1/message/delete/byIds | Deletes multiple messages
[**findMessages**](MessageApi.md#findMessages) | **GET** /rest/v1/message | Get all messages (paginated) for current HC Party
[**findMessagesByFromAddress**](MessageApi.md#findMessagesByFromAddress) | **GET** /rest/v1/message/byFromAddress | Get all messages (paginated) for current HC Party and provided from address
[**findMessagesByHCPartyPatientForeignKeys**](MessageApi.md#findMessagesByHCPartyPatientForeignKeys) | **GET** /rest/v1/message/byHcPartySecretForeignKeys | List messages found By Healthcare Party and secret foreign keys.
[**findMessagesByToAddress**](MessageApi.md#findMessagesByToAddress) | **GET** /rest/v1/message/byToAddress | Get all messages (paginated) for current HC Party and provided to address
[**findMessagesByTransportGuid**](MessageApi.md#findMessagesByTransportGuid) | **GET** /rest/v1/message/byTransportGuid | Get all messages (paginated) for current HC Party and provided transportGuid
[**findMessagesByTransportGuidSentDate**](MessageApi.md#findMessagesByTransportGuidSentDate) | **GET** /rest/v1/message/byTransportGuidSentDate | Get all messages starting by a prefix between two date
[**getChildrenMessages**](MessageApi.md#getChildrenMessages) | **GET** /rest/v1/message/{messageId}/children | Get children messages of provided message
[**getChildrenMessagesOfList**](MessageApi.md#getChildrenMessagesOfList) | **POST** /rest/v1/message/children/batch | Get children messages of provided message
[**getMessage**](MessageApi.md#getMessage) | **GET** /rest/v1/message/{messageId} | Gets a message
[**listMessagesByInvoiceIds**](MessageApi.md#listMessagesByInvoiceIds) | **POST** /rest/v1/message/byInvoiceId | Get children messages of provided message
[**modifyMessage**](MessageApi.md#modifyMessage) | **PUT** /rest/v1/message | Updates a message
[**newMessageDelegations**](MessageApi.md#newMessageDelegations) | **PUT** /rest/v1/message/{messageId}/delegate | Adds a delegation to a message
[**setMessagesReadStatus**](MessageApi.md#setMessagesReadStatus) | **PUT** /rest/v1/message/readstatus | Set read status for given list of messages
[**setMessagesStatusBits**](MessageApi.md#setMessagesStatusBits) | **PUT** /rest/v1/message/status/{status} | Set status bits for given list of messages

<a name="createMessage"></a>
# **createMessage**
> MessageDto createMessage(body)

Creates a message

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = MessageApi()
val body : MessageDto =  // MessageDto | 
try {
    val result : MessageDto = apiInstance.createMessage(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MessageApi#createMessage")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MessageApi#createMessage")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**MessageDto**](MessageDto.md)|  |

### Return type

[**MessageDto**](MessageDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="deleteDelegation"></a>
# **deleteDelegation**
> MessageDto deleteDelegation(messageId, delegateId)

Deletes a message delegation

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = MessageApi()
val messageId : kotlin.String = messageId_example // kotlin.String | 
val delegateId : kotlin.String = delegateId_example // kotlin.String | 
try {
    val result : MessageDto = apiInstance.deleteDelegation(messageId, delegateId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MessageApi#deleteDelegation")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MessageApi#deleteDelegation")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **messageId** | **kotlin.String**|  |
 **delegateId** | **kotlin.String**|  |

### Return type

[**MessageDto**](MessageDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="deleteMessages"></a>
# **deleteMessages**
> kotlin.Array&lt;DocIdentifier&gt; deleteMessages(messageIds)

Deletes multiple messages

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = MessageApi()
val messageIds : kotlin.String = messageIds_example // kotlin.String | 
try {
    val result : kotlin.Array<DocIdentifier> = apiInstance.deleteMessages(messageIds)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MessageApi#deleteMessages")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MessageApi#deleteMessages")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **messageIds** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;DocIdentifier&gt;**](DocIdentifier.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="deleteMessagesBatch"></a>
# **deleteMessagesBatch**
> kotlin.Array&lt;DocIdentifier&gt; deleteMessagesBatch(body)

Deletes multiple messages

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = MessageApi()
val body : ListOfIdsDto =  // ListOfIdsDto | 
try {
    val result : kotlin.Array<DocIdentifier> = apiInstance.deleteMessagesBatch(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MessageApi#deleteMessagesBatch")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MessageApi#deleteMessagesBatch")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ListOfIdsDto**](ListOfIdsDto.md)|  |

### Return type

[**kotlin.Array&lt;DocIdentifier&gt;**](DocIdentifier.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="findMessages"></a>
# **findMessages**
> PaginatedListMessageDto findMessages(startKey, startDocumentId, limit)

Get all messages (paginated) for current HC Party

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = MessageApi()
val startKey : kotlin.String = startKey_example // kotlin.String | 
val startDocumentId : kotlin.String = startDocumentId_example // kotlin.String | 
val limit : kotlin.Int = 56 // kotlin.Int | 
try {
    val result : PaginatedListMessageDto = apiInstance.findMessages(startKey, startDocumentId, limit)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MessageApi#findMessages")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MessageApi#findMessages")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **startKey** | **kotlin.String**|  | [optional]
 **startDocumentId** | **kotlin.String**|  | [optional]
 **limit** | **kotlin.Int**|  | [optional]

### Return type

[**PaginatedListMessageDto**](PaginatedListMessageDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="findMessagesByFromAddress"></a>
# **findMessagesByFromAddress**
> PaginatedListMessageDto findMessagesByFromAddress(fromAddress, startKey, startDocumentId, limit, hcpId)

Get all messages (paginated) for current HC Party and provided from address

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = MessageApi()
val fromAddress : kotlin.String = fromAddress_example // kotlin.String | 
val startKey : kotlin.String = startKey_example // kotlin.String | 
val startDocumentId : kotlin.String = startDocumentId_example // kotlin.String | 
val limit : kotlin.Int = 56 // kotlin.Int | 
val hcpId : kotlin.String = hcpId_example // kotlin.String | 
try {
    val result : PaginatedListMessageDto = apiInstance.findMessagesByFromAddress(fromAddress, startKey, startDocumentId, limit, hcpId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MessageApi#findMessagesByFromAddress")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MessageApi#findMessagesByFromAddress")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fromAddress** | **kotlin.String**|  | [optional]
 **startKey** | **kotlin.String**|  | [optional]
 **startDocumentId** | **kotlin.String**|  | [optional]
 **limit** | **kotlin.Int**|  | [optional]
 **hcpId** | **kotlin.String**|  | [optional]

### Return type

[**PaginatedListMessageDto**](PaginatedListMessageDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="findMessagesByHCPartyPatientForeignKeys"></a>
# **findMessagesByHCPartyPatientForeignKeys**
> kotlin.Array&lt;MessageDto&gt; findMessagesByHCPartyPatientForeignKeys(secretFKeys)

List messages found By Healthcare Party and secret foreign keys.

Keys must be delimited by coma

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = MessageApi()
val secretFKeys : kotlin.String = secretFKeys_example // kotlin.String | 
try {
    val result : kotlin.Array<MessageDto> = apiInstance.findMessagesByHCPartyPatientForeignKeys(secretFKeys)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MessageApi#findMessagesByHCPartyPatientForeignKeys")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MessageApi#findMessagesByHCPartyPatientForeignKeys")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **secretFKeys** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;MessageDto&gt;**](MessageDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="findMessagesByToAddress"></a>
# **findMessagesByToAddress**
> PaginatedListMessageDto findMessagesByToAddress(toAddress, startKey, startDocumentId, limit, reverse, hcpId)

Get all messages (paginated) for current HC Party and provided to address

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = MessageApi()
val toAddress : kotlin.String = toAddress_example // kotlin.String | 
val startKey : kotlin.String = startKey_example // kotlin.String | 
val startDocumentId : kotlin.String = startDocumentId_example // kotlin.String | 
val limit : kotlin.Int = 56 // kotlin.Int | 
val reverse : kotlin.Boolean = true // kotlin.Boolean | 
val hcpId : kotlin.String = hcpId_example // kotlin.String | 
try {
    val result : PaginatedListMessageDto = apiInstance.findMessagesByToAddress(toAddress, startKey, startDocumentId, limit, reverse, hcpId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MessageApi#findMessagesByToAddress")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MessageApi#findMessagesByToAddress")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **toAddress** | **kotlin.String**|  | [optional]
 **startKey** | **kotlin.String**|  | [optional]
 **startDocumentId** | **kotlin.String**|  | [optional]
 **limit** | **kotlin.Int**|  | [optional]
 **reverse** | **kotlin.Boolean**|  | [optional]
 **hcpId** | **kotlin.String**|  | [optional]

### Return type

[**PaginatedListMessageDto**](PaginatedListMessageDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="findMessagesByTransportGuid"></a>
# **findMessagesByTransportGuid**
> PaginatedListMessageDto findMessagesByTransportGuid(transportGuid, received, startKey, startDocumentId, limit, hcpId)

Get all messages (paginated) for current HC Party and provided transportGuid

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = MessageApi()
val transportGuid : kotlin.String = transportGuid_example // kotlin.String | 
val received : kotlin.Boolean = true // kotlin.Boolean | 
val startKey : kotlin.String = startKey_example // kotlin.String | 
val startDocumentId : kotlin.String = startDocumentId_example // kotlin.String | 
val limit : kotlin.Int = 56 // kotlin.Int | 
val hcpId : kotlin.String = hcpId_example // kotlin.String | 
try {
    val result : PaginatedListMessageDto = apiInstance.findMessagesByTransportGuid(transportGuid, received, startKey, startDocumentId, limit, hcpId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MessageApi#findMessagesByTransportGuid")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MessageApi#findMessagesByTransportGuid")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **transportGuid** | **kotlin.String**|  | [optional]
 **received** | **kotlin.Boolean**|  | [optional]
 **startKey** | **kotlin.String**|  | [optional]
 **startDocumentId** | **kotlin.String**|  | [optional]
 **limit** | **kotlin.Int**|  | [optional]
 **hcpId** | **kotlin.String**|  | [optional]

### Return type

[**PaginatedListMessageDto**](PaginatedListMessageDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="findMessagesByTransportGuidSentDate"></a>
# **findMessagesByTransportGuidSentDate**
> PaginatedListMessageDto findMessagesByTransportGuidSentDate(from, to, transportGuid, startKey, startDocumentId, limit, hcpId)

Get all messages starting by a prefix between two date

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = MessageApi()
val from : kotlin.Long = 789 // kotlin.Long | 
val to : kotlin.Long = 789 // kotlin.Long | 
val transportGuid : kotlin.String = transportGuid_example // kotlin.String | 
val startKey : kotlin.String = startKey_example // kotlin.String | 
val startDocumentId : kotlin.String = startDocumentId_example // kotlin.String | 
val limit : kotlin.Int = 56 // kotlin.Int | 
val hcpId : kotlin.String = hcpId_example // kotlin.String | 
try {
    val result : PaginatedListMessageDto = apiInstance.findMessagesByTransportGuidSentDate(from, to, transportGuid, startKey, startDocumentId, limit, hcpId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MessageApi#findMessagesByTransportGuidSentDate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MessageApi#findMessagesByTransportGuidSentDate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **from** | **kotlin.Long**|  | [optional]
 **to** | **kotlin.Long**|  | [optional]
 **transportGuid** | **kotlin.String**|  | [optional]
 **startKey** | **kotlin.String**|  | [optional]
 **startDocumentId** | **kotlin.String**|  | [optional]
 **limit** | **kotlin.Int**|  | [optional]
 **hcpId** | **kotlin.String**|  | [optional]

### Return type

[**PaginatedListMessageDto**](PaginatedListMessageDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getChildrenMessages"></a>
# **getChildrenMessages**
> kotlin.Array&lt;MessageDto&gt; getChildrenMessages(messageId)

Get children messages of provided message

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = MessageApi()
val messageId : kotlin.String = messageId_example // kotlin.String | 
try {
    val result : kotlin.Array<MessageDto> = apiInstance.getChildrenMessages(messageId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MessageApi#getChildrenMessages")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MessageApi#getChildrenMessages")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **messageId** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;MessageDto&gt;**](MessageDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getChildrenMessagesOfList"></a>
# **getChildrenMessagesOfList**
> kotlin.Array&lt;MessageDto&gt; getChildrenMessagesOfList(body)

Get children messages of provided message

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = MessageApi()
val body : ListOfIdsDto =  // ListOfIdsDto | 
try {
    val result : kotlin.Array<MessageDto> = apiInstance.getChildrenMessagesOfList(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MessageApi#getChildrenMessagesOfList")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MessageApi#getChildrenMessagesOfList")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ListOfIdsDto**](ListOfIdsDto.md)|  |

### Return type

[**kotlin.Array&lt;MessageDto&gt;**](MessageDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="getMessage"></a>
# **getMessage**
> MessageDto getMessage(messageId)

Gets a message

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = MessageApi()
val messageId : kotlin.String = messageId_example // kotlin.String | 
try {
    val result : MessageDto = apiInstance.getMessage(messageId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MessageApi#getMessage")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MessageApi#getMessage")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **messageId** | **kotlin.String**|  |

### Return type

[**MessageDto**](MessageDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="listMessagesByInvoiceIds"></a>
# **listMessagesByInvoiceIds**
> kotlin.Array&lt;MessageDto&gt; listMessagesByInvoiceIds(body)

Get children messages of provided message

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = MessageApi()
val body : ListOfIdsDto =  // ListOfIdsDto | 
try {
    val result : kotlin.Array<MessageDto> = apiInstance.listMessagesByInvoiceIds(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MessageApi#listMessagesByInvoiceIds")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MessageApi#listMessagesByInvoiceIds")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ListOfIdsDto**](ListOfIdsDto.md)|  |

### Return type

[**kotlin.Array&lt;MessageDto&gt;**](MessageDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="modifyMessage"></a>
# **modifyMessage**
> MessageDto modifyMessage(body)

Updates a message

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = MessageApi()
val body : MessageDto =  // MessageDto | 
try {
    val result : MessageDto = apiInstance.modifyMessage(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MessageApi#modifyMessage")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MessageApi#modifyMessage")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**MessageDto**](MessageDto.md)|  |

### Return type

[**MessageDto**](MessageDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="newMessageDelegations"></a>
# **newMessageDelegations**
> IcureStubDto newMessageDelegations(body, messageId)

Adds a delegation to a message

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = MessageApi()
val body : kotlin.Array<DelegationDto> =  // kotlin.Array<DelegationDto> | 
val messageId : kotlin.String = messageId_example // kotlin.String | 
try {
    val result : IcureStubDto = apiInstance.newMessageDelegations(body, messageId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MessageApi#newMessageDelegations")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MessageApi#newMessageDelegations")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**kotlin.Array&lt;DelegationDto&gt;**](DelegationDto.md)|  |
 **messageId** | **kotlin.String**|  |

### Return type

[**IcureStubDto**](IcureStubDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="setMessagesReadStatus"></a>
# **setMessagesReadStatus**
> kotlin.Array&lt;MessageDto&gt; setMessagesReadStatus(body)

Set read status for given list of messages

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = MessageApi()
val body : MessagesReadStatusUpdate =  // MessagesReadStatusUpdate | 
try {
    val result : kotlin.Array<MessageDto> = apiInstance.setMessagesReadStatus(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MessageApi#setMessagesReadStatus")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MessageApi#setMessagesReadStatus")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**MessagesReadStatusUpdate**](MessagesReadStatusUpdate.md)|  |

### Return type

[**kotlin.Array&lt;MessageDto&gt;**](MessageDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="setMessagesStatusBits"></a>
# **setMessagesStatusBits**
> kotlin.Array&lt;MessageDto&gt; setMessagesStatusBits(body, status)

Set status bits for given list of messages

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = MessageApi()
val body : ListOfIdsDto =  // ListOfIdsDto | 
val status : kotlin.Int = 56 // kotlin.Int | 
try {
    val result : kotlin.Array<MessageDto> = apiInstance.setMessagesStatusBits(body, status)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MessageApi#setMessagesStatusBits")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MessageApi#setMessagesStatusBits")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ListOfIdsDto**](ListOfIdsDto.md)|  |
 **status** | **kotlin.Int**|  |

### Return type

[**kotlin.Array&lt;MessageDto&gt;**](MessageDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

