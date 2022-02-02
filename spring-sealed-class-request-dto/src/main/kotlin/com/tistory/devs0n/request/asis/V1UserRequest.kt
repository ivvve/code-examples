package com.tistory.devs0n.request.asis

import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

data class V1UserRequest(
    @field:NotBlank
    val loginId: String,

    @field:NotBlank
    val name: String,

    )
