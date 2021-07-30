
# VmpGroupDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **kotlin.String** |  | 
**rev** | **kotlin.String** |  |  [optional]
**deletionDate** | **kotlin.Long** | hard delete (unix epoch in ms) timestamp of the object. Filled automatically when deletePatient is called. |  [optional]
**from** | **kotlin.Long** |  |  [optional]
**to** | **kotlin.Long** |  |  [optional]
**productId** | **kotlin.String** |  |  [optional]
**code** | **kotlin.String** |  |  [optional]
**name** | [**SamTextDto**](SamTextDto.md) |  |  [optional]
**noGenericPrescriptionReason** | [**NoGenericPrescriptionReasonDto**](NoGenericPrescriptionReasonDto.md) |  |  [optional]
**noSwitchReason** | [**NoSwitchReasonDto**](NoSwitchReasonDto.md) |  |  [optional]



