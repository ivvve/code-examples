import io.github.ivvve.ChaninOfResponsibilityPattern.`problem-support`.AllExceptionHandler
import io.github.ivvve.ChaninOfResponsibilityPattern.`problem-support`.ExceptionHandler
import io.github.ivvve.ChaninOfResponsibilityPattern.`problem-support`.IOExceptionHandler
import io.github.ivvve.ChaninOfResponsibilityPattern.`problem-support`.RuntimeExceptionHandler
import java.io.IOException

fun main() {
    val ioExceptionHandler: ExceptionHandler = IOExceptionHandler()
    val runtimeExceptionHandler: ExceptionHandler = RuntimeExceptionHandler()
    val allExceptionHandler: ExceptionHandler = AllExceptionHandler()

    ioExceptionHandler.setNext(runtimeExceptionHandler).setNext(allExceptionHandler)

    ioExceptionHandler.handle(IOException())
    ioExceptionHandler.handle(IllegalArgumentException())
    ioExceptionHandler.handle(IOException())
}

