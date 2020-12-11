package io.github.ivvve.ChaninOfResponsibilityPattern.`problem-support`

import java.io.IOException
import java.lang.Exception

abstract class ExceptionHandler {
    private var next: ExceptionHandler? = null

    fun setNext(handler: ExceptionHandler): ExceptionHandler {
        this.next = handler
        return this.next!!
    }

    fun handle(exception: Exception) {
        if (this.canHandle(exception)) {
            this.doHandle(exception)
        } else if (this.hasNext()) {
            this.next!!.handle(exception)
        } else {
            throw exception
        }
    }

    protected abstract fun canHandle(exception: Exception): Boolean

    protected abstract fun doHandle(exception: Exception)

    private fun hasNext(): Boolean {
        return this.next != null
    }
}

class IOExceptionHandler : ExceptionHandler() {
    override fun canHandle(exception: Exception): Boolean {
        return exception is IOException
    }

    override fun doHandle(exception: Exception) {
        println("Handle IOException")
    }
}

class RuntimeExceptionHandler : ExceptionHandler() {
    override fun canHandle(exception: Exception): Boolean {
        return exception is RuntimeException
    }

    override fun doHandle(exception: Exception) {
        println("Handle RuntimeException")
    }
}

class AllExceptionHandler : ExceptionHandler() {
    override fun canHandle(exception: Exception): Boolean {
        return true
    }

    override fun doHandle(exception: Exception) {
        println("Handle Exception")
    }
}