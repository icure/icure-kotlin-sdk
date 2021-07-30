
# InsuranceDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **kotlin.String** |  | 
**name** | **kotlin.collections.Map&lt;kotlin.String, kotlin.String&gt;** |  | 
**privateInsurance** | **kotlin.Boolean** |  | 
**hospitalisationInsurance** | **kotlin.Boolean** |  | 
**ambulatoryInsurance** | **kotlin.Boolean** |  | 
**address** | [**AddressDto**](AddressDto.md) |  | 
**rev** | **kotlin.String** |  |  [optional]
**deletionDate** | **kotlin.Long** | hard delete (unix epoch in ms) timestamp of the object. Filled automatically when deletePatient is called. |  [optional]
**code** | **kotlin.String** |  |  [optional]
**agreementNumber** | **kotlin.String** |  |  [optional]
**parent** | **kotlin.String** |  |  [optional]



