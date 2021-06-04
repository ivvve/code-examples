package tistory.com.devs0n.shortener.helper

import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.slf4j.LoggerFactory
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Component
import tistory.com.devs0n.shortener.core.domain.ShortenedUrl

@Component
class DatabaseCleaner(
    private val shortenedUrlRepository: ReactiveCrudRepository<ShortenedUrl, Long>
) {
    suspend fun clean() {
        this.shortenedUrlRepository.deleteAll().awaitSingleOrNull()
        LOGGER.info("ShortenedUrl data has deleted")
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(this::class.java)
    }
}
