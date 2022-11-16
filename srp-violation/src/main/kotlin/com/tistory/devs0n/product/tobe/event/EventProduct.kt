package com.tistory.devs0n.product.tobe.event

import com.tistory.devs0n.product.asis.Product
import com.tistory.devs0n.product.asis.ProductId
import com.tistory.devs0n.product.asis.ProductType
import java.math.BigDecimal
import java.time.LocalDate

class EventProduct(
    internal val product: Product
) {
    init {
        require(product.type == ProductType.EVENT)
    }

    val id: ProductId = this.product.id
    val type: ProductType = this.product.type
    val name: String = this.product.name
    val price: BigDecimal = this.product.price
    val forSale: Boolean = this.product.forSale
    val salesStartsDate: LocalDate = this.product.salesStartsDate
        ?: throw IllegalStateException("salesStartsDate is not defiend")
    val salesEndsDate: LocalDate = this.product.salesEndsDate
        ?: throw IllegalStateException("salesEndsDate is not defiend")

    fun methodForEvent1() { /** 이벤트 상품 전용 메서드 1 **/ }
    fun methodForEvent2() { /** 이벤트 상품 전용 메서드 2 **/ }
    fun methodForEvent3() { /** 이벤트 상품 전용 메서드 3 **/ }

    companion object {
        fun create(
            id: ProductId,
            name: String,
            price: BigDecimal,
            forSale: Boolean,
            salesStartsDate: LocalDate,
            salesEndsDate: LocalDate,
        ): EventProduct {
            return EventProduct(
                Product.createEvent(
                    id = id,
                    name = name,
                    price = price,
                    forSale = forSale,
                    salesStartsDate = salesStartsDate,
                    salesEndsDate = salesEndsDate,
                )
            )
        }
    }
}
