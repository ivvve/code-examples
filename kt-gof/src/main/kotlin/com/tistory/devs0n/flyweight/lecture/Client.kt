package com.tistory.devs0n.flyweight.lecture

fun main() {
    val fontFactory = FontFactory()
    val c1 = Character(value = 'a', color = "white", font = fontFactory.getFont("nanum:12"))
    val c2 = Character(value = 'b', color = "white", font = fontFactory.getFont("nanum:12"))
    val c3 = Character(value = 'c', color = "white", font = fontFactory.getFont("nanum:12"))
}
