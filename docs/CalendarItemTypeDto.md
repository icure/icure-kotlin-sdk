
# CalendarItemTypeDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **kotlin.String** |  |
**duration** | **kotlin.Int** |  |
**docIds** | **kotlin.collections.Set&lt;kotlin.String&gt;** |  |
**otherInfos** | **kotlin.collections.Map&lt;kotlin.String, kotlin.String&gt;** |  |
**subjectByLanguage** | **kotlin.collections.Map&lt;kotlin.String, kotlin.String&gt;** |  |
**rev** | **kotlin.String** |  |  [optional]
**deletionDate** | **kotlin.Long** | hard delete (unix epoch in ms) timestamp of the object. Filled automatically when deletePatient is called. |  [optional]
**name** | **kotlin.String** |  |  [optional]
**color** | **kotlin.String** |  |  [optional]
**externalRef** | **kotlin.String** |  |  [optional]
**mikronoId** | **kotlin.String** |  |  [optional]
