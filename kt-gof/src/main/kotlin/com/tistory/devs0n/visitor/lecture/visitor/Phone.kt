package com.tistory.devs0n.visitor.lecture.visitor

import com.tistory.devs0n.visitor.lecture.element.Circle
import com.tistory.devs0n.visitor.lecture.element.Rectangle
import com.tistory.devs0n.visitor.lecture.element.Triangle

class Phone : Device {
    override fun print(circle: Circle) {
        println("Print Circle to Phone")
    }

    override fun print(rectangle: Rectangle) {
        println("Print Rectangle to Phone")
    }

    override fun print(triangle: Triangle) {
        println("Print Triangle to Phone")
    }
}
