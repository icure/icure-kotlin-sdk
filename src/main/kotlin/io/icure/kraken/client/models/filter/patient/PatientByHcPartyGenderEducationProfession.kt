/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */
package io.icure.kraken.client.models.filter.patient

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import org.taktik.icure.services.external.rest.v2.dto.PatientDto
import io.icure.kraken.client.models.filter.AbstractFilterDto
import org.taktik.icure.services.external.rest.v2.dto.embed.GenderDto

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class PatientByHcPartyGenderEducationProfession(
    override val desc: String? = null,
    val healthcarePartyId: String? = null,
    val gender: GenderDto? = null,
    val education: String? = null,
    val profession: String? = null
) : AbstractFilterDto<PatientDto>
