package io.icure.kraken.client.models.filter.service

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import org.taktik.icure.services.external.rest.v2.dto.base.IdentifierDto
import org.taktik.icure.services.external.rest.v2.dto.embed.ServiceDto
import io.icure.kraken.client.models.filter.AbstractFilterDto

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class ServiceByHcPartyIdentifiersFilter(
    val healthcarePartyId: String? = null,
    override val desc: String? = null,
    val identifiers: List<IdentifierDto> = emptyList()
) : AbstractFilterDto<ServiceDto>
