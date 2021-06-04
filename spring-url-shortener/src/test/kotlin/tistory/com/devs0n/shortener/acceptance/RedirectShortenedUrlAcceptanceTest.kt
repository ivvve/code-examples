package tistory.com.devs0n.shortener.acceptance

import org.junit.jupiter.api.Test
import tistory.com.devs0n.shortener.IntegrationTest
import tistory.com.devs0n.shortener.acceptance.step.*

class RedirectShortenedUrlAcceptanceTest : IntegrationTest() {
    @Test
    fun `Redirecting Shortened URL`() {
        // given
        val originalUrl = "https://devs0n.tistory.com/"
        val shortenUrlResponse = `Sent Shorten URL Request`(originalUrl)

        // when
        val redirectShortenedUrlResponse = `Send Redirect Shortened URL Request`(shortenUrlResponse)

        // then
        `Redirect Shortened URL Request Succeeded`(redirectShortenedUrlResponse)
        `Redirect to Original URL Responded`(redirectShortenedUrlResponse, originalUrl)
    }
}

class RedirectShortenedUrlAcceptanceTestExceptionalCase : IntegrationTest() {
    @Test
    fun `Redirecting Shortened URL - not registered `() {
        // when
        val redirectShortenedUrlResponse = `Send Redirect Shortened URL Request`("1234567")

        // then
        `Redirect Shortened URL Request Failed - ShortenedUrl has not registered`(redirectShortenedUrlResponse)
    }
}
