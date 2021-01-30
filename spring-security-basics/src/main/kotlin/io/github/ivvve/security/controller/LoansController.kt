package io.github.ivvve.security.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

// With Security
@RestController
@RequestMapping("/loans")
class LoansController {
    @GetMapping
    fun get(): String {
        return "get"
    }
}