package com.tistory.devs0n.amd

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AnnotatedMultiDatasourceApplication

fun main(args: Array<String>) {
    runApplication<AnnotatedMultiDatasourceApplication>(*args)
}
