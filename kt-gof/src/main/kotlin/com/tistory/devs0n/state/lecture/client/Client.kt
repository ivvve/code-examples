package com.tistory.devs0n.state.lecture.client

import com.tistory.devs0n.state.lecture.Student
import com.tistory.devs0n.state.lecture.context.OnlineCourse

fun main() {
    val onlineCourse = OnlineCourse("Design Pattern")
    val lim = Student("Lim")
    val na = Student("Na")

    lim.addInvitation(onlineCourse)

    // Draft
    println(
        runCatching { onlineCourse.addStudent(lim) }
    )
    println(
        runCatching { onlineCourse.addStudent(na) }
    )

    println("====")

    // Private
    onlineCourse.openPrivately()
    println(
        runCatching { onlineCourse.addStudent(lim) }
    )
    println(
        runCatching { onlineCourse.addStudent(na) }
    )

    println("====")

    // Published
    onlineCourse.openToPublic()
    println(
        runCatching { onlineCourse.addReview("Good", lim) }
    )
    println(
        runCatching { onlineCourse.addReview("Nice", na) }
    )
}
