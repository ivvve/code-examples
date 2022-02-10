package com.tistory.devs0n.templatemethod.templateCallback

fun main() {
    val fileUser = FileUser()
    val filePath = ""

    // describe file
    fileUser.useFile(
        filePath,
        {
            println("File name is ${it.name}")
            println("File size is ${it.readBytes().size}")
        }
    )

    // send file
    fileUser.useFile(
        filePath,
        {
            println("Send file to Server")
            // Sending file to server logic
            println("Finished!")
        }
    )
}
