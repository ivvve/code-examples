package com.tistory.devs0n.command.game.after.invoker

import com.tistory.devs0n.command.game.after.command.Command

class Key(
    val key: String,
    var command: Command,
) {
    fun push() {
        println("${this.key} key is pushed")
        this.command.execute()
    }

    fun changeCommand(command: Command) {
        this.command = command
    }
}
