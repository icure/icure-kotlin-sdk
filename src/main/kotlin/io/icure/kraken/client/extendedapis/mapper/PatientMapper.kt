package io.icure.kraken.client.extendedapis.mapper

import io.icure.kraken.client.models.decrypted.PatientDto
import org.mapstruct.Mapper

@Mapper
interface PatientMapper {
    fun map(patient: PatientDto): org.taktik.icure.services.external.rest.v2.dto.PatientDto
    fun map(patient: org.taktik.icure.services.external.rest.v2.dto.PatientDto): PatientDto
}

object PatientMapperFactory {
    val instance = PatientMapperImpl()
}
