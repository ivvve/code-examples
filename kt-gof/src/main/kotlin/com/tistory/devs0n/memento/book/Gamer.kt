package com.tistory.devs0n.memento.book

import kotlin.random.Random

class Gamer(
    var money: Int,
) {
    val fruits: MutableList<String> = mutableListOf()

    fun bet() {
        val diceNumber = this.rollDice()

        when (diceNumber) {
            1 -> {
                this.money += 100
                println("You got money: 100")
            }
            2 -> {
                this.money /= 2
                println("You lost money: ${this.money}")
            }
            6 -> {
                val fruit = FruitStore.getRandomly()
                this.fruits.add(fruit)
                println("You got fruit: $fruit")
            }
            else -> println("Nothing changed")
        }
    }

    private fun rollDice(): Int = Random.nextInt(1, 6)

    fun createMemento(): GamerMemento {
        val memento = GamerMemento(this.money)
        this.fruits
            .filter { it.startsWith("맛있는 ") }
            .forEach { memento.addFruit(it) }

        return memento
    }

    fun restoreMemento(memento: GamerMemento) {
        this.money = memento.money

        this.fruits.clear()
        memento.fruits.forEach{ this.fruits.add(it) }
    }
}
