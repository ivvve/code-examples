package com.tistory.devs0n.iterator.book.iterator

import com.tistory.devs0n.iterator.book.Book
import com.tistory.devs0n.iterator.book.aggregate.BookShelf

class BookShelfIterator(
    private val bookShelf: BookShelf
) : Iterator<Book> {
    private var index = 0

    override fun hasNext(): Boolean =
        this.index < this.bookShelf.maxNumberOfBooks

    override fun getNext(): Book {
        return this.bookShelf.getBookAt(this.index++)
    }
}
