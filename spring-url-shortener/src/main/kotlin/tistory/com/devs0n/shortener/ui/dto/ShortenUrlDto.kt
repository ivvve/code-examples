package tistory.com.devs0n.shortener.ui.dto

import org.hibernate.validator.constraints.URL
import javax.validation.constraints.NotBlank

class ShortenUrlDto {
    data class Request(
        @field:URL
        @field:NotBlank
        val url: String
    )

    data class Response(
        val id: String,
        val url: String,
    )
}
