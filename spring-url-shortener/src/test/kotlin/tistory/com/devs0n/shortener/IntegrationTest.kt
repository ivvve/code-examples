package tistory.com.devs0n.shortener

import io.restassured.RestAssured
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import tistory.com.devs0n.shortener.helper.DatabaseCleaner

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTest{
    @LocalServerPort
    private var port: Int = 0

    @Autowired
    private lateinit var databaseCleaner: DatabaseCleaner

    @BeforeEach
    fun setUpIntegrationTest() {
        RestAssured.port = this.port
    }

    @AfterEach
    fun tearDownIntegrationTest() = runBlocking {
        databaseCleaner.clean()
    }
}
