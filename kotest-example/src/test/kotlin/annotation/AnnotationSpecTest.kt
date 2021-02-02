package annotation

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class AnnotationSpecTest : AnnotationSpec() {
    @BeforeEach
    fun beforeEach() {
        println("beforeEach")
    }

    @AfterEach
    fun afterEach() {
        println("afterEach")
    }

    @Test
    fun `test 1 == 1`() {
        1 shouldBe 1
    }

    @Ignore
    fun ignoredTest() {
        1 shouldNotBe 1
    }
}