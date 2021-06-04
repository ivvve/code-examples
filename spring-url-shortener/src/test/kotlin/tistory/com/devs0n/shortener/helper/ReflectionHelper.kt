package tistory.com.devs0n.shortener.helper

import org.springframework.test.util.ReflectionTestUtils

fun setField(instance: Any, field: String, value: Any) =
    ReflectionTestUtils.setField(instance, field, value)
