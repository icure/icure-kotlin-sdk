
# PlanOfActionDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **kotlin.String** |  | 
**tags** | [**kotlin.collections.Set&lt;CodeStubDto&gt;**](CodeStubDto.md) | A tag is an item from a codification system that qualifies an entity as being member of a certain class, whatever the value it might have taken. If the tag qualifies the content of a field, it means that whatever the content of the field, the tag will always apply. For example, the label of a field is qualified using a tag. LOINC is a codification system typically used for tags. | 
**codes** | [**kotlin.collections.Set&lt;CodeStubDto&gt;**](CodeStubDto.md) | A code is an item from a codification system that qualifies the content of this entity. SNOMED-CT, ICPC-2 or ICD-10 codifications systems can be used for codes | 
**status** | **kotlin.Int** | bit 0: active/inactive, bit 1: relevant/irrelevant, bit 2 : present/absent, ex: 0 &#x3D; active,relevant and present | 
**documentIds** | **kotlin.collections.Set&lt;kotlin.String&gt;** |  | 
**careTeamMemberships** | [**kotlin.collections.List&lt;CareTeamMembershipDto&gt;**](CareTeamMembershipDto.md) | Members of the careteam involved in this approach | 
**relevant** | **kotlin.Boolean** |  | 
**created** | **kotlin.Long** | The timestamp (unix epoch in ms) of creation of this entity, will be filled automatically if missing. Not enforced by the application server. |  [optional]
**modified** | **kotlin.Long** | The date (unix epoch in ms) of the latest modification of this entity, will be filled automatically if missing. Not enforced by the application server. |  [optional]
**author** | **kotlin.String** | The id of the User that has created this entity, will be filled automatically if missing. Not enforced by the application server. |  [optional]
**responsible** | **kotlin.String** | The id of the HealthcareParty that is responsible for this entity, will be filled automatically if missing. Not enforced by the application server. |  [optional]
**medicalLocationId** | **kotlin.String** | The id of the medical location where this entity was created. |  [optional]
**endOfLife** | **kotlin.Long** | Soft delete (unix epoch in ms) timestamp of the object. |  [optional]
**prescriberId** | **kotlin.String** | The id of the hcp who prescribed this healthcare approach |  [optional]
**valueDate** | **kotlin.Long** | The date (unix epoch in ms) when the healthcare approach is noted to have started and also closes on the same date |  [optional]
**openingDate** | **kotlin.Long** | The date (unix epoch in ms) of the start of the healthcare approach. |  [optional]
**closingDate** | **kotlin.Long** | The date (unix epoch in ms) marking the end of the healthcare approach. |  [optional]
**deadlineDate** | **kotlin.Long** | The date (unix epoch in ms) when the healthcare approach has to be carried out. |  [optional]
**name** | **kotlin.String** | The name of the healthcare approach. |  [optional]
**descr** | **kotlin.String** | Description of the healthcare approach. |  [optional]
**note** | **kotlin.String** | Note about the healthcare approach. |  [optional]
**idOpeningContact** | **kotlin.String** | Id of the opening contact when the healthcare approach was created. |  [optional]
**idClosingContact** | **kotlin.String** | Id of the closing contact for the healthcare approach. |  [optional]
**numberOfCares** | **kotlin.Int** | The number of individual cares already performed in the course of this healthcare approach |  [optional]
**encryptedSelf** | **kotlin.String** | The base64 encoded data of this object, formatted as JSON and encrypted in AES using the random master key from encryptionKeys. |  [optional]



