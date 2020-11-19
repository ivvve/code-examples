package money

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MoneyTest {

    @Test
    fun testMultiplication() {
        val dollar = Money.dollar(5)
        assertThat(dollar.times(2)).isEqualTo(Money.dollar(10))
        assertThat(dollar.times(3)).isEqualTo(Money.dollar(15))
    }

    @Test
    fun testEquality() {
        assertThat(Money.dollar(5)).isEqualTo(Money.dollar(5))
        assertThat(Money.dollar(5)).isNotEqualTo(Money.dollar(6))
        assertThat(Franc(5)).isEqualTo(Franc(5))
        assertThat(Franc(5)).isNotEqualTo(Franc(6))
        assertThat(Franc(5)).isNotEqualTo(Money.dollar(5))
    }

    @Test
    fun testFrancMultiplication() {
        val franc = Franc(5)
        assertThat(franc.times(2)).isEqualTo(Franc(10))
        assertThat(franc.times(3)).isEqualTo(Franc(15))
    }
}