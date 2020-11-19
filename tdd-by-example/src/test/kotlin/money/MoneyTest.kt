package money

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MoneyTest {

    @Test
    fun testMultiplication() {
        val dollar = Money.dollar(5)
        assertThat(dollar.times(2)).isEqualTo(Dollar(10))
        assertThat(dollar.times(3)).isEqualTo(Dollar(15))
    }

    @Test
    fun testEquality() {
        assertThat(Dollar(5)).isEqualTo(Dollar(5))
        assertThat(Dollar(5)).isNotEqualTo(Dollar(6))
        assertThat(Franc(5)).isEqualTo(Franc(5))
        assertThat(Franc(5)).isNotEqualTo(Franc(6))
        assertThat(Franc(5)).isNotEqualTo(Dollar(5))
    }

    @Test
    fun testFrancMultiplication() {
        val franc = Franc(5)
        assertThat(franc.times(2)).isEqualTo(Franc(10))
        assertThat(franc.times(3)).isEqualTo(Franc(15))
    }
}