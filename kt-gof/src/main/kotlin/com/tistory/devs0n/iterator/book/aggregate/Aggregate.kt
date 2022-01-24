package com.tistory.devs0n.iterator.book.aggregate

import com.tistory.devs0n.iterator.book.iterator.Iterator

interface Aggregate<T> {
    fun createIterator(): Iterator<T>
}
