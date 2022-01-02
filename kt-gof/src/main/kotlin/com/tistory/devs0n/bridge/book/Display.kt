package com.tistory.devs0n.bridge.book

// Abstraction
open class Display(
    private val impl: DisplayImpl
) {
    fun open() {
        this.impl.rawOpen()
    }

    fun print() {
        this.impl.rawPrint()
    }

    fun close() {
        this.impl.rawClose()
    }

    fun display() {
        this.open()
        this.print()
        this.close()
    }
}
