package tistory.com.devs0n.shortener.core.domain

import tistory.com.devs0n.shortener.helper.setField

class MockShortenedUrlRepository : ShortenedUrlRepository {
    private var id = 1L
    private val urls = mutableMapOf<Long, ShortenedUrl>()

    fun reset() {
        this.urls.clear()
    }

    override suspend fun save(shortenedUrl: ShortenedUrl): ShortenedUrl {
        setField(shortenedUrl, "id", id++)
        this.urls[shortenedUrl.id!!] = shortenedUrl
        return shortenedUrl
    }

    override suspend fun existsByCode(code: String): Boolean {
        return this.urls.values.any { it.code == code }
    }

    override suspend fun findByOriginal(original: String): ShortenedUrl? {
        return this.urls.values.firstOrNull{ it.original == original }
    }

    override suspend fun findByCode(code: String): ShortenedUrl? {
        return this.urls.values.firstOrNull { it.code == code }
    }
}
