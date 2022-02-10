package com.tistory.devs0n.visitor.lecture.visitor

import com.tistory.devs0n.visitor.lecture.element.Circle
import com.tistory.devs0n.visitor.lecture.element.Rectangle
import com.tistory.devs0n.visitor.lecture.element.Triangle

interface Device {
    fun print(circle: Circle)

    fun print(rectangle: Rectangle)

    fun print(triangle: Triangle)
}
