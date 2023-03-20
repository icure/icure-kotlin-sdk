package io.icure.kraken.client.extendedapis.mapper

import io.icure.kraken.client.models.decrypted.InvoiceDto
import org.mapstruct.InjectionStrategy
import org.mapstruct.Mapper

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
interface InvoiceMapper {
    fun map(invoice: InvoiceDto): org.taktik.icure.services.external.rest.v2.dto.InvoiceDto
    fun map(invoice: org.taktik.icure.services.external.rest.v2.dto.InvoiceDto): InvoiceDto
}

object InvoiceMapperFactory {
    val instance = InvoiceMapperImpl()
}
