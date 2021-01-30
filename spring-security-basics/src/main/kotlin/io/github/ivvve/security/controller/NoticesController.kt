package io.github.ivvve.security.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

// Without Security
@RestController
@RequestMapping("/notices")
class NoticesController {
    @GetMapping
    fun get(): String {
        return "get"
    }
}