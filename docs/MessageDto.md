# MessageDto

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
**fromAddress** | [**kotlin.String**](.md) |  |  [optional]
**fromHealthcarePartyId** | [**kotlin.String**](.md) |  |  [optional]
**formId** | [**kotlin.String**](.md) |  |  [optional]
**status** | [**kotlin.Int**](.md) |  |  [optional]
**recipientsType** | [**kotlin.String**](.md) |  |  [optional]
**recipients** | [**kotlin.Array&lt;kotlin.String&gt;**](.md) |  | 
**toAddresses** | [**kotlin.Array&lt;kotlin.String&gt;**](.md) |  | 
**received** | [**kotlin.Long**](.md) |  |  [optional]
**sent** | [**kotlin.Long**](.md) |  |  [optional]
**metas** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.String&gt;**](.md) |  | 
**readStatus** | [**kotlin.collections.Map&lt;kotlin.String, MessageReadStatusDto&gt;**](MessageReadStatusDto.md) |  | 
**transportGuid** | [**kotlin.String**](.md) |  |  [optional]
**remark** | [**kotlin.String**](.md) |  |  [optional]
**conversationGuid** | [**kotlin.String**](.md) |  |  [optional]
**subject** | [**kotlin.String**](.md) |  |  [optional]
**invoiceIds** | [**kotlin.Array&lt;kotlin.String&gt;**](.md) |  | 
**parentId** | [**kotlin.String**](.md) |  |  [optional]
**externalRef** | [**kotlin.String**](.md) |  |  [optional]
**unassignedResults** | [**kotlin.Array&lt;kotlin.String&gt;**](.md) |  | 
**assignedResults** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.String&gt;**](.md) |  | 
**senderReferences** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.String&gt;**](.md) |  | 
**secretForeignKeys** | [**kotlin.Array&lt;kotlin.String&gt;**](.md) |  | 
**cryptedForeignKeys** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.Array&lt;DelegationDto&gt;&gt;**](.md) |  | 
**delegations** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.Array&lt;DelegationDto&gt;&gt;**](.md) |  | 
**encryptionKeys** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.Array&lt;DelegationDto&gt;&gt;**](.md) |  | 
**encryptedSelf** | [**kotlin.String**](.md) |  |  [optional]
