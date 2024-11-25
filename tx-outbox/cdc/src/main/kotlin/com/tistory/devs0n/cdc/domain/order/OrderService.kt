package com.tistory.devs0n.cdc.domain.order

import com.tistory.devs0n.cdc.domain.order.event.OrderEventPublisher
import com.tistory.devs0n.cdc.domain.order.event.OrderPlacedEvent
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderService(
    private val orderRepository: OrderRepository,
    private val orderEventPublisher: OrderEventPublisher,
) {

    // Order와 Event는 동일한 Transactional으로 DB에 저장된다.
    @Transactional
    fun placeOrder(productId: String, quantity: Int): Order {
        val order = this.orderRepository.save(Order(productId = productId, quantity = quantity))
        this.orderEventPublisher.orderPlaced(OrderPlacedEvent(orderId = order.id!!))
        return order
    }
}
