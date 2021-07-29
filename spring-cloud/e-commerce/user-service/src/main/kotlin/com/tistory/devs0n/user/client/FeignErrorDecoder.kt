package com.tistory.devs0n.user.client

import feign.Response
import feign.codec.ErrorDecoder
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

@Configuration
class FeignErrorDecoder : ErrorDecoder {
    override fun decode(methodKey: String, response: Response): Exception? {
        LOGGER.info("[Feign Client] methodKey: $methodKey, response: ${response.status()}")

        if (response.status() != HttpStatus.OK.value()) {
            return ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE)
        }

        return null
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(this::class.java)
    }
}
