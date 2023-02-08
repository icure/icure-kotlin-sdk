package io.icure.kraken.client.extendedapis.mapper

import io.icure.kraken.client.models.decrypted.ContentDto
import io.icure.kraken.client.models.decrypted.ServiceDto
import org.mapstruct.Mapper

@Mapper
interface ServiceMapper {
    fun map(service: ServiceDto): org.taktik.icure.services.external.rest.v2.dto.embed.ServiceDto
    fun map(service: org.taktik.icure.services.external.rest.v2.dto.embed.ServiceDto): ServiceDto

    fun map(content: ContentDto): org.taktik.icure.services.external.rest.v2.dto.embed.ContentDto
    fun map(content: org.taktik.icure.services.external.rest.v2.dto.embed.ContentDto): ContentDto
}

object ServiceMapperFactory {
    val instance = ServiceMapperImpl()
}
