import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
    runBlockingBuilder()
}

fun runBlockingBuilder() {
    println("Before runBlocking\n")

    val time = measureTimeMillis {
        runBlocking {
            print("Hello ")
            delay(200)
            println("World")
        }
    }

    println("\nAfter runBlocking")

    println("===================")

    println("It took $time ms")
}
