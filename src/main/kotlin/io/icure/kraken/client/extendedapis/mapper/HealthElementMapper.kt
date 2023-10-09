package io.icure.kraken.client.extendedapis.mapper

import io.icure.kraken.client.models.decrypted.HealthElementDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper
interface HealthElementMapper {
    @Mappings(
        Mapping(target = "notes", ignore = true),
    )
    fun map(healthElement: HealthElementDto): org.taktik.icure.services.external.rest.v2.dto.HealthElementDto
    fun map(healthElement: org.taktik.icure.services.external.rest.v2.dto.HealthElementDto): HealthElementDto
}

object HealthElementMapperFactory {
    val instance = HealthElementMapperImpl()
}
