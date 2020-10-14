# ServiceDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | [**kotlin.String**](.md) |  | 
**contactId** | [**kotlin.String**](.md) |  |  [optional]
**subContactIds** | [**kotlin.Array&lt;kotlin.String&gt;**](.md) |  |  [optional]
**plansOfActionIds** | [**kotlin.Array&lt;kotlin.String&gt;**](.md) |  |  [optional]
**healthElementsIds** | [**kotlin.Array&lt;kotlin.String&gt;**](.md) |  |  [optional]
**formIds** | [**kotlin.Array&lt;kotlin.String&gt;**](.md) |  |  [optional]
**secretForeignKeys** | [**kotlin.Array&lt;kotlin.String&gt;**](.md) |  |  [optional]
**cryptedForeignKeys** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.Array&lt;DelegationDto&gt;&gt;**](.md) |  | 
**delegations** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.Array&lt;DelegationDto&gt;&gt;**](.md) |  | 
**encryptionKeys** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.Array&lt;DelegationDto&gt;&gt;**](.md) |  | 
**label** | [**kotlin.String**](.md) |  | 
**dataClassName** | [**kotlin.String**](.md) |  |  [optional]
**index** | [**kotlin.Long**](.md) |  |  [optional]
**content** | [**kotlin.collections.Map&lt;kotlin.String, ContentDto&gt;**](ContentDto.md) |  | 
**encryptedContent** | [**kotlin.String**](.md) |  |  [optional]
**textIndexes** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.String&gt;**](.md) |  | 
**valueDate** | [**kotlin.Long**](.md) |  |  [optional]
**openingDate** | [**kotlin.Long**](.md) |  |  [optional]
**closingDate** | [**kotlin.Long**](.md) |  |  [optional]
**formId** | [**kotlin.String**](.md) |  |  [optional]
**created** | [**kotlin.Long**](.md) |  |  [optional]
**modified** | [**kotlin.Long**](.md) |  |  [optional]
**endOfLife** | [**kotlin.Long**](.md) |  |  [optional]
**author** | [**kotlin.String**](.md) |  |  [optional]
**responsible** | [**kotlin.String**](.md) |  |  [optional]
**medicalLocationId** | [**kotlin.String**](.md) |  |  [optional]
**comment** | [**kotlin.String**](.md) |  |  [optional]
**status** | [**kotlin.Int**](.md) |  |  [optional]
**invoicingCodes** | [**kotlin.Array&lt;kotlin.String&gt;**](.md) |  | 
**qualifiedLinks** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.Array&lt;kotlin.String&gt;&gt;**](.md) |  | 
**codes** | [**kotlin.Array&lt;CodeStubDto&gt;**](CodeStubDto.md) |  | 
**tags** | [**kotlin.Array&lt;CodeStubDto&gt;**](CodeStubDto.md) |  | 
**encryptedSelf** | [**kotlin.String**](.md) |  |  [optional]
