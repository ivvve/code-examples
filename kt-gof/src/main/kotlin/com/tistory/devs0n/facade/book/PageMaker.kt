package com.tistory.devs0n.facade.book

import java.io.FileWriter

class PageMaker {
    private constructor()

    companion object {
        fun makeWelcomePage(mailAddress: String, fileName: String) {
            val mailProperties = Database.getProperties("maildata")
            val username = mailProperties.getProperty(mailAddress)

            val writer = HtmlWriter(FileWriter(fileName))
            writer.title("Welcome to ${username}'s page!")
            writer.paragraph("I'm waiting for your email")
            writer.mailto(mailAddress, username)
            writer.close()

            println("$fileName is created for ${username}(${mailAddress})")
        }
    }
}
