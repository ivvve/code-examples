package io.github.ivvve.ObserverPattern

import kotlin.random.Random

// Subject
abstract class NumberGenerator {
    private val observers: MutableList<Observer> = mutableListOf()

    fun addObserver(observer: Observer) {
        this.observers.add(observer)
    }

    fun deleteObserver(observer: Observer) {
        this.observers.remove(observer)
    }

    fun notifyObservers() {
        this.observers.forEach {
            this.notifyObserver(it)
        }
    }

    private fun notifyObserver(observer: Observer) {
        observer.update(this)
    }

    abstract fun getNumber(): Int
    abstract fun execute()
}

class RandomNumberGenerator : NumberGenerator() {
    private var number: Int? = null

    override fun getNumber(): Int {
        return this.number!!
    }

    override fun execute() {
        for (i in 0 until 20) {
            this.number = Random.nextInt(50)
            super.notifyObservers()
            Thread.sleep(500)
            println()
        }
    }
}
