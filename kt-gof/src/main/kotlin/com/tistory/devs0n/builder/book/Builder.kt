package com.tistory.devs0n.builder.book

/**
 * 문서를 만든다
 */
interface Builder {
    fun makeTitle(title: String): Builder

    fun makeString(string: String): Builder

    fun makeItems(items: List<String>): Builder

    fun close(): Builder

    fun getResult(): String
}
