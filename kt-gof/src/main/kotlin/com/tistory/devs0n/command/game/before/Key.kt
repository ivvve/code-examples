package com.tistory.devs0n.command.game.before

class Key(
    val cookie: Cookie,
) {
    private var jump = "z"
    private var slice = "x"

    fun push(key: String) {
        println("$key key is pushed")

        when (key) {
            this.jump -> this.cookie.jump()
            this.slice -> this.cookie.slide()
        }
    }

    fun changeJumpKey(key: String) {
        this.jump = key
    }

    fun changeSlideKey(key: String) {
        this.slice = key
    }
}
