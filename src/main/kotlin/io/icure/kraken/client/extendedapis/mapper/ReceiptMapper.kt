package io.icure.kraken.client.extendedapis.mapper

import io.icure.kraken.client.models.decrypted.ReceiptDto
import org.mapstruct.Mapper

@Mapper
interface ReceiptMapper {
    fun map(receipt: ReceiptDto): org.taktik.icure.services.external.rest.v2.dto.ReceiptDto
    fun map(receipt: org.taktik.icure.services.external.rest.v2.dto.ReceiptDto): ReceiptDto
}

object ReceiptMapperFactory {
    val instance = ReceiptMapperImpl()
}
