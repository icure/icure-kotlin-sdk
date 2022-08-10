
# SubstanceDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **kotlin.String** |  |
**rev** | **kotlin.String** |  |  [optional]
**deletionDate** | **kotlin.Long** | hard delete (unix epoch in ms) timestamp of the object. Filled automatically when deletePatient is called. |  [optional]
**code** | **kotlin.String** |  |  [optional]
**chemicalForm** | **kotlin.String** |  |  [optional]
**name** | [**SamTextDto**](SamTextDto.md) |  |  [optional]
**note** | [**SamTextDto**](SamTextDto.md) |  |  [optional]
**standardSubstances** | [**kotlin.collections.List&lt;StandardSubstanceDto&gt;**](StandardSubstanceDto.md) |  |  [optional]
