
# MessageDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **kotlin.String** | The ID of the message. We encourage using either a v4 UUID or a HL7 Id. | 
**tags** | [**kotlin.collections.Set&lt;CodeStubDto&gt;**](CodeStubDto.md) | A tag is an item from a codification system that qualifies an entity as being member of a certain class, whatever the value it might have taken. If the tag qualifies the content of a field, it means that whatever the content of the field, the tag will always apply. For example, the label of a field is qualified using a tag. LOINC is a codification system typically used for tags. | 
**codes** | [**kotlin.collections.Set&lt;CodeStubDto&gt;**](CodeStubDto.md) | A code is an item from a codification system that qualifies the content of this entity. SNOMED-CT, ICPC-2 or ICD-10 codifications systems can be used for codes | 
**recipients** | **kotlin.collections.Set&lt;kotlin.String&gt;** | List of IDs of healthcare parties to whom the message is addressed | 
**toAddresses** | **kotlin.collections.Set&lt;kotlin.String&gt;** | The address of the recipient of the message. Format is of an email address with extra domains defined for mycarenet and ehealth: (efact.mycarenet.be/eattest.mycarenet.be/chapter4.mycarenet.be/ehbox.ehealth.fgov.be) | 
**metas** | **kotlin.collections.Map&lt;kotlin.String, kotlin.String&gt;** |  | 
**readStatus** | [**kotlin.collections.Map&lt;kotlin.String, MessageReadStatusDto&gt;**](MessageReadStatusDto.md) | Status showing whether the message is read or not and the time of reading | 
**invoiceIds** | **kotlin.collections.Set&lt;kotlin.String&gt;** | Set of IDs for invoices in the message | 
**unassignedResults** | **kotlin.collections.Set&lt;kotlin.String&gt;** |  | 
**assignedResults** | **kotlin.collections.Map&lt;kotlin.String, kotlin.String&gt;** |  | 
**senderReferences** | **kotlin.collections.Map&lt;kotlin.String, kotlin.String&gt;** |  | 
**secretForeignKeys** | **kotlin.collections.Set&lt;kotlin.String&gt;** | The secretForeignKeys are filled at the to many end of a one to many relationship (for example inside Contact for the Patient -&gt; Contacts relationship). Used when we want to find all contacts for a specific patient. These keys are in clear. You can have several to partition the medical document space. | 
**cryptedForeignKeys** | **kotlin.collections.Map&lt;kotlin.String, kotlin.collections.Set&lt;DelegationDto&gt;&gt;** | The secretForeignKeys are filled at the to many end of a one to many relationship (for example inside Contact for the Patient -&gt; Contacts relationship). Used when we want to find the patient for a specific contact. These keys are the encrypted id (using the hcParty key for the delegate) that can be found in clear inside the patient. ids encrypted using the hcParty keys. | 
**delegations** | **kotlin.collections.Map&lt;kotlin.String, kotlin.collections.Set&lt;DelegationDto&gt;&gt;** | When a document is created, the responsible generates a cryptographically random master key (never to be used for something else than referencing from other entities). He/she encrypts it using his own AES exchange key and stores it as a delegation. The responsible is thus always in the delegations as well | 
**encryptionKeys** | **kotlin.collections.Map&lt;kotlin.String, kotlin.collections.Set&lt;DelegationDto&gt;&gt;** | When a document needs to be encrypted, the responsible generates a cryptographically random master key (different from the delegation key, never to appear in clear anywhere in the db. He/she encrypts it using his own AES exchange key and stores it as a delegation | 
**rev** | **kotlin.String** | The revision of the message in the database, used for conflict management / optimistic locking. |  [optional]
**created** | **kotlin.Long** | The timestamp (unix epoch in ms) of creation of this entity, will be filled automatically if missing. Not enforced by the application server. |  [optional]
**modified** | **kotlin.Long** | The date (unix epoch in ms) of the latest modification of this entity, will be filled automatically if missing. Not enforced by the application server. |  [optional]
**author** | **kotlin.String** | The id of the User that has created this entity, will be filled automatically if missing. Not enforced by the application server. |  [optional]
**responsible** | **kotlin.String** | The id of the HealthcareParty that is responsible for this entity, will be filled automatically if missing. Not enforced by the application server. |  [optional]
**medicalLocationId** | **kotlin.String** | The id of the medical location where this entity was created. |  [optional]
**endOfLife** | **kotlin.Long** | Soft delete (unix epoch in ms) timestamp of the object. |  [optional]
**deletionDate** | **kotlin.Long** | hard delete (unix epoch in ms) timestamp of the object. Filled automatically when deletePatient is called. |  [optional]
**fromAddress** | **kotlin.String** | Address of the sender of the message |  [optional]
**fromHealthcarePartyId** | **kotlin.String** | ID of the healthcare party sending the message |  [optional]
**formId** | **kotlin.String** |  |  [optional]
**status** | **kotlin.Int** | Status of the message |  [optional]
**recipientsType** | **kotlin.String** | The type of user who is the recipient of this message |  [optional]
**received** | **kotlin.Long** | The timestamp (unix epoch in ms) when the message was received |  [optional]
**sent** | **kotlin.Long** | The timestamp (unix epoch in ms) when the message was sent |  [optional]
**transportGuid** | **kotlin.String** |  |  [optional]
**remark** | **kotlin.String** |  |  [optional]
**conversationGuid** | **kotlin.String** |  |  [optional]
**subject** | **kotlin.String** | Subject for the message |  [optional]
**parentId** | **kotlin.String** | ID of a parent in a message conversation |  [optional]
**externalRef** | **kotlin.String** |  |  [optional]
**encryptedSelf** | **kotlin.String** | The base64 encoded data of this object, formatted as JSON and encrypted in AES using the random master key from encryptionKeys. |  [optional]



