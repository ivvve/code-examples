package com.tistory.devs0n.jooq.test

import io.kotest.core.extensions.Extension
import io.kotest.core.spec.style.FunSpec
import org.springframework.beans.factory.annotation.Autowired

abstract class IntegrationTestFunSpec(body: FunSpec.() -> Unit = {}) : IntegrationTest, FunSpec(body) {
    @Autowired
    private lateinit var databaseCleaner: DatabaseCleaner

    init {
        beforeTest {
            this.databaseCleaner.clean()
        }
    }

    override fun extensions(): List<Extension> {
        return IntegrationTest.kotestExtensions
    }
}
