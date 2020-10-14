# BekmehrApi

All URIs are relative to *https://kraken.icure.dev*

Method | HTTP request | Description
------------- | ------------- | -------------
[**checkIfSMFPatientsExists**](BekmehrApi.md#checkIfSMFPatientsExists) | **POST** /rest/v1/be_kmehr/smf/{documentId}/checkIfSMFPatientsExists | Check whether patients in SMF already exists in DB
[**generateContactreportExport**](BekmehrApi.md#generateContactreportExport) | **POST** /rest/v1/be_kmehr/contactreport/{patientId}/export/{id} | Get Kmehr contactreport
[**generateDiaryNote**](BekmehrApi.md#generateDiaryNote) | **POST** /rest/v1/be_kmehr/diarynote/{patientId}/export | Generate diarynote
[**generateLabresultExport**](BekmehrApi.md#generateLabresultExport) | **POST** /rest/v1/be_kmehr/labresult/{patientId}/export/{id} | Get Kmehr labresult
[**generateMedicationSchemeExport**](BekmehrApi.md#generateMedicationSchemeExport) | **POST** /rest/v1/be_kmehr/medicationscheme/{patientId}/export | Get Medicationscheme export
[**generateNoteExport**](BekmehrApi.md#generateNoteExport) | **POST** /rest/v1/be_kmehr/note/{patientId}/export/{id} | Get Kmehr note
[**generatePrescriptionExport**](BekmehrApi.md#generatePrescriptionExport) | **POST** /rest/v1/be_kmehr/prescription/{patientId}/export/{id} | Get Kmehr prescription
[**generateReportExport**](BekmehrApi.md#generateReportExport) | **POST** /rest/v1/be_kmehr/report/{patientId}/export/{id} | Get Kmehr report
[**generateRequestExport**](BekmehrApi.md#generateRequestExport) | **POST** /rest/v1/be_kmehr/request/{patientId}/export/{id} | Get Kmehr request
[**generateResultExport**](BekmehrApi.md#generateResultExport) | **POST** /rest/v1/be_kmehr/result/{patientId}/export/{id} | Get Kmehr result
[**generateSmfExport**](BekmehrApi.md#generateSmfExport) | **POST** /rest/v1/be_kmehr/smf/{patientId}/export | Get SMF (Software Medical File) export
[**generateSumehr**](BekmehrApi.md#generateSumehr) | **POST** /rest/v1/be_kmehr/sumehr/{patientId}/export | Generate sumehr
[**generateSumehrV2**](BekmehrApi.md#generateSumehrV2) | **POST** /rest/v1/be_kmehr/sumehrv2/{patientId}/export | Generate sumehr
[**getSumehrContent**](BekmehrApi.md#getSumehrContent) | **POST** /rest/v1/be_kmehr/sumehr/{patientId}/content | Get sumehr elements
[**getSumehrMd5**](BekmehrApi.md#getSumehrMd5) | **POST** /rest/v1/be_kmehr/sumehr/{patientId}/md5 | Check sumehr signature
[**getSumehrV2Content**](BekmehrApi.md#getSumehrV2Content) | **POST** /rest/v1/be_kmehr/sumehrv2/{patientId}/content | Get sumehr elements
[**getSumehrV2Md5**](BekmehrApi.md#getSumehrV2Md5) | **POST** /rest/v1/be_kmehr/sumehrv2/{patientId}/md5 | Check sumehr signature
[**importMedicationScheme**](BekmehrApi.md#importMedicationScheme) | **POST** /rest/v1/be_kmehr/medicationscheme/{documentId}/import | Import MedicationScheme into patient(s) using existing document
[**importSmf**](BekmehrApi.md#importSmf) | **POST** /rest/v1/be_kmehr/smf/{documentId}/import | Import SMF into patient(s) using existing document
[**importSumehr**](BekmehrApi.md#importSumehr) | **POST** /rest/v1/be_kmehr/sumehr/{documentId}/import | Import sumehr into patient(s) using existing document
[**importSumehrByItemId**](BekmehrApi.md#importSumehrByItemId) | **POST** /rest/v1/be_kmehr/sumehr/{documentId}/importbyitemid | Import sumehr into patient(s) using existing document
[**isSumehrV2Valid**](BekmehrApi.md#isSumehrV2Valid) | **POST** /rest/v1/be_kmehr/sumehrv2/{patientId}/valid | Get sumehr validity
[**isSumehrValid**](BekmehrApi.md#isSumehrValid) | **POST** /rest/v1/be_kmehr/sumehr/{patientId}/valid | Get sumehr validity
[**validateSumehr**](BekmehrApi.md#validateSumehr) | **POST** /rest/v1/be_kmehr/sumehr/{patientId}/validate | Validate sumehr
[**validateSumehrV2**](BekmehrApi.md#validateSumehrV2) | **POST** /rest/v1/be_kmehr/sumehrv2/{patientId}/validate | Validate sumehr

<a name="checkIfSMFPatientsExists"></a>
# **checkIfSMFPatientsExists**
> kotlin.Array&lt;CheckSMFPatientResult&gt; checkIfSMFPatientsExists(body, documentId, documentKey, patientId, language)

Check whether patients in SMF already exists in DB

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BekmehrApi()
val body : kotlin.collections.Map<kotlin.String, kotlin.Array<ImportMapping>> =  // kotlin.collections.Map<kotlin.String, kotlin.Array<ImportMapping>> | 
val documentId : kotlin.String = documentId_example // kotlin.String | 
val documentKey : kotlin.String = documentKey_example // kotlin.String | 
val patientId : kotlin.String = patientId_example // kotlin.String | 
val language : kotlin.String = language_example // kotlin.String | 
try {
    val result : kotlin.Array<CheckSMFPatientResult> = apiInstance.checkIfSMFPatientsExists(body, documentId, documentKey, patientId, language)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BekmehrApi#checkIfSMFPatientsExists")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BekmehrApi#checkIfSMFPatientsExists")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.Array&lt;ImportMapping&gt;&gt;**](kotlin.collections.Map.md)|  |
 **documentId** | **kotlin.String**|  |
 **documentKey** | **kotlin.String**|  | [optional]
 **patientId** | **kotlin.String**|  | [optional]
 **language** | **kotlin.String**|  | [optional]

### Return type

[**kotlin.Array&lt;CheckSMFPatientResult&gt;**](CheckSMFPatientResult.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="generateContactreportExport"></a>
# **generateContactreportExport**
> kotlin.Array&lt;kotlin.Byte&gt; generateContactreportExport(body, date, language, recipientNihii, recipientSsin, recipientFirstName, recipientLastName, mimeType, patientId, id)

Get Kmehr contactreport

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BekmehrApi()
val body : kotlin.Array<ByteArray> =  // kotlin.Array<ByteArray> | 
val date : kotlin.Long = 789 // kotlin.Long | 
val language : kotlin.String = language_example // kotlin.String | 
val recipientNihii : kotlin.String = recipientNihii_example // kotlin.String | 
val recipientSsin : kotlin.String = recipientSsin_example // kotlin.String | 
val recipientFirstName : kotlin.String = recipientFirstName_example // kotlin.String | 
val recipientLastName : kotlin.String = recipientLastName_example // kotlin.String | 
val mimeType : kotlin.String = mimeType_example // kotlin.String | 
val patientId : kotlin.String = patientId_example // kotlin.String | 
val id : kotlin.String = id_example // kotlin.String | 
try {
    val result : kotlin.Array<kotlin.Byte> = apiInstance.generateContactreportExport(body, date, language, recipientNihii, recipientSsin, recipientFirstName, recipientLastName, mimeType, patientId, id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BekmehrApi#generateContactreportExport")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BekmehrApi#generateContactreportExport")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**kotlin.Array&lt;ByteArray&gt;**](ByteArray.md)|  |
 **date** | **kotlin.Long**|  |
 **language** | **kotlin.String**|  |
 **recipientNihii** | **kotlin.String**|  |
 **recipientSsin** | **kotlin.String**|  |
 **recipientFirstName** | **kotlin.String**|  |
 **recipientLastName** | **kotlin.String**|  |
 **mimeType** | **kotlin.String**|  |
 **patientId** | **kotlin.String**|  |
 **id** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;kotlin.Byte&gt;**](kotlin.Array&lt;kotlin.Byte&gt;.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/octet-stream
 - **Accept**: application/octet-stream

<a name="generateDiaryNote"></a>
# **generateDiaryNote**
> kotlin.Array&lt;kotlin.Byte&gt; generateDiaryNote(body, language, patientId)

Generate diarynote

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BekmehrApi()
val body : DiaryNoteExportInfoDto =  // DiaryNoteExportInfoDto | 
val language : kotlin.String = language_example // kotlin.String | 
val patientId : kotlin.String = patientId_example // kotlin.String | 
try {
    val result : kotlin.Array<kotlin.Byte> = apiInstance.generateDiaryNote(body, language, patientId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BekmehrApi#generateDiaryNote")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BekmehrApi#generateDiaryNote")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**DiaryNoteExportInfoDto**](DiaryNoteExportInfoDto.md)|  |
 **language** | **kotlin.String**|  |
 **patientId** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;kotlin.Byte&gt;**](kotlin.Array&lt;kotlin.Byte&gt;.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/octet-stream

<a name="generateLabresultExport"></a>
# **generateLabresultExport**
> kotlin.Array&lt;kotlin.Byte&gt; generateLabresultExport(body, date, language, recipientNihii, recipientSsin, recipientFirstName, recipientLastName, mimeType, patientId, id)

Get Kmehr labresult

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BekmehrApi()
val body : kotlin.Array<ByteArray> =  // kotlin.Array<ByteArray> | 
val date : kotlin.Long = 789 // kotlin.Long | 
val language : kotlin.String = language_example // kotlin.String | 
val recipientNihii : kotlin.String = recipientNihii_example // kotlin.String | 
val recipientSsin : kotlin.String = recipientSsin_example // kotlin.String | 
val recipientFirstName : kotlin.String = recipientFirstName_example // kotlin.String | 
val recipientLastName : kotlin.String = recipientLastName_example // kotlin.String | 
val mimeType : kotlin.String = mimeType_example // kotlin.String | 
val patientId : kotlin.String = patientId_example // kotlin.String | 
val id : kotlin.String = id_example // kotlin.String | 
try {
    val result : kotlin.Array<kotlin.Byte> = apiInstance.generateLabresultExport(body, date, language, recipientNihii, recipientSsin, recipientFirstName, recipientLastName, mimeType, patientId, id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BekmehrApi#generateLabresultExport")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BekmehrApi#generateLabresultExport")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**kotlin.Array&lt;ByteArray&gt;**](ByteArray.md)|  |
 **date** | **kotlin.Long**|  |
 **language** | **kotlin.String**|  |
 **recipientNihii** | **kotlin.String**|  |
 **recipientSsin** | **kotlin.String**|  |
 **recipientFirstName** | **kotlin.String**|  |
 **recipientLastName** | **kotlin.String**|  |
 **mimeType** | **kotlin.String**|  |
 **patientId** | **kotlin.String**|  |
 **id** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;kotlin.Byte&gt;**](kotlin.Array&lt;kotlin.Byte&gt;.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/octet-stream
 - **Accept**: application/octet-stream

<a name="generateMedicationSchemeExport"></a>
# **generateMedicationSchemeExport**
> kotlin.Array&lt;kotlin.Byte&gt; generateMedicationSchemeExport(body, language, recipientSafe, version, patientId)

Get Medicationscheme export

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BekmehrApi()
val body : MedicationSchemeExportInfoDto =  // MedicationSchemeExportInfoDto | 
val language : kotlin.String = language_example // kotlin.String | 
val recipientSafe : kotlin.String = recipientSafe_example // kotlin.String | 
val version : kotlin.Int = 56 // kotlin.Int | 
val patientId : kotlin.String = patientId_example // kotlin.String | 
try {
    val result : kotlin.Array<kotlin.Byte> = apiInstance.generateMedicationSchemeExport(body, language, recipientSafe, version, patientId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BekmehrApi#generateMedicationSchemeExport")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BekmehrApi#generateMedicationSchemeExport")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**MedicationSchemeExportInfoDto**](MedicationSchemeExportInfoDto.md)|  |
 **language** | **kotlin.String**|  |
 **recipientSafe** | **kotlin.String**|  |
 **version** | **kotlin.Int**|  |
 **patientId** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;kotlin.Byte&gt;**](kotlin.Array&lt;kotlin.Byte&gt;.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/octet-stream

<a name="generateNoteExport"></a>
# **generateNoteExport**
> kotlin.Array&lt;kotlin.Byte&gt; generateNoteExport(body, date, language, recipientNihii, recipientSsin, recipientFirstName, recipientLastName, mimeType, patientId, id)

Get Kmehr note

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BekmehrApi()
val body : kotlin.Array<ByteArray> =  // kotlin.Array<ByteArray> | 
val date : kotlin.Long = 789 // kotlin.Long | 
val language : kotlin.String = language_example // kotlin.String | 
val recipientNihii : kotlin.String = recipientNihii_example // kotlin.String | 
val recipientSsin : kotlin.String = recipientSsin_example // kotlin.String | 
val recipientFirstName : kotlin.String = recipientFirstName_example // kotlin.String | 
val recipientLastName : kotlin.String = recipientLastName_example // kotlin.String | 
val mimeType : kotlin.String = mimeType_example // kotlin.String | 
val patientId : kotlin.String = patientId_example // kotlin.String | 
val id : kotlin.String = id_example // kotlin.String | 
try {
    val result : kotlin.Array<kotlin.Byte> = apiInstance.generateNoteExport(body, date, language, recipientNihii, recipientSsin, recipientFirstName, recipientLastName, mimeType, patientId, id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BekmehrApi#generateNoteExport")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BekmehrApi#generateNoteExport")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**kotlin.Array&lt;ByteArray&gt;**](ByteArray.md)|  |
 **date** | **kotlin.Long**|  |
 **language** | **kotlin.String**|  |
 **recipientNihii** | **kotlin.String**|  |
 **recipientSsin** | **kotlin.String**|  |
 **recipientFirstName** | **kotlin.String**|  |
 **recipientLastName** | **kotlin.String**|  |
 **mimeType** | **kotlin.String**|  |
 **patientId** | **kotlin.String**|  |
 **id** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;kotlin.Byte&gt;**](kotlin.Array&lt;kotlin.Byte&gt;.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/octet-stream
 - **Accept**: application/octet-stream

<a name="generatePrescriptionExport"></a>
# **generatePrescriptionExport**
> kotlin.Array&lt;kotlin.Byte&gt; generatePrescriptionExport(body, date, language, recipientNihii, recipientSsin, recipientFirstName, recipientLastName, mimeType, patientId, id)

Get Kmehr prescription

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BekmehrApi()
val body : kotlin.Array<ByteArray> =  // kotlin.Array<ByteArray> | 
val date : kotlin.Long = 789 // kotlin.Long | 
val language : kotlin.String = language_example // kotlin.String | 
val recipientNihii : kotlin.String = recipientNihii_example // kotlin.String | 
val recipientSsin : kotlin.String = recipientSsin_example // kotlin.String | 
val recipientFirstName : kotlin.String = recipientFirstName_example // kotlin.String | 
val recipientLastName : kotlin.String = recipientLastName_example // kotlin.String | 
val mimeType : kotlin.String = mimeType_example // kotlin.String | 
val patientId : kotlin.String = patientId_example // kotlin.String | 
val id : kotlin.String = id_example // kotlin.String | 
try {
    val result : kotlin.Array<kotlin.Byte> = apiInstance.generatePrescriptionExport(body, date, language, recipientNihii, recipientSsin, recipientFirstName, recipientLastName, mimeType, patientId, id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BekmehrApi#generatePrescriptionExport")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BekmehrApi#generatePrescriptionExport")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**kotlin.Array&lt;ByteArray&gt;**](ByteArray.md)|  |
 **date** | **kotlin.Long**|  |
 **language** | **kotlin.String**|  |
 **recipientNihii** | **kotlin.String**|  |
 **recipientSsin** | **kotlin.String**|  |
 **recipientFirstName** | **kotlin.String**|  |
 **recipientLastName** | **kotlin.String**|  |
 **mimeType** | **kotlin.String**|  |
 **patientId** | **kotlin.String**|  |
 **id** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;kotlin.Byte&gt;**](kotlin.Array&lt;kotlin.Byte&gt;.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/octet-stream
 - **Accept**: application/octet-stream

<a name="generateReportExport"></a>
# **generateReportExport**
> kotlin.Array&lt;kotlin.Byte&gt; generateReportExport(body, date, language, recipientNihii, recipientSsin, recipientFirstName, recipientLastName, mimeType, patientId, id)

Get Kmehr report

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BekmehrApi()
val body : kotlin.Array<ByteArray> =  // kotlin.Array<ByteArray> | 
val date : kotlin.Long = 789 // kotlin.Long | 
val language : kotlin.String = language_example // kotlin.String | 
val recipientNihii : kotlin.String = recipientNihii_example // kotlin.String | 
val recipientSsin : kotlin.String = recipientSsin_example // kotlin.String | 
val recipientFirstName : kotlin.String = recipientFirstName_example // kotlin.String | 
val recipientLastName : kotlin.String = recipientLastName_example // kotlin.String | 
val mimeType : kotlin.String = mimeType_example // kotlin.String | 
val patientId : kotlin.String = patientId_example // kotlin.String | 
val id : kotlin.String = id_example // kotlin.String | 
try {
    val result : kotlin.Array<kotlin.Byte> = apiInstance.generateReportExport(body, date, language, recipientNihii, recipientSsin, recipientFirstName, recipientLastName, mimeType, patientId, id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BekmehrApi#generateReportExport")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BekmehrApi#generateReportExport")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**kotlin.Array&lt;ByteArray&gt;**](ByteArray.md)|  |
 **date** | **kotlin.Long**|  |
 **language** | **kotlin.String**|  |
 **recipientNihii** | **kotlin.String**|  |
 **recipientSsin** | **kotlin.String**|  |
 **recipientFirstName** | **kotlin.String**|  |
 **recipientLastName** | **kotlin.String**|  |
 **mimeType** | **kotlin.String**|  |
 **patientId** | **kotlin.String**|  |
 **id** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;kotlin.Byte&gt;**](kotlin.Array&lt;kotlin.Byte&gt;.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/octet-stream
 - **Accept**: application/octet-stream

<a name="generateRequestExport"></a>
# **generateRequestExport**
> kotlin.Array&lt;kotlin.Byte&gt; generateRequestExport(body, date, language, recipientNihii, recipientSsin, recipientFirstName, recipientLastName, mimeType, patientId, id)

Get Kmehr request

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BekmehrApi()
val body : kotlin.Array<ByteArray> =  // kotlin.Array<ByteArray> | 
val date : kotlin.Long = 789 // kotlin.Long | 
val language : kotlin.String = language_example // kotlin.String | 
val recipientNihii : kotlin.String = recipientNihii_example // kotlin.String | 
val recipientSsin : kotlin.String = recipientSsin_example // kotlin.String | 
val recipientFirstName : kotlin.String = recipientFirstName_example // kotlin.String | 
val recipientLastName : kotlin.String = recipientLastName_example // kotlin.String | 
val mimeType : kotlin.String = mimeType_example // kotlin.String | 
val patientId : kotlin.String = patientId_example // kotlin.String | 
val id : kotlin.String = id_example // kotlin.String | 
try {
    val result : kotlin.Array<kotlin.Byte> = apiInstance.generateRequestExport(body, date, language, recipientNihii, recipientSsin, recipientFirstName, recipientLastName, mimeType, patientId, id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BekmehrApi#generateRequestExport")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BekmehrApi#generateRequestExport")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**kotlin.Array&lt;ByteArray&gt;**](ByteArray.md)|  |
 **date** | **kotlin.Long**|  |
 **language** | **kotlin.String**|  |
 **recipientNihii** | **kotlin.String**|  |
 **recipientSsin** | **kotlin.String**|  |
 **recipientFirstName** | **kotlin.String**|  |
 **recipientLastName** | **kotlin.String**|  |
 **mimeType** | **kotlin.String**|  |
 **patientId** | **kotlin.String**|  |
 **id** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;kotlin.Byte&gt;**](kotlin.Array&lt;kotlin.Byte&gt;.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/octet-stream
 - **Accept**: application/octet-stream

<a name="generateResultExport"></a>
# **generateResultExport**
> kotlin.Array&lt;kotlin.Byte&gt; generateResultExport(body, date, language, recipientNihii, recipientSsin, recipientFirstName, recipientLastName, mimeType, patientId, id)

Get Kmehr result

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BekmehrApi()
val body : kotlin.Array<ByteArray> =  // kotlin.Array<ByteArray> | 
val date : kotlin.Long = 789 // kotlin.Long | 
val language : kotlin.String = language_example // kotlin.String | 
val recipientNihii : kotlin.String = recipientNihii_example // kotlin.String | 
val recipientSsin : kotlin.String = recipientSsin_example // kotlin.String | 
val recipientFirstName : kotlin.String = recipientFirstName_example // kotlin.String | 
val recipientLastName : kotlin.String = recipientLastName_example // kotlin.String | 
val mimeType : kotlin.String = mimeType_example // kotlin.String | 
val patientId : kotlin.String = patientId_example // kotlin.String | 
val id : kotlin.String = id_example // kotlin.String | 
try {
    val result : kotlin.Array<kotlin.Byte> = apiInstance.generateResultExport(body, date, language, recipientNihii, recipientSsin, recipientFirstName, recipientLastName, mimeType, patientId, id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BekmehrApi#generateResultExport")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BekmehrApi#generateResultExport")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**kotlin.Array&lt;ByteArray&gt;**](ByteArray.md)|  |
 **date** | **kotlin.Long**|  |
 **language** | **kotlin.String**|  |
 **recipientNihii** | **kotlin.String**|  |
 **recipientSsin** | **kotlin.String**|  |
 **recipientFirstName** | **kotlin.String**|  |
 **recipientLastName** | **kotlin.String**|  |
 **mimeType** | **kotlin.String**|  |
 **patientId** | **kotlin.String**|  |
 **id** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;kotlin.Byte&gt;**](kotlin.Array&lt;kotlin.Byte&gt;.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/octet-stream
 - **Accept**: application/octet-stream

<a name="generateSmfExport"></a>
# **generateSmfExport**
> kotlin.Array&lt;kotlin.Byte&gt; generateSmfExport(body, language, patientId)

Get SMF (Software Medical File) export

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BekmehrApi()
val body : SoftwareMedicalFileExportDto =  // SoftwareMedicalFileExportDto | 
val language : kotlin.String = language_example // kotlin.String | 
val patientId : kotlin.String = patientId_example // kotlin.String | 
try {
    val result : kotlin.Array<kotlin.Byte> = apiInstance.generateSmfExport(body, language, patientId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BekmehrApi#generateSmfExport")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BekmehrApi#generateSmfExport")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**SoftwareMedicalFileExportDto**](SoftwareMedicalFileExportDto.md)|  |
 **language** | **kotlin.String**|  |
 **patientId** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;kotlin.Byte&gt;**](kotlin.Array&lt;kotlin.Byte&gt;.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/octet-stream

<a name="generateSumehr"></a>
# **generateSumehr**
> kotlin.Array&lt;kotlin.Byte&gt; generateSumehr(body, language, patientId)

Generate sumehr

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BekmehrApi()
val body : SumehrExportInfoDto =  // SumehrExportInfoDto | 
val language : kotlin.String = language_example // kotlin.String | 
val patientId : kotlin.String = patientId_example // kotlin.String | 
try {
    val result : kotlin.Array<kotlin.Byte> = apiInstance.generateSumehr(body, language, patientId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BekmehrApi#generateSumehr")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BekmehrApi#generateSumehr")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**SumehrExportInfoDto**](SumehrExportInfoDto.md)|  |
 **language** | **kotlin.String**|  |
 **patientId** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;kotlin.Byte&gt;**](kotlin.Array&lt;kotlin.Byte&gt;.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/octet-stream

<a name="generateSumehrV2"></a>
# **generateSumehrV2**
> kotlin.Array&lt;kotlin.Byte&gt; generateSumehrV2(body, language, patientId)

Generate sumehr

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BekmehrApi()
val body : SumehrExportInfoDto =  // SumehrExportInfoDto | 
val language : kotlin.String = language_example // kotlin.String | 
val patientId : kotlin.String = patientId_example // kotlin.String | 
try {
    val result : kotlin.Array<kotlin.Byte> = apiInstance.generateSumehrV2(body, language, patientId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BekmehrApi#generateSumehrV2")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BekmehrApi#generateSumehrV2")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**SumehrExportInfoDto**](SumehrExportInfoDto.md)|  |
 **language** | **kotlin.String**|  |
 **patientId** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;kotlin.Byte&gt;**](kotlin.Array&lt;kotlin.Byte&gt;.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/octet-stream

<a name="getSumehrContent"></a>
# **getSumehrContent**
> SumehrContentDto getSumehrContent(body, patientId)

Get sumehr elements

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BekmehrApi()
val body : SumehrExportInfoDto =  // SumehrExportInfoDto | 
val patientId : kotlin.String = patientId_example // kotlin.String | 
try {
    val result : SumehrContentDto = apiInstance.getSumehrContent(body, patientId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BekmehrApi#getSumehrContent")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BekmehrApi#getSumehrContent")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**SumehrExportInfoDto**](SumehrExportInfoDto.md)|  |
 **patientId** | **kotlin.String**|  |

### Return type

[**SumehrContentDto**](SumehrContentDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="getSumehrMd5"></a>
# **getSumehrMd5**
> ContentDto getSumehrMd5(body, patientId)

Check sumehr signature

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BekmehrApi()
val body : SumehrExportInfoDto =  // SumehrExportInfoDto | 
val patientId : kotlin.String = patientId_example // kotlin.String | 
try {
    val result : ContentDto = apiInstance.getSumehrMd5(body, patientId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BekmehrApi#getSumehrMd5")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BekmehrApi#getSumehrMd5")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**SumehrExportInfoDto**](SumehrExportInfoDto.md)|  |
 **patientId** | **kotlin.String**|  |

### Return type

[**ContentDto**](ContentDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="getSumehrV2Content"></a>
# **getSumehrV2Content**
> SumehrContentDto getSumehrV2Content(body, patientId)

Get sumehr elements

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BekmehrApi()
val body : SumehrExportInfoDto =  // SumehrExportInfoDto | 
val patientId : kotlin.String = patientId_example // kotlin.String | 
try {
    val result : SumehrContentDto = apiInstance.getSumehrV2Content(body, patientId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BekmehrApi#getSumehrV2Content")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BekmehrApi#getSumehrV2Content")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**SumehrExportInfoDto**](SumehrExportInfoDto.md)|  |
 **patientId** | **kotlin.String**|  |

### Return type

[**SumehrContentDto**](SumehrContentDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="getSumehrV2Md5"></a>
# **getSumehrV2Md5**
> ContentDto getSumehrV2Md5(body, patientId)

Check sumehr signature

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BekmehrApi()
val body : SumehrExportInfoDto =  // SumehrExportInfoDto | 
val patientId : kotlin.String = patientId_example // kotlin.String | 
try {
    val result : ContentDto = apiInstance.getSumehrV2Md5(body, patientId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BekmehrApi#getSumehrV2Md5")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BekmehrApi#getSumehrV2Md5")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**SumehrExportInfoDto**](SumehrExportInfoDto.md)|  |
 **patientId** | **kotlin.String**|  |

### Return type

[**ContentDto**](ContentDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="importMedicationScheme"></a>
# **importMedicationScheme**
> kotlin.Array&lt;ImportResultDto&gt; importMedicationScheme(body, documentId, documentKey, dryRun, patientId, language)

Import MedicationScheme into patient(s) using existing document

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BekmehrApi()
val body : kotlin.collections.Map<kotlin.String, kotlin.Array<ImportMapping>> =  // kotlin.collections.Map<kotlin.String, kotlin.Array<ImportMapping>> | 
val documentId : kotlin.String = documentId_example // kotlin.String | 
val documentKey : kotlin.String = documentKey_example // kotlin.String | 
val dryRun : kotlin.Boolean = true // kotlin.Boolean | Dry run: do not save in database
val patientId : kotlin.String = patientId_example // kotlin.String | 
val language : kotlin.String = language_example // kotlin.String | 
try {
    val result : kotlin.Array<ImportResultDto> = apiInstance.importMedicationScheme(body, documentId, documentKey, dryRun, patientId, language)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BekmehrApi#importMedicationScheme")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BekmehrApi#importMedicationScheme")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.Array&lt;ImportMapping&gt;&gt;**](kotlin.collections.Map.md)|  |
 **documentId** | **kotlin.String**|  |
 **documentKey** | **kotlin.String**|  | [optional]
 **dryRun** | **kotlin.Boolean**| Dry run: do not save in database | [optional]
 **patientId** | **kotlin.String**|  | [optional]
 **language** | **kotlin.String**|  | [optional]

### Return type

[**kotlin.Array&lt;ImportResultDto&gt;**](ImportResultDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="importSmf"></a>
# **importSmf**
> kotlin.Array&lt;ImportResultDto&gt; importSmf(body, documentId, documentKey, patientId, language)

Import SMF into patient(s) using existing document

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BekmehrApi()
val body : kotlin.collections.Map<kotlin.String, kotlin.Array<ImportMapping>> =  // kotlin.collections.Map<kotlin.String, kotlin.Array<ImportMapping>> | 
val documentId : kotlin.String = documentId_example // kotlin.String | 
val documentKey : kotlin.String = documentKey_example // kotlin.String | 
val patientId : kotlin.String = patientId_example // kotlin.String | 
val language : kotlin.String = language_example // kotlin.String | 
try {
    val result : kotlin.Array<ImportResultDto> = apiInstance.importSmf(body, documentId, documentKey, patientId, language)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BekmehrApi#importSmf")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BekmehrApi#importSmf")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.Array&lt;ImportMapping&gt;&gt;**](kotlin.collections.Map.md)|  |
 **documentId** | **kotlin.String**|  |
 **documentKey** | **kotlin.String**|  | [optional]
 **patientId** | **kotlin.String**|  | [optional]
 **language** | **kotlin.String**|  | [optional]

### Return type

[**kotlin.Array&lt;ImportResultDto&gt;**](ImportResultDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="importSumehr"></a>
# **importSumehr**
> kotlin.Array&lt;ImportResultDto&gt; importSumehr(body, documentId, documentKey, dryRun, patientId, language)

Import sumehr into patient(s) using existing document

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BekmehrApi()
val body : kotlin.collections.Map<kotlin.String, kotlin.Array<ImportMapping>> =  // kotlin.collections.Map<kotlin.String, kotlin.Array<ImportMapping>> | 
val documentId : kotlin.String = documentId_example // kotlin.String | 
val documentKey : kotlin.String = documentKey_example // kotlin.String | 
val dryRun : kotlin.Boolean = true // kotlin.Boolean | Dry run: do not save in database
val patientId : kotlin.String = patientId_example // kotlin.String | 
val language : kotlin.String = language_example // kotlin.String | 
try {
    val result : kotlin.Array<ImportResultDto> = apiInstance.importSumehr(body, documentId, documentKey, dryRun, patientId, language)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BekmehrApi#importSumehr")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BekmehrApi#importSumehr")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.Array&lt;ImportMapping&gt;&gt;**](kotlin.collections.Map.md)|  |
 **documentId** | **kotlin.String**|  |
 **documentKey** | **kotlin.String**|  | [optional]
 **dryRun** | **kotlin.Boolean**| Dry run: do not save in database | [optional]
 **patientId** | **kotlin.String**|  | [optional]
 **language** | **kotlin.String**|  | [optional]

### Return type

[**kotlin.Array&lt;ImportResultDto&gt;**](ImportResultDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="importSumehrByItemId"></a>
# **importSumehrByItemId**
> kotlin.Array&lt;ImportResultDto&gt; importSumehrByItemId(body, itemId, documentId, documentKey, dryRun, patientId, language)

Import sumehr into patient(s) using existing document

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BekmehrApi()
val body : kotlin.collections.Map<kotlin.String, kotlin.Array<ImportMapping>> =  // kotlin.collections.Map<kotlin.String, kotlin.Array<ImportMapping>> | 
val itemId : kotlin.String = itemId_example // kotlin.String | 
val documentId : kotlin.String = documentId_example // kotlin.String | 
val documentKey : kotlin.String = documentKey_example // kotlin.String | 
val dryRun : kotlin.Boolean = true // kotlin.Boolean | Dry run: do not save in database
val patientId : kotlin.String = patientId_example // kotlin.String | 
val language : kotlin.String = language_example // kotlin.String | 
try {
    val result : kotlin.Array<ImportResultDto> = apiInstance.importSumehrByItemId(body, itemId, documentId, documentKey, dryRun, patientId, language)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BekmehrApi#importSumehrByItemId")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BekmehrApi#importSumehrByItemId")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.Array&lt;ImportMapping&gt;&gt;**](kotlin.collections.Map.md)|  |
 **itemId** | **kotlin.String**|  |
 **documentId** | **kotlin.String**|  |
 **documentKey** | **kotlin.String**|  | [optional]
 **dryRun** | **kotlin.Boolean**| Dry run: do not save in database | [optional]
 **patientId** | **kotlin.String**|  | [optional]
 **language** | **kotlin.String**|  | [optional]

### Return type

[**kotlin.Array&lt;ImportResultDto&gt;**](ImportResultDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="isSumehrV2Valid"></a>
# **isSumehrV2Valid**
> SumehrValidityDto isSumehrV2Valid(body, patientId)

Get sumehr validity

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BekmehrApi()
val body : SumehrExportInfoDto =  // SumehrExportInfoDto | 
val patientId : kotlin.String = patientId_example // kotlin.String | 
try {
    val result : SumehrValidityDto = apiInstance.isSumehrV2Valid(body, patientId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BekmehrApi#isSumehrV2Valid")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BekmehrApi#isSumehrV2Valid")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**SumehrExportInfoDto**](SumehrExportInfoDto.md)|  |
 **patientId** | **kotlin.String**|  |

### Return type

[**SumehrValidityDto**](SumehrValidityDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="isSumehrValid"></a>
# **isSumehrValid**
> SumehrValidityDto isSumehrValid(body, patientId)

Get sumehr validity

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BekmehrApi()
val body : SumehrExportInfoDto =  // SumehrExportInfoDto | 
val patientId : kotlin.String = patientId_example // kotlin.String | 
try {
    val result : SumehrValidityDto = apiInstance.isSumehrValid(body, patientId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BekmehrApi#isSumehrValid")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BekmehrApi#isSumehrValid")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**SumehrExportInfoDto**](SumehrExportInfoDto.md)|  |
 **patientId** | **kotlin.String**|  |

### Return type

[**SumehrValidityDto**](SumehrValidityDto.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="validateSumehr"></a>
# **validateSumehr**
> kotlin.Array&lt;kotlin.Byte&gt; validateSumehr(body, language, patientId)

Validate sumehr

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BekmehrApi()
val body : SumehrExportInfoDto =  // SumehrExportInfoDto | 
val language : kotlin.String = language_example // kotlin.String | 
val patientId : kotlin.String = patientId_example // kotlin.String | 
try {
    val result : kotlin.Array<kotlin.Byte> = apiInstance.validateSumehr(body, language, patientId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BekmehrApi#validateSumehr")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BekmehrApi#validateSumehr")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**SumehrExportInfoDto**](SumehrExportInfoDto.md)|  |
 **language** | **kotlin.String**|  |
 **patientId** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;kotlin.Byte&gt;**](kotlin.Array&lt;kotlin.Byte&gt;.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/octet-stream

<a name="validateSumehrV2"></a>
# **validateSumehrV2**
> kotlin.Array&lt;kotlin.Byte&gt; validateSumehrV2(body, language, patientId)

Validate sumehr

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BekmehrApi()
val body : SumehrExportInfoDto =  // SumehrExportInfoDto | 
val language : kotlin.String = language_example // kotlin.String | 
val patientId : kotlin.String = patientId_example // kotlin.String | 
try {
    val result : kotlin.Array<kotlin.Byte> = apiInstance.validateSumehrV2(body, language, patientId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BekmehrApi#validateSumehrV2")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BekmehrApi#validateSumehrV2")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**SumehrExportInfoDto**](SumehrExportInfoDto.md)|  |
 **language** | **kotlin.String**|  |
 **patientId** | **kotlin.String**|  |

### Return type

[**kotlin.Array&lt;kotlin.Byte&gt;**](kotlin.Array&lt;kotlin.Byte&gt;.md)

### Authorization

[basicScheme](../README.md#basicScheme)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/octet-stream

