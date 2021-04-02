package com.tistory.devs0n.ktvalidation.web

import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

data class Person(
    @field:NotBlank
//    @NotBlank - not working
    val name: String,

    @field:Min(10)
//    @Min(10) - not working
    val age: Int,
)
