package com.tistory.devs0n.cdc.event.listener

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import io.github.oshai.kotlinlogging.KotlinLogging
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class CdcEventListener(
    private val kafkaTemplate: KafkaTemplate<String, Any>,
) {
    private val logger = KotlinLogging.logger {}

    @KafkaListener(topics = ["cdc.playground.events"])
    fun listenCdcEvent(cdcEventRecord: ConsumerRecord<String, String>) {
        // CDC event
        val rawCdcEventMessage = cdcEventRecord.value()
        this.logger.debug { "Raw CDC event message: \n${rawCdcEventMessage}" }
        val cdcEvent = objectMapper.readValue<Map<String, Any>>(rawCdcEventMessage)
        val cdcPayload = cdcEvent["payload"] as Map<String, Any>

        // domain event
        val eventMessage = cdcPayload["after"] as LinkedHashMap<String, Any>
        this.logger.info { "Event message in CDC event: $eventMessage" }
        val topic = eventMessage["topic"] as String
        val partitionKey = eventMessage["partition_key"] as String
        val payload = eventMessage["payload"] as String

        // publish domain event message
        this.kafkaTemplate.send(topic, partitionKey, payload)
    }

    companion object {
        private val objectMapper = jacksonObjectMapper().apply {
            configure(DeserializationFeature.USE_LONG_FOR_INTS, true)
        }
    }
}
