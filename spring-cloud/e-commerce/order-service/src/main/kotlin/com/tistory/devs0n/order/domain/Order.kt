package com.tistory.devs0n.order.domain

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("orders")
class Order {
    @Id
    var id: Long? = null
        private set

    @Column("order_id")
    val orderId: String

    @Column("user_id")
    val userId: String

    @Column("product_id")
    val productId: String

    @Column("quantity")
    val quantity: Int

    @Column("unit_price")
    val unitPrice: Long

    @Column("total_price")
    val totalPrice: Long

    constructor(userId: String, productId: String, quantity: Int, unitPrice: Long) {
        this.orderId = UUID.randomUUID().toString()
        this.userId = userId
        this.productId = productId
        this.quantity = quantity
        this.unitPrice = unitPrice
        this.totalPrice = quantity * unitPrice
    }
}