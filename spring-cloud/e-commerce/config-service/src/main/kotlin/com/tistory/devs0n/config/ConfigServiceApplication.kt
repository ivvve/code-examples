package com.tistory.devs0n.config

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer

@SpringBootApplication
@EnableConfigServer
class ConfigServiceApplication

fun main(args: Array<String>) {
    runApplication<ConfigServiceApplication>(*args)
}
