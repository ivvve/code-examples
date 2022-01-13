package com.tistory.devs0n.springkotest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class EchoController {
    @GetMapping
    fun echo(@RequestParam("message") message: String, @RequestParam("prefix") prefix: String? = null): String {
        return if (prefix != null) {
            "$prefix - $message"
        } else {
            message
        }
    }
}
