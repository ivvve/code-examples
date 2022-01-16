package com.tistory.devs0n.command.game.after.client

import com.tistory.devs0n.command.game.after.command.JumpCommand
import com.tistory.devs0n.command.game.after.command.MacroCommand
import com.tistory.devs0n.command.game.after.command.SlideCommand
import com.tistory.devs0n.command.game.after.invoker.Key
import com.tistory.devs0n.command.game.after.receiver.Cookie

fun main() {
    val cookie = Cookie()
    val slideCommand = SlideCommand(cookie)
    val jumpCommand = JumpCommand(cookie)

    // Command와 Receiver 연결
    val z = Key("z", slideCommand)
    val x = Key("x", jumpCommand)

    z.push()
    x.push()

    println("===\nChange key mapping\n===")

    // change key mapping
    z.changeCommand(jumpCommand)
    x.changeCommand(slideCommand)

    z.push()
    x.push()

    println("===\nClient has updated\n===")
    // 새로운 기능 추가
    val jumpAndSliceMacroCommand = MacroCommand(listOf(slideCommand, jumpCommand))
    val c = Key("c", jumpAndSliceMacroCommand)
    c.push()
}
