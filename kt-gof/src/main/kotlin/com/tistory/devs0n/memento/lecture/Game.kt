package com.tistory.devs0n.memento.lecture

class Game {
    private var blueTeamScore = 0
    private var redTeamScore = 0

    fun increaseBlueTeamScore(score: Int) {
        this.blueTeamScore += score
    }

    fun increaseRedTeamScore(score: Int) {
        this.redTeamScore += score
    }

    // createMemento
    fun save(): GameSave = GameSave(
        blueTeamScore = this.blueTeamScore,
        redTeamScore = this.redTeamScore,
    )

    // restore using Memento
    fun restore(save: GameSave) {
        this.blueTeamScore = save.blueTeamScore
        this.redTeamScore = save.redTeamScore
    }

    override fun toString(): String {
        return "Game(blueTeamScore=$blueTeamScore, redTeamScore=$redTeamScore)"
    }
}
