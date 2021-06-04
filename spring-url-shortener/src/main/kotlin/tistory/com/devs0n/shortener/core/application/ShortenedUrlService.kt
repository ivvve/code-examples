package tistory.com.devs0n.shortener.core.application

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import tistory.com.devs0n.shortener.core.domain.ShortenedUrl
import tistory.com.devs0n.shortener.core.domain.ShortenedUrlCodeGenerator
import tistory.com.devs0n.shortener.core.domain.ShortenedUrlRepository
import tistory.com.devs0n.shortener.core.domain.exception.ShortenedUrlNotFoundException

@Service
class ShortenedUrlService(
    private val shortenedUrlCodeGenerator: ShortenedUrlCodeGenerator,
    private val shortenedUrlRepository: ShortenedUrlRepository,
) {
    @Transactional
    suspend fun shorten(originalUrl: String): ShortenedUrl {
        val shortedShortenedUrl = this.shortenedUrlRepository.findByOriginal(originalUrl)

        if (shortedShortenedUrl != null) {
            return shortedShortenedUrl
        }

        val shortenedUrlCode = this.shortenedUrlCodeGenerator.generate()
        val shortenedUrl = ShortenedUrl(originalUrl, shortenedUrlCode)
        return this.shortenedUrlRepository.save(shortenedUrl)
    }

    @Transactional(readOnly = true)
    suspend fun getByCode(shortenedUrlCode: String) =
        this.shortenedUrlRepository.findByCode(shortenedUrlCode)
            ?: throw ShortenedUrlNotFoundException()
}
