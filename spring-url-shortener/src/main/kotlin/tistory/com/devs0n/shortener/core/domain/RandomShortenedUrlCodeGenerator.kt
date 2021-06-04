package tistory.com.devs0n.shortener.core.domain

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import tistory.com.devs0n.shortener.core.domain.exception.CannotGenerateShortenedUrlException

/**
 * Implementation of ShortenedUrlCodeGenerator
 *
 * Code generation strategy can be replaced using Counter or E.T.C.
 */
@Component
class RandomShortenedUrlCodeGenerator(
    private val shortenedUrlRepository: ShortenedUrlRepository,
) : ShortenedUrlCodeGenerator {
    override suspend fun generate(): String {
        for (i in 1..MAX_RETRY) {
            val code = this.generateRandomCode()
            val exists = this.shortenedUrlRepository.existsByCode(code)

            if (!exists) {
                return code
            }

            LOGGER.debug("ShortenUrlID was collided try again: $i times")
        }

        throw CannotGenerateShortenedUrlException()
    }

    private fun generateRandomCode(): String {
        var code = ""

        for (i in 0 until ShortenedUrl.CODE_LENGTH) {
            code += ShortenedUrl.CODE_CHARACTERS.random()
        }

        return code
    }

    companion object {
        const val MAX_RETRY = 30

        private val LOGGER = LoggerFactory.getLogger(this::class.java)
    }
}
