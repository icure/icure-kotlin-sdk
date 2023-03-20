package io.icure.kraken.client.extendedapis.mapper

import io.icure.kraken.client.models.decrypted.ClassificationDto
import org.mapstruct.Mapper

@Mapper
interface ClassificationMapper {
    fun map(classification: ClassificationDto): org.taktik.icure.services.external.rest.v2.dto.ClassificationDto
    fun map(classification: org.taktik.icure.services.external.rest.v2.dto.ClassificationDto): ClassificationDto
}

object ClassificationMapperFactory {
    val instance = ClassificationMapperImpl()
}
