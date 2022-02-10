package com.tistory.devs0n.archunit.subpackage

import com.tistory.devs0n.archunit.subpackage.a.AService
import com.tistory.devs0n.archunit.subpackage.b.BService

class ABService(
    private val aService: AService,
    private val bService: BService,
)
