package com.tistory.devs0n.lock.product

interface ProductRepository {
    fun save(product: Product): Product

    fun saveAll(products: List<Product>): List<Product>

    fun findByNumber(number: Long): Product?

    fun findAllByNumberIn(numbers: List<Long>): List<Product>
}
