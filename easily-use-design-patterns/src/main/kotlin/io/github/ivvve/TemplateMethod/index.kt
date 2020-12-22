package io.github.ivvve.TemplateMethod

fun main() {
    val charDisplay: AbstractDisplay = CharDisplay('H')
    charDisplay.display()

    println("\n---------------------------------------------\n")

    val stringDisplay: AbstractDisplay = StringDisplay("Hello world")
    stringDisplay.display()
}
