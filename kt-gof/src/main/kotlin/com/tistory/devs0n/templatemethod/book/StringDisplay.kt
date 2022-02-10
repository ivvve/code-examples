package com.tistory.devs0n.templatemethod.book

class StringDisplay(
    val string: String,
) : Display() {
    private val width: Int = this.string.toByteArray().size

    override fun open() {
        this.printLine()
    }

    override fun print() {
        println("|${this.string}|")
    }

    override fun close() {
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
