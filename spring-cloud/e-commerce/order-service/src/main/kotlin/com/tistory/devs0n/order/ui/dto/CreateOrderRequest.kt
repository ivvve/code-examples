package com.tistory.devs0n.order.ui.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class CreateOrderRequest(
    @JsonProperty("product_id")
    val productId: String,
    @JsonProperty("quantity")
    val quantity: Int,
    @JsonProperty("unit_price")
    val unitPrice: Long,
)
