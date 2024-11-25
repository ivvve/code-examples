package com.tistory.devs0n.cdc.event.listener

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.tistory.devs0n.cdc.domain.order.event.OrderPlacedEvent
import io.github.oshai.kotlinlogging.KotlinLogging
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class OrderEventListener {
    private val logger = KotlinLogging.logger {}

    @KafkaListener(topics = ["order.placed"])
    fun listenOrderPlacedEvent(eventRecord: ConsumerRecord<String, String>) {
        val rawEventMessage = eventRecord.value()
        val orderPlacedEvent = eventObjectMapper.readValue<OrderPlacedEvent>(rawEventMessage)
        this.logger.info { "Order placed event: $orderPlacedEvent" }

        // do something with OrderPlacedEvent
    }

    companion object {
        private val eventObjectMapper = jacksonObjectMapper()
    }
}
