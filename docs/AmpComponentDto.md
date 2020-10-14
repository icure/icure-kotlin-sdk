# AmpComponentDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**from** | [**kotlin.Long**](.md) |  |  [optional]
**to** | [**kotlin.Long**](.md) |  |  [optional]
**ingredients** | [**kotlin.Array&lt;IngredientDto&gt;**](IngredientDto.md) |  |  [optional]
**pharmaceuticalForms** | [**kotlin.Array&lt;PharmaceuticalFormDto&gt;**](PharmaceuticalFormDto.md) |  |  [optional]
**routeOfAdministrations** | [**kotlin.Array&lt;RouteOfAdministrationDto&gt;**](RouteOfAdministrationDto.md) |  |  [optional]
**dividable** | [**kotlin.String**](.md) |  |  [optional]
**scored** | [**kotlin.String**](.md) |  |  [optional]
**crushable** | [**inline**](#CrushableEnum) |  |  [optional]
**containsAlcohol** | [**inline**](#ContainsAlcoholEnum) |  |  [optional]
**sugarFree** | [**kotlin.Boolean**](.md) |  |  [optional]
**modifiedReleaseType** | [**kotlin.Int**](.md) |  |  [optional]
**specificDrugDevice** | [**kotlin.Int**](.md) |  |  [optional]
**dimensions** | [**kotlin.String**](.md) |  |  [optional]
**name** | [**SamTextDto**](SamTextDto.md) |  |  [optional]
**note** | [**SamTextDto**](SamTextDto.md) |  |  [optional]

<a name="CrushableEnum"></a>
## Enum: crushable
Name | Value
---- | -----
crushable | Y, N, X

<a name="ContainsAlcoholEnum"></a>
## Enum: containsAlcohol
Name | Value
---- | -----
containsAlcohol | Y, N, X
