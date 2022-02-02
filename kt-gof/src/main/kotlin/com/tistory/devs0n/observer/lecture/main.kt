package com.tistory.devs0n.observer.lecture

fun main() {
    val chatServer = ChatServer()

    val subscriber1: Subscriber = ChatClient("Lim")
    val subscriber2: Subscriber = ChatClient("Na")
    val subscriber3: Subscriber = ChatClient("Son")

    chatServer.register("Django", subscriber1)
    chatServer.register("Django", subscriber2)
    chatServer.register("Django", subscriber3)
    chatServer.register("Spring", subscriber3)

    chatServer.sendMessage(subscriber1, "Django", "Django 3.0 has been released")

    println("----")

    chatServer.unregister("Django", subscriber3)

    chatServer.sendMessage(subscriber3, "Spring", "Spring 6.0 has been released")
}
