# UserApi

All URIs are relative to *https://kraken.icure.dev*

Method | HTTP request | Description
------------- | ------------- | -------------
[**assignHealthcareParty**](UserApi.md#assignHealthcareParty) | **PUT** /rest/v1/user/current/hcparty/{healthcarePartyId} | Assign a healthcare party ID to current user
[**checkPassword**](UserApi.md#checkPassword) | **GET** /rest/v1/user/checkPassword | 
[**createUser**](UserApi.md#createUser) | **POST** /rest/v1/user | Create a user
[**createUserInGroup**](UserApi.md#createUserInGroup) | **POST** /rest/v1/user/inGroup/{groupId} | Create a user
[**deleteUser**](UserApi.md#deleteUser) | **DELETE** /rest/v1/user/{userId} | Delete a User based on his/her ID.
[**deleteUserInGroup**](UserApi.md#deleteUserInGroup) | **DELETE** /rest/v1/user/inGroup/{groupId}/{userId} | Delete a User based on his/her ID.
[**encodePassword**](UserApi.md#encodePassword) | **GET** /rest/v1/user/encodePassword | 
[**findByHcpartyId**](UserApi.md#findByHcpartyId) | **GET** /rest/v1/user/byHealthcarePartyId/{id} | Get the list of users by healthcare party id
[**forgottenPassword**](UserApi.md#forgottenPassword) | **POST** /rest/v1/user/forgottenPassword/{email} | Send a forgotten email message to an user
[**getCurrentSession**](UserApi.md#getCurrentSession) | **GET** /rest/v1/user/session | Get Currently logged-in user session.
[**getCurrentUser**](UserApi.md#getCurrentUser) | **GET** /rest/v1/user/current | Get presently logged-in user.
[**getMatchingUsers**](UserApi.md#getMatchingUsers) | **GET** /rest/v1/user/matches | Get presently logged-in user.
[**getUser**](UserApi.md#getUser) | **GET** /rest/v1/user/{userId} | Get a user by his ID
[**getUserByEmail**](UserApi.md#getUserByEmail) | **GET** /rest/v1/user/byEmail/{email} | Get a user by his Email/Login
[**listUsers**](UserApi.md#listUsers) | **GET** /rest/v1/user | List users with(out) pagination
[**listUsersInGroup**](UserApi.md#listUsersInGroup) | **GET** /rest/v1/user/inGroup/{groupId} | List users with(out) pagination
[**modifyProperties**](UserApi.md#modifyProperties) | **PUT** /rest/v1/user/{userId}/properties | Modify a User property
[**modifyUser**](UserApi.md#modifyUser) | **PUT** /rest/v1/user | Modify a user.
[**modifyUserInGroup**](UserApi.md#modifyUserInGroup) | **PUT** /rest/v1/user/inGroup/{groupId} | Modify a user.

<a name="assignHealthcareParty"></a>
# **assignHealthcareParty**
> UserDto assignHealthcareParty(healthcarePartyId)

Assign a healthcare party ID to current user

UserDto gets returned.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = UserApi()
val healthcarePartyId : kotlin.String = healthcarePartyId_example // kotlin.String | 
try {
    val result : UserDto = apiInstance.assignHealthcareParty(healthcarePartyId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserApi#assignHealthcareParty")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserApi#assignHealthcareParty")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **healthcarePartyId** | **kotlin.String**|  |

### Return type

[**UserDto**](UserDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="checkPassword"></a>
# **checkPassword**
> kotlin.Boolean checkPassword(password)



### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = UserApi()
val password : kotlin.String = password_example // kotlin.String | 
try {
    val result : kotlin.Boolean = apiInstance.checkPassword(password)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserApi#checkPassword")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserApi#checkPassword")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **password** | **kotlin.String**|  |

### Return type

**kotlin.Boolean**

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="createUser"></a>
# **createUser**
> UserDto createUser(body)

Create a user

Create a user. HealthcareParty ID should be set. Email has to be set and the Login has to be null. On server-side, Email will be used for Login.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = UserApi()
val body : UserDto =  // UserDto | 
try {
    val result : UserDto = apiInstance.createUser(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserApi#createUser")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserApi#createUser")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**UserDto**](UserDto.md)|  |

### Return type

[**UserDto**](UserDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="createUserInGroup"></a>
# **createUserInGroup**
> UserDto createUserInGroup(body, groupId)

Create a user

Create a user. HealthcareParty ID should be set. Email has to be set and the Login has to be null. On server-side, Email will be used for Login.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = UserApi()
val body : UserDto =  // UserDto | 
val groupId : kotlin.String = groupId_example // kotlin.String | 
try {
    val result : UserDto = apiInstance.createUserInGroup(body, groupId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserApi#createUserInGroup")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserApi#createUserInGroup")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**UserDto**](UserDto.md)|  |
 **groupId** | **kotlin.String**|  |

### Return type

[**UserDto**](UserDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="deleteUser"></a>
# **deleteUser**
> DocIdentifier deleteUser(userId)

Delete a User based on his/her ID.

Delete a User based on his/her ID. The return value is an array containing the ID of deleted user.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = UserApi()
val userId : kotlin.String = userId_example // kotlin.String | 
try {
    val result : DocIdentifier = apiInstance.deleteUser(userId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserApi#deleteUser")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserApi#deleteUser")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **kotlin.String**|  |

### Return type

[**DocIdentifier**](DocIdentifier.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="deleteUserInGroup"></a>
# **deleteUserInGroup**
> Unit deleteUserInGroup(groupId, userId)

Delete a User based on his/her ID.

Delete a User based on his/her ID. The return value is an array containing the ID of deleted user.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = UserApi()
val groupId : kotlin.String = groupId_example // kotlin.String | 
val userId : kotlin.String = userId_example // kotlin.String | 
try {
    val result : Unit = apiInstance.deleteUserInGroup(groupId, userId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserApi#deleteUserInGroup")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserApi#deleteUserInGroup")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **kotlin.String**|  |
 **userId** | **kotlin.String**|  |

### Return type

[**Unit**](Unit.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="encodePassword"></a>
# **encodePassword**
> kotlin.String encodePassword(password)



### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = UserApi()
val password : kotlin.String = password_example // kotlin.String | 
try {
    val result : kotlin.String = apiInstance.encodePassword(password)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserApi#encodePassword")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserApi#encodePassword")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **password** | **kotlin.String**|  |

### Return type

**kotlin.String**

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="findByHcpartyId"></a>
# **findByHcpartyId**
> kotlin.Array&lt;kotlin.String&gt; findByHcpartyId(id)

Get the list of users by healthcare party id

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = UserApi()
val id : kotlin.String = id_example // kotlin.String | 
try {
    val result : kotlin.Array<kotlin.String> = apiInstance.findByHcpartyId(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserApi#findByHcpartyId")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserApi#findByHcpartyId")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.String**|  |

### Return type

**kotlin.Array&lt;kotlin.String&gt;**

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="forgottenPassword"></a>
# **forgottenPassword**
> kotlin.Boolean forgottenPassword(body, email)

Send a forgotten email message to an user

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = UserApi()
val body : EmailTemplateDto =  // EmailTemplateDto | 
val email : kotlin.String = email_example // kotlin.String | the email of the user 
try {
    val result : kotlin.Boolean = apiInstance.forgottenPassword(body, email)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserApi#forgottenPassword")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserApi#forgottenPassword")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**EmailTemplateDto**](EmailTemplateDto.md)|  |
 **email** | **kotlin.String**| the email of the user  |

### Return type

**kotlin.Boolean**

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="getCurrentSession"></a>
# **getCurrentSession**
> kotlin.String getCurrentSession()

Get Currently logged-in user session.

Get current user.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = UserApi()
try {
    val result : kotlin.String = apiInstance.getCurrentSession()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserApi#getCurrentSession")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserApi#getCurrentSession")
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

<a name="getCurrentUser"></a>
# **getCurrentUser**
> UserDto getCurrentUser()

Get presently logged-in user.

Get current user.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = UserApi()
try {
    val result : UserDto = apiInstance.getCurrentUser()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserApi#getCurrentUser")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserApi#getCurrentUser")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**UserDto**](UserDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getMatchingUsers"></a>
# **getMatchingUsers**
> kotlin.Array&lt;UserGroupDto&gt; getMatchingUsers()

Get presently logged-in user.

Get current user.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = UserApi()
try {
    val result : kotlin.Array<UserGroupDto> = apiInstance.getMatchingUsers()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserApi#getMatchingUsers")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserApi#getMatchingUsers")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.Array&lt;UserGroupDto&gt;**](UserGroupDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getUser"></a>
# **getUser**
> UserDto getUser(userId)

Get a user by his ID

General information about the user

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = UserApi()
val userId : kotlin.String = userId_example // kotlin.String | 
try {
    val result : UserDto = apiInstance.getUser(userId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserApi#getUser")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserApi#getUser")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **kotlin.String**|  |

### Return type

[**UserDto**](UserDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getUserByEmail"></a>
# **getUserByEmail**
> UserDto getUserByEmail(email)

Get a user by his Email/Login

General information about the user

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = UserApi()
val email : kotlin.String = email_example // kotlin.String | 
try {
    val result : UserDto = apiInstance.getUserByEmail(email)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserApi#getUserByEmail")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserApi#getUserByEmail")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **email** | **kotlin.String**|  |

### Return type

[**UserDto**](UserDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="listUsers"></a>
# **listUsers**
> PaginatedListUserDto listUsers(startKey, startDocumentId, limit)

List users with(out) pagination

Returns a list of users.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = UserApi()
val startKey : kotlin.String = startKey_example // kotlin.String | An user email
val startDocumentId : kotlin.String = startDocumentId_example // kotlin.String | An user document ID
val limit : kotlin.Int = 56 // kotlin.Int | Number of rows
try {
    val result : PaginatedListUserDto = apiInstance.listUsers(startKey, startDocumentId, limit)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserApi#listUsers")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserApi#listUsers")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **startKey** | **kotlin.String**| An user email | [optional]
 **startDocumentId** | **kotlin.String**| An user document ID | [optional]
 **limit** | **kotlin.Int**| Number of rows | [optional]

### Return type

[**PaginatedListUserDto**](PaginatedListUserDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="listUsersInGroup"></a>
# **listUsersInGroup**
> PaginatedListUserDto listUsersInGroup(groupId, startKey, startDocumentId, limit)

List users with(out) pagination

Returns a list of users.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = UserApi()
val groupId : kotlin.String = groupId_example // kotlin.String | 
val startKey : kotlin.String = startKey_example // kotlin.String | An user login
val startDocumentId : kotlin.String = startDocumentId_example // kotlin.String | An user document ID
val limit : kotlin.Int = 56 // kotlin.Int | Number of rows
try {
    val result : PaginatedListUserDto = apiInstance.listUsersInGroup(groupId, startKey, startDocumentId, limit)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserApi#listUsersInGroup")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserApi#listUsersInGroup")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **kotlin.String**|  |
 **startKey** | **kotlin.String**| An user login | [optional]
 **startDocumentId** | **kotlin.String**| An user document ID | [optional]
 **limit** | **kotlin.Int**| Number of rows | [optional]

### Return type

[**PaginatedListUserDto**](PaginatedListUserDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="modifyProperties"></a>
# **modifyProperties**
> UserDto modifyProperties(body, userId)

Modify a User property

Modify a User properties based on his/her ID. The return value is the modified user.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = UserApi()
val body : kotlin.Array<PropertyStubDto> =  // kotlin.Array<PropertyStubDto> | 
val userId : kotlin.String = userId_example // kotlin.String | 
try {
    val result : UserDto = apiInstance.modifyProperties(body, userId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserApi#modifyProperties")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserApi#modifyProperties")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**kotlin.Array&lt;PropertyStubDto&gt;**](PropertyStubDto.md)|  |
 **userId** | **kotlin.String**|  |

### Return type

[**UserDto**](UserDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="modifyUser"></a>
# **modifyUser**
> UserDto modifyUser(body)

Modify a user.

No particular return value. It&#x27;s just a message.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = UserApi()
val body : UserDto =  // UserDto | 
try {
    val result : UserDto = apiInstance.modifyUser(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserApi#modifyUser")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserApi#modifyUser")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**UserDto**](UserDto.md)|  |

### Return type

[**UserDto**](UserDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="modifyUserInGroup"></a>
# **modifyUserInGroup**
> UserDto modifyUserInGroup(body, groupId)

Modify a user.

No particular return value. It&#x27;s just a message.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = UserApi()
val body : UserDto =  // UserDto | 
val groupId : kotlin.String = groupId_example // kotlin.String | 
try {
    val result : UserDto = apiInstance.modifyUserInGroup(body, groupId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserApi#modifyUserInGroup")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserApi#modifyUserInGroup")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**UserDto**](UserDto.md)|  |
 **groupId** | **kotlin.String**|  |

### Return type

[**UserDto**](UserDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

