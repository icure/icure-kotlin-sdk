package io.icure.kraken.client.extendedapis.mapper

import io.icure.kraken.client.models.decrypted.AccessLogDto
import org.mapstruct.InjectionStrategy
import org.mapstruct.Mapper

@Mapper(uses = [InstantMapper::class], injectionStrategy = InjectionStrategy.CONSTRUCTOR)
interface AccessLogMapper {
    fun map(accessLog: AccessLogDto): org.taktik.icure.services.external.rest.v2.dto.AccessLogDto
    fun map(accessLog: org.taktik.icure.services.external.rest.v2.dto.AccessLogDto): AccessLogDto
}

object AccessLogMapperFactory {
    val instance = AccessLogMapperImpl(InstantMapperImpl())
}
