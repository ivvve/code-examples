package com.tistory.devs0n.builder.person

data class Person(
    var name: String? = null,
    var birthDay: BirthDay? = null
) {
     fun birthDay(init: BirthDay.() -> Unit) {
        this.birthDay = BirthDay().apply(init)
    }
}

data class BirthDay(
    var year: Int? = null,
    var month: Int? = null,
    var day: Int? = null
)

fun person(init: Person.() -> Unit): Person {
//    val person = Person()
//    person.init()
//    return person
    return Person().apply(init)
}
