package io.github.ivvve.containertest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TestcontainersExampleApplication

fun main(args: Array<String>) {
    runApplication<TestcontainersExampleApplication>(*args)

    print("Done without any problems")
}
