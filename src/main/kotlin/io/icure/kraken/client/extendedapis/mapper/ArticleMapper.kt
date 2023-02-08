package io.icure.kraken.client.extendedapis.mapper

import io.icure.kraken.client.models.decrypted.ArticleDto
import org.mapstruct.Mapper

@Mapper
interface ArticleMapper {
    fun map(article: ArticleDto): org.taktik.icure.services.external.rest.v2.dto.ArticleDto
    fun map(article: org.taktik.icure.services.external.rest.v2.dto.ArticleDto): ArticleDto
}

object ArticleMapperFactory {
    val instance = ArticleMapperImpl()
}
