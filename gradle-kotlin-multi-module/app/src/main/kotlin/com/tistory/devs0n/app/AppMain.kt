package com.tistory.devs0n.app

import com.tistory.devs0n.utils.isNotNumber
import com.tistory.devs0n.utils.isNumber
import com.tistory.devs0n.utils.isSpaceWithWidth
import org.apache.commons.lang3.StringUtils

fun main() {
    assert("123".isNumber())
    assert("123a".isNotNumber())
    assert("   " isSpaceWithWidth 3)

    assert(StringUtils.isBlank("  "))
}
