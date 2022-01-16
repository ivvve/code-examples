package com.tistory.devs0n.command.game.before

import java.util.*

fun main() {
    val cookie = Cookie()
    val key = Key(cookie)

    key.push("z")
    key.push("x")

    println("===\nChange key mapping\n===")

    key.changeJumpKey("x")
    key.changeSlideKey("z")

    key.push("z")
    key.push("x")

    // 새로운 key가 등록이 되면 그때마다 Key의 분기문과 기능 추가에 대한 코드가 추가되어야한다
}
