package com.tistory.devs0n.scalar

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@Tag(name = "Product API")
@RestController
@RequestMapping("/api/products")
class ProductController {
    private val products = mutableListOf(
        Product(name = "Jeans", price = 55_000),
        Product(name = "T-shirt", price = 24_500),
    )

    @Operation(description = "제품 조회")
    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE]) // `produces` 설정을 해야 응답 예제가 나옴
    fun getProducts(): List<Product> {
        return this.products
    }

    @Operation(description = "제품 추가")
    @PostMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun addProduct(@RequestBody request: Product): Product {
        this.products.add(request)
        return request
    }
}

@Schema(description = "제품 정보")
data class Product(
    @Schema(description = "제품명", example = "Jeans")
    val name: String,
    @Schema(description = "가격", example = "55_000")
    val price: Int,
)
