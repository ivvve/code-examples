package com.tistory.devs0n.ktvalidation.web

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class PersonController {
    @PostMapping
    fun echoPerson(@Valid @RequestBody person: Person): Person {
        return person
    }
}
