package com.tistory.devs0n.sample.integration

import io.kotest.core.listeners.AfterProjectListener
import io.kotest.core.listeners.BeforeProjectListener
import org.testcontainers.containers.MySQLContainer

class MySQLTestcontainersListener : BeforeProjectListener, AfterProjectListener {
    private val mysqlContainer = MySQLContainer<Nothing>("mysql:5.7").apply {
        withReuse(true) // to speed up container startup
        withDatabaseName("playground")
        withUsername("root")
        withPassword("root")
        withCreateContainerCmdModifier { cmd -> cmd.withPlatform("linux/x86_64") }
        withCommand("mysqld", "--character-set-server=utf8mb4")
    }

    override suspend fun beforeProject() {
        this.mysqlContainer.start()
        System.setProperty("spring.datasource.url", mysqlContainer.jdbcUrl)
        System.setProperty("spring.datasource.username", mysqlContainer.username)
        System.setProperty("spring.datasource.password", mysqlContainer.password)
    }

    override suspend fun afterProject() {
        this.mysqlContainer.close()
    }
}
