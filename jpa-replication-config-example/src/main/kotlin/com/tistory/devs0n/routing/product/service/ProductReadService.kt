package com.tistory.devs0n.routing.product.service

import com.tistory.devs0n.routing.product.domain.Product
import com.tistory.devs0n.routing.product.domain.ProductRepository
import com.tistory.devs0n.routing.product.domain.SKU
import com.tistory.devs0n.routing.product.exceptions.ProductIsNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductReadService(
    private val productRepository: ProductRepository,
) {
    @Transactional(readOnly = true)
    fun getProductBySKU(query: GetProductBySKUQuery): Product {
        println("============== getProductBySKU 시작 ==============")

        return this.productRepository.findBySku(query.sku)
            ?: throw ProductIsNotFoundException(query.sku)
    }

    data class GetProductBySKUQuery(
        val sku: SKU,
    )
}
