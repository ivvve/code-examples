package com.tistory.devs0n.decorator.book

class SideBorder(
    private val borderChar: Char,
    display: Display
) : Border(display) {
    override fun getColumns(): Int = 1 + super.display.getColumns() + 1;

    override fun getRows(): Int = super.display.getRows()

    override fun getRowText(row: Int): String =
        this.borderChar + super.display.getRowText(row) + this.borderChar
}
