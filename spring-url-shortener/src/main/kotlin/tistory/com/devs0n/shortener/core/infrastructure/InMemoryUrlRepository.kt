package tistory.com.devs0n.shortener.core.infrastructure

import org.springframework.stereotype.Repository
import tistory.com.devs0n.shortener.core.domain.ShortenedUrl
import tistory.com.devs0n.shortener.core.domain.ShortenedUrlRepository

@Repository
class InMemoryUrlRepository : ShortenedUrlRepository {
    private val urls = mutableMapOf<String, ShortenedUrl>()

    override fun save(shortenedUrl: ShortenedUrl): ShortenedUrl {
        this.urls[shortenedUrl.code] = shortenedUrl
        return shortenedUrl
    }

    override fun existsByCode(code: String): Boolean {
        return this.urls.values.any { it.code == code }
    }

    override fun findByOriginal(original: String): ShortenedUrl? {
        return this.urls.values.find { it.original == original }
    }

    override fun findByCode(code: String): ShortenedUrl? {
        return this.urls.values.find { it.code == code }
    }
}
