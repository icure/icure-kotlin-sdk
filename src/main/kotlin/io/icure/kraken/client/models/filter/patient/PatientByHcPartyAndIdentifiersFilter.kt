package io.icure.kraken.client.models.filter.patient

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import org.taktik.icure.services.external.rest.v2.dto.base.IdentifierDto
import io.icure.kraken.client.models.filter.AbstractFilterDto
import org.taktik.icure.services.external.rest.v2.dto.PatientDto

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class PatientByHcPartyAndIdentifiersFilter(
    override val desc: String? = null,
    val healthcarePartyId: String? = null,
    val identifiers: List<IdentifierDto> = emptyList(),
) : AbstractFilterDto<PatientDto>
