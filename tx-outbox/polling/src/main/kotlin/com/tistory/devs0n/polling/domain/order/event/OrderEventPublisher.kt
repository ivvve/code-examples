package com.tistory.devs0n.polling.domain.order.event

import com.fasterxml.jackson.module.kotlin.convertValue
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.tistory.devs0n.polling.event.publisher.Event
import com.tistory.devs0n.polling.event.publisher.EventPublisher
import org.springframework.stereotype.Component

@Component
class OrderEventPublisher(
    private val eventPublisher: EventPublisher,
) {
    fun orderPlaced(event: OrderPlacedEvent) {
        this.eventPublisher.publish(
            Event(
                partitionKey = event.orderId.toString(),
                topic = "order.placed",
                payload = event,
            )
        )
    }
}
