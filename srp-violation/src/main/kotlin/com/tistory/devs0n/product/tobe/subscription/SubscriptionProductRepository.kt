package com.tistory.devs0n.product.tobe.subscription

import com.tistory.devs0n.product.asis.ProductId
import com.tistory.devs0n.product.asis.ProductRepository
import com.tistory.devs0n.product.asis.ProductType

class SubscriptionProductRepository(
    private val productRepository: ProductRepository,
) {
    fun save(entity: SubscriptionProduct): SubscriptionProduct {
        this.productRepository.save(entity.product)
        return entity
    }

    fun findById(id: ProductId): SubscriptionProduct? {
        return this.productRepository.findByIdAndType(id = id, type = ProductType.SUBSCRIPTION)
            ?.let(::SubscriptionProduct)
    }
}
