package money

import org.junit.jupiter.api.Assertions.*
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ChocoServiceTest {
    @Test
    fun `doThat Test`() {
        val chocoService = ChocoService()
//        chocoService.value == 1

        chocoService.doThat(4)

//        chocoService.value == 0 or chocoService == 1
    }
}