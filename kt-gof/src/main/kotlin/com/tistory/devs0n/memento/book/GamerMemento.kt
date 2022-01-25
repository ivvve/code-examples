package com.tistory.devs0n.memento.book

class GamerMemento(
    val money: Int,
) {
    val fruits: MutableList<String> = mutableListOf()

    fun addFruit(fruit: String) {
        this.fruits.add(fruit)
    }
}
