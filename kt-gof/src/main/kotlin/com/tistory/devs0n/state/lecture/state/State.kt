package com.tistory.devs0n.state.lecture.state

import com.tistory.devs0n.state.lecture.Student

interface State {
    fun addReview(review: String, student: Student)

    fun addStudent(student: Student)
}
