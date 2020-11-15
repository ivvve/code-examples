package money

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class MoneyTest {
    @Test
    fun testMultiplication() {
        val five = Dollar(5)
        assertThat(five.times(2)).isEqualTo(Dollar(10))
        assertThat(five.times(3)).isEqualTo(Dollar(15))
    }

    @Test
    fun testEquality() {
        assertThat(Dollar(5)).isEqualTo(Dollar(5))
        assertThat(Dollar(5)).isNotEqualTo(Dollar(6))
    }

    @Test
    fun testFracMultiplication() {
        val five = Dollar(5)
        assertThat(five.times(2)).isEqualTo(Dollar(10))
        assertThat(five.times(3)).isEqualTo(Dollar(15))
    }
}
