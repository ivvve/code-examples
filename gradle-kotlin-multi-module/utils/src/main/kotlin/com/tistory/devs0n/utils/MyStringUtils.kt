package com.tistory.devs0n.utils

infix fun String.isSpaceWithWidth(width: Int): Boolean = this.isBlank() && (this.length == width)

fun String.isNumber(): Boolean = !this.isNotNumber()

fun String.isNotNumber(): Boolean = this.any { !it.isDigit() }
