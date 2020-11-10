package io.github.ivvve.AbstractFactoryPattern.`01`

class StateFactory: Factory() {
    override fun createTire(): Tire {
        return StateTireProduct()
    }

    override fun createDoor(): Door {
        return StateDoorProduct()
    }
}

class StateTireProduct: Tire()
class StateDoorProduct: Door()
