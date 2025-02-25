package com.tistory.devs0n.example

import com.fasterxml.jackson.annotation.JsonSetter
import com.fasterxml.jackson.annotation.Nulls
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertEquals

@SpringBootTest
class DeserializationTest {
    private data class ListOfNonNullElementsData(
        val values: List<String>,
    )

    private data class SkipOnNullData(
        @JsonSetter(contentNulls = Nulls.SKIP)
        val values: List<String>,
    )

    private data class FailOnNullData(
        @JsonSetter(contentNulls = Nulls.FAIL)
        val values: List<String>,
    )

    @Autowired
    private lateinit var mapper: ObjectMapper

    @Test
    fun `serialization for list of non-null elements test`() {
        val serialized = mapper.readValue<ListOfNonNullElementsData>("""{"values": ["a", null]}""")
        assertEquals(serialized.values, listOf("a", null))
    }

    @Test
    fun `serialization for list of non-null elements test - skip`() {
        val serialized = mapper.readValue<SkipOnNullData>("""{"values": ["a", null]}""")
        assertEquals(serialized.values, listOf("a"))
    }

    @Test
    fun `serialization for list of non-null elements test - fail`() {
        assertThrows<Exception> {
            mapper.readValue<FailOnNullData>("""{"values": ["a", null]}""")
        }.apply {
            this.printStackTrace()
        }
    }
}
