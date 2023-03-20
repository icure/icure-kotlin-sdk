package io.icure.kraken.client.extendedapis.mapper

import org.mapstruct.Mapper

@Mapper
abstract class ListMapper {

    fun map(list: List<String>): Array<String> {
        return list.toTypedArray()
    }

    fun map(array: Array<String>): List<String> {
        return array.toList()
    }

}

object ListMapperFactory {
    val instance = ListMapperImpl()
}
