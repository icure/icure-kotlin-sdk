
# VmpDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **kotlin.String** |  | 
**rev** | **kotlin.String** |  |  [optional]
**deletionDate** | **kotlin.Long** | hard delete (unix epoch in ms) timestamp of the object. Filled automatically when deletePatient is called. |  [optional]
**from** | **kotlin.Long** |  |  [optional]
**to** | **kotlin.Long** |  |  [optional]
**code** | **kotlin.String** |  |  [optional]
**vmpGroup** | [**VmpGroupStubDto**](VmpGroupStubDto.md) |  |  [optional]
**name** | [**SamTextDto**](SamTextDto.md) |  |  [optional]
**abbreviation** | [**SamTextDto**](SamTextDto.md) |  |  [optional]
**vtm** | [**VtmDto**](VtmDto.md) |  |  [optional]
**wadas** | [**kotlin.collections.List&lt;WadaDto&gt;**](WadaDto.md) |  |  [optional]
**components** | [**kotlin.collections.List&lt;VmpComponentDto&gt;**](VmpComponentDto.md) |  |  [optional]
**commentedClassifications** | [**kotlin.collections.List&lt;CommentedClassificationDto&gt;**](CommentedClassificationDto.md) |  |  [optional]



