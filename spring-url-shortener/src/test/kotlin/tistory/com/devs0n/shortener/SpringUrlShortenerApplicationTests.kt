package tistory.com.devs0n.shortener

import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory

class SpringUrlShortenerApplicationTests : IntegrationTest() {

    @Test
    fun contextLoads() {
        LOGGER.info("Context loading succeeded")
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(this::class.java)
    }
}
