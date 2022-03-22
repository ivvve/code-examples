package com.tistory.devs0n.dgs.author

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository

@Repository
class AuthorRepository {
    private val logger = LoggerFactory.getLogger(this::class.java)

    private val authors: MutableMap<Long, Author> = mutableMapOf()

    fun save(author: Author): Author {
        this.authors[author.id] = author
        return author
    }

    fun findAll(): List<Author> = this.authors.values.toList()

    fun findAllByIds(authorIds: Collection<Long>): List<Author> {
        logger.info("[AuthorRepository.findAllByIds] authorIds - $authorIds")
        return authorIds.mapNotNull { id -> this.authors[id] }
    }

    fun findById(authorId: Long): Author? {
        logger.info("[AuthorRepository.findById] authorId - $authorId")
        return this.authors[authorId]
    }
}
