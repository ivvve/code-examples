package com.tistory.devs0n.product.asis

interface ProductRepository {
    fun save(entity: Product): Product

//    fun findById(id: ProductId): Product?

    fun findByIdAndType(id: ProductId, type: ProductType): Product?
}
