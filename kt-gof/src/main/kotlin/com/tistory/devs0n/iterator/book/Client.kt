package com.tistory.devs0n.iterator.book

import com.tistory.devs0n.iterator.book.aggregate.BookShelf

fun main() {
    val bookShelf = BookShelf(4)
    bookShelf.add(Book("MongoDB in Action"))
    bookShelf.add(Book("레거시 코드 활용 전략"))
    bookShelf.add(Book("오브젝트"))
    bookShelf.add(Book("크래프톤 웨이"))

    val iterator = bookShelf.createIterator()
    while (iterator.hasNext()) {
        println(iterator.getNext())
    }
}
