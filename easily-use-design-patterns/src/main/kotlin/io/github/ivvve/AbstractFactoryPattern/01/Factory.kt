package io.github.ivvve.AbstractFactoryPattern.`01`

abstract class Factory {
    abstract fun createTire(): Tire
    abstract fun createDoor(): Door
}

open class Tire
open class Door
