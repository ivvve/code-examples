package com.tistory.devs0n.lock.product

import java.math.BigDecimal

class Product {
    var number: Long? = null
        private set

    val name: String

    var stockQuantity: Int
        private set

    var price: BigDecimal
        private set

    constructor(name: String, stock: Int, price: BigDecimal) {
        if (name.isBlank()) { throw RuntimeException() }
        if (stock < 0) { throw RuntimeException() }
        if (price.isNegative()) { throw RuntimeException() }

        this.name = name
        this.stockQuantity = stock
        this.price = price
    }

    fun addStock(quantity: Int) {
        this.stockQuantity += quantity
    }

    fun reduceStock(quantity: Int) {
        if ((this.stockQuantity - quantity).isNegative()) {
            throw RuntimeException() // TODO out of stock
        }

        this.stockQuantity -= quantity
    }
}

fun Int.isNegative(): Boolean = (this < 0)

fun BigDecimal.isNegative(): Boolean = (this < BigDecimal.ZERO)
