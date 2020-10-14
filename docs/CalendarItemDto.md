# CalendarItemDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | [**kotlin.String**](.md) |  | 
**rev** | [**kotlin.String**](.md) |  |  [optional]
**created** | [**kotlin.Long**](.md) |  |  [optional]
**modified** | [**kotlin.Long**](.md) |  |  [optional]
**author** | [**kotlin.String**](.md) |  |  [optional]
**responsible** | [**kotlin.String**](.md) |  |  [optional]
**medicalLocationId** | [**kotlin.String**](.md) |  |  [optional]
**tags** | [**kotlin.Array&lt;CodeStubDto&gt;**](CodeStubDto.md) |  | 
**codes** | [**kotlin.Array&lt;CodeStubDto&gt;**](CodeStubDto.md) |  | 
**endOfLife** | [**kotlin.Long**](.md) |  |  [optional]
**deletionDate** | [**kotlin.Long**](.md) |  |  [optional]
**title** | [**kotlin.String**](.md) |  |  [optional]
**calendarItemTypeId** | [**kotlin.String**](.md) |  |  [optional]
**masterCalendarItemId** | [**kotlin.String**](.md) |  |  [optional]
**patientId** | [**kotlin.String**](.md) |  |  [optional]
**important** | [**kotlin.Boolean**](.md) |  |  [optional]
**homeVisit** | [**kotlin.Boolean**](.md) |  |  [optional]
**phoneNumber** | [**kotlin.String**](.md) |  |  [optional]
**placeId** | [**kotlin.String**](.md) |  |  [optional]
**address** | [**AddressDto**](AddressDto.md) |  |  [optional]
**addressText** | [**kotlin.String**](.md) |  |  [optional]
**startTime** | [**kotlin.Long**](.md) |  |  [optional]
**endTime** | [**kotlin.Long**](.md) |  |  [optional]
**confirmationTime** | [**kotlin.Long**](.md) |  |  [optional]
**confirmationId** | [**kotlin.String**](.md) |  |  [optional]
**duration** | [**kotlin.Long**](.md) |  |  [optional]
**allDay** | [**kotlin.Boolean**](.md) |  |  [optional]
**details** | [**kotlin.String**](.md) |  |  [optional]
**wasMigrated** | [**kotlin.Boolean**](.md) |  |  [optional]
**agendaId** | [**kotlin.String**](.md) |  |  [optional]
**meetingTags** | [**kotlin.Array&lt;CalendarItemTagDto&gt;**](CalendarItemTagDto.md) |  | 
**flowItem** | [**FlowItemDto**](FlowItemDto.md) |  |  [optional]
**secretForeignKeys** | [**kotlin.Array&lt;kotlin.String&gt;**](.md) |  | 
**cryptedForeignKeys** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.Array&lt;DelegationDto&gt;&gt;**](.md) |  | 
**delegations** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.Array&lt;DelegationDto&gt;&gt;**](.md) |  | 
**encryptionKeys** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.Array&lt;DelegationDto&gt;&gt;**](.md) |  | 
**encryptedSelf** | [**kotlin.String**](.md) |  |  [optional]
