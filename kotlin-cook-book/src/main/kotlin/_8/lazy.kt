package _8


object Answer {
//    val value = 42
    val value: Int by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
        println("Computing the answer...")
        42
    }
}

// 수행이 오래 걸리는 기능
fun longJob() {
    println("Job just started")
    Thread.sleep(2_000)
    println("Job has done")
}

fun main() {
    val answer: Int by lazy {
        println("Computing the answer...")
        42
    }
    longJob()
    println(answer)
}
