package com.tistory.devs0n.abstractfactory.book.factory

import java.io.FileWriter

/**
 * HTML 페이지 전체를 추상적으로 표현한 클래스
 * Item(Link, Tray)를 모아 하나의 페이지를 만든다.
 */
abstract class Page(
    protected val title: String,
    protected val author: String,
) {
    protected val contents: MutableList<Item> = mutableListOf()

    fun add(item: Item) {
        this.contents.add(item)
    }

    fun output() {
        val fileName = "${this.title}.html"
        FileWriter(fileName).use {
            it.write(this.makeHTML())
        }
        println("${fileName}을 작성했습니다")
    }

    abstract fun makeHTML(): String
}
