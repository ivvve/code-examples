package io.github.ivvve.securityoauth.core.user.domain

class UserInformation {
    val name: String
    val email: String

    constructor(name: String, email: String) {
        this.validate(name, email)

        this.name = name
        this.email = email
    }

    private fun validate(name: String, email: String) {
        if (name.isBlank()) {
            throw RuntimeException()
        }

        if (email.isBlank()) {
            throw RuntimeException()
        }
    }
}