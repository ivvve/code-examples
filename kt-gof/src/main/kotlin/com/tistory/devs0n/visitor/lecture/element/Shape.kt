package com.tistory.devs0n.visitor.lecture.element

import com.tistory.devs0n.visitor.lecture.visitor.Device

interface Shape {
    fun accept(device: Device)
}
