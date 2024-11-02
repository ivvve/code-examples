package com.tistory.devs0n.parameter

import com.tistory.devs0n.parameter.config.LoginUser
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono

@RestController
class ApiController {
    @GetMapping("/auth")
    fun authenticated(user: LoginUser): Mono<String> {
        return "authenticated user: ${user.userId}".toMono()
    }

    @GetMapping("/unauth")
    fun unauthenticated(): Mono<String> {
        return "unauthenticated user".toMono()
    }
}
