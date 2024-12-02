package com.tistory.devs0n.jooq.product

import java.math.BigDecimal
import java.time.LocalDateTime

class Product {
    val id: Long?
    val name: String
    val unitPrice: BigDecimal
    var stockQuantity: Int
        private set
    val createdAt: LocalDateTime?
    val updatedAt: LocalDateTime?

    constructor(
        id: Long?,
        name: String,
        unitPrice: BigDecimal,
        stockQuantity: Int,
        createdAt: LocalDateTime?,
        updatedAt: LocalDateTime?
    ) {
        require(BigDecimal.ZERO <= unitPrice)
        require(0 <= stockQuantity)

        this.id = id
        this.name = name
        this.unitPrice = unitPrice
        this.stockQuantity = stockQuantity
        this.createdAt = createdAt
        this.updatedAt = updatedAt
    }

    fun reduceStockQuantity(quantity: Int){
        require(0 <= quantity)
        require(quantity <= this.stockQuantity)

        this.stockQuantity -= quantity
    }

    companion object {
        fun new(name: String, unitPrice: BigDecimal, stockQuantity: Int): Product {
            return Product(
                id = null,
                name = name,
                unitPrice = unitPrice,
                stockQuantity = stockQuantity,
                createdAt = null,
                updatedAt = null,
            )
        }
    }
}
