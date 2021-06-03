package tistory.com.devs0n.shortener.core.domain

interface ShortenedUrlRepository {
    suspend fun save(shortenedUrl: ShortenedUrl): ShortenedUrl

    suspend fun existsByCode(code: String): Boolean

    suspend fun findByOriginal(original: String): ShortenedUrl?

    suspend fun findByCode(code: String): ShortenedUrl?
}
