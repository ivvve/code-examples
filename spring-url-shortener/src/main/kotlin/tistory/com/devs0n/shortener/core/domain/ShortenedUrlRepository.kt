package tistory.com.devs0n.shortener.core.domain

interface ShortenedUrlRepository {
    fun save(shortenedUrl: ShortenedUrl): ShortenedUrl

    fun existsByCode(code: String): Boolean

    fun findByOriginal(original: String): ShortenedUrl?

    fun findByCode(code: String): ShortenedUrl?
}
