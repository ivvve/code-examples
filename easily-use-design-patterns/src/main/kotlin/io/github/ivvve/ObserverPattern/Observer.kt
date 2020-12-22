package io.github.ivvve.ObserverPattern

interface Observer {
    fun update(numberGenerator: NumberGenerator)
}

class DigitObserver : Observer {
    override fun update(numberGenerator: NumberGenerator) {
        println("DigitObserver: ${numberGenerator.getNumber()}")
    }
}

class GraphObserver : Observer {
    override fun update(numberGenerator: NumberGenerator) {
        val graph = "*".repeat(numberGenerator.getNumber())
        println("GraphObserver: $graph")
    }
}
