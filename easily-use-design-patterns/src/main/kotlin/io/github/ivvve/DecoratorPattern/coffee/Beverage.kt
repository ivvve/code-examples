package io.github.ivvve.DecoratorPattern.coffee

abstract class Beverage {
    internal abstract val decryption: String
    abstract fun cost(): Double

    override fun toString(): String {
        return "${this.getDecryption()}: ${this.cost()}"
    }

    open fun getDecryption(): String {
        return this.decryption
    }
}

class Espresso : Beverage() {
    override val decryption = "에스프레소"
    override fun cost() = 1.9
}

class HouseBlend: Beverage() {
    override val decryption = "하우스 블렌드 커피"
    override fun cost() = 0.89
}