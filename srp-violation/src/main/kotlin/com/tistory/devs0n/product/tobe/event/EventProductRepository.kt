package com.tistory.devs0n.product.tobe.event

import com.tistory.devs0n.product.asis.ProductId
import com.tistory.devs0n.product.asis.ProductRepository
import com.tistory.devs0n.product.asis.ProductType

class EventProductRepository(
    private val productRepository: ProductRepository,
) {
    fun save(entity: EventProduct): EventProduct {
        this.productRepository.save(entity.product)
        return entity
    }

    fun findById(id: ProductId): EventProduct? {
        return this.productRepository.findByIdAndType(id = id, type = ProductType.EVENT)
            ?.let(::EventProduct)
    }
}
