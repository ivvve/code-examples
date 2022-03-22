package com.tistory.devs0n.dgs

import com.netflix.graphql.dgs.*
import com.tistory.devs0n.dgs.author.Author
import com.tistory.devs0n.dgs.author.AuthorRepository
import com.tistory.devs0n.dgs.book.Book
import com.tistory.devs0n.dgs.book.BookRepository
import com.tistory.devs0n.dgs.publisher.Publisher
import com.tistory.devs0n.dgs.publisher.PublisherRepository
import org.dataloader.MappedBatchLoader
import org.slf4j.LoggerFactory
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionStage

@DgsComponent
class BookDataFetcher(
    private val bookRepository: BookRepository,
    private val authorRepository: AuthorRepository,
    private val publisherRepository: PublisherRepository,
) {
    @DgsQuery(field = "book")
    fun book(@InputArgument("id") id: Long): Book? = this.bookRepository.findById(id)

    @DgsQuery(field = "books")
    fun books(): List<Book> = this.bookRepository.findAll()

    // below code might occurs N+1 problem
//    @DgsData(parentType = "Book", field = "author")
//    fun author(dfe: DgsDataFetchingEnvironment): Author {
//        val book = dfe.getSource<Book>()
//        return this.authorRepository.findById(book.authorId)!!
//    }
//
//    @DgsData(parentType = "Book", field = "publisher")
//    fun publisher(dfe: DgsDataFetchingEnvironment): Publisher {
//        val book = dfe.getSource<Book>()
//        return this.publisherRepository.findById(book.publisherId)!!
//    }

    @DgsData(parentType = "Book", field = "author")
    fun author(dfe: DgsDataFetchingEnvironment): CompletableFuture<Author> {
        val book = dfe.getSource<Book>()
        val authorDataLoader = dfe.getDataLoader<Long, Author>(AuthorDataLoader::class.java)
        return authorDataLoader.load(book.authorId)
    }

    @DgsData(parentType = "Book", field = "publisher")
    fun publisher(dfe: DgsDataFetchingEnvironment): CompletableFuture<Publisher> {
        val book = dfe.getSource<Book>()
        val publisherDataLoader = dfe.getDataLoader<Long, Publisher>(PublisherDataLoader::class.java)
        return publisherDataLoader.load(book.publisherId)
    }
}

@DgsComponent
class AuthorDataFetcher(
    private val authorRepository: AuthorRepository,
    private val bookRepository: BookRepository,
) {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @DgsQuery(field = "author")
    fun author(@InputArgument("id") id: Long): Author? = this.authorRepository.findById(id)

    @DgsQuery(field = "authors")
    fun authors(): List<Author> = this.authorRepository.findAll()

    @DgsData(parentType = "Author", field = "books")
    fun books(dfe: DgsDataFetchingEnvironment): List<Book> {
        val author = dfe.getSource<Author>()
        return this.bookRepository.findAllByAuthorId(author.id)
    }
}

@DgsDataLoader(name = "authorDataLoader")
class AuthorDataLoader(
    private val authorRepository: AuthorRepository
) : MappedBatchLoader<Long, Author> {

    override fun load(authorIds: MutableSet<Long>): CompletionStage<MutableMap<Long, Author>> {
        return CompletableFuture.supplyAsync {
            val authors = this.authorRepository.findAllByIds(authorIds)
            authors.associateBy { it.id }.toMutableMap()
        }
    }
}

@DgsComponent
class PublisherDataFetcher(
    private val publisherRepository: PublisherRepository,
    private val bookRepository: BookRepository,
) {
    @DgsQuery(field = "publisher")
    fun publisher(@InputArgument("id") id: Long): Publisher? = this.publisherRepository.findById(id)

    @DgsQuery(field = "publishers")
    fun publishers(): List<Publisher> = this.publisherRepository.findAll()

    @DgsData(parentType = "Publisher", field = "books")
    fun books(dfe: DgsDataFetchingEnvironment): List<Book> {
        val publisher = dfe.getSource<Publisher>()
        return this.bookRepository.findAllByPublisherId(publisher.id)
    }
}


@DgsDataLoader(name = "publisherDataLoader")
class PublisherDataLoader(
    private val publisherRepository: PublisherRepository
) : MappedBatchLoader<Long, Publisher> {

    override fun load(publisherIds: MutableSet<Long>): CompletionStage<MutableMap<Long, Publisher>> {
        return CompletableFuture.supplyAsync {
            val authors = this.publisherRepository.findAllByIds(publisherIds)
            authors.associateBy { it.id }.toMutableMap()
        }
    }
}
