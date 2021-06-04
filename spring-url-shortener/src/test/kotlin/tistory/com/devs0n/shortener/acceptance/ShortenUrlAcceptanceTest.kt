package tistory.com.devs0n.shortener.acceptance

import org.junit.jupiter.api.Test
import tistory.com.devs0n.shortener.IntegrationTest
import tistory.com.devs0n.shortener.acceptance.step.`Send Shorten URL Request`
import tistory.com.devs0n.shortener.acceptance.step.`Shorten URL Request Succeeded`
import tistory.com.devs0n.shortener.acceptance.step.`Shortened URL Responded`

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
