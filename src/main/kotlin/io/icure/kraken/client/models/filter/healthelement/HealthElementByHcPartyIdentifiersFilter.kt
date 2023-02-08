package io.icure.kraken.client.models.filter.healthelement

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import org.taktik.icure.services.external.rest.v2.dto.HealthElementDto
import org.taktik.icure.services.external.rest.v2.dto.base.IdentifierDto
import io.icure.kraken.client.models.filter.AbstractFilterDto

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class HealthElementByHcPartyIdentifiersFilter(
    override val desc: String? = null,
    val healthcarePartyId: String? = null,
    val identifiers: List<IdentifierDto> = emptyList(),
) : AbstractFilterDto<HealthElementDto>
