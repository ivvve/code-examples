package io.github.ivvve.restdocs

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RestdocsApplication

fun main(args: Array<String>) {
	runApplication<RestdocsApplication>(*args)
}
