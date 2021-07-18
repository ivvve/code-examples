package com.tistory.devs0n.catalog.domain

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("catalogs")
class Catalog {
    @Id
    var id: Long? = null
        private set

    @Column("product_id")
    val productId: String

    @Column("name")
    val name: String

    @Column("stock")
    val stock: Int

    @Column("unit_price")
    val unitPrice: Long

    @Column("created_at")
    val createdAt: LocalDateTime

    constructor(productId: String, name: String, stock: Int, unitPrice: Long) {
        this.productId = productId
        this.name = name
        this.stock = stock
        this.unitPrice = unitPrice
        this.createdAt = LocalDateTime.now()
    }
}
