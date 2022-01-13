package _8

interface Worker {
    fun work()
}

class OfficeWorker : Worker {
    override fun work() {
        println("Work in my office")
    }
}

interface Student {
    fun study()
}

class WorkerStudent : Student {
    override fun study() {
        println("Work after work")
    }
}

class Developer1 : Worker, Student {
    override fun work() {
        println("Work hard!")
    }

    override fun study() {
        println("Study hard!")
    }
}

class Developer2(
    private val worker: Worker,
    private val student: Student
) : Worker by worker, Student by student

fun main() {
    val developer1 = Developer1()
    developer1.work()
    developer1.study()

    val developer2 = Developer2(OfficeWorker(), WorkerStudent())
    developer2.work()
    developer2.study()
}
