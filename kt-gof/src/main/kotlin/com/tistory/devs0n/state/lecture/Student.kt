package com.tistory.devs0n.state.lecture

import com.tistory.devs0n.state.lecture.context.OnlineCourse

class Student(
    val name: String,
) {
    private val courseInvitations: MutableSet<OnlineCourse> = mutableSetOf()

    fun hasInvitation(onlineCourse: OnlineCourse): Boolean = this.courseInvitations.contains(onlineCourse)

    fun addInvitation(onlineCourse: OnlineCourse) {
        this.courseInvitations.add(onlineCourse)
    }
}
