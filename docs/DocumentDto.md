# DocumentDto

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
**attachment** | [**kotlin.Array&lt;ByteArray&gt;**](ByteArray.md) |  |  [optional]
**documentLocation** | [**inline**](#DocumentLocationEnum) |  |  [optional]
**documentType** | [**inline**](#DocumentTypeEnum) |  |  [optional]
**documentStatus** | [**inline**](#DocumentStatusEnum) |  |  [optional]
**externalUri** | [**kotlin.String**](.md) |  |  [optional]
**mainUti** | [**kotlin.String**](.md) |  |  [optional]
**name** | [**kotlin.String**](.md) |  |  [optional]
**otherUtis** | [**kotlin.Array&lt;kotlin.String&gt;**](.md) |  | 
**storedICureDocumentId** | [**kotlin.String**](.md) |  |  [optional]
**attachmentId** | [**kotlin.String**](.md) |  |  [optional]
**secretForeignKeys** | [**kotlin.Array&lt;kotlin.String&gt;**](.md) |  | 
**cryptedForeignKeys** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.Array&lt;DelegationDto&gt;&gt;**](.md) |  | 
**delegations** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.Array&lt;DelegationDto&gt;&gt;**](.md) |  | 
**encryptionKeys** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.Array&lt;DelegationDto&gt;&gt;**](.md) |  | 
**encryptedSelf** | [**kotlin.String**](.md) |  |  [optional]

<a name="DocumentLocationEnum"></a>
## Enum: documentLocation
Name | Value
---- | -----
documentLocation | annex, body

<a name="DocumentTypeEnum"></a>
## Enum: documentType
Name | Value
---- | -----
documentType | admission, alert, bvt_sample, clinicalpath, clinicalsummary, contactreport, quote, invoice, death, discharge, dischargereport, ebirth_baby_medicalform, ebirth_baby_notification, ebirth_mother_medicalform, ebirth_mother_notification, ecare_safe_consultation, epidemiology, intervention, labrequest, labresult, medicaladvisoragreement, medicationschemeelement, note, notification, pharmaceuticalprescription, prescription, productdelivery, quickdischargereport, radiationexposuremonitoring, referral, report, request, result, sumehr, telemonitoring, template, template_admin, treatmentsuspension, vaccination

<a name="DocumentStatusEnum"></a>
## Enum: documentStatus
Name | Value
---- | -----
documentStatus | draft, finalized, pending_review, reviewed, pending_signature, signed, canceled, sent, delivered
