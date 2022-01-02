package com.tistory.devs0n.decorator.book

abstract class Display {
    abstract fun getColumns(): Int

    abstract fun getRows(): Int

    abstract fun getRowText(row: Int): String

    fun show() {
        val rows = this.getRows()
        for (i in 0 until rows) {
            println(this.getRowText(i))
        }
    }
}
