package com.tistory.devs0n.state.lecture.context

import com.tistory.devs0n.state.lecture.Student
import com.tistory.devs0n.state.lecture.state.Draft
import com.tistory.devs0n.state.lecture.state.Private
import com.tistory.devs0n.state.lecture.state.Published
import com.tistory.devs0n.state.lecture.state.State

class OnlineCourse(
    val name: String,
) {
    private var state: State = Draft()

    val students: MutableList<Student> = mutableListOf()
    val reviews: MutableList<String> = mutableListOf()

    fun addStudent(student: Student) {
        this.state.addStudent(student)
    }

    fun addReview(review: String, student: Student) {
        this.state.addReview(review, student)
    }

    fun openPrivately() {
        this.state = Private(this)
    }

    fun openToPublic() {
        this.state = Published(this)
    }
}
