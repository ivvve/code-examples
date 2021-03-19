package io.github.ivvve.multids

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MultipleDatasourceApplication

fun main(args: Array<String>) {
    runApplication<MultipleDatasourceApplication>(*args)
}
