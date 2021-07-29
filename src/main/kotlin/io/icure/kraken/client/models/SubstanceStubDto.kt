/**
* iCure Cloud API Documentation
* Spring shop sample application
*
* The version of the OpenAPI document: v0.0.1
* 
*
* NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
* https://openapi-generator.tech
* Do not edit the class manually.
*/
package io.icure.kraken.client.models

import io.icure.kraken.client.models.SamTextDto
import io.icure.kraken.client.models.StandardSubstanceDto

import com.squareup.moshi.Json

/**
 * 
 * @param id 
 * @param code 
 * @param chemicalForm 
 * @param name 
 * @param note 
 * @param standardSubstances 
 */

data class SubstanceStubDto (
    @Json(name = "id")
    val id: kotlin.String? = null,
    @Json(name = "code")
    val code: kotlin.String? = null,
    @Json(name = "chemicalForm")
    val chemicalForm: kotlin.String? = null,
    @Json(name = "name")
    val name: SamTextDto? = null,
    @Json(name = "note")
    val note: SamTextDto? = null,
    @Json(name = "standardSubstances")
    val standardSubstances: kotlin.collections.List<StandardSubstanceDto>? = null
)

