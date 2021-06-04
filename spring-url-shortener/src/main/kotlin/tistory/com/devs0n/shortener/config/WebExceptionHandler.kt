package tistory.com.devs0n.shortener.config

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import tistory.com.devs0n.shortener.core.domain.exception.CannotGenerateShortenedUrlCodeException
import tistory.com.devs0n.shortener.core.domain.exception.ShortenedUrlNotFoundException

@RestControllerAdvice
class WebExceptionHandler {
    @ExceptionHandler(CannotGenerateShortenedUrlCodeException::class)
    fun handleCannotGenerateShortenedUrlCodeException(
        exception: CannotGenerateShortenedUrlCodeException
    ): ResponseEntity<Unit> {
        LOGGER.error("Cannot generate shortened url now - check the data")
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build()
    }

    @ExceptionHandler(ShortenedUrlNotFoundException::class)
    fun handleShortenedUrlNotFoundException(
        exception: ShortenedUrlNotFoundException
    ): ResponseEntity<Unit> {
        return ResponseEntity.notFound().build()
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(this::class.java)
    }
}
