package com.tistory.devs0n.command.game.after.command

import com.tistory.devs0n.command.game.after.receiver.Cookie

class JumpCommand(
    val cookie: Cookie,
) : Command {
    override fun execute() {
        this.cookie.jump()
    }
}
