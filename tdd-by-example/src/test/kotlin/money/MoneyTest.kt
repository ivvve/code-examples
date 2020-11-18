package money

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MoneyTest {

    @Test
    fun testMultiplication() {
        val dollar = Dollar(5)

        var product = dollar.times(2)
        assertThat(product.amount).isEqualTo(10)

        product = dollar.times(3)
        assertThat(product.amount).isEqualTo(15)
    }
}