/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */
package io.icure.kraken.client.models.filter.invoice

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import org.taktik.icure.services.external.rest.v2.dto.InvoiceDto
import io.icure.kraken.client.models.filter.AbstractFilterDto

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class InvoiceByHcPartyCodeDateFilter(
    override val desc: String? = null,
    val healthcarePartyId: String? = null,
    val code: String? = null,
    val startInvoiceDate: Long? = null,
    val endInvoiceDate: Long? = null
) : AbstractFilterDto<InvoiceDto>
