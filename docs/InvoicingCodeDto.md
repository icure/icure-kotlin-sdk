# InvoicingCodeDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | [**kotlin.String**](.md) |  | 
**dateCode** | [**kotlin.Long**](.md) |  |  [optional]
**logicalId** | [**kotlin.String**](.md) |  |  [optional]
**label** | [**kotlin.String**](.md) |  |  [optional]
**userId** | [**kotlin.String**](.md) |  |  [optional]
**contactId** | [**kotlin.String**](.md) |  |  [optional]
**serviceId** | [**kotlin.String**](.md) |  |  [optional]
**tarificationId** | [**kotlin.String**](.md) |  |  [optional]
**code** | [**kotlin.String**](.md) |  |  [optional]
**paymentType** | [**inline**](#PaymentTypeEnum) |  |  [optional]
**paid** | [**kotlin.Double**](.md) |  |  [optional]
**totalAmount** | [**kotlin.Double**](.md) |  |  [optional]
**reimbursement** | [**kotlin.Double**](.md) |  |  [optional]
**patientIntervention** | [**kotlin.Double**](.md) |  |  [optional]
**doctorSupplement** | [**kotlin.Double**](.md) |  |  [optional]
**conventionAmount** | [**kotlin.Double**](.md) |  |  [optional]
**vat** | [**kotlin.Double**](.md) |  |  [optional]
**error** | [**kotlin.String**](.md) |  |  [optional]
**contract** | [**kotlin.String**](.md) |  |  [optional]
**contractDate** | [**kotlin.Long**](.md) |  |  [optional]
**units** | [**kotlin.Int**](.md) |  |  [optional]
**side** | [**kotlin.Int**](.md) |  |  [optional]
**timeOfDay** | [**kotlin.Int**](.md) |  |  [optional]
**eidReadingHour** | [**kotlin.Int**](.md) |  |  [optional]
**eidReadingValue** | [**kotlin.String**](.md) |  |  [optional]
**override3rdPayerCode** | [**kotlin.Int**](.md) |  |  [optional]
**override3rdPayerReason** | [**kotlin.String**](.md) |  |  [optional]
**transplantationCode** | [**kotlin.Int**](.md) |  |  [optional]
**prescriberNorm** | [**kotlin.Int**](.md) |  |  [optional]
**percentNorm** | [**kotlin.Int**](.md) |  |  [optional]
**prescriberNihii** | [**kotlin.String**](.md) |  |  [optional]
**relatedCode** | [**kotlin.String**](.md) |  |  [optional]
**prescriptionDate** | [**kotlin.Long**](.md) |  |  [optional]
**derogationMaxNumber** | [**kotlin.Int**](.md) |  |  [optional]
**prescriberSsin** | [**kotlin.String**](.md) |  |  [optional]
**prescriberLastName** | [**kotlin.String**](.md) |  |  [optional]
**prescriberFirstName** | [**kotlin.String**](.md) |  |  [optional]
**prescriberCdHcParty** | [**kotlin.String**](.md) |  |  [optional]
**locationNihii** | [**kotlin.String**](.md) |  |  [optional]
**locationCdHcParty** | [**kotlin.String**](.md) |  |  [optional]
**canceled** | [**kotlin.Boolean**](.md) |  |  [optional]
**accepted** | [**kotlin.Boolean**](.md) |  |  [optional]
**pending** | [**kotlin.Boolean**](.md) |  |  [optional]
**resent** | [**kotlin.Boolean**](.md) |  |  [optional]
**archived** | [**kotlin.Boolean**](.md) |  |  [optional]
**lost** | [**kotlin.Boolean**](.md) |  |  [optional]
**insuranceJustification** | [**kotlin.Int**](.md) |  |  [optional]
**cancelPatientInterventionReason** | [**kotlin.Int**](.md) |  |  [optional]
**status** | [**kotlin.Long**](.md) |  |  [optional]
**encryptedSelf** | [**kotlin.String**](.md) |  |  [optional]

<a name="PaymentTypeEnum"></a>
## Enum: paymentType
Name | Value
---- | -----
paymentType | cash, wired, insurance, creditcard, debitcard, paypal, bitcoin, other
