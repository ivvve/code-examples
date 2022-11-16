package com.tistory.devs0n.product.tobe.goods

import com.tistory.devs0n.product.asis.ProductId
import com.tistory.devs0n.product.asis.ProductRepository
import com.tistory.devs0n.product.asis.ProductType

class GoodsProductRepository(
    private val productRepository: ProductRepository,
) {
    fun save(entity: GoodsProduct): GoodsProduct {
        this.productRepository.save(entity.product)
        return entity
    }

    fun findById(id: ProductId): GoodsProduct? {
        return this.productRepository.findByIdAndType(id = id, type = ProductType.GOODS)
            ?.let(::GoodsProduct)
    }
}
