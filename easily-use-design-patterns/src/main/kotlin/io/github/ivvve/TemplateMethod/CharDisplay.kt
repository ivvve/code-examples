package io.github.ivvve.TemplateMethod

class CharDisplay(private val character: Char) : AbstractDisplay() {
    override fun open() {
        print("<<")
    }

    override fun print() {
        print(this.character)
    }

    override fun close() {
        print(">>\n")
    }
}