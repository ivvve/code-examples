package com.tistory.devs0n.springdoc.controller

import io.swagger.v3.oas.annotations.Parameter
import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthController {
    private val logger = KotlinLogging.logger { }

    @GetMapping("/auth")
    fun authenticatedRequest(
        @Parameter(hidden = true) @RequestHeader("X-AUTH-TOKEN", required = false) authToken: String?
    ): String {
        this.logger.info { "auth token is `${authToken}`" }

        if (authToken == null) {
            return "not allowed"
        }

        return "authenticated!"
    }
}
