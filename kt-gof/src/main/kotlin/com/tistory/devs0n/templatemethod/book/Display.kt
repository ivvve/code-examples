package com.tistory.devs0n.templatemethod.book

abstract class Display {
    fun display() {
        this.open()
        repeat(5) {
            this.print()
        }
        this.close()
    }

    protected abstract fun open()

    protected abstract fun print()

    protected abstract fun close()
}
