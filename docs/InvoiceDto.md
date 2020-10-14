# InvoiceDto

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
**invoiceDate** | [**kotlin.Long**](.md) |  |  [optional]
**sentDate** | [**kotlin.Long**](.md) |  |  [optional]
**printedDate** | [**kotlin.Long**](.md) |  |  [optional]
**invoicingCodes** | [**kotlin.Array&lt;InvoicingCodeDto&gt;**](InvoicingCodeDto.md) |  | 
**receipts** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.String&gt;**](.md) |  | 
**recipientType** | [**kotlin.String**](.md) |  |  [optional]
**recipientId** | [**kotlin.String**](.md) |  |  [optional]
**invoiceReference** | [**kotlin.String**](.md) |  |  [optional]
**thirdPartyReference** | [**kotlin.String**](.md) |  |  [optional]
**thirdPartyPaymentJustification** | [**kotlin.String**](.md) |  |  [optional]
**thirdPartyPaymentReason** | [**kotlin.String**](.md) |  |  [optional]
**reason** | [**kotlin.String**](.md) |  |  [optional]
**invoiceType** | [**inline**](#InvoiceTypeEnum) |  |  [optional]
**sentMediumType** | [**inline**](#SentMediumTypeEnum) |  |  [optional]
**interventionType** | [**inline**](#InterventionTypeEnum) |  |  [optional]
**groupId** | [**kotlin.String**](.md) |  |  [optional]
**paymentType** | [**inline**](#PaymentTypeEnum) |  |  [optional]
**paid** | [**kotlin.Double**](.md) |  |  [optional]
**payments** | [**kotlin.Array&lt;PaymentDto&gt;**](PaymentDto.md) |  |  [optional]
**gnotionNihii** | [**kotlin.String**](.md) |  |  [optional]
**gnotionSsin** | [**kotlin.String**](.md) |  |  [optional]
**gnotionLastName** | [**kotlin.String**](.md) |  |  [optional]
**gnotionFirstName** | [**kotlin.String**](.md) |  |  [optional]
**gnotionCdHcParty** | [**kotlin.String**](.md) |  |  [optional]
**invoicePeriod** | [**kotlin.Int**](.md) |  |  [optional]
**careProviderType** | [**kotlin.String**](.md) |  |  [optional]
**internshipNihii** | [**kotlin.String**](.md) |  |  [optional]
**internshipSsin** | [**kotlin.String**](.md) |  |  [optional]
**internshipLastName** | [**kotlin.String**](.md) |  |  [optional]
**internshipFirstName** | [**kotlin.String**](.md) |  |  [optional]
**internshipCdHcParty** | [**kotlin.String**](.md) |  |  [optional]
**internshipCbe** | [**kotlin.String**](.md) |  |  [optional]
**supervisorNihii** | [**kotlin.String**](.md) |  |  [optional]
**supervisorSsin** | [**kotlin.String**](.md) |  |  [optional]
**supervisorLastName** | [**kotlin.String**](.md) |  |  [optional]
**supervisorFirstName** | [**kotlin.String**](.md) |  |  [optional]
**supervisorCdHcParty** | [**kotlin.String**](.md) |  |  [optional]
**supervisorCbe** | [**kotlin.String**](.md) |  |  [optional]
**error** | [**kotlin.String**](.md) |  |  [optional]
**encounterLocationName** | [**kotlin.String**](.md) |  |  [optional]
**encounterLocationNihii** | [**kotlin.String**](.md) |  |  [optional]
**encounterLocationNorm** | [**kotlin.Int**](.md) |  |  [optional]
**longDelayJustification** | [**kotlin.Int**](.md) |  |  [optional]
**correctiveInvoiceId** | [**kotlin.String**](.md) |  |  [optional]
**correctedInvoiceId** | [**kotlin.String**](.md) |  |  [optional]
**creditNote** | [**kotlin.Boolean**](.md) |  |  [optional]
**creditNoteRelatedInvoiceId** | [**kotlin.String**](.md) |  |  [optional]
**idDocument** | [**IdentityDocumentReaderDto**](IdentityDocumentReaderDto.md) |  |  [optional]
**cancelReason** | [**kotlin.String**](.md) |  |  [optional]
**cancelDate** | [**kotlin.Long**](.md) |  |  [optional]
**options** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.String&gt;**](.md) |  | 
**secretForeignKeys** | [**kotlin.Array&lt;kotlin.String&gt;**](.md) |  | 
**cryptedForeignKeys** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.Array&lt;DelegationDto&gt;&gt;**](.md) |  | 
**delegations** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.Array&lt;DelegationDto&gt;&gt;**](.md) |  | 
**encryptionKeys** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.Array&lt;DelegationDto&gt;&gt;**](.md) |  | 
**encryptedSelf** | [**kotlin.String**](.md) |  |  [optional]

<a name="InvoiceTypeEnum"></a>
## Enum: invoiceType
Name | Value
---- | -----
invoiceType | patient, mutualfund, payingagency, insurance, efact, other

<a name="SentMediumTypeEnum"></a>
## Enum: sentMediumType
Name | Value
---- | -----
sentMediumType | cdrom, eattest, efact, email, mediprima, paper

<a name="InterventionTypeEnum"></a>
## Enum: interventionType
Name | Value
---- | -----
interventionType | total, userfees

<a name="PaymentTypeEnum"></a>
## Enum: paymentType
Name | Value
---- | -----
paymentType | cash, wired, insurance, creditcard, debitcard, paypal, bitcoin, other
