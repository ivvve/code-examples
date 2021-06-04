package tistory.com.devs0n.shortener.core.application

import io.kotest.core.spec.style.DescribeSpec
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import tistory.com.devs0n.shortener.core.domain.MockShortenedUrlRepository
import tistory.com.devs0n.shortener.core.domain.RandomShortenedUrlCodeGenerator
import tistory.com.devs0n.shortener.core.domain.ShortenedUrl
import tistory.com.devs0n.shortener.core.domain.exception.ShortenedUrlNotFoundException

internal class ShortenedUrlServiceTest : DescribeSpec({
    // components
    val shortenedUrlRepository = MockShortenedUrlRepository()
    val shortenedUrlCodeGenerator = RandomShortenedUrlCodeGenerator(shortenedUrlRepository)
    val shortenedUrlService = ShortenedUrlService(
        shortenedUrlCodeGenerator,
        shortenedUrlRepository
    )

    // fixture
    lateinit var shortenedUrl: ShortenedUrl

    beforeEach {
        shortenedUrl = ShortenedUrl("https://devs0n.tistory.com/", "0000000")
        shortenedUrlRepository.save(shortenedUrl)
    }

    afterEach {
        shortenedUrlRepository.reset()
    }

    // tests
    describe("getByCode method") {
        describe("when ShortenedUrl of given code is registered") {
            it("returns ShortenedUrl instance") {
                val storedShortenedUrl = shortenedUrlService.getByCode(shortenedUrl.code)
                assertThat(storedShortenedUrl).isEqualTo(shortenedUrl)
            }
        }

        describe("when ShortenedUrl of given code is not registered") {
            it("throws ShortenedUrlNotFoundException") {
                assertThrows<ShortenedUrlNotFoundException> {
                    shortenedUrlService.getByCode(shortenedUrl.code + "1")
                }
            }
        }
    }
})