package com.tistory.devs0n.archunit.layer.persistence

import com.tistory.devs0n.archunit.layer.service.MyService

class IllegalDao(
    private val myService: MyService,
)
