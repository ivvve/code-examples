package com.tistory.devs0n.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringMvcGracefulShutdownApplication

fun main(args: Array<String>) {
    runApplication<SpringMvcGracefulShutdownApplication>(*args)
}
