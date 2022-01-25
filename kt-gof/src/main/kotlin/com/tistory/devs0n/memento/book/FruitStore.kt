package com.tistory.devs0n.memento.book

import kotlin.random.Random

class FruitStore {
    companion object {
        private val fruits: List<String> = listOf("귤", "포도", "사과", "바나나")

        fun getRandomly(): String {
            val fruit = this.fruits.random()
            return when (Random.nextBoolean()) {
                true -> "맛있는 $fruit"
                false -> fruit
            }
        }
    }
}
