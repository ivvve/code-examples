package _8

import java.util.concurrent.atomic.AtomicBoolean
import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}

class HelloDelegate(private var value: String) : ReadWriteProperty<Any, String> {
    override operator fun getValue(thisRef: Any, property: KProperty<*>): String {
        return "Hello, ${this.value}"
    }

    override operator fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        this.value = value
    }
}
