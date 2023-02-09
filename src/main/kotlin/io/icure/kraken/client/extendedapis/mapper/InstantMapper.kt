package io.icure.kraken.client.extendedapis.mapper

import org.mapstruct.Mapper
import java.time.Instant
import java.time.OffsetDateTime
import java.time.ZoneOffset

@Mapper
abstract class InstantMapper {

    fun map(instant: Instant): OffsetDateTime {
        return instant.atOffset(ZoneOffset.UTC)
    }

    fun map(odt: OffsetDateTime): Instant {
        return odt.toInstant()
    }

}

object InstantMapperFactory {
    val instance = InstantMapperImpl()
}