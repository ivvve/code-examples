package tistory.com.devs0n.shortener.acceptance

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import tistory.com.devs0n.shortener.IntegrationTest
import tistory.com.devs0n.shortener.acceptance.step.*
import tistory.com.devs0n.shortener.core.domain.RandomShortenedUrlCodeGeneratorTestWrapper

class ShortenUrlAcceptanceTest : IntegrationTest() {
    @Test
    fun `Shortening URL`() {
        // given
        val originalUrl = "https://devs0n.tistory.com/"

        // when
        val shortenUrlResponse = `Send Shorten URL Request`(originalUrl)

        // then
        `Shorten URL Request Succeeded`(shortenUrlResponse)
        `Shortened URL Responded`(shortenUrlResponse, originalUrl)
    }
}

class ShortenUrlAcceptanceTestExceptionalCase : IntegrationTest() {
    @Autowired
    private lateinit var shortenedUrlCodeGenerator: RandomShortenedUrlCodeGeneratorTestWrapper

    @AfterEach
    fun tearDon() {
        shortenedUrlCodeGenerator.reset();
    }

    @Test
    fun `Shortening URL - cannot generate shortened url code`() {
        // given
        shortenedUrlCodeGenerator.throwCannotGenerateShortenedUrlCodeException = true
        val originalUrl = "https://devs0n.tistory.com/"

        // when
        val shortenUrlResponse = `Send Shorten URL Request`(originalUrl)

        // then
        `Shorten URL Request Failed - Cannot Generate Shortened URL Code`(shortenUrlResponse)
    }
}

class ShortenUrlAcceptanceTestBadRequest : IntegrationTest() {
    @Test
    fun `Shortening URL - url `() {
        // Null
        `Redirect Shortened URL Request Failed - Invalid url`(
            `Send Shorten URL Request`(null)
        )

        // Blank
        `Redirect Shortened URL Request Failed - Invalid url`(
            `Send Shorten URL Request`(" ")
        )

        // Not URL
        `Redirect Shortened URL Request Failed - Invalid url`(
            `Send Shorten URL Request`("devs0n")
        )
    }
}
