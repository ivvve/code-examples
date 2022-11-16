package com.tistory.devs0n.product.tobe.goods

import com.tistory.devs0n.product.asis.Product
import com.tistory.devs0n.product.asis.ProductId
import com.tistory.devs0n.product.asis.ProductType
import java.math.BigDecimal

class GoodsProduct(
    internal val product: Product
) {
    init {
        require(product.type == ProductType.GOODS)
    }

    val id: ProductId = this.product.id
    val type: ProductType = this.product.type
    val name: String = this.product.name
    val price: BigDecimal = this.product.price
    val forSale: Boolean = this.product.forSale

    fun methodForGoods1() { /** 굿즈 상품 전용 메서드 1 **/ }
    fun methodForGoods2() { /** 굿즈 상품 전용 메서드 2 **/ }

    companion object {
        fun create(
            id: ProductId,
            name: String,
            price: BigDecimal,
            forSale: Boolean,
        ): GoodsProduct {
            return GoodsProduct(
                Product.createGoods(
                    id = id,
                    name = name,
                    price = price,
                    forSale = forSale,
                )
            )
        }
    }
}
