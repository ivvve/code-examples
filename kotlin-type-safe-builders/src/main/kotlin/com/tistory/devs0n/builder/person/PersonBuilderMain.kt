package com.tistory.devs0n.builder.person

fun main() {
    val person = person {
        // this.name = "devson"
        name = "devson"

        birthDay {
            year = 1991
            month = 11
            day = 9
        }
    }

    println(person)
}
