package io.github.ivvve.mm

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MmApplication

fun main(args: Array<String>) {
    runApplication<MmApplication>(*args)
}
