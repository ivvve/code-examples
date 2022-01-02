package com.tistory.devs0n.bridge.book

// Concrete Implementation
class StringDisplayImpl(
    private val string: String,
) : DisplayImpl() {
    private val width = this.string.toByteArray().size

    override fun rawOpen() {
        this.printLine()
    }

    override fun rawPrint() {
        println("|${this.string}|")
    }

    override fun rawClose() {
        this.printLine()
    }

    private fun printLine() {
        print("+")

        repeat(this.width) {
            print("-")
        }

        println("+")
    }
}
