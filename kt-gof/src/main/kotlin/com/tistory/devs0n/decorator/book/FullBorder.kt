package com.tistory.devs0n.decorator.book

class FullBorder(display: Display) : Border(display) {
    override fun getColumns(): Int = 1 + super.display.getColumns() + 1

    override fun getRows(): Int = 1 + super.display.getRows() + 1

    override fun getRowText(row: Int): String {
        return if (this.isFirstOrLastRow(row)) {
            "+" + this.makeLine('-', super.display.getColumns()) + "+"
        } else {
            "|" + super.display.getRowText(row - 1) + "|"
        }
    }

    private fun isFirstOrLastRow(row: Int): Boolean =
        (row == 0) || (row == super.display.getRows() + 1)

    private fun makeLine(char: Char, count: Int): String {
        val builder = StringBuilder()

        for (i in 0 until count) {
            builder.append(char)
        }

        return builder.toString()
    }
}
