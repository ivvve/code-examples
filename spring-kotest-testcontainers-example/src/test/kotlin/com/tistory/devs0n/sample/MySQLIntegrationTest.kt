package com.tistory.devs0n.sample

import com.tistory.devs0n.sample.integration.IntegrationTest
import com.tistory.devs0n.sample.mysql.MySQLEntity
import com.tistory.devs0n.sample.mysql.MySQLEntityRepository
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

@IntegrationTest
class MySQLIntegrationTest(
    private val mySQLEntityRepository: MySQLEntityRepository,
) : FunSpec({

    test("MySQL integration test") {
        mySQLEntityRepository.save(MySQLEntity("mysql"))

        mySQLEntityRepository.findAll().apply {
            this shouldHaveSize 1
            this.first().name shouldBe "mysql"
        }
    }
})
