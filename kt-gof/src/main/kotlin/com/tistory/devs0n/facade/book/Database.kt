package com.tistory.devs0n.facade.book

import java.io.FileInputStream
import java.io.IOException
import java.util.*

class Database {
    private constructor()

    companion object {
        fun getProperties(dbName: String): Properties {
            val properties = Properties()
            val fileName = "${dbName}.txt"

            try {
                properties.load(FileInputStream(fileName))
            } catch (ex: IOException) {
                println("Warning: $fileName not found")
            }

            return properties
        }
    }
}
