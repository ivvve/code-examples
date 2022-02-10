package com.tistory.devs0n.templatemethod.templateCallback

import java.io.File
import java.io.IOException

class FileUser {
    fun useFile(filePath: String, callback: FileUsage) {
        val file = try {
            File(filePath)
        } catch (ex: IOException) {
            ex.printStackTrace()
            throw ex
        }

        println("I found the file")
        callback.use(file)
        println("I've finished using the file")
    }

//    fun useFile(filePath: String, callback: FileUsage) {
//        val file = try {
//            File(filePath)
//        } catch (ex: IOException) {
//            ex.printStackTrace()
//            throw ex
//        }
//
//        println("I found the file")
//        this.callback(file)
//        println("I've finished using the file")
//    }
//
//    abstract fun callback(file: File)
}
