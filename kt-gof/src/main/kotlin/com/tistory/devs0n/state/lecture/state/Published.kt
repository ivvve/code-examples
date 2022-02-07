package com.tistory.devs0n.state.lecture.state

import com.tistory.devs0n.state.lecture.Student
import com.tistory.devs0n.state.lecture.context.OnlineCourse

class Published(
    private val onlineCourse: OnlineCourse,
) : State {

    override fun addReview(review: String, student: Student) {
        this.onlineCourse.reviews.add(review)
    }

    override fun addStudent(student: Student) {
        this.onlineCourse.students.add(student)
    }
}
