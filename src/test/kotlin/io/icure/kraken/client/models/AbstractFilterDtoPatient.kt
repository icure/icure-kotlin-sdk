package io.icure.kraken.client.models

import io.icure.kraken.client.models.filter.AbstractFilterDto
import org.taktik.icure.services.external.rest.v2.dto.PatientDto

interface AbstractFilterDtoPatient : AbstractFilterDto<PatientDto>
