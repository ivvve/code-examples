package com.tistory.devs0n.visitor.lecture.visitor

import com.tistory.devs0n.visitor.lecture.element.Circle
import com.tistory.devs0n.visitor.lecture.element.Rectangle
import com.tistory.devs0n.visitor.lecture.element.Triangle

class Watch : Device {
    override fun print(circle: Circle) {
        println("Print Circie to Watch")
    }

    override fun print(rectangle: Rectangle) {
        println("Print Rectangle to Watch")
    }

    override fun print(triangle: Triangle) {
        println("Print Triangle to Watch")
    }
}
