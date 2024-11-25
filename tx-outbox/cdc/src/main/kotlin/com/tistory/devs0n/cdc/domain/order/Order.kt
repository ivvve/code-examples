package com.tistory.devs0n.cdc.domain.order

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table(name = "orders")
class Order {
    @Id
    var id: Long? = null
        private set

    @Column(value = "product_id")
    val productId: String

    @Column(value = "quantity")
    val quantity: Int

    @Column(value = "created_at")
    @CreatedDate
    val createdAt: LocalDateTime = LocalDateTime.now()

    @Column(value = "updated_at")
    @LastModifiedDate
    val updatedAt: LocalDateTime = LocalDateTime.now()

    constructor(productId: String, quantity: Int) {
        require(productId.isNotBlank())
        require(0 < quantity)

        this.productId = productId
        this.quantity = quantity
    }
}
