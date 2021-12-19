package com.tistory.devs0n.prototype.book

fun main() {
    val manager = Manager()
    manager.register("strong message", UnderlinePen('~'))
    manager.register("warning box", MessageBox('*'))
    manager.register("slash box", MessageBox('/'))

    manager.create("strong message")
        .use("Hello, world")
    println("=========")
    manager.create("warning box")
        .use("Hello, world")
    println("=========")
    manager.create("slash box")
        .use("Hello, world")
}
