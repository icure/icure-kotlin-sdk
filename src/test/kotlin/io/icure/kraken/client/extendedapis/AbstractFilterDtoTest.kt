package io.icure.kraken.client.extendedapis

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import io.icure.kraken.client.infrastructure.ByteArrayWrapper
import io.icure.kraken.client.infrastructure.ByteArrayWrapperDeserializer
import io.icure.kraken.client.infrastructure.ByteArrayWrapperSerializer
import io.icure.kraken.client.infrastructure.FilterDeserializer
import io.icure.kraken.client.infrastructure.TestUtils
import io.icure.kraken.client.models.HealthElementDto
import io.icure.kraken.client.models.filter.AbstractFilterDto
import io.icure.kraken.client.models.filter.chain.FilterChain

internal class AbstractFilterDtoTest {
    @org.junit.jupiter.api.Test
    fun testDeserialize() {
        val objectMapper = ObjectMapper()
            .registerModule(object : SimpleModule() {
                override fun setupModule(context: SetupContext) {
                    addDeserializer(AbstractFilterDto::class.java, FilterDeserializer())
                    super.setupModule(context)
                }
            })
            .registerModule(KotlinModule())
            .registerModule(object : SimpleModule() {
                override fun setupModule(context: SetupContext?) {
                    addDeserializer(ByteArrayWrapper::class.java, ByteArrayWrapperDeserializer())
                    addSerializer(ByteArrayWrapper::class.java, ByteArrayWrapperSerializer())
                    super.setupModule(context)
                }
            })

        objectMapper.readValue<AbstractFilterDto<*>>("{\"\$type\":\"HealthElementByHcPartyTagCodeFilter\",\"tagCode\":\"proven\",\"tagType\":\"CD-CERTAINTY\",\"healthCarePartyId\":\"160f0d0e-430d-41f2-8f0d-0e430d21f287\"}", AbstractFilterDto::class.java)
        val res = TestUtils.objectMapper.readValue<FilterChain<HealthElementDto>>("{\"filter\":{\"\$type\":\"HealthElementByHcPartyTagCodeFilter\",\"tagCode\":\"proven\",\"tagType\":\"CD-CERTAINTY\",\"healthCarePartyId\":\"160f0d0e-430d-41f2-8f0d-0e430d21f287\"}}")
    }
}
