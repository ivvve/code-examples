package tistory.com.devs0n.shortener.core.domain

import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import tistory.com.devs0n.shortener.core.domain.exception.CannotGenerateShortenedUrlCodeException

@Primary
@Component
class MockRandomShortenedUrlCodeGenerator(
    shortenedUrlRepository: ShortenedUrlRepository,
) : RandomShortenedUrlCodeGenerator(shortenedUrlRepository) {
    var throwCannotGenerateShortenedUrlCodeException = false

    fun reset() {
        this.throwCannotGenerateShortenedUrlCodeException = false
    }

    override suspend fun generate(): String {
        if (throwCannotGenerateShortenedUrlCodeException) {
            throw CannotGenerateShortenedUrlCodeException()
        }

        return super.generate()
    }
}
