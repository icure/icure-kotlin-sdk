# TarificationDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | [**kotlin.String**](.md) |  | 
**rev** | [**kotlin.String**](.md) |  |  [optional]
**deletionDate** | [**kotlin.Long**](.md) |  |  [optional]
**label** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.String&gt;**](.md) |  | 
**type** | [**kotlin.String**](.md) |  |  [optional]
**code** | [**kotlin.String**](.md) |  |  [optional]
**version** | [**kotlin.String**](.md) |  |  [optional]
**author** | [**kotlin.String**](.md) |  |  [optional]
**regions** | [**kotlin.Array&lt;kotlin.String&gt;**](.md) |  | 
**periodicity** | [**kotlin.Array&lt;PeriodicityDto&gt;**](PeriodicityDto.md) |  | 
**level** | [**kotlin.Int**](.md) |  |  [optional]
**links** | [**kotlin.Array&lt;kotlin.String&gt;**](.md) |  | 
**qualifiedLinks** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.Array&lt;kotlin.String&gt;&gt;**](.md) |  | 
**flags** | [**inline**](#kotlin.Array&lt;FlagsEnum&gt;) |  | 
**searchTerms** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.Array&lt;kotlin.String&gt;&gt;**](.md) |  | 
**&#x60;data&#x60;** | [**kotlin.String**](.md) |  |  [optional]
**appendices** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.String&gt;**](.md) |  | 
**disabled** | [**kotlin.Boolean**](.md) |  | 
**valorisations** | [**kotlin.Array&lt;ValorisationDto&gt;**](ValorisationDto.md) |  | 
**category** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.String&gt;**](.md) |  | 
**consultationCode** | [**kotlin.Boolean**](.md) |  |  [optional]
**hasRelatedCode** | [**kotlin.Boolean**](.md) |  |  [optional]
**needsPrescriber** | [**kotlin.Boolean**](.md) |  |  [optional]
**relatedCodes** | [**kotlin.Array&lt;kotlin.String&gt;**](.md) |  | 
**nGroup** | [**kotlin.String**](.md) |  |  [optional]
**letterValues** | [**kotlin.Array&lt;LetterValueDto&gt;**](LetterValueDto.md) |  | 
**ngroup** | [**kotlin.String**](.md) |  |  [optional]

<a name="kotlin.Array<FlagsEnum>"></a>
## Enum: flags
Name | Value
---- | -----
flags | male_only, female_only, deptkinesitherapy, deptnursing, deptgeneralpractice, deptsocialworker, deptpsychology, deptadministrative, deptdietetics, deptspeechtherapy, deptdentistry, deptoccupationaltherapy, depthealthcare, deptgynecology, deptpediatry, deptalgology, deptanatomopathology, deptanesthesiology, deptbacteriology, deptcardiacsurgery, deptcardiology, deptchildandadolescentpsychiatry, deptdermatology, deptdiabetology, deptemergency, deptendocrinology, deptgastroenterology, deptgenetics, deptgeriatry, depthandsurgery, depthematology, deptinfectiousdisease, deptintensivecare, deptlaboratory, deptmajorburns, deptmaxillofacialsurgery, deptmedicine, deptmolecularbiology, deptneonatalogy, deptnephrology, deptneurology, deptneurosurgery, deptnte, deptnuclear, deptnutritiondietetics, deptobstetrics, deptoncology, deptophtalmology, deptorthopedy, deptpalliativecare, deptpediatricintensivecare, deptpediatricsurgery, deptpharmacy, deptphysicalmedecine, deptphysiotherapy, deptplasticandreparatorysurgery, deptpneumology, deptpodiatry, deptpsychiatry, deptradiology, deptradiotherapy, deptrevalidation, deptrheumatology, deptrhumatology, deptsenology, deptsocialservice, deptsportsmedecine, deptstomatology, deptsurgery, deptthoracicsurgery, depttoxicology, depttropicalmedecine, depturology, deptvascularsurgery, deptvisceraldigestiveabdominalsurgery, depttransplantsurgery, deptpercutaneous, deptchildbirth
