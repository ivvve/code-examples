package com.tistory.devs0n.example

import kotlinx.serialization.Serializable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class RequestController {
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

data class JacksonRequest(
    val values: List<String>,
)

@Serializable
data class KMSRequest(
    val values: List<String>,
)
