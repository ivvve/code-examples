package com.tistory.devs0n.jooq.test

import org.jooq.DSLContext
import org.springframework.stereotype.Component

@Component
class DatabaseCleaner(
    private val dsl: DSLContext,
) {
    // caching tables
    private val tables = this.dsl.meta()
        .getSchemas("playground")
        .flatMap { it.tables }
        .filter { it.name != "flyway_schema_history" }

    fun clean() {
        this.tables
            .parallelStream()
            .forEach { this.dsl.truncate(it).execute() }
    }
}
