package tistory.com.devs0n.shortener.core.domain

import tistory.com.devs0n.shortener.core.domain.exception.CannotGenerateShortenedUrlCodeException

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
