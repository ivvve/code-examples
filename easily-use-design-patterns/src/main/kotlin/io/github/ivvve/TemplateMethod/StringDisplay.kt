package io.github.ivvve.TemplateMethod

class StringDisplay(private val string: String) : AbstractDisplay() {
    override fun open() {
        this.printLine()
    }

    override fun print() {
        println("| ${this.string} |")
    }

    override fun close() {
        this.printLine()
    }

    private fun printLine() {
        println("+" + "-".repeat(this.string.length + 2) + "+")
    }
}