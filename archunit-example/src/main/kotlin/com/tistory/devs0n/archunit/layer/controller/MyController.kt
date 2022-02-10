package com.tistory.devs0n.archunit.layer.controller

import com.tistory.devs0n.archunit.layer.service.MyService

class MyController(
    private val service: MyService,
)
