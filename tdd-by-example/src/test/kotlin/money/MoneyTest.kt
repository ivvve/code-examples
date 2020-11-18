package money

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MoneyTest {

    @Test
    fun testMultiplication() {
        val dollar = Dollar(5)

        var product = dollar.times(2)
        assertThat(product).isEqualTo(Dollar(10))

        product = dollar.times(3)
        assertThat(product).isEqualTo(Dollar(15))
    }

    @Test
    fun testEquality() {
        assertThat(Dollar(5)).isEqualTo(Dollar(5))
        assertThat(Dollar(5)).isNotEqualTo(Dollar(6))
    }
}