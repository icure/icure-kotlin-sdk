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
data class ContactByServiceIdsFilter(
    override val desc: String? = null,
    val ids: List<String>? = null
) : AbstractFilterDto<ContactDto>
