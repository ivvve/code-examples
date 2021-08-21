package com.tistory.devs0n.user.ui

import io.micrometer.core.annotation.Timed
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MetricController {
    @GetMapping("/health_check")
    @Timed(value = "users.status", longTask = true)
    fun status(): String {
        return "User Service is running"
    }

    @GetMapping("/welcome")
    @Timed(value = "users.welcome", longTask = true)
    fun welcome(): String {
        return "welcome"
    }
}
