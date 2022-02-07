package com.tistory.devs0n.state.lecture.state

import com.tistory.devs0n.state.lecture.context.OnlineCourse
import com.tistory.devs0n.state.lecture.Student

class Private(
    private val onlineCourse: OnlineCourse,
)  : State{
    override fun addReview(review: String, student: Student) {
        this.validateStudentHasInvitation(student)
        this.onlineCourse.reviews.add(review)
    }

    override fun addStudent(student: Student) {
        this.validateStudentHasInvitation(student)
        this.onlineCourse.students.add(student)
    }

    private fun validateStudentHasInvitation(student: Student) {
        if (!student.hasInvitation(this.onlineCourse)) {
            throw UnsupportedOperationException("${student.name} cannot join this course ${this.onlineCourse.name}")
        }
    }
}
