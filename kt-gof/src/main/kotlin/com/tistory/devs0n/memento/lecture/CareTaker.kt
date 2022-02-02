package com.tistory.devs0n.memento.lecture

fun main() {
    val game = Game()
    game.increaseBlueTeamScore(10)
    game.increaseRedTeamScore(20)
    println(game)

    val gameSave = game.save()

    println("==========")

    game.increaseBlueTeamScore(40)
    game.increaseRedTeamScore(20)
    println(game)

    println("==========")

    game.restore(gameSave)
    println(game)
}
