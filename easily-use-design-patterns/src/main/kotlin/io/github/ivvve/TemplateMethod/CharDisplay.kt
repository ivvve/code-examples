package io.github.ivvve.TemplateMethod

/**
 * If constructor parameter is 'H',
 * it displays like this:
 * <<HHHH>>
 */
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