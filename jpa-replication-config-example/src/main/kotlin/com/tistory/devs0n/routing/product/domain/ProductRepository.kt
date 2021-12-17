package com.tistory.devs0n.routing.product.domain

import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long> {
    fun findBySku(sku: SKU): Product?

    fun existsBySku(sku: SKU): Boolean
}
