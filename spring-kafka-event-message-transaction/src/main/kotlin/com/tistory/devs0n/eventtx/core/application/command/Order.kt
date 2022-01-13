package com.tistory.devs0n.eventtx.core.application.command

class OrderCommand {
    data class Order(
        val userId: String,
        val orderItems: List<Pair<String, Int>>,
    )
}
