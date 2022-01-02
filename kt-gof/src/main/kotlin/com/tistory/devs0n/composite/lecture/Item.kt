package com.tistory.devs0n.composite.lecture

// Leaf
class Item(
    private val name: String,
    private val price: Int,
) : Component {
    override fun getPrice(): Int = this.price
}
