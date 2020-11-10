package io.github.ivvve.AbstractFactoryPattern.`01`

class KoreaFactory: Factory() {
    override fun createTire(): Tire {
        return KoreaTireProduct()
    }

    override fun createDoor(): Door {
        return KoreaDoorProduct()
    }
}

class KoreaTireProduct: Tire()
class KoreaDoorProduct: Door()
