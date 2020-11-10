package io.github.ivvve.AbstractFactoryPattern.`02`

class StateFactory: Factory() {
    override fun createTire(): TireProduct {
        return StateTireProductProduct()
    }

    override fun createDoor(): DoorProduct {
        return StateDoorProductProduct()
    }
}

class StateTireProductProduct: TireProduct() {
    override fun makeAssemble() {
        println("State Tire assembled")
    }
}

class StateDoorProductProduct: DoorProduct() {
    override fun makeAssemble() {
        println("State Door assembled")
    }
}
