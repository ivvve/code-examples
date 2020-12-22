package io.github.ivvve.TemplateMethod

/**
 * If constructor parameter is "Hello World",
 * it displays like this:
 * +-------------+
 * | Hello World |
 * | Hello World |
 * | Hello World |
 * | Hello World |
 * +-------------+
 */
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