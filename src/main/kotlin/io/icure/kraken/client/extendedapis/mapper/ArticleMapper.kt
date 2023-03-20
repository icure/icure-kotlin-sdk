package io.icure.kraken.client.extendedapis.mapper

import io.icure.kraken.client.models.decrypted.ArticleDto
import org.mapstruct.InjectionStrategy
import org.mapstruct.Mapper

@Mapper(uses = [ServiceMapper::class], injectionStrategy = InjectionStrategy.CONSTRUCTOR)
interface ArticleMapper {
    fun map(article: ArticleDto): org.taktik.icure.services.external.rest.v2.dto.ArticleDto
    fun map(article: org.taktik.icure.services.external.rest.v2.dto.ArticleDto): ArticleDto
}

object ArticleMapperFactory {
    val instance = ArticleMapperImpl(ServiceMapperImpl(
        InstantMapperImpl(),
        ByteArrayMapperImpl()
    ))
}
