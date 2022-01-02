package com.tistory.devs0n.composite.lecture

// Client
class Client(
    private val component: Component
) {
    fun printPrice() {
        println("Price is ${this.component.getPrice()}")
    }
}
