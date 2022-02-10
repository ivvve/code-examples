package com.tistory.devs0n.visitor.lecture

import com.tistory.devs0n.visitor.lecture.element.Rectangle
import com.tistory.devs0n.visitor.lecture.element.Shape
import com.tistory.devs0n.visitor.lecture.visitor.Device
import com.tistory.devs0n.visitor.lecture.visitor.Watch

fun main() {
    val rectangle: Shape = Rectangle()
    val watch: Device =  Watch()

    rectangle.accept(watch)
}
