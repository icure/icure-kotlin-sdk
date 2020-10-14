# EntitytemplateApi

All URIs are relative to *https://kraken.icure.dev*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createEntityTemplate**](EntitytemplateApi.md#createEntityTemplate) | **POST** /rest/v1/entitytemplate | Create a EntityTemplate
[**deleteEntityTemplate**](EntitytemplateApi.md#deleteEntityTemplate) | **DELETE** /rest/v1/entitytemplate/{entityTemplateIds} | Delete entity templates
[**findAllEntityTemplates**](EntitytemplateApi.md#findAllEntityTemplates) | **GET** /rest/v1/entitytemplate/findAll/{type} | Finding entityTemplates by entityTemplate, type and version with pagination.
[**findEntityTemplates**](EntitytemplateApi.md#findEntityTemplates) | **GET** /rest/v1/entitytemplate/find/{userId}/{type} | Finding entityTemplates by userId, entityTemplate, type and version with pagination.
[**getEntityTemplate**](EntitytemplateApi.md#getEntityTemplate) | **GET** /rest/v1/entitytemplate/{entityTemplateId} | Get a entityTemplate
[**getEntityTemplates**](EntitytemplateApi.md#getEntityTemplates) | **GET** /rest/v1/entitytemplate/byIds/{entityTemplateIds} | Get a list of entityTemplates by ids
[**modifyEntityTemplate**](EntitytemplateApi.md#modifyEntityTemplate) | **PUT** /rest/v1/entitytemplate | Modify a entityTemplate

<a name="createEntityTemplate"></a>
# **createEntityTemplate**
> EntityTemplateDto createEntityTemplate(body)

Create a EntityTemplate

Type, EntityTemplate and Version are required.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = EntitytemplateApi()
val body : EntityTemplateDto =  // EntityTemplateDto | 
try {
    val result : EntityTemplateDto = apiInstance.createEntityTemplate(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EntitytemplateApi#createEntityTemplate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EntitytemplateApi#createEntityTemplate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**EntityTemplateDto**](EntityTemplateDto.md)|  |

### Return type

[**EntityTemplateDto**](EntityTemplateDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="deleteEntityTemplate"></a>
# **deleteEntityTemplate**
> kotlin.Array&lt;DocIdentifier&gt; deleteEntityTemplate(entityTemplateIds)

Delete entity templates

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = EntitytemplateApi()
val entityTemplateIds : kotlin.String = entityTemplateIds_example // kotlin.String | 
try {
    val result : kotlin.Array<DocIdentifier> = apiInstance.deleteEntityTemplate(entityTemplateIds)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EntitytemplateApi#deleteEntityTemplate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EntitytemplateApi#deleteEntityTemplate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityTemplateIds** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;DocIdentifier&gt;**](DocIdentifier.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="findAllEntityTemplates"></a>
# **findAllEntityTemplates**
> kotlin.Array&lt;EntityTemplateDto&gt; findAllEntityTemplates(type, searchString, includeEntities)

Finding entityTemplates by entityTemplate, type and version with pagination.

Returns a list of entityTemplates matched with given input.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = EntitytemplateApi()
val type : kotlin.String = type_example // kotlin.String | 
val searchString : kotlin.String = searchString_example // kotlin.String | 
val includeEntities : kotlin.Boolean = true // kotlin.Boolean | 
try {
    val result : kotlin.Array<EntityTemplateDto> = apiInstance.findAllEntityTemplates(type, searchString, includeEntities)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EntitytemplateApi#findAllEntityTemplates")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EntitytemplateApi#findAllEntityTemplates")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **type** | **kotlin.String**|  |
 **searchString** | **kotlin.String**|  | [optional]
 **includeEntities** | **kotlin.Boolean**|  | [optional]

### Return type

[**kotlin.Array&lt;EntityTemplateDto&gt;**](EntityTemplateDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="findEntityTemplates"></a>
# **findEntityTemplates**
> kotlin.Array&lt;EntityTemplateDto&gt; findEntityTemplates(userId, type, searchString, includeEntities)

Finding entityTemplates by userId, entityTemplate, type and version with pagination.

Returns a list of entityTemplates matched with given input.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = EntitytemplateApi()
val userId : kotlin.String = userId_example // kotlin.String | 
val type : kotlin.String = type_example // kotlin.String | 
val searchString : kotlin.String = searchString_example // kotlin.String | 
val includeEntities : kotlin.Boolean = true // kotlin.Boolean | 
try {
    val result : kotlin.Array<EntityTemplateDto> = apiInstance.findEntityTemplates(userId, type, searchString, includeEntities)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EntitytemplateApi#findEntityTemplates")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EntitytemplateApi#findEntityTemplates")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **kotlin.String**|  |
 **type** | **kotlin.String**|  |
 **searchString** | **kotlin.String**|  | [optional]
 **includeEntities** | **kotlin.Boolean**|  | [optional]

### Return type

[**kotlin.Array&lt;EntityTemplateDto&gt;**](EntityTemplateDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getEntityTemplate"></a>
# **getEntityTemplate**
> EntityTemplateDto getEntityTemplate(entityTemplateId)

Get a entityTemplate

Get a entityTemplate based on ID or (entityTemplate,type,version) as query strings. (entityTemplate,type,version) is unique.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = EntitytemplateApi()
val entityTemplateId : kotlin.String = entityTemplateId_example // kotlin.String | EntityTemplate id
try {
    val result : EntityTemplateDto = apiInstance.getEntityTemplate(entityTemplateId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EntitytemplateApi#getEntityTemplate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EntitytemplateApi#getEntityTemplate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityTemplateId** | **kotlin.String**| EntityTemplate id |

### Return type

[**EntityTemplateDto**](EntityTemplateDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getEntityTemplates"></a>
# **getEntityTemplates**
> kotlin.Array&lt;EntityTemplateDto&gt; getEntityTemplates(entityTemplateIds)

Get a list of entityTemplates by ids

Keys must be delimited by coma

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = EntitytemplateApi()
val entityTemplateIds : kotlin.String = entityTemplateIds_example // kotlin.String | 
try {
    val result : kotlin.Array<EntityTemplateDto> = apiInstance.getEntityTemplates(entityTemplateIds)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EntitytemplateApi#getEntityTemplates")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EntitytemplateApi#getEntityTemplates")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityTemplateIds** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;EntityTemplateDto&gt;**](EntityTemplateDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="modifyEntityTemplate"></a>
# **modifyEntityTemplate**
> EntityTemplateDto modifyEntityTemplate(body)

Modify a entityTemplate

Modification of (type, entityTemplate, version) is not allowed.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = EntitytemplateApi()
val body : EntityTemplateDto =  // EntityTemplateDto | 
try {
    val result : EntityTemplateDto = apiInstance.modifyEntityTemplate(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EntitytemplateApi#modifyEntityTemplate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EntitytemplateApi#modifyEntityTemplate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**EntityTemplateDto**](EntityTemplateDto.md)|  |

### Return type

[**EntityTemplateDto**](EntityTemplateDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

