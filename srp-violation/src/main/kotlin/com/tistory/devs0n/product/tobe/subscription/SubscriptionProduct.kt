package com.tistory.devs0n.product.tobe.subscription

import com.tistory.devs0n.product.asis.Product
import com.tistory.devs0n.product.asis.ProductId
import com.tistory.devs0n.product.asis.ProductType
import java.math.BigDecimal

class SubscriptionProduct(
    internal val product: Product
) {
    init {
        require(product.type == ProductType.SUBSCRIPTION)
    }

    val id: ProductId = this.product.id
    val type: ProductType = this.product.type
    val name: String = this.product.name
    val price: BigDecimal = this.product.price
    val forSale: Boolean = this.product.forSale
    val subscriptionPeriodInMonth: Int = this.product.subscriptionPeriodInMonth
        ?: throw IllegalStateException("subscriptionPeriodInMonth is not defiend")

    fun methodForSubscription() { /** 구독 상품 전용 메서드 **/ }

    companion object {
        fun create(
            id: ProductId,
            name: String,
            price: BigDecimal,
            forSale: Boolean,
            subscriptionPeriodInMonth: Int,
        ): SubscriptionProduct {
            return SubscriptionProduct(
                Product.createSubscription(
                    id = id,
                    name = name,
                    price = price,
                    forSale = forSale,
                    subscriptionPeriodInMonth = subscriptionPeriodInMonth,
                )
            )
        }
    }
}
