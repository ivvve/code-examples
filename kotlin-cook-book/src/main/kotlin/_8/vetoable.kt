package _8

import kotlin.properties.Delegates

fun main() {
    var increasingNumber by Delegates.vetoable(0) { property, oldValue, newValue ->
        println("`${property.name}` is tried to be changed from `$oldValue` to `$newValue`")
        oldValue < newValue
    }

    increasingNumber = 1
    println(increasingNumber) // 1

    increasingNumber = 5
    println(increasingNumber) // 5

    increasingNumber = 3
    println(increasingNumber) // 5
}
