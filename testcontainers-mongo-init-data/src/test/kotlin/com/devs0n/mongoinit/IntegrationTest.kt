package com.devs0n.mongoinit

import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@ExtendWith(MongodbTestcontainersExtension::class)
abstract class IntegrationTest {
}
