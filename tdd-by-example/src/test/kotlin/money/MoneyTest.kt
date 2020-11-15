package money

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class MoneyTest {
    @Test
    fun testMultiplication() {
        val dollar = Dollar(5)
        dollar.times(2)
        assertThat(dollar.amount)
    }
}
