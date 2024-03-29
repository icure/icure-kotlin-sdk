/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */
package io.icure.kraken.client.models.filter.contact

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import org.taktik.icure.services.external.rest.v2.dto.ContactDto
import io.icure.kraken.client.models.filter.AbstractFilterDto

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class ContactByHcPartyTagCodeDateFilter(
    override val desc: String? = null,
    val healthcarePartyId: String? = null,
    val tagType: String? = null,
    val tagCode: String? = null,
    val codeType: String? = null,
    val codeCode: String? = null,
    val startOfContactOpeningDate: Long? = null,
    val endOfContactOpeningDate: Long? = null
) : AbstractFilterDto<ContactDto>
