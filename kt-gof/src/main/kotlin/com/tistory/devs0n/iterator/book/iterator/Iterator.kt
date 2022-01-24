package com.tistory.devs0n.iterator.book.iterator

interface Iterator <T> {
    fun hasNext(): Boolean

    fun getNext(): T
}
