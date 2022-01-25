package com.tistory.devs0n.memento.book

// caretaker
fun main() {
    val gamer = Gamer(money = 100)
    var memento = gamer.createMemento()

    repeat(10) { i->
        println("==== $i")
        println("Gamer - money: ${gamer.money}, fruits: ${gamer.fruits}")

        gamer.bet()

        println("Your money is `${gamer.money}`")

        if (memento.money < gamer.money) {
            memento = gamer.createMemento()
            println("Save!")
        } else if (gamer.money < (memento.money / 2)) {
            gamer.restoreMemento(memento)
            println("Load...")
        }

        Thread.sleep(300)
        println()
    }
}
