# Invoice

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**patient** | [**PatientDto**](PatientDto.md) |  |  [optional]
**ioCode** | [**kotlin.String**](.md) |  |  [optional]
**items** | [**kotlin.Array&lt;InvoiceItem&gt;**](InvoiceItem.md) |  | 
**reason** | [**inline**](#ReasonEnum) |  |  [optional]
**invoiceRef** | [**kotlin.String**](.md) |  |  [optional]
**invoiceNumber** | [**kotlin.Long**](.md) |  |  [optional]
**ignorePrescriptionDate** | [**kotlin.Boolean**](.md) |  | 
**hospitalisedPatient** | [**kotlin.Boolean**](.md) |  | 
**creditNote** | [**kotlin.Boolean**](.md) |  | 
**relatedInvoiceIoCode** | [**kotlin.String**](.md) |  |  [optional]
**relatedInvoiceNumber** | [**kotlin.Long**](.md) |  |  [optional]
**relatedBatchSendNumber** | [**kotlin.Long**](.md) |  |  [optional]
**relatedBatchYearMonth** | [**kotlin.Long**](.md) |  |  [optional]

<a name="ReasonEnum"></a>
## Enum: reason
Name | Value
---- | -----
reason | Chimiotherapy, ProfessionalDisease, WorkAccident, Accident, Other
