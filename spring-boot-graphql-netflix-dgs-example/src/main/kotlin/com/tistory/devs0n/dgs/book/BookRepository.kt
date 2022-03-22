package com.tistory.devs0n.dgs.book

import org.springframework.stereotype.Repository

@Repository
class BookRepository {
    private val books: MutableMap<Long, Book> = mutableMapOf()

    fun save(book: Book): Book {
        this.books[book.id] = book
        return book
    }

    fun findAll(): List<Book> = this.books.values.toList()

    fun findById(bookId: Long): Book? = this.books[bookId]

    fun findAllByAuthorId(authorId: Long): List<Book> = this.books.values.filter { it.authorId == authorId }

    fun findAllByPublisherId(publisherId: Long): List<Book> = this.books.values.filter { it.publisherId == publisherId }
}
