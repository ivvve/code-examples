package com.tistory.devs0n.state.lecture.state

import com.tistory.devs0n.state.lecture.Student

class Draft : State {
    override fun addReview(review: String, student: Student) {
        throw UnsupportedOperationException("Cannot add review because this course hasn't published yet")
    }

    override fun addStudent(student: Student) {
        throw UnsupportedOperationException("Cannot add student because this course hasn't published yet")
    }
}
