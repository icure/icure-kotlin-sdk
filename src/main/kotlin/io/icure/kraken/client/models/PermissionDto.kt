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

import io.icure.kraken.client.models.PermissionItemDto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder


/**
 * If permission to modify patient data is granted or revoked
 *
 * @param grants Granted permissions.
 * @param revokes Revoked permissions.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@KotlinBuilder
data class PermissionDto (

    /* Granted permissions. */
    @field:JsonProperty("grants")
    val grants: kotlin.collections.List<PermissionItemDto> = listOf(),

    /* Revoked permissions. */
    @field:JsonProperty("revokes")
    val revokes: kotlin.collections.List<PermissionItemDto> = listOf()

)

