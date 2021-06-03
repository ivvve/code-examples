package tistory.com.devs0n.shortener.ui.web

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import tistory.com.devs0n.shortener.core.application.ShortenedUrlService
import tistory.com.devs0n.shortener.ui.dto.ShortenUrlDto
import java.net.URI
import javax.validation.Valid

@RestController
class ShortenedUrlController(
    private val shortenedUrlService: ShortenedUrlService,
) {
    @PostMapping("/shorten-url")
    suspend fun handleShortenUrlRequest(
        @Valid @RequestBody request: ShortenUrlDto.Request
    ): ResponseEntity<ShortenUrlDto.Response> {
        val shortenedUrl = this.shortenedUrlService.shorten(request.url)

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(
                ShortenUrlDto.Response(
                    shortenedUrl.original,
                    shortenedUrl.getFullShortenedUrl("http://localhost:8080")
                )
            )
    }

    @GetMapping("/{shortenedUrlCode}")
    suspend fun handleRedirectShortenedUrlRequest(@PathVariable shortenedUrlCode: String): ResponseEntity<Unit> {
        val shortenedUrl = this.shortenedUrlService.getByCode(shortenedUrlCode)

        return ResponseEntity
            .status(HttpStatus.FOUND)
            .location(URI.create(shortenedUrl.original))
            .build()
    }
}
