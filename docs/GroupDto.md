
# GroupDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **kotlin.String** | The id of the group. We encourage using either a v4 UUID or a HL7 Id. | 
**superAdmin** | **kotlin.Boolean** | Whether the group has a super admin permission, originally set to no access. | 
**properties** | [**kotlin.collections.Set&lt;PropertyStubDto&gt;**](PropertyStubDto.md) | Extra properties for the user. Those properties are typed (see class Property) | 
**rev** | **kotlin.String** | The revision of the group in the database, used for conflict management / optimistic locking. |  [optional]
**deletionDate** | **kotlin.Long** | hard delete (unix epoch in ms) timestamp of the object. Filled automatically when deletePatient is called. |  [optional]
**name** | **kotlin.String** | Username for the group |  [optional]
**password** | **kotlin.String** | Password for the group access |  [optional]
**servers** | **kotlin.collections.List&lt;kotlin.String&gt;** | List of servers accessible to the group |  [optional]
**superGroup** | **kotlin.String** |  |  [optional]



