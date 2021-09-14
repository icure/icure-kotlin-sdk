/**
 * iCure Data Stack API Documentation
 *
 * The iCure Data Stack Application API is the native interface to iCure.
 *
 * The version of the OpenAPI document: v2
 * 
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
package io.icure.kraken.client.models


import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder


/**
 * 
 *
 * @param id 
 * @param entity 
 * @param rev 
 * @param deletionDate hard delete (unix epoch in ms) timestamp of the object. Filled automatically when deletePatient is called.
 * @param userId 
 * @param descr 
 * @param keywords 
 * @param entityType 
 * @param subType 
 * @param defaultTemplate 
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@KotlinBuilder
data class EntityTemplateDto (

    @field:JsonProperty("id")
    val id: kotlin.String,

    @field:JsonProperty("entity")
    val entity: kotlin.collections.List<kotlin.collections.Map<kotlin.String, kotlin.Any>> = listOf(),

    @field:JsonProperty("rev")
    val rev: kotlin.String? = null,

    /* hard delete (unix epoch in ms) timestamp of the object. Filled automatically when deletePatient is called. */
    @field:JsonProperty("deletionDate")
    val deletionDate: kotlin.Long? = null,

    @field:JsonProperty("userId")
    val userId: kotlin.String? = null,

    @field:JsonProperty("descr")
    val descr: kotlin.String? = null,

    @field:JsonProperty("keywords")
    val keywords: kotlin.collections.Set<kotlin.String>? = null,

    @field:JsonProperty("entityType")
    val entityType: kotlin.String? = null,

    @field:JsonProperty("subType")
    val subType: kotlin.String? = null,

    @field:JsonProperty("defaultTemplate")
    val defaultTemplate: kotlin.Boolean? = null

)

