package tistory.com.devs0n.shortener.ui.dto

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.validator.constraints.URL
import javax.validation.constraints.NotBlank

class ShortenUrlDto {
    data class Request(
        @field:URL
        @field:NotBlank
        @JsonProperty("url")
        val url: String
    )

    data class Response(
        @JsonProperty("original")
        val original: String,

        @JsonProperty("shortened")
        val shortened: String,
    )
}
