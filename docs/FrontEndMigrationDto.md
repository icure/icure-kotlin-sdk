
# FrontEndMigrationDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **kotlin.String** |  | 
**properties** | [**kotlin.collections.Set&lt;PropertyStubDto&gt;**](PropertyStubDto.md) | Extra properties for the fem. Those properties are typed (see class Property) | 
**rev** | **kotlin.String** |  |  [optional]
**deletionDate** | **kotlin.Long** | hard delete (unix epoch in ms) timestamp of the object. Filled automatically when deletePatient is called. |  [optional]
**name** | **kotlin.String** |  |  [optional]
**startDate** | **kotlin.Long** |  |  [optional]
**endDate** | **kotlin.Long** |  |  [optional]
**status** | [**inline**](#StatusEnum) |  |  [optional]
**logs** | **kotlin.String** |  |  [optional]
**userId** | **kotlin.String** |  |  [optional]
**startKey** | **kotlin.String** |  |  [optional]
**startKeyDocId** | **kotlin.String** |  |  [optional]
**processCount** | **kotlin.Long** |  |  [optional]


<a name="StatusEnum"></a>
## Enum: status
Name | Value
---- | -----
status | STARTED, PAUSED, ERROR, SUCCESS



