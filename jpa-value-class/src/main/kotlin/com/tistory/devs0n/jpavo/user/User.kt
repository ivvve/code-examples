package com.tistory.devs0n.jpavo.user

import javax.persistence.*

/**
 * Without VO
 */
//@Entity
//@Table(name = "users")
//class User(
//    name: String,
//    email: String,
//) {
//    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    val id: Long = 0
//
//    @Column(name = "name")
//    val name: String = name
//
//    @Column(name = "email")
//    val email: String = email
//
//    init {
//        validateUserName()
//        validateUserEmail()
//    }
//
//    private fun validateUserName() {
//        if (this.name.isBlank()) {
//            throw IllegalArgumentException("invalid user name: ${this.name}")
//        }
//    }
//
//    private fun validateUserEmail() {
//        val usernameAndDomain = this.email.split('@')
//
//        if (usernameAndDomain.size != 2) {
//            throw IllegalArgumentException("invalid user email: ${this.email}")
//        }
//    }
//
//    override fun toString(): String {
//        return "User(id=$id, name='$name', email='$email')"
//    }
//}


/**
 * With VO - data class
 */
//@Entity
//@Table(name = "users")
//class User(
//    name: UserName,
//    email: UserEmail,
//) {
//    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    val id: Long = 0
//
//    @Embedded
//    val name: UserName = name
//
//    @Embedded
//    val email: UserEmail = email
//
//    override fun toString(): String {
//        return "User(id=$id, name='$name', email='$email')"
//    }
//}
//
//@Embeddable
//data class UserName(
//    @Column(name = "name")
//    val value: String
//) {
//    init {
//        if (this.value.isBlank()) {
//            throw IllegalArgumentException("invalid user name: ${this.value}")
//        }
//    }
//}
//
//@Embeddable
//data class UserEmail(
//    @Column(name = "email")
//    val value: String
//) {
//    init {
//        val usernameAndDomain = this.value.split('@')
//
//        if (usernameAndDomain.size != 2) {
//            throw IllegalArgumentException("invalid user email: ${this.value}")
//        }
//    }
//}


/**
 * With VO - value class
 */
@Entity
@Table(name = "users")
class User(
    name: UserName,
    email: UserEmail,
) {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @Column(name = "name")
    val name: UserName = name

    @Column(name = "email")
    val email: UserEmail = email

    override fun toString(): String {
        return "User(id=$id, name='$name', email='$email')"
    }
}

@JvmInline
value class UserName(
    val value: String
) {
    init {
        if (this.value.isBlank()) {
            throw IllegalArgumentException("invalid user name: ${this.value}")
        }
    }
}

@JvmInline
value class UserEmail(
    val value: String
) {
    init {
        val usernameAndDomain = this.value.split('@')

        if (usernameAndDomain.size != 2) {
            throw IllegalArgumentException("invalid user email: ${this.value}")
        }
    }
}
