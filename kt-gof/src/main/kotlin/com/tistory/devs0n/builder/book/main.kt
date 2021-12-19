package com.tistory.devs0n.builder.book

fun main() {
    val textDirector = Director(TextBuilder())
    val text = textDirector.construct()
    println(text)

    println("===========")

    val htmlDirector = Director(HTMLBuilder())
    val html = htmlDirector.construct()
    println(html)
}
