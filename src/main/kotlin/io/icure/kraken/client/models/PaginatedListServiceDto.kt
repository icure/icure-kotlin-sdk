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

import io.icure.kraken.client.models.PaginatedDocumentKeyIdPairObject
import io.icure.kraken.client.models.ServiceDto

import com.squareup.moshi.Json

/**
 * 
 * @param pageSize 
 * @param totalSize 
 * @param rows 
 * @param nextKeyPair 
 */

data class PaginatedListServiceDto (
    @Json(name = "pageSize")
    val pageSize: kotlin.Int,
    @Json(name = "totalSize")
    val totalSize: kotlin.Int,
    @Json(name = "rows")
    val rows: kotlin.collections.List<ServiceDto>,
    @Json(name = "nextKeyPair")
    val nextKeyPair: PaginatedDocumentKeyIdPairObject? = null
)

