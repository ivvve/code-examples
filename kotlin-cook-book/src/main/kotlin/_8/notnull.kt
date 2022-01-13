package _8

import kotlin.properties.Delegates

fun main() {
    var shouldNotBeNull by Delegates.notNull<String>()

    try {
        println(shouldNotBeNull)
    } catch (e: IllegalStateException) {
        e.printStackTrace()
    }

    shouldNotBeNull = "Not Null"
    println(shouldNotBeNull)
}
