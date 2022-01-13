package _8

import kotlin.properties.Delegates

fun main() {
    var watchedNumber by Delegates.observable(0) { property, oldValue, newValue ->
        println("`${property.name}` changed from `$oldValue` to `$newValue`")
    }

    watchedNumber = 1
    watchedNumber = 2
    watchedNumber = 3
}
