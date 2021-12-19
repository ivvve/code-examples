package com.tistory.devs0n.abstractfactory.book.factory

/**
 * 여러 Item을 합친 것을 표시한 클래스
 */
abstract class Tray(
    caption: String
) : Item(caption) {
    protected val tray: MutableList<Item> = mutableListOf()

    fun add(item: Item) {
        this.tray.add(item)
    }
}
