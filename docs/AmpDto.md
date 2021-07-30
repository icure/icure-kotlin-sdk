
# AmpDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **kotlin.String** |  | 
**blackTriangle** | **kotlin.Boolean** |  | 
**ampps** | [**kotlin.collections.List&lt;AmppDto&gt;**](AmppDto.md) |  | 
**components** | [**kotlin.collections.List&lt;AmpComponentDto&gt;**](AmpComponentDto.md) |  | 
**rev** | **kotlin.String** |  |  [optional]
**deletionDate** | **kotlin.Long** | hard delete (unix epoch in ms) timestamp of the object. Filled automatically when deletePatient is called. |  [optional]
**from** | **kotlin.Long** |  |  [optional]
**to** | **kotlin.Long** |  |  [optional]
**code** | **kotlin.String** |  |  [optional]
**vmp** | [**VmpStubDto**](VmpStubDto.md) |  |  [optional]
**officialName** | **kotlin.String** |  |  [optional]
**status** | [**inline**](#StatusEnum) |  |  [optional]
**name** | [**SamTextDto**](SamTextDto.md) |  |  [optional]
**medicineType** | [**inline**](#MedicineTypeEnum) |  |  [optional]
**company** | [**CompanyDto**](CompanyDto.md) |  |  [optional]
**abbreviatedName** | [**SamTextDto**](SamTextDto.md) |  |  [optional]
**proprietarySuffix** | [**SamTextDto**](SamTextDto.md) |  |  [optional]
**prescriptionName** | [**SamTextDto**](SamTextDto.md) |  |  [optional]


<a name="StatusEnum"></a>
## Enum: status
Name | Value
---- | -----
status | AUTHORIZED, SUSPENDED, REVOKED


<a name="MedicineTypeEnum"></a>
## Enum: medicineType
Name | Value
---- | -----
medicineType | ALLOPATHIC, HOMEOPATHIC



