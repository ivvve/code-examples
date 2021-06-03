package tistory.com.devs0n.shortener.core.infrastructure

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import tistory.com.devs0n.shortener.core.domain.ShortenedUrl
import tistory.com.devs0n.shortener.core.domain.ShortenedUrlRepository

interface ReactiveJdbcShortenedUrlRepository : ShortenedUrlRepository, ReactiveCrudRepository<ShortenedUrl, Long>
