/**
 * OpenAPI definition
 *
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: v0
 * 
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
package io.icure.kraken.client.models

import io.icure.kraken.client.models.PeriodicityDto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder


/**
 * 
 *
 * @param id 
 * @param regions 
 * @param periodicity 
 * @param links 
 * @param qualifiedLinks 
 * @param flags 
 * @param searchTerms 
 * @param appendices 
 * @param disabled 
 * @param rev 
 * @param deletionDate hard delete (unix epoch in ms) timestamp of the object. Filled automatically when deletePatient is called.
 * @param context 
 * @param type 
 * @param code 
 * @param version 
 * @param label 
 * @param author 
 * @param level 
 * @param `data` 
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@KotlinBuilder
data class CodeDto (

    @field:JsonProperty("id")
    val id: kotlin.String,

    @field:JsonProperty("regions")
    val regions: kotlin.collections.List<kotlin.String> = listOf(),

    @field:JsonProperty("periodicity")
    val periodicity: kotlin.collections.List<PeriodicityDto> = listOf(),

    @field:JsonProperty("links")
    val links: kotlin.collections.List<kotlin.String> = listOf(),

    @field:JsonProperty("qualifiedLinks")
    val qualifiedLinks: kotlin.collections.Map<kotlin.String, kotlin.collections.List<kotlin.String>> = mapOf(),

    @field:JsonProperty("flags")
    val flags: kotlin.collections.List<CodeDto.Flags> = listOf(),

    @field:JsonProperty("searchTerms")
    val searchTerms: kotlin.collections.Map<kotlin.String, kotlin.collections.Set<kotlin.String>> = mapOf(),

    @field:JsonProperty("appendices")
    val appendices: kotlin.collections.Map<kotlin.String, kotlin.String> = mapOf(),

    @field:JsonProperty("disabled")
    val disabled: kotlin.Boolean = false,

    @field:JsonProperty("rev")
    val rev: kotlin.String? = null,

    /* hard delete (unix epoch in ms) timestamp of the object. Filled automatically when deletePatient is called. */
    @field:JsonProperty("deletionDate")
    val deletionDate: kotlin.Long? = null,

    @field:JsonProperty("context")
    val context: kotlin.String? = null,

    @field:JsonProperty("type")
    val type: kotlin.String? = null,

    @field:JsonProperty("code")
    val code: kotlin.String? = null,

    @field:JsonProperty("version")
    val version: kotlin.String? = null,

    @field:JsonProperty("label")
    val label: kotlin.collections.Map<kotlin.String, kotlin.String>? = null,

    @field:JsonProperty("author")
    val author: kotlin.String? = null,

    @field:JsonProperty("level")
    val level: kotlin.Int? = null,

    @field:JsonProperty("data")
    val `data`: kotlin.String? = null

) {

    /**
     * 
     *
     * Values: maleOnly,femaleOnly,deptkinesitherapy,deptnursing,deptgeneralpractice,deptsocialworker,deptpsychology,deptadministrative,deptdietetics,deptspeechtherapy,deptdentistry,deptoccupationaltherapy,depthealthcare,deptgynecology,deptpediatry,deptalgology,deptanatomopathology,deptanesthesiology,deptbacteriology,deptcardiacsurgery,deptcardiology,deptchildandadolescentpsychiatry,deptdermatology,deptdiabetology,deptemergency,deptendocrinology,deptgastroenterology,deptgenetics,deptgeriatry,depthandsurgery,depthematology,deptinfectiousdisease,deptintensivecare,deptlaboratory,deptmajorburns,deptmaxillofacialsurgery,deptmedicine,deptmolecularbiology,deptneonatalogy,deptnephrology,deptneurology,deptneurosurgery,deptnte,deptnuclear,deptnutritiondietetics,deptobstetrics,deptoncology,deptophtalmology,deptorthopedy,deptpalliativecare,deptpediatricintensivecare,deptpediatricsurgery,deptpharmacy,deptphysicalmedecine,deptphysiotherapy,deptplasticandreparatorysurgery,deptpneumology,deptpodiatry,deptpsychiatry,deptradiology,deptradiotherapy,deptrevalidation,deptrheumatology,deptrhumatology,deptsenology,deptsocialservice,deptsportsmedecine,deptstomatology,deptsurgery,deptthoracicsurgery,depttoxicology,depttropicalmedecine,depturology,deptvascularsurgery,deptvisceraldigestiveabdominalsurgery,depttransplantsurgery,deptpercutaneous,deptchildbirth
     */
    enum class Flags(val value: kotlin.String) {
        @JsonProperty(value = "male_only") maleOnly("male_only"),
        @JsonProperty(value = "female_only") femaleOnly("female_only"),
        @JsonProperty(value = "deptkinesitherapy") deptkinesitherapy("deptkinesitherapy"),
        @JsonProperty(value = "deptnursing") deptnursing("deptnursing"),
        @JsonProperty(value = "deptgeneralpractice") deptgeneralpractice("deptgeneralpractice"),
        @JsonProperty(value = "deptsocialworker") deptsocialworker("deptsocialworker"),
        @JsonProperty(value = "deptpsychology") deptpsychology("deptpsychology"),
        @JsonProperty(value = "deptadministrative") deptadministrative("deptadministrative"),
        @JsonProperty(value = "deptdietetics") deptdietetics("deptdietetics"),
        @JsonProperty(value = "deptspeechtherapy") deptspeechtherapy("deptspeechtherapy"),
        @JsonProperty(value = "deptdentistry") deptdentistry("deptdentistry"),
        @JsonProperty(value = "deptoccupationaltherapy") deptoccupationaltherapy("deptoccupationaltherapy"),
        @JsonProperty(value = "depthealthcare") depthealthcare("depthealthcare"),
        @JsonProperty(value = "deptgynecology") deptgynecology("deptgynecology"),
        @JsonProperty(value = "deptpediatry") deptpediatry("deptpediatry"),
        @JsonProperty(value = "deptalgology") deptalgology("deptalgology"),
        @JsonProperty(value = "deptanatomopathology") deptanatomopathology("deptanatomopathology"),
        @JsonProperty(value = "deptanesthesiology") deptanesthesiology("deptanesthesiology"),
        @JsonProperty(value = "deptbacteriology") deptbacteriology("deptbacteriology"),
        @JsonProperty(value = "deptcardiacsurgery") deptcardiacsurgery("deptcardiacsurgery"),
        @JsonProperty(value = "deptcardiology") deptcardiology("deptcardiology"),
        @JsonProperty(value = "deptchildandadolescentpsychiatry") deptchildandadolescentpsychiatry("deptchildandadolescentpsychiatry"),
        @JsonProperty(value = "deptdermatology") deptdermatology("deptdermatology"),
        @JsonProperty(value = "deptdiabetology") deptdiabetology("deptdiabetology"),
        @JsonProperty(value = "deptemergency") deptemergency("deptemergency"),
        @JsonProperty(value = "deptendocrinology") deptendocrinology("deptendocrinology"),
        @JsonProperty(value = "deptgastroenterology") deptgastroenterology("deptgastroenterology"),
        @JsonProperty(value = "deptgenetics") deptgenetics("deptgenetics"),
        @JsonProperty(value = "deptgeriatry") deptgeriatry("deptgeriatry"),
        @JsonProperty(value = "depthandsurgery") depthandsurgery("depthandsurgery"),
        @JsonProperty(value = "depthematology") depthematology("depthematology"),
        @JsonProperty(value = "deptinfectiousdisease") deptinfectiousdisease("deptinfectiousdisease"),
        @JsonProperty(value = "deptintensivecare") deptintensivecare("deptintensivecare"),
        @JsonProperty(value = "deptlaboratory") deptlaboratory("deptlaboratory"),
        @JsonProperty(value = "deptmajorburns") deptmajorburns("deptmajorburns"),
        @JsonProperty(value = "deptmaxillofacialsurgery") deptmaxillofacialsurgery("deptmaxillofacialsurgery"),
        @JsonProperty(value = "deptmedicine") deptmedicine("deptmedicine"),
        @JsonProperty(value = "deptmolecularbiology") deptmolecularbiology("deptmolecularbiology"),
        @JsonProperty(value = "deptneonatalogy") deptneonatalogy("deptneonatalogy"),
        @JsonProperty(value = "deptnephrology") deptnephrology("deptnephrology"),
        @JsonProperty(value = "deptneurology") deptneurology("deptneurology"),
        @JsonProperty(value = "deptneurosurgery") deptneurosurgery("deptneurosurgery"),
        @JsonProperty(value = "deptnte") deptnte("deptnte"),
        @JsonProperty(value = "deptnuclear") deptnuclear("deptnuclear"),
        @JsonProperty(value = "deptnutritiondietetics") deptnutritiondietetics("deptnutritiondietetics"),
        @JsonProperty(value = "deptobstetrics") deptobstetrics("deptobstetrics"),
        @JsonProperty(value = "deptoncology") deptoncology("deptoncology"),
        @JsonProperty(value = "deptophtalmology") deptophtalmology("deptophtalmology"),
        @JsonProperty(value = "deptorthopedy") deptorthopedy("deptorthopedy"),
        @JsonProperty(value = "deptpalliativecare") deptpalliativecare("deptpalliativecare"),
        @JsonProperty(value = "deptpediatricintensivecare") deptpediatricintensivecare("deptpediatricintensivecare"),
        @JsonProperty(value = "deptpediatricsurgery") deptpediatricsurgery("deptpediatricsurgery"),
        @JsonProperty(value = "deptpharmacy") deptpharmacy("deptpharmacy"),
        @JsonProperty(value = "deptphysicalmedecine") deptphysicalmedecine("deptphysicalmedecine"),
        @JsonProperty(value = "deptphysiotherapy") deptphysiotherapy("deptphysiotherapy"),
        @JsonProperty(value = "deptplasticandreparatorysurgery") deptplasticandreparatorysurgery("deptplasticandreparatorysurgery"),
        @JsonProperty(value = "deptpneumology") deptpneumology("deptpneumology"),
        @JsonProperty(value = "deptpodiatry") deptpodiatry("deptpodiatry"),
        @JsonProperty(value = "deptpsychiatry") deptpsychiatry("deptpsychiatry"),
        @JsonProperty(value = "deptradiology") deptradiology("deptradiology"),
        @JsonProperty(value = "deptradiotherapy") deptradiotherapy("deptradiotherapy"),
        @JsonProperty(value = "deptrevalidation") deptrevalidation("deptrevalidation"),
        @JsonProperty(value = "deptrheumatology") deptrheumatology("deptrheumatology"),
        @JsonProperty(value = "deptrhumatology") deptrhumatology("deptrhumatology"),
        @JsonProperty(value = "deptsenology") deptsenology("deptsenology"),
        @JsonProperty(value = "deptsocialservice") deptsocialservice("deptsocialservice"),
        @JsonProperty(value = "deptsportsmedecine") deptsportsmedecine("deptsportsmedecine"),
        @JsonProperty(value = "deptstomatology") deptstomatology("deptstomatology"),
        @JsonProperty(value = "deptsurgery") deptsurgery("deptsurgery"),
        @JsonProperty(value = "deptthoracicsurgery") deptthoracicsurgery("deptthoracicsurgery"),
        @JsonProperty(value = "depttoxicology") depttoxicology("depttoxicology"),
        @JsonProperty(value = "depttropicalmedecine") depttropicalmedecine("depttropicalmedecine"),
        @JsonProperty(value = "depturology") depturology("depturology"),
        @JsonProperty(value = "deptvascularsurgery") deptvascularsurgery("deptvascularsurgery"),
        @JsonProperty(value = "deptvisceraldigestiveabdominalsurgery") deptvisceraldigestiveabdominalsurgery("deptvisceraldigestiveabdominalsurgery"),
        @JsonProperty(value = "depttransplantsurgery") depttransplantsurgery("depttransplantsurgery"),
        @JsonProperty(value = "deptpercutaneous") deptpercutaneous("deptpercutaneous"),
        @JsonProperty(value = "deptchildbirth") deptchildbirth("deptchildbirth");
    }
}

