import kotlinx.coroutines.*

fun main() = runBlocking {
    val result1 = wait(1000)
    val result2 = wait(2000)

    println(result1)
    println(result2)
}

suspend fun wait(ms: Long) =
    withContext(Dispatchers.IO) {
        println(Thread.currentThread().name)
        delay(ms)
        "wait for $ms"
    }

