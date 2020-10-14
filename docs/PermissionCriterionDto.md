# PermissionCriterionDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**negative** | [**kotlin.Boolean**](.md) |  | 
**currentUser** | [**inline**](#CurrentUserEnum) |  |  [optional]
**dataType** | [**inline**](#DataTypeEnum) |  |  [optional]
**patientStatus** | [**kotlin.String**](.md) |  |  [optional]

<a name="CurrentUserEnum"></a>
## Enum: currentUser
Name | Value
---- | -----
currentUser | DATA_CREATION_USER, DATA_MODIFICATION_USER, PATIENT_CREATION_USER, PATIENT_MODIFICATION_USER, PATIENT_REFERENCE_HC_USER, PATIENT_HC_TEAM_USER

<a name="DataTypeEnum"></a>
## Enum: dataType
Name | Value
---- | -----
dataType | ADMINISTRATIVE, HEALTH, SENSITIVE, CONFIDENTIAL
