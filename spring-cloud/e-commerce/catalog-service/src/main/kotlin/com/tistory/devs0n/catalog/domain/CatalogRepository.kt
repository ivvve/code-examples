package com.tistory.devs0n.catalog.domain

import org.springframework.data.repository.CrudRepository

interface CatalogRepository : CrudRepository<Catalog, Long> {
    fun findByProductId(productId: String): Catalog?
}
