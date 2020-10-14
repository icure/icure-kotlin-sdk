# HealthElementDto

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
**healthElementId** | [**kotlin.String**](.md) |  |  [optional]
**valueDate** | [**kotlin.Long**](.md) |  |  [optional]
**openingDate** | [**kotlin.Long**](.md) |  |  [optional]
**closingDate** | [**kotlin.Long**](.md) |  |  [optional]
**descr** | [**kotlin.String**](.md) |  |  [optional]
**note** | [**kotlin.String**](.md) |  |  [optional]
**relevant** | [**kotlin.Boolean**](.md) |  | 
**idOpeningContact** | [**kotlin.String**](.md) |  |  [optional]
**idClosingContact** | [**kotlin.String**](.md) |  |  [optional]
**idService** | [**kotlin.String**](.md) |  |  [optional]
**status** | [**kotlin.Int**](.md) |  | 
**laterality** | [**inline**](#LateralityEnum) |  |  [optional]
**plansOfAction** | [**kotlin.Array&lt;PlanOfActionDto&gt;**](PlanOfActionDto.md) |  | 
**episodes** | [**kotlin.Array&lt;EpisodeDto&gt;**](EpisodeDto.md) |  | 
**careTeam** | [**kotlin.Array&lt;CareTeamMemberDto&gt;**](CareTeamMemberDto.md) |  | 
**secretForeignKeys** | [**kotlin.Array&lt;kotlin.String&gt;**](.md) |  | 
**cryptedForeignKeys** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.Array&lt;DelegationDto&gt;&gt;**](.md) |  | 
**delegations** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.Array&lt;DelegationDto&gt;&gt;**](.md) |  | 
**encryptionKeys** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.Array&lt;DelegationDto&gt;&gt;**](.md) |  | 
**encryptedSelf** | [**kotlin.String**](.md) |  |  [optional]

<a name="LateralityEnum"></a>
## Enum: laterality
Name | Value
---- | -----
laterality | left, right
