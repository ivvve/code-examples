package tistory.com.devs0n.shortener.ui.web

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import tistory.com.devs0n.shortener.ui.dto.ShortenUrlDto
import javax.validation.Valid

@RestController
class ShortenUrlController {
    @PostMapping("/shorten-url")
    fun handleShortenUrlRequest(
        @Valid @RequestBody request: ShortenUrlDto.Request
    ): ResponseEntity<ShortenUrlDto.Response> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(ShortenUrlDto.Response("1234567", "http://localhost:8080/1234567"))
    }
}
