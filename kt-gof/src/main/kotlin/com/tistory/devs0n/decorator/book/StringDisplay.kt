package com.tistory.devs0n.decorator.book

class StringDisplay(
    private val string: String
) : Display() {

    override fun getColumns(): Int = this.string.toCharArray().size

    override fun getRows(): Int = 1

    override fun getRowText(row: Int): String {
        return if (row == 0) {
            this.string
        } else {
            ""
        }
    }
}
