package com.tistory.devs0n.eventtx.common.exception

abstract class BaseException(
    val context: String,
    val code: String,
    val description: String,
) : RuntimeException()
