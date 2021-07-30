
# AmpComponentDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**from** | **kotlin.Long** |  |  [optional]
**to** | **kotlin.Long** |  |  [optional]
**ingredients** | [**kotlin.collections.List&lt;IngredientDto&gt;**](IngredientDto.md) |  |  [optional]
**pharmaceuticalForms** | [**kotlin.collections.List&lt;PharmaceuticalFormStubDto&gt;**](PharmaceuticalFormStubDto.md) |  |  [optional]
**routeOfAdministrations** | [**kotlin.collections.List&lt;RouteOfAdministrationDto&gt;**](RouteOfAdministrationDto.md) |  |  [optional]
**dividable** | **kotlin.String** |  |  [optional]
**scored** | **kotlin.String** |  |  [optional]
**crushable** | [**inline**](#CrushableEnum) |  |  [optional]
**containsAlcohol** | [**inline**](#ContainsAlcoholEnum) |  |  [optional]
**sugarFree** | **kotlin.Boolean** |  |  [optional]
**modifiedReleaseType** | **kotlin.Int** |  |  [optional]
**specificDrugDevice** | **kotlin.Int** |  |  [optional]
**dimensions** | **kotlin.String** |  |  [optional]
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



