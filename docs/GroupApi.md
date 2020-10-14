# GroupApi

All URIs are relative to *https://kraken.icure.dev*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createGroup**](GroupApi.md#createGroup) | **POST** /rest/v1/group/{id} | Create a group
[**listGroups**](GroupApi.md#listGroups) | **GET** /rest/v1/group | List groups
[**setGroupPassword**](GroupApi.md#setGroupPassword) | **PUT** /rest/v1/group/{id}/password | List groups

<a name="createGroup"></a>
# **createGroup**
> GroupDto createGroup(body, password, name, id, server, q, n)

Create a group

Create a new group and associated dbs.  The created group will be manageable by the users that belong to the same group as the one that called createGroup. Several tasks can be executed during the group creation like DB replications towards the created DBs, users creation and healthcare parties creation

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = GroupApi()
val body : DatabaseInitialisationDto =  // DatabaseInitialisationDto | initialisationData is an object that contains the initial replications (target must be an internalTarget of value base, healthdata or patient) and the users and healthcare parties to be created
val password : kotlin.String = password_example // kotlin.String | The password of the group (can only contain digits, letters, - and _)
val name : kotlin.String = name_example // kotlin.String | The name of the group
val id : kotlin.String = id_example // kotlin.String | The id of the group, also used for subsequent authentication against the db (can only contain digits, letters, - and _)
val server : kotlin.String = server_example // kotlin.String | The server on which the group dbs will be created
val q : kotlin.Int = 56 // kotlin.Int | The number of shards for patient and healthdata dbs : 3-8 is a recommended range of value
val n : kotlin.Int = 56 // kotlin.Int | The number of replications for dbs : 3 is a recommended value
try {
    val result : GroupDto = apiInstance.createGroup(body, password, name, id, server, q, n)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GroupApi#createGroup")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GroupApi#createGroup")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**DatabaseInitialisationDto**](DatabaseInitialisationDto.md)| initialisationData is an object that contains the initial replications (target must be an internalTarget of value base, healthdata or patient) and the users and healthcare parties to be created |
 **password** | **kotlin.String**| The password of the group (can only contain digits, letters, - and _) |
 **name** | **kotlin.String**| The name of the group |
 **id** | **kotlin.String**| The id of the group, also used for subsequent authentication against the db (can only contain digits, letters, - and _) |
 **server** | **kotlin.String**| The server on which the group dbs will be created | [optional]
 **q** | **kotlin.Int**| The number of shards for patient and healthdata dbs : 3-8 is a recommended range of value | [optional]
 **n** | **kotlin.Int**| The number of replications for dbs : 3 is a recommended value | [optional]

### Return type

[**GroupDto**](GroupDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="listGroups"></a>
# **listGroups**
> kotlin.Array&lt;GroupDto&gt; listGroups()

List groups

Create a new gorup with associated dbs

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = GroupApi()
try {
    val result : kotlin.Array<GroupDto> = apiInstance.listGroups()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GroupApi#listGroups")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GroupApi#listGroups")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.Array&lt;GroupDto&gt;**](GroupDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="setGroupPassword"></a>
# **setGroupPassword**
> GroupDto setGroupPassword(id, password)

List groups

Create a new gorup with associated dbs

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = GroupApi()
val id : kotlin.String = id_example // kotlin.String | The id of the group
val password : kotlin.String = password_example // kotlin.String | The new password for the group (can only contain digits, letters, - and _)
try {
    val result : GroupDto = apiInstance.setGroupPassword(id, password)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GroupApi#setGroupPassword")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GroupApi#setGroupPassword")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.String**| The id of the group |
 **password** | **kotlin.String**| The new password for the group (can only contain digits, letters, - and _) |

### Return type

[**GroupDto**](GroupDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

