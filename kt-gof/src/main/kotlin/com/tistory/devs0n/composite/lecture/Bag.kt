package com.tistory.devs0n.composite.lecture

// Composite
class Bag : Component {
    private val components = mutableListOf<Component>()

    override fun getPrice(): Int  = this.components.sumOf { it.getPrice() }

    fun add(component: Component) {
        this.components.add(component)
    }
}
