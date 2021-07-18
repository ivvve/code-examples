package com.tistory.devs0n.user.ui.dto

import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class LoginRequest (
    @JsonProperty("email")
    @field:NotBlank(message = "Email cannot be blank")
    @field:Size(min = 5, message = "Email must be longer than 4 characters")
    @field:Email
    val email: String,

    @JsonProperty("password")
    @field:NotBlank(message = "Password cannot be blank")
    @field:Size(min = 5, message = "Password must be longer than 4 characters")
    val password: String,
)
