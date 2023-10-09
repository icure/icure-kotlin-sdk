package io.icure.kraken.client.extendedapis.mapper

import io.icure.kraken.client.models.decrypted.PatientDto
import org.mapstruct.InjectionStrategy
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper(uses = [ByteArrayMapper::class, ListMapper::class], injectionStrategy = InjectionStrategy.CONSTRUCTOR)
interface PatientMapper {
    @Mappings(
        Mapping(target = "notes", ignore = true),
    )
    fun map(patient: PatientDto): org.taktik.icure.services.external.rest.v2.dto.PatientDto
    fun map(patient: org.taktik.icure.services.external.rest.v2.dto.PatientDto): PatientDto
}

object PatientMapperFactory {
    val instance = PatientMapperImpl(ByteArrayMapperImpl(), ListMapperImpl())
}
