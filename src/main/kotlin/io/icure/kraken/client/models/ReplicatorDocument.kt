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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 *
 *
 * @param id
 * @param rev
 * @param source
 * @param target
 * @param owner
 * @param createTarget
 * @param continuous
 * @param docIds
 * @param replicationState
 * @param replicationStateTime
 * @param replicationStats
 * @param errorCount
 * @param revsInfo
 * @param revHistory
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class ReplicatorDocument(

    @field:JsonProperty("_id")
    val id: kotlin.String,

    @field:JsonProperty("_rev")
    val rev: kotlin.String? = null,

    @field:JsonProperty("source")
    val source: Remote? = null,

    @field:JsonProperty("target")
    val target: Remote? = null,

    @field:JsonProperty("owner")
    val owner: kotlin.String? = null,

    @field:JsonProperty("create_target")
    val createTarget: kotlin.Boolean? = null,

    @field:JsonProperty("continuous")
    val continuous: kotlin.Boolean? = null,

    @field:JsonProperty("doc_ids")
    val docIds: kotlin.collections.List<kotlin.String>? = null,

    @field:JsonProperty("_replication_state")
    val replicationState: kotlin.String? = null,

    @field:JsonProperty("_replication_state_time")
    val replicationStateTime: java.time.OffsetDateTime? = null,

    @field:JsonProperty("_replication_stats")
    val replicationStats: ReplicationStats? = null,

    @field:JsonProperty("error_count")
    val errorCount: kotlin.Int? = null,

    @field:JsonProperty("_revs_info")
    val revsInfo: kotlin.collections.List<kotlin.collections.Map<kotlin.String, kotlin.String>>? = null,

    @field:JsonProperty("rev_history")
    val revHistory: kotlin.collections.Map<kotlin.String, kotlin.String>? = null

)
