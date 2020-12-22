package io.github.ivvve.ObserverPattern

fun main() {
    val digitObserver = DigitObserver()
    val graphObserver = GraphObserver()

    // Subject
    val numberGenerator = RandomNumberGenerator()
    numberGenerator.addObserver(digitObserver)
    numberGenerator.addObserver(graphObserver)

    numberGenerator.execute()
}