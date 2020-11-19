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
        assertThat(Money.franc(5)).isNotEqualTo(Money.dollar(5))
    }

    @Test
    fun testDifferentClassEquality() {
        assertThat(Money(10, "CHF")).isEqualTo(Franc(10, "CHF"))
    }

    @Test
    fun testFrancMultiplication() {
        val franc = Money.franc(5)
        assertThat(franc.times(2)).isEqualTo(Money.franc(10))
        assertThat(franc.times(3)).isEqualTo(Money.franc(15))
    }

    @Test
    fun testCurrency() {
        assertThat("USD").isEqualTo(Money.dollar(1).currency())
        assertThat("CHF").isEqualTo(Money.franc(1).currency())
    }
}