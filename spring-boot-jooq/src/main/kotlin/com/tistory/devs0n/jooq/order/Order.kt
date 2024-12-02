package com.tistory.devs0n.jooq.order

import java.math.BigDecimal
import java.time.LocalDateTime

class Order {
    val id: Long?
    val userId: Long
    var orderLines: List<OrderLine>
        private set
    var totalPrice: BigDecimal
        private set
    val createdAt: LocalDateTime?
    val updatedAt: LocalDateTime?

    constructor(
        id: Long?,
        userId: Long,
        orderLines: List<OrderLine>,
        totalPrice: BigDecimal,
        createdAt: LocalDateTime?,
        updatedAt: LocalDateTime?
    ) {
        require(0 < userId)
        require(orderLines.isNotEmpty())
        require(orderLines.distinctBy { it.productId }.size == orderLines.size)
        require(BigDecimal.ZERO <= totalPrice)

        this.id = id
        this.userId = userId
        this.orderLines = orderLines
        this.totalPrice = totalPrice
        this.createdAt = createdAt
        this.updatedAt = updatedAt
    }

    fun updateOrderLines(orderLines: List<OrderLine>) {
        require(orderLines.isNotEmpty())
        require(orderLines.distinctBy { it.productId }.size == orderLines.size)

        this.orderLines = orderLines
        this.totalPrice = orderLines.sumOf { it.getTotalPrice() }
    }

    companion object {
        fun new(userId: Long, orderLines: List<OrderLine>): Order {
            return Order(
                id = null,
                userId = userId, orderLines = orderLines,
                totalPrice = orderLines.sumOf { it.getTotalPrice() },
                createdAt = null, updatedAt = null,
            )
        }
    }
}
