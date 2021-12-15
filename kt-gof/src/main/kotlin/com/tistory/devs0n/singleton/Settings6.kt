package com.tistory.devs0n.singleton

import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

enum class Settings6(
    private val number: Int,
) {
    INSTANCE(777);
}

fun main() {
    val settings1 = Settings6.INSTANCE

    ObjectOutputStream(FileOutputStream("settings.obj")).use {
        it.writeObject(settings1)
    }

    ObjectInputStream(FileInputStream("settings.obj")).use {
        val settings2 = it.readObject() as Settings6
        println(settings1 == settings2)
    }
}
