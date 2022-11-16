package com.tistory.devs0n.product.asis

import java.math.BigDecimal
import java.time.LocalDate

class Product private constructor(
    id: ProductId,
    type: ProductType,
    name: String,
    price: BigDecimal,
    forSale: Boolean,
    subscriptionPeriodInMonth: Int?,
    salesStartsDate: LocalDate?,
    salesEndsDate: LocalDate?,
) {
    // 상품 id
    val id: ProductId = id

    // 상품 타입
    val type: ProductType = type

    // 상품명
    val name: String = name

    // 금액
    val price: BigDecimal = price

    // 판매 여부
    val forSale: Boolean = forSale

    // 구독 기간 (월 단위) - 구독 상품인 경우에만 not null
    val subscriptionPeriodInMonth: Int? = subscriptionPeriodInMonth

    // 판매 시작 일자 - 이벤트 상품인 경우에만 not null
    val salesStartsDate: LocalDate? = salesStartsDate

    // 판매 종료 일자 - 이벤트 상품인 경우에만 not null
    val salesEndsDate: LocalDate? = salesEndsDate

    companion object {
        // 굿즈 상품 생성
        fun createGoods(
            id: ProductId,
            name: String,
            price: BigDecimal,
            forSale: Boolean,
        ): Product {
            return Product(
                id = id,
                type = ProductType.GOODS,
                name = name,
                price = price,
                forSale = forSale,
                subscriptionPeriodInMonth = null,
                salesStartsDate = null,
                salesEndsDate = null,
            )
        }

        // 구독 상품 생성
        fun createSubscription(
            id: ProductId,
            name: String,
            price: BigDecimal,
            forSale: Boolean,
            subscriptionPeriodInMonth: Int,
        ): Product {
            return Product(
                id = id,
                type = ProductType.SUBSCRIPTION,
                name = name,
                price = price,
                forSale = forSale,
                subscriptionPeriodInMonth = subscriptionPeriodInMonth,
                salesStartsDate = null,
                salesEndsDate = null,
            )
        }

        // 이벤트 상품 생성
        fun createEvent(
            id: ProductId,
            name: String,
            price: BigDecimal,
            forSale: Boolean,
            salesStartsDate: LocalDate,
            salesEndsDate: LocalDate,
        ): Product {
            return Product(
                id = id,
                type = ProductType.EVENT,
                name = name,
                price = price,
                forSale = forSale,
                subscriptionPeriodInMonth = null,
                salesStartsDate = salesStartsDate,
                salesEndsDate = salesEndsDate,
            )
        }
    }
}

enum class ProductType {
    GOODS,
    SUBSCRIPTION,
    EVENT,
}
