package io.icure.kraken.client.extendedapis.mapper

import io.icure.kraken.client.infrastructure.ByteArrayWrapper
import org.mapstruct.Mapper

@Mapper
abstract class ByteArrayMapper {

    fun map(byteArrayWrapper: ByteArrayWrapper): ByteArray {
        return byteArrayWrapper.byteArray
    }

    fun map(byteArray: ByteArray): ByteArrayWrapper {
        return ByteArrayWrapper(byteArray)
    }

}

object ByteArrayMapperFactory {
    val instance = ByteArrayMapperImpl()
}