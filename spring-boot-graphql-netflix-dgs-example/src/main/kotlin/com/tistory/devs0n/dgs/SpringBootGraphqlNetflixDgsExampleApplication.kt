package com.tistory.devs0n.dgs

import com.tistory.devs0n.dgs.author.Author
import com.tistory.devs0n.dgs.author.AuthorRepository
import com.tistory.devs0n.dgs.book.Book
import com.tistory.devs0n.dgs.book.BookRepository
import com.tistory.devs0n.dgs.publisher.Publisher
import com.tistory.devs0n.dgs.publisher.PublisherRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.time.LocalDate
import java.util.*

@SpringBootApplication
class SpringBootGraphqlNetflixDgsExampleApplication

fun main(args: Array<String>) {
    val ac = runApplication<SpringBootGraphqlNetflixDgsExampleApplication>(*args)

    val bookRepository = ac.getBean(BookRepository::class.java)
    (1..50).map { i ->
        bookRepository.save(
            Book(
                id = i.toLong(),
                authorId = i.toLong() % 5 + 1,
                publisherId = i.toLong() % 10 + 1,

                isbn = UUID.randomUUID().toString(),
                title = "도서${i}",
                publishedAt = LocalDate.now().plusDays(i.toLong()),
            )
        )
    }

    val authorRepository = ac.getBean(AuthorRepository::class.java)
    (1..50).map { i ->
        authorRepository.save(
            Author(
                id = i.toLong(),
                name = "작가${i}",
                description =  "작가${i}는 책을 씁니다",
        )
        )
    }

    val publisherRepository = ac.getBean(PublisherRepository::class.java)
    (1..50).map { i ->
        publisherRepository.save(
            Publisher(
                id = i.toLong(),
                name = "출판사${i}",
                address = "서울시 ${i}번지",
            )
        )
    }
}
