package io.github.ivvve.TemplateMethod

abstract class AbstractDisplay {
    fun display() {
        this.open()

        for (i in 0 until 4) {
            this.print()
        }

        this.close()
    }

    protected abstract fun open()
    protected abstract fun print()
    protected abstract fun close()
}