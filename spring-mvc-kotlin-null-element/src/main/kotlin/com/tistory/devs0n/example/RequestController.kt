package com.tistory.devs0n.example

import com.fasterxml.jackson.annotation.JsonSetter
import com.fasterxml.jackson.annotation.Nulls
import kotlinx.serialization.Serializable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class RequestController {
    @PostMapping("/filter")
    fun filter(@RequestBody request: FilterRequest): FilterRequest {
        println("Contains null? : ${request.values.any { it == null }}")
        return request.copy(
            values = request.values.filter { it != null },
        )
    }

    @PostMapping("/jackson")
    fun jackson(@RequestBody request: JacksonRequest): JacksonRequest {
        println("Contains null? : ${request.values.any { it == null }}")
        return request
    }

    @PostMapping("/kms")
    fun kms(@RequestBody request: KMSRequest): KMSRequest {
        println("Contains null? : ${request.values.any { it == null }}")
        return request
    }
}

data class FilterRequest(
    val values: List<String>,
)

data class JacksonRequest(
    @JsonSetter(contentNulls = Nulls.SKIP)
    val values: List<String>,
)

@Serializable
data class KMSRequest(
    val values: List<String>,
)
