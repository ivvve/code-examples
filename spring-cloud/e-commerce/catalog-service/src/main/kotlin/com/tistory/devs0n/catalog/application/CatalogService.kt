package com.tistory.devs0n.catalog.application

import com.tistory.devs0n.catalog.domain.Catalog
import com.tistory.devs0n.catalog.domain.CatalogRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CatalogService(
    private val catalogRepository: CatalogRepository
) {
    @Transactional(readOnly = true)
    fun getCatalogOf(productId: String): Catalog =
        this.catalogRepository.findByProductId(productId)
            ?: throw RuntimeException("Catalog of the product($productId) not found")
}
