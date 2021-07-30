
# SubContactDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**tags** | [**kotlin.collections.Set&lt;CodeStubDto&gt;**](CodeStubDto.md) | A tag is an item from a codification system that qualifies an entity as being member of a certain class, whatever the value it might have taken. If the tag qualifies the content of a field, it means that whatever the content of the field, the tag will always apply. For example, the label of a field is qualified using a tag. LOINC is a codification system typically used for tags. | 
**codes** | [**kotlin.collections.Set&lt;CodeStubDto&gt;**](CodeStubDto.md) | A code is an item from a codification system that qualifies the content of this entity. SNOMED-CT, ICPC-2 or ICD-10 codifications systems can be used for codes | 
**services** | [**kotlin.collections.List&lt;ServiceLinkDto&gt;**](ServiceLinkDto.md) | List of all services provided to the patient under a given contact which is linked by this sub-contact to other structuring elements. | 
**id** | **kotlin.String** | The Id of the sub-contact. We encourage using either a v4 UUID or a HL7 Id. |  [optional]
**created** | **kotlin.Long** | The timestamp (unix epoch in ms) of creation of this entity, will be filled automatically if missing. Not enforced by the application server. |  [optional]
**modified** | **kotlin.Long** | The date (unix epoch in ms) of the latest modification of this entity, will be filled automatically if missing. Not enforced by the application server. |  [optional]
**author** | **kotlin.String** | The id of the User that has created this entity, will be filled automatically if missing. Not enforced by the application server. |  [optional]
**responsible** | **kotlin.String** | The id of the HealthcareParty that is responsible for this entity, will be filled automatically if missing. Not enforced by the application server. |  [optional]
**medicalLocationId** | **kotlin.String** | The id of the medical location where this entity was created. |  [optional]
**endOfLife** | **kotlin.Long** | Soft delete (unix epoch in ms) timestamp of the object. |  [optional]
**descr** | **kotlin.String** | Description of the sub-contact |  [optional]
**protocol** | **kotlin.String** | Protocol based on which the sub-contact was used for linking services to structuring elements |  [optional]
**status** | **kotlin.Int** |  |  [optional]
**formId** | **kotlin.String** | Id of the form used in the sub-contact. Several sub-contacts with the same form ID can coexist as long as they are in different contacts or they relate to a different planOfActionID |  [optional]
**planOfActionId** | **kotlin.String** | Id of the plan of action (healthcare approach) that is linked by the sub-contact to a service. |  [optional]
**healthElementId** | **kotlin.String** | Id of the healthcare element that is linked by the sub-contact to a service |  [optional]
**classificationId** | **kotlin.String** |  |  [optional]
**encryptedSelf** | **kotlin.String** | The base64 encoded data of this object, formatted as JSON and encrypted in AES using the random master key from encryptionKeys. |  [optional]



