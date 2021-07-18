package com.tistory.devs0n.order.domain

import org.springframework.data.repository.CrudRepository

interface OrderRepository : CrudRepository<Order, Long> {
    fun findByOrderId(orderId: String): Order?

    fun findAllByUserId(userId: String): List<Order>
}
