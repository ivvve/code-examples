package com.tistory.devs0n.ktvalidation.web

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(exception: MethodArgumentNotValidException): ResponseEntity<*> {
        val fields = exception.bindingResult.fieldErrors.map { it.field }.toList()
        return ResponseEntity
            .badRequest()
            .body(mapOf(
                "code" to "bad request",
                "fields" to fields,
            ))
    }
}
