package com.tistory.devs0n.jooq.order

import java.math.BigDecimal
import java.time.LocalDateTime

class OrderLine {
    val id: Long?
    val productId: Long
    val quantity: Int
    val unitPrice: BigDecimal
    val createdAt: LocalDateTime?
    val updatedAt: LocalDateTime?

    constructor(
        id: Long?,
        productId: Long,
        quantity: Int,
        unitPrice: BigDecimal,
        createdAt: LocalDateTime?,
        updatedAt: LocalDateTime?
    ) {
        require(0 < productId)
        require(0 < quantity)
        require(BigDecimal.ZERO <= unitPrice)

        this.id = id
        this.productId = productId
        this.quantity = quantity
        this.unitPrice = unitPrice
        this.createdAt = createdAt
        this.updatedAt = updatedAt
    }

    fun getTotalPrice(): BigDecimal {
        return unitPrice * quantity.toBigDecimal()
    }

    companion object {
        fun new(productId: Long, quantity: Int, unitPrice: BigDecimal): OrderLine {
            return OrderLine(
                id = null,
                productId = productId, quantity = quantity, unitPrice = unitPrice,
                createdAt = null, updatedAt = null,
            )
        }
    }
}
