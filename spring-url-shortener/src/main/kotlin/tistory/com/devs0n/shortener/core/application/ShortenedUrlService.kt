package tistory.com.devs0n.shortener.core.application

import org.springframework.stereotype.Service
import tistory.com.devs0n.shortener.core.domain.ShortenedUrl
import tistory.com.devs0n.shortener.core.domain.ShortenedUrlCodeGenerator
import tistory.com.devs0n.shortener.core.domain.ShortenedUrlRepository
import tistory.com.devs0n.shortener.core.domain.exception.ShortenedUrlNotFoundException

@Service
class ShortenedUrlService(
    private val shortenedUrlCodeGenerator: ShortenedUrlCodeGenerator,
    private val shortenedUrlRepository: ShortenedUrlRepository,
) {
    fun shorten(originalUrl: String): ShortenedUrl {
        val storedShortenedUrl = this.shortenedUrlRepository.findByOriginal(originalUrl)

        if (storedShortenedUrl != null) {
            return storedShortenedUrl
        }

        val shortenedUrlCode = this.shortenedUrlCodeGenerator.generate()
        val shortenedUrl = ShortenedUrl(originalUrl, shortenedUrlCode)
        return this.shortenedUrlRepository.save(shortenedUrl)
    }

    fun getByCode(shortenedUrlCode: String): ShortenedUrl {
        return this.shortenedUrlRepository.findByCode(shortenedUrlCode)
            ?: throw ShortenedUrlNotFoundException()
    }
}
