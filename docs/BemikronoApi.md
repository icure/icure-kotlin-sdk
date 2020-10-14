# BemikronoApi

All URIs are relative to *https://kraken.icure.dev*

Method | HTTP request | Description
------------- | ------------- | -------------
[**appointmentsByDate**](BemikronoApi.md#appointmentsByDate) | **GET** /rest/v1/be_mikrono/appointments/byDate/{calendarDate} | Get appointments for patient
[**appointmentsByPatient**](BemikronoApi.md#appointmentsByPatient) | **GET** /rest/v1/be_mikrono/appointments/byPatient/{patientId} | Get appointments for patient
[**createAppointmentTypes**](BemikronoApi.md#createAppointmentTypes) | **POST** /rest/v1/be_mikrono/appointmentTypes | 
[**createAppointments**](BemikronoApi.md#createAppointments) | **POST** /rest/v1/be_mikrono/appointments | Create appointments for owner
[**notify**](BemikronoApi.md#notify) | **GET** /rest/v1/be_mikrono/notify/{appointmentId}/{action} | Notify of an appointment change
[**register**](BemikronoApi.md#register) | **PUT** /rest/v1/be_mikrono/user/{userId}/register | Set credentials for provided user
[**sendMessage**](BemikronoApi.md#sendMessage) | **POST** /rest/v1/be_mikrono/sendMessage | Send message using mikrono from logged user
[**setUserCredentials**](BemikronoApi.md#setUserCredentials) | **PUT** /rest/v1/be_mikrono/user/{userId}/credentials | Set credentials for provided user

<a name="appointmentsByDate"></a>
# **appointmentsByDate**
> kotlin.Array&lt;AppointmentDto&gt; appointmentsByDate(calendarDate)

Get appointments for patient

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BemikronoApi()
val calendarDate : kotlin.Long = 789 // kotlin.Long | 
try {
    val result : kotlin.Array<AppointmentDto> = apiInstance.appointmentsByDate(calendarDate)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BemikronoApi#appointmentsByDate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BemikronoApi#appointmentsByDate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **calendarDate** | **kotlin.Long**|  |

### Return type

[**kotlin.Array&lt;AppointmentDto&gt;**](AppointmentDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="appointmentsByPatient"></a>
# **appointmentsByPatient**
> kotlin.Array&lt;AppointmentDto&gt; appointmentsByPatient(patientId, from, to)

Get appointments for patient

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BemikronoApi()
val patientId : kotlin.String = patientId_example // kotlin.String | 
val from : kotlin.Long = 789 // kotlin.Long | 
val to : kotlin.Long = 789 // kotlin.Long | 
try {
    val result : kotlin.Array<AppointmentDto> = apiInstance.appointmentsByPatient(patientId, from, to)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BemikronoApi#appointmentsByPatient")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BemikronoApi#appointmentsByPatient")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **patientId** | **kotlin.String**|  |
 **from** | **kotlin.Long**|  | [optional]
 **to** | **kotlin.Long**|  | [optional]

### Return type

[**kotlin.Array&lt;AppointmentDto&gt;**](AppointmentDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="createAppointmentTypes"></a>
# **createAppointmentTypes**
> kotlin.Array&lt;MikronoAppointmentTypeRestDto&gt; createAppointmentTypes(body)



### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BemikronoApi()
val body : kotlin.Array<MikronoAppointmentTypeRestDto> =  // kotlin.Array<MikronoAppointmentTypeRestDto> | 
try {
    val result : kotlin.Array<MikronoAppointmentTypeRestDto> = apiInstance.createAppointmentTypes(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BemikronoApi#createAppointmentTypes")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BemikronoApi#createAppointmentTypes")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**kotlin.Array&lt;MikronoAppointmentTypeRestDto&gt;**](MikronoAppointmentTypeRestDto.md)|  | [optional]

### Return type

[**kotlin.Array&lt;MikronoAppointmentTypeRestDto&gt;**](MikronoAppointmentTypeRestDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="createAppointments"></a>
# **createAppointments**
> kotlin.Array&lt;kotlin.String&gt; createAppointments(body)

Create appointments for owner

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BemikronoApi()
val body : kotlin.Array<AppointmentImportDto> =  // kotlin.Array<AppointmentImportDto> | 
try {
    val result : kotlin.Array<kotlin.String> = apiInstance.createAppointments(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BemikronoApi#createAppointments")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BemikronoApi#createAppointments")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**kotlin.Array&lt;AppointmentImportDto&gt;**](AppointmentImportDto.md)|  |

### Return type

**kotlin.Array&lt;kotlin.String&gt;**

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="notify"></a>
# **notify**
> notify(appointmentId, action)

Notify of an appointment change

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BemikronoApi()
val appointmentId : kotlin.String = appointmentId_example // kotlin.String | 
val action : kotlin.String = action_example // kotlin.String | 
try {
    apiInstance.notify(appointmentId, action)
} catch (e: ClientException) {
    println("4xx response calling BemikronoApi#notify")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BemikronoApi#notify")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **appointmentId** | **kotlin.String**|  |
 **action** | **kotlin.String**|  |

### Return type

null (empty response body)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="register"></a>
# **register**
> UserDto register(body, userId)

Set credentials for provided user

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BemikronoApi()
val body : MikronoCredentialsDto =  // MikronoCredentialsDto | 
val userId : kotlin.String = userId_example // kotlin.String | 
try {
    val result : UserDto = apiInstance.register(body, userId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BemikronoApi#register")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BemikronoApi#register")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**MikronoCredentialsDto**](MikronoCredentialsDto.md)|  |
 **userId** | **kotlin.String**|  |

### Return type

[**UserDto**](UserDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="sendMessage"></a>
# **sendMessage**
> Unit sendMessage(body)

Send message using mikrono from logged user

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BemikronoApi()
val body : EmailOrSmsMessageDto =  // EmailOrSmsMessageDto | 
try {
    val result : Unit = apiInstance.sendMessage(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BemikronoApi#sendMessage")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BemikronoApi#sendMessage")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**EmailOrSmsMessageDto**](EmailOrSmsMessageDto.md)|  |

### Return type

[**Unit**](Unit.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="setUserCredentials"></a>
# **setUserCredentials**
> UserDto setUserCredentials(body, userId)

Set credentials for provided user

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BemikronoApi()
val body : MikronoCredentialsDto =  // MikronoCredentialsDto | 
val userId : kotlin.String = userId_example // kotlin.String | 
try {
    val result : UserDto = apiInstance.setUserCredentials(body, userId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BemikronoApi#setUserCredentials")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BemikronoApi#setUserCredentials")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**MikronoCredentialsDto**](MikronoCredentialsDto.md)|  |
 **userId** | **kotlin.String**|  |

### Return type

[**UserDto**](UserDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

