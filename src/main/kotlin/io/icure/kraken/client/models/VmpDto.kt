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


/**
 * 
 *
 * @param id 
 * @param rev 
 * @param deletionDate hard delete (unix epoch in ms) timestamp of the object. Filled automatically when deletePatient is called.
 * @param from 
 * @param to 
 * @param code 
 * @param vmpGroup 
 * @param name 
 * @param abbreviation 
 * @param vtm 
 * @param wadas 
 * @param components 
 * @param commentedClassifications 
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class VmpDto (

    @field:JsonProperty("id")
    val id: String,

    @field:JsonProperty("rev")
    val rev: String? = null,

    /* hard delete (unix epoch in ms) timestamp of the object. Filled automatically when deletePatient is called. */
    @field:JsonProperty("deletionDate")
    val deletionDate: Long? = null,

    @field:JsonProperty("from")
    val from: Long? = null,

    @field:JsonProperty("to")
    val to: Long? = null,

    @field:JsonProperty("code")
    val code: String? = null,

    @field:JsonProperty("vmpGroup")
    val vmpGroup: VmpGroupStubDto? = null,

    @field:JsonProperty("name")
    val name: SamTextDto? = null,

    @field:JsonProperty("abbreviation")
    val abbreviation: SamTextDto? = null,

    @field:JsonProperty("vtm")
    val vtm: VtmDto? = null,

    @field:JsonProperty("wadas")
    val wadas: List<WadaDto>? = null,

    @field:JsonProperty("components")
    val components: List<VmpComponentDto>? = null,

    @field:JsonProperty("commentedClassifications")
    val commentedClassifications: List<CommentedClassificationDto>? = null

)

