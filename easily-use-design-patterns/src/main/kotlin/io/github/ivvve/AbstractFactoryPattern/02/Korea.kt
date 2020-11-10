package io.github.ivvve.AbstractFactoryPattern.`02`

class KoreaFactory: Factory() {
    override fun createTire(): TireProduct {
        return KoreaTireProductProduct()
    }

    override fun createDoor(): DoorProduct {
        return KoreaDoorProductProduct()
    }
}

class KoreaTireProductProduct: TireProduct() {
    override fun makeAssemble() {
        println("Korea Tire assembled")
    }
}

class KoreaDoorProductProduct: DoorProduct() {
    override fun makeAssemble() {
        println("Korea Door assembled")
    }
}
