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
    var orderId: String
        private set

    @Column("user_id")
    var userId: String
        private set

    @Column("product_id")
    var productId: String
        private set

    @Column("quantity")
    var quantity: Int
        private set

    @Column("unit_price")
    var unitPrice: Long
        private set

    @Column("total_price")
    var totalPrice: Long
        private set

    constructor(userId: String, productId: String, quantity: Int, unitPrice: Long) {
        this.orderId = UUID.randomUUID().toString()
        this.userId = userId
        this.productId = productId
        this.quantity = quantity
        this.unitPrice = unitPrice
        this.totalPrice = quantity * unitPrice
    }
}
