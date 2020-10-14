# AmpDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | [**kotlin.String**](.md) |  | 
**rev** | [**kotlin.String**](.md) |  |  [optional]
**deletionDate** | [**kotlin.Long**](.md) |  |  [optional]
**from** | [**kotlin.Long**](.md) |  |  [optional]
**to** | [**kotlin.Long**](.md) |  |  [optional]
**code** | [**kotlin.String**](.md) |  |  [optional]
**vmp** | [**VmpStubDto**](VmpStubDto.md) |  |  [optional]
**officialName** | [**kotlin.String**](.md) |  |  [optional]
**status** | [**inline**](#StatusEnum) |  |  [optional]
**name** | [**SamTextDto**](SamTextDto.md) |  |  [optional]
**blackTriangle** | [**kotlin.Boolean**](.md) |  | 
**medicineType** | [**inline**](#MedicineTypeEnum) |  |  [optional]
**company** | [**CompanyDto**](CompanyDto.md) |  |  [optional]
**abbreviatedName** | [**SamTextDto**](SamTextDto.md) |  |  [optional]
**proprietarySuffix** | [**SamTextDto**](SamTextDto.md) |  |  [optional]
**prescriptionName** | [**SamTextDto**](SamTextDto.md) |  |  [optional]
**ampps** | [**kotlin.Array&lt;AmppDto&gt;**](AmppDto.md) |  | 
**components** | [**kotlin.Array&lt;AmpComponentDto&gt;**](AmpComponentDto.md) |  | 

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
