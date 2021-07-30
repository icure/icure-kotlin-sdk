
# MedicalLocationDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **kotlin.String** |  | 
**agendaIds** | **kotlin.collections.Set&lt;kotlin.String&gt;** |  | 
**options** | **kotlin.collections.Map&lt;kotlin.String, kotlin.String&gt;** |  | 
**rev** | **kotlin.String** |  |  [optional]
**deletionDate** | **kotlin.Long** | hard delete (unix epoch in ms) timestamp of the object. Filled automatically when deletePatient is called. |  [optional]
**name** | **kotlin.String** |  |  [optional]
**description** | **kotlin.String** |  |  [optional]
**responsible** | **kotlin.String** |  |  [optional]
**guardPost** | **kotlin.Boolean** |  |  [optional]
**cbe** | **kotlin.String** |  |  [optional]
**bic** | **kotlin.String** |  |  [optional]
**bankAccount** | **kotlin.String** |  |  [optional]
**nihii** | **kotlin.String** |  |  [optional]
**ssin** | **kotlin.String** |  |  [optional]
**address** | [**AddressDto**](AddressDto.md) |  |  [optional]



