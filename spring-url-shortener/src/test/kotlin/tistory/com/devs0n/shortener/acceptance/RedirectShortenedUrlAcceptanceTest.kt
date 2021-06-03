package tistory.com.devs0n.shortener.acceptance

import org.junit.jupiter.api.Test
import tistory.com.devs0n.shortener.IntegrationTest
import tistory.com.devs0n.shortener.acceptance.step.`Redirect Shortened URL Request Succeeded`
import tistory.com.devs0n.shortener.acceptance.step.`Redirect to Raw URL Responded`
import tistory.com.devs0n.shortener.acceptance.step.`Send Redirect Shortened URL Request`
import tistory.com.devs0n.shortener.acceptance.step.`Sent Shorten URL Request`

class RedirectShortenedUrlAcceptanceTest : IntegrationTest() {
    @Test
    fun `Redirecting Shortened URL`() {
        // given
        val rawUrl = "https://devs0n.tistory.com/"
        val shortenUrlResponse = `Sent Shorten URL Request`(rawUrl)

        // when
        val redirectShortenedUrlResponse = `Send Redirect Shortened URL Request`(shortenUrlResponse)

        // then
        `Redirect Shortened URL Request Succeeded`(redirectShortenedUrlResponse)
        `Redirect to Raw URL Responded`(redirectShortenedUrlResponse, rawUrl)
    }
}