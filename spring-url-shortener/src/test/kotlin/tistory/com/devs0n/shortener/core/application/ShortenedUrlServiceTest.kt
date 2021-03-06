package tistory.com.devs0n.shortener.core.application

import io.kotest.core.spec.style.DescribeSpec
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import tistory.com.devs0n.shortener.core.domain.RandomShortenedUrlCodeGeneratorTestWrapper
import tistory.com.devs0n.shortener.core.domain.MockShortenedUrlRepository
import tistory.com.devs0n.shortener.core.domain.ShortenedUrl
import tistory.com.devs0n.shortener.core.domain.exception.CannotGenerateShortenedUrlCodeException
import tistory.com.devs0n.shortener.core.domain.exception.ShortenedUrlNotFoundException

internal class ShortenedUrlServiceTest : DescribeSpec({
    // components
    val shortenedUrlRepository = MockShortenedUrlRepository()
    val shortenedUrlCodeGenerator = RandomShortenedUrlCodeGeneratorTestWrapper(shortenedUrlRepository)
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
        shortenedUrlCodeGenerator.reset()
    }

    // tests
    describe("shorten method") {
        describe("when ShortenedUrl of given originalUrl is registered") {
            it("returns registered ShortenedUrl") {
                val registeredShortenedUrl = shortenedUrlService.shorten(shortenedUrl.original)
                assertThat(registeredShortenedUrl).isEqualTo(shortenedUrl)
            }
        }

        describe("when ShortenedUrl of given originalUrl is not registered") {
            val newOriginalUrl = shortenedUrl.original + "category/"

            it("registers new ShortenedUrl") {
                val newShortenedUrl = shortenedUrlService.shorten(newOriginalUrl)
                assertThat(newShortenedUrl.original).isEqualTo(newOriginalUrl)
            }

            describe("and cannot generate shortened url code") {
                it("throws CannotGenerateShortenedUrlCodeException") {
                    shortenedUrlCodeGenerator.throwCannotGenerateShortenedUrlCodeException = true

                    assertThrows<CannotGenerateShortenedUrlCodeException> {
                        shortenedUrlService.shorten(newOriginalUrl)
                    }
                }
            }
        }
    }

    describe("getByCode method") {
        describe("when ShortenedUrl of given code is registered") {
            it("returns ShortenedUrl instance") {
                val registeredShortenedUrl = shortenedUrlService.getByCode(shortenedUrl.code)
                assertThat(registeredShortenedUrl).isEqualTo(shortenedUrl)
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
