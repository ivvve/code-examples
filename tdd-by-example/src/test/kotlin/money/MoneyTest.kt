package money

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class MoneyTest {
    @Test
    fun testMultiplication() {
        val five = Dollar(5)

        var product = five.times(2)
        assertThat(product.amount).isEqualTo(10)

        product = five.times(3)
        assertThat(product.amount).isEqualTo(15)
    }
}
