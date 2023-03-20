package io.icure.kraken.client.extendedapis.mapper

import io.icure.kraken.client.models.decrypted.HealthElementDto
import org.mapstruct.Mapper

@Mapper
interface HealthElementMapper {
    fun map(healthElement: HealthElementDto): org.taktik.icure.services.external.rest.v2.dto.HealthElementDto
    fun map(healthElement: org.taktik.icure.services.external.rest.v2.dto.HealthElementDto): HealthElementDto
}

object HealthElementMapperFactory {
    val instance = HealthElementMapperImpl()
}
