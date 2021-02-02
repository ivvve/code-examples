package money

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ATest {
    @Test
    fun test_rrn_checker() {
        val rrnChecker = RRNChecker()
        val checked: Boolean = rrnChecker.check("9111091234567")
        assertThat(checked).isTrue()
    }


    @Test
    fun `주민번호는 길이가 13`() {

    }

    @Test
    fun `2000년도 이후 태어난 사람은 뒷자리 앞이 3 or 4`() {
        val rrnChecker = RRNChecker()
        val checked: Boolean = rrnChecker.check("9111093234567")
        assertThat(checked).isFalse()
    }

    // 1. 쉬운 경우 -> 어려운 경우: 테스트가

    // 2. 예외적인 경우 -> 정상적인 경우: 로직이
    // 예외 -> 설계

}