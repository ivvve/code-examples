package io.github.ivvve.common.utils

fun String.isEmail(): Boolean {
    val splitEmail = this.split("@")

    if (splitEmail.size != 2) {
        return false
    }

    val id = splitEmail[0]
    val domain = splitEmail[1]

    if (id.isBlank() || domain.isBlank()) {
        return false
    }

    val splitDomain = domain.split(".")

    if (splitDomain.size < 2) {
        return false
    }

    return !splitDomain.any { it.isBlank() }
}
