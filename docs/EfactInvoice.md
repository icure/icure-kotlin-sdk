
# EfactInvoice

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**items** | [**kotlin.collections.List&lt;InvoiceItem&gt;**](InvoiceItem.md) |  |
**ignorePrescriptionDate** | **kotlin.Boolean** |  |
**hospitalisedPatient** | **kotlin.Boolean** |  |
**creditNote** | **kotlin.Boolean** |  |
**patient** | [**PatientDto**](PatientDto.md) |  |  [optional]
**ioCode** | **kotlin.String** |  |  [optional]
**reason** | [**inline**](#ReasonEnum) |  |  [optional]
**invoiceRef** | **kotlin.String** |  |  [optional]
**invoiceNumber** | **kotlin.Long** |  |  [optional]
**relatedInvoiceIoCode** | **kotlin.String** |  |  [optional]
**relatedInvoiceNumber** | **kotlin.Long** |  |  [optional]
**relatedBatchSendNumber** | **kotlin.Long** |  |  [optional]
**relatedBatchYearMonth** | **kotlin.Long** |  |  [optional]


<a name="ReasonEnum"></a>
## Enum: reason
Name | Value
---- | -----
reason | Chimiotherapy, ProfessionalDisease, WorkAccident, Accident, Other
