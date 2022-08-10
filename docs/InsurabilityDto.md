
# InsurabilityDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**parameters** | **kotlin.collections.Map&lt;kotlin.String, kotlin.String&gt;** | Insurance extra parameters. |
**hospitalisation** | **kotlin.Boolean** | Is hospitalization covered. |  [optional]
**ambulatory** | **kotlin.Boolean** | Is outpatient care covered. |  [optional]
**dental** | **kotlin.Boolean** | Is dental care covered. |  [optional]
**identificationNumber** | **kotlin.String** | Identification number of the patient at the insurance. |  [optional]
**insuranceId** | **kotlin.String** | Id of the Insurance. |  [optional]
**startDate** | **kotlin.Long** | Start date of the coverage (YYYYMMDD). |  [optional]
**endDate** | **kotlin.Long** | End date of the coverage (YYYYMMDD). |  [optional]
**titularyId** | **kotlin.String** | UUID of the contact person who is the policyholder of the insurance (when the patient is covered by the insurance of a third person). |  [optional]
**encryptedSelf** | **kotlin.String** | The base64 encoded data of this object, formatted as JSON and encrypted in AES using the random master key from encryptionKeys. |  [optional]
