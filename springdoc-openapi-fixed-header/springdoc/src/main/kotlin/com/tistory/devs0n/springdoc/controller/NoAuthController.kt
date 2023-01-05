package com.tistory.devs0n.springdoc.controller

import io.swagger.v3.oas.annotations.Parameter
import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class NoAuthController {
    private val logger = KotlinLogging.logger { }

    @GetMapping("/no-auth")
    fun anyRequest(): String {
        return "allowed!"
    }
}
