package com.tistory.devs0n.restdocs.user

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController {
    @GetMapping
    fun getUser(): ResponseEntity<Map<String, String>> {
        return ResponseEntity.ok(
            mapOf(
                "name" to "Chris",
                "address" to "Seoul",
            )
        )
    }

    @PostMapping
    fun createUser(): ResponseEntity<Map<String, String>> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(
                mapOf(
                    "name" to "Chris",
                    "address" to "Seoul",
                )
            )
    }
}
