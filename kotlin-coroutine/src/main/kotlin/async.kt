import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
    asyncBuilder()
}

fun asyncBuilder() {
    println("Before runBlocking\n")

    val time = measureTimeMillis {
        runBlocking {
            val sum1 = async { add(1, 2) }
            val sum2 = async { add(2, 3) }

            val sumOfSums = sum1.await() + sum2.await()
            println("Sum of sums: $sumOfSums")
        }
    }

    println("\nAfter runBlocking")

    println("===================")

    println("It took $time ms")

}

suspend fun add(a: Int, b: Int): Int {
    delay(100L * a)
    return a + b
}
