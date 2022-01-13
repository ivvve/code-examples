package com.tistory.devs0n.flyweight.lecture

class FontFactory {
    private val cache = mutableMapOf<String, Font>()

    fun getFont(fontName: String): Font {
        val font = this.cache[fontName]

        if (font != null) {
            return font
        }

        val newFont = this.createFont(fontName)
        this.cache[fontName] = newFont
        return newFont
    }

    private fun createFont(font: String): Font {
        val familyAndSize = font.split(":")
        return Font(family = familyAndSize[0], size = familyAndSize[1].toInt())
    }
}
