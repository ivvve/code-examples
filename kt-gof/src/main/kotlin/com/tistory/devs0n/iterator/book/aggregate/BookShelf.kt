package com.tistory.devs0n.iterator.book.aggregate

import com.tistory.devs0n.iterator.book.Book
import com.tistory.devs0n.iterator.book.iterator.BookShelfIterator
import com.tistory.devs0n.iterator.book.iterator.Iterator

class BookShelf(
    val maxNumberOfBooks: Int,
) : Aggregate<Book> {
    private val books: Array<Book?> = arrayOfNulls(this.maxNumberOfBooks)

    private var last: Int = 0

    fun getBookAt(index: Int): Book = this.books[index]!!

    fun add(book: Book) {
        this.books[this.last] = book
        this.last++
    }

    override fun createIterator(): Iterator<Book> = BookShelfIterator(this)
}
