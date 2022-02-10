package com.tistory.devs0n.archunit.layer.service

import com.tistory.devs0n.archunit.layer.persistence.MyDao

class MyService(
    private val myDao: MyDao,
)
