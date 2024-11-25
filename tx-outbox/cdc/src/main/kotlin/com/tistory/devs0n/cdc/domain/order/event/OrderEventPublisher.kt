package com.tistory.devs0n.cdc.domain.order.event

import com.tistory.devs0n.cdc.event.publisher.Event
import com.tistory.devs0n.cdc.event.publisher.EventPublisher
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
