package com.tistory.devs0n.routing.product.domain

import java.time.Instant
import javax.persistence.*

@Entity
@Table(
    name = "products",
    indexes = [
        Index(name = "sku_index", columnList = "sku", unique = true)
    ]
)
class Product(
    @Embedded
    val sku: SKU,

    @Column(name = "manufacturing_date")
    val manufacturingDate: Instant,

    @Column(name = "receiving_date")
    val receivingDate: Instant,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "sold")
    var sold: Boolean = false
        private set

    @Column(name = "sold_datetime")
    var soldDateTime: Instant? = null
        private set

    @Column(name = "shipping_datetime")
    var shippingDateTime: Instant? = null
        private set

    fun getSold() {
        this.sold = true
        this.soldDateTime = Instant.now()
    }

    fun getShipped() {
        this.shippingDateTime = Instant.now()
    }
}
