package com.tistory.devs0n.order.application

import com.tistory.devs0n.order.domain.Order
import com.tistory.devs0n.order.domain.OrderRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderService(
    private val orderRepository: OrderRepository
) {
    @Transactional
    fun createOrder(userId: String, productId: String, quantity: Int, unitPrice: Long) =
        this.orderRepository.save(
            Order(userId, productId, quantity, unitPrice)
        )

    @Transactional(readOnly = true)
    fun getUserOrders(userId: String): List<Order>  {
        throw IllegalArgumentException("YABAL")
        return this.orderRepository.findAllByUserId(userId)
    }
}
