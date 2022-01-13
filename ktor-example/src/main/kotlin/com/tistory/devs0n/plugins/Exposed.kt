package com.tistory.devs0n.plugins

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.application.*

fun Application.configureExposed() {
    fun hikary() {
        HikariConfig().apply {

        }
        HikariDataSource(HikariConfig().apply {
            driverClassName = ""
        })
    }
}
