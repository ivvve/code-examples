package io.github.ivvve.DecoratorPattern.coffee

abstract class CondimentDecorator : Beverage()

class Mocha(private val beverage: Beverage) : CondimentDecorator() {
    override val decryption = "모카"

    override fun cost(): Double {
        return this.beverage.cost() + 0.20
    }

    override fun getDecryption(): String {
        return "${this.beverage.getDecryption()} ${this.decryption}"
    }
}
