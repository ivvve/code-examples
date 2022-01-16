package com.tistory.devs0n.command.game.after.command

class MacroCommand(
    val commands: List<Command>,
) : Command {
    override fun execute() {
        this.commands.forEach { it.execute() }
    }
}
