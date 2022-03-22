package com.tistory.devs0n.dgs.book

import java.time.LocalDate

data class Book(
    val id: Long,
    val authorId: Long,
    val publisherId: Long,

    val isbn: String,
    val title: String,
    val publishedAt: LocalDate,
)
