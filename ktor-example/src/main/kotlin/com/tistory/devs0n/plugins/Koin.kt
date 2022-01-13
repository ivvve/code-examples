package com.tistory.devs0n.plugins

import io.ktor.application.*
import org.koin.ktor.ext.Koin

fun Application.configureKoin() {
    install(Koin)
}
