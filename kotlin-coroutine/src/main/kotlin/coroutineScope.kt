import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() = coroutineScope {
    for (i in 1..10) {
        // Each coroutine runs concurrently
        launch {
            delay(1000L - (i * 100))
            println("index $i")
        }
    }
}
