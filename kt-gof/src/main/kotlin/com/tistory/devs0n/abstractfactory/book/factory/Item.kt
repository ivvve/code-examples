package com.tistory.devs0n.abstractfactory.book.factory

/**
 * `항목`의 목차를 표시
 */
abstract class Item(
    protected val caption: String,
) {
    abstract fun makeHTML(): String
}
