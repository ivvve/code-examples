package com.tistory.devs0n.templatemethod.book

class CharDisplay(
    val char: Char,
) : Display() {
    override fun open() {
        print("<<")
    }

    override fun print() {
        print(this.char)
    }

    override fun close() {
        println(">>")
    }
}
