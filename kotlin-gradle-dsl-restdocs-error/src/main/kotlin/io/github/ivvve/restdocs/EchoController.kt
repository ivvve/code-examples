package io.github.ivvve.restdocs

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class EchoController {
    @GetMapping("/echo")
    fun echo(@RequestParam value: String): String {
        return value
    }
}