# MedicalHouseContractDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**contractId** | [**kotlin.String**](.md) |  |  [optional]
**validFrom** | [**kotlin.Long**](.md) |  |  [optional]
**validTo** | [**kotlin.Long**](.md) |  |  [optional]
**mmNihii** | [**kotlin.String**](.md) |  |  [optional]
**hcpId** | [**kotlin.String**](.md) |  |  [optional]
**changeType** | [**inline**](#ChangeTypeEnum) |  |  [optional]
**parentContractId** | [**kotlin.String**](.md) |  |  [optional]
**changedBy** | [**kotlin.String**](.md) |  |  [optional]
**startOfContract** | [**kotlin.Long**](.md) |  |  [optional]
**startOfCoverage** | [**kotlin.Long**](.md) |  |  [optional]
**endOfContract** | [**kotlin.Long**](.md) |  |  [optional]
**endOfCoverage** | [**kotlin.Long**](.md) |  |  [optional]
**kine** | [**kotlin.Boolean**](.md) |  | 
**gp** | [**kotlin.Boolean**](.md) |  | 
**nurse** | [**kotlin.Boolean**](.md) |  | 
**noKine** | [**kotlin.Boolean**](.md) |  | 
**noGp** | [**kotlin.Boolean**](.md) |  | 
**noNurse** | [**kotlin.Boolean**](.md) |  | 
**unsubscriptionReasonId** | [**kotlin.Int**](.md) |  |  [optional]
**startOfSuspension** | [**kotlin.Long**](.md) |  |  [optional]
**endOfSuspension** | [**kotlin.Long**](.md) |  |  [optional]
**suspensionReason** | [**inline**](#SuspensionReasonEnum) |  |  [optional]
**suspensionSource** | [**kotlin.String**](.md) |  |  [optional]
**forcedSuspension** | [**kotlin.Boolean**](.md) |  | 
**signatureType** | [**inline**](#SignatureTypeEnum) |  |  [optional]
**status** | [**kotlin.Int**](.md) |  |  [optional]
**receipts** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.String&gt;**](.md) |  | 
**encryptedSelf** | [**kotlin.String**](.md) |  |  [optional]

<a name="ChangeTypeEnum"></a>
## Enum: changeType
Name | Value
---- | -----
changeType | inscriptionStart, inscriptionEnd, suspension, coverageChange

<a name="SuspensionReasonEnum"></a>
## Enum: suspensionReason
Name | Value
---- | -----
suspensionReason | notInsured, noReasonGiven, isHospitalized, outsideOfCountry, changeOfMutuality

<a name="SignatureTypeEnum"></a>
## Enum: signatureType
Name | Value
---- | -----
signatureType | holderEid, holderPaper, legalrepresentativeEid, legalrepresentativePaper
