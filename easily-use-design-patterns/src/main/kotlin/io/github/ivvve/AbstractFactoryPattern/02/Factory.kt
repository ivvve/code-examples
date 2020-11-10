package io.github.ivvve.AbstractFactoryPattern.`02`

abstract class Factory {
    abstract fun createTire(): TireProduct
    abstract fun createDoor(): DoorProduct
}

abstract class TireProduct {
    abstract fun makeAssemble()
}

abstract class DoorProduct {
    abstract fun makeAssemble()
}
