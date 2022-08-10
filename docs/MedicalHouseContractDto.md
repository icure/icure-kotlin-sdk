
# MedicalHouseContractDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**kine** | **kotlin.Boolean** |  |
**gp** | **kotlin.Boolean** |  |
**ptd** | **kotlin.Boolean** |  |
**nurse** | **kotlin.Boolean** |  |
**noKine** | **kotlin.Boolean** |  |
**noGp** | **kotlin.Boolean** |  |
**noNurse** | **kotlin.Boolean** |  |
**forcedSuspension** | **kotlin.Boolean** |  |
**options** | **kotlin.collections.Map&lt;kotlin.String, kotlin.String&gt;** |  |
**receipts** | **kotlin.collections.Map&lt;kotlin.String, kotlin.String&gt;** |  |
**contractId** | **kotlin.String** |  |  [optional]
**validFrom** | **kotlin.Long** |  |  [optional]
**validTo** | **kotlin.Long** |  |  [optional]
**mmNihii** | **kotlin.String** |  |  [optional]
**hcpId** | **kotlin.String** |  |  [optional]
**changeType** | [**inline**](#ChangeTypeEnum) |  |  [optional]
**parentContractId** | **kotlin.String** |  |  [optional]
**changedBy** | **kotlin.String** |  |  [optional]
**startOfContract** | **kotlin.Long** |  |  [optional]
**startOfCoverage** | **kotlin.Long** |  |  [optional]
**endOfContract** | **kotlin.Long** |  |  [optional]
**endOfCoverage** | **kotlin.Long** |  |  [optional]
**unsubscriptionReasonId** | **kotlin.Int** |  |  [optional]
**ptdStart** | **kotlin.Long** |  |  [optional]
**ptdEnd** | **kotlin.Long** |  |  [optional]
**ptdLastInvoiced** | **kotlin.Long** |  |  [optional]
**startOfSuspension** | **kotlin.Long** |  |  [optional]
**endOfSuspension** | **kotlin.Long** |  |  [optional]
**suspensionReason** | [**inline**](#SuspensionReasonEnum) |  |  [optional]
**suspensionSource** | **kotlin.String** |  |  [optional]
**signatureType** | [**inline**](#SignatureTypeEnum) |  |  [optional]
**status** | **kotlin.Int** |  |  [optional]
**encryptedSelf** | **kotlin.String** | The base64 encoded data of this object, formatted as JSON and encrypted in AES using the random master key from encryptionKeys. |  [optional]


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
