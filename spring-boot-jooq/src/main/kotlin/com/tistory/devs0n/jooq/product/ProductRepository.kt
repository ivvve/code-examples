package com.tistory.devs0n.jooq.product

import com.tistory.devs0n.jooq.models.tables.Products.Companion.PRODUCTS
import com.tistory.devs0n.jooq.models.tables.records.ProductsRecord
import org.jooq.DSLContext
import org.jooq.impl.DSL.currentLocalDateTime
import org.jooq.types.UInteger
import org.jooq.types.ULong
import org.springframework.stereotype.Repository

@Repository
class ProductRepository(
    private val dsl: DSLContext
) {
    fun insert(product: Product): Product {
        val productRecord = this.dsl.insertInto(PRODUCTS)
            .set(PRODUCTS.NAME, product.name)
            .set(PRODUCTS.UNIT_PRICE, product.unitPrice)
            .set(PRODUCTS.STOCK_QUANTITY, UInteger.valueOf(product.stockQuantity))
            .set(PRODUCTS.CREATED_AT, currentLocalDateTime())
            .set(PRODUCTS.UPDATED_AT, currentLocalDateTime())
            .returning()
            .fetchOne()!!
        return productRecord.toProduct()
    }

    fun updateAll(products: List<Product>): List<Product> {
        // update
        val updateStatements = products.map {
            this.dsl.update(PRODUCTS)
                .set(PRODUCTS.NAME, it.name)
                .set(PRODUCTS.UNIT_PRICE, it.unitPrice)
                .set(PRODUCTS.STOCK_QUANTITY, UInteger.valueOf(it.stockQuantity))
                .set(PRODUCTS.UPDATED_AT, currentLocalDateTime())
                .where(PRODUCTS.ID.eq(ULong.valueOf(it.id!!)))
        }
        this.dsl.batch(updateStatements).execute()

        // select
        val productRecords = this.dsl.selectFrom(PRODUCTS)
            .where(PRODUCTS.ID.`in`(products.map { ULong.valueOf(it.id!!) }))
            .fetch()

        return productRecords.map { it.toProduct() }
    }

    fun getAllByIds(ids: List<Long>): List<Product> {
        val products = this.findAllByIds(ids)

        if (products.map { it.id }.sortedBy { it } != ids.sortedBy { it }) {
            throw RuntimeException("Product not found")
        }

        return products
    }

    fun findAllByIds(ids: List<Long>): List<Product> {
        val productRecords = this.dsl.selectFrom(PRODUCTS)
            .where(PRODUCTS.ID.`in`(ids.map { ULong.valueOf(it) }))
            .fetch()
        return productRecords.map { it.toProduct() }
    }
}

private fun ProductsRecord.toProduct(): Product {
    return Product(
        id = this.id!!.toLong(),
        name = this.name!!,
        unitPrice = this.unitPrice!!,
        stockQuantity = this.stockQuantity!!.toInt(),
        createdAt = this.createdAt,
        updatedAt = this.updatedAt,
    )
}
