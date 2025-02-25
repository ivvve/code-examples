package com.tistory.devs0n.example

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class KMSTest {
    @Serializable
    private data class ListOfNonNullElementsData(
        val values: List<String>,
    )

    @Serializable
    private data class ListOfNullableElementsData(
        val values: List<String?>,
    )

    @Test
    fun `serialization for list of non-null elements test`() {
        assertThrows<Exception> {
            Json.Default.decodeFromString<ListOfNonNullElementsData>("""{"values": ["a", null]}""")
        }.apply {
            this.printStackTrace()
        }
    }

    @Test
    fun `serialization for list of nullable elements test`() {
        assertDoesNotThrow {
            Json.Default.decodeFromString<ListOfNullableElementsData>("""{"values": ["a", null]}""")
        }
    }
}
