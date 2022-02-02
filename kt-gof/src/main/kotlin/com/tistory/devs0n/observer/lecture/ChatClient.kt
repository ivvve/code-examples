package com.tistory.devs0n.observer.lecture

class ChatClient(
    val name: String
) : Subscriber {
    override fun onMessage(message: String) {
        println("${this.name} - $message")
    }

    override fun toString(): String {
        return "ChatClient(name='$name')"
    }
}
