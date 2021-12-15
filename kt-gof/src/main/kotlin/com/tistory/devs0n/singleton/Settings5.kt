package com.tistory.devs0n.singleton

import java.io.*

class Settings5 : Serializable {
    private constructor()

    // static inner class: java로 변환하면 static class로 변환됨
    private class SettingsHolder {
        companion object {
            val INSTANCE = Settings5()
        }
    }

    companion object {
        fun getInstance(): Settings5 = SettingsHolder.INSTANCE
    }

    protected fun readResolve(): Any = getInstance()
}

// reflection으로 깨트리기
//fun main() {
//    val settings1 = Settings5.getInstance();
//
//    val constructor = Settings5::class.java.getDeclaredConstructor()
//    constructor.isAccessible = true
//    val settings2 = constructor.newInstance()
//
//    println(settings1 == settings2)
//}

// 직렬화&역직렬화로 깨트리기
fun main() {
    val settings1 = Settings5.getInstance()

    ObjectOutputStream(FileOutputStream("settings.obj")).use {
        it.writeObject(settings1)
    }

    ObjectInputStream(FileInputStream("settings.obj")).use {
        val settings2 = it.readObject() as Settings5
        println(settings1 == settings2)
    }
}
