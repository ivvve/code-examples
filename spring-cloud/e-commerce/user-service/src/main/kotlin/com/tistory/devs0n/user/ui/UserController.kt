package com.tistory.devs0n.user.ui

import com.tistory.devs0n.user.application.UserService
import com.tistory.devs0n.user.ui.dto.CreateUserRequest
import com.tistory.devs0n.user.ui.dto.UserResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {
    @GetMapping("/{userId}")
    fun getUser(@PathVariable("userId") userId: String): ResponseEntity<UserResponse> {
        val (user, orders) = this.userService.getUser(userId)
        return ResponseEntity.status(HttpStatus.CREATED).body(UserResponse.of(user, orders))
    }

    @PostMapping
    fun createUser(@Valid @RequestBody request: CreateUserRequest): ResponseEntity<UserResponse> {
        val user = this.userService.createUser(request.email, request.password, request.name)
        return ResponseEntity.status(HttpStatus.CREATED).body(UserResponse.of(user, listOf()))
    }
}
