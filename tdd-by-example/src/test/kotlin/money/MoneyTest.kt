package money

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MoneyTest {

    @Test
    fun testMultiplication() {
        val dollar = Dollar(5)
        assertThat(dollar.times(2)).isEqualTo(Dollar(10))
        assertThat(dollar.times(3)).isEqualTo(Dollar(15))
    }

    @Test
    fun testEquality() {
        assertThat(Dollar(5)).isEqualTo(Dollar(5))
        assertThat(Dollar(5)).isNotEqualTo(Dollar(6))
    }
}