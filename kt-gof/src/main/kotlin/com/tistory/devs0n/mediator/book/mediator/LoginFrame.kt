package com.tistory.devs0n.mediator.book.mediator

import com.tistory.devs0n.mediator.book.colleague.ColleagueButton
import com.tistory.devs0n.mediator.book.colleague.ColleagueCheckbox
import com.tistory.devs0n.mediator.book.colleague.ColleagueTextField
import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import kotlin.system.exitProcess

class LoginFrame(
    title: String
) : Frame(title), ActionListener, Mediator {
    init {
        this.background = Color.lightGray
        this.layout = GridLayout(4, 2)

        // component (Colleague) 생성
        this.createColleague()

        // component (Colleague) 배치
        this.add(this.checkboxGuest)
        this.add(this.checkboxLogin)
        this.add(Label("ID:"))
        this.add(this.textId)
        this.add(Label("Password:"))
        this.add(this.textPassword)
        this.add(this.buttonOk)
        this.add(this.buttonCancel)

        // 초기화
        this.colleagueChanged()

        // display
        this.pack()
        this.isVisible = true
    }

    lateinit var checkboxGuest: ColleagueCheckbox
    lateinit var checkboxLogin: ColleagueCheckbox
    lateinit var textId: ColleagueTextField
    lateinit var textPassword: ColleagueTextField
    lateinit var buttonOk: ColleagueButton
    lateinit var buttonCancel: ColleagueButton

    // Mediator 주변 Colleague들을 생성한다
    override fun createColleague() {
        val checkboxGroup = CheckboxGroup()

        this.checkboxGuest = ColleagueCheckbox("Guest", checkboxGroup, true)
        this.checkboxGuest.setMediator(this)
        this.checkboxGuest.addItemListener(checkboxGuest)

        this.checkboxLogin = ColleagueCheckbox("Login", checkboxGroup, false)
        this.checkboxLogin.setMediator(this)
        this.checkboxLogin.addItemListener(checkboxLogin)

        this.textId = ColleagueTextField("", 10)
        this.textId.setMediator(this)
        this.textId.addTextListener(textId)

        this.textPassword = ColleagueTextField("", 10)
        this.textPassword.setMediator(this)
        this.textPassword.echoChar = '*'
        this.textPassword.addTextListener(textPassword)

        this.buttonOk = ColleagueButton("OK")
        this.buttonOk.setMediator(this)
        this.buttonOk.addActionListener(this)

        this.buttonCancel = ColleagueButton("Cancel")
        this.buttonCancel.setMediator(this)
        this.buttonCancel.addActionListener(this)
    }

    override fun colleagueChanged() {
        if (this.checkboxGuest.state) {
            // Guest mode
            this.textId.changeColleagueEnabled(false)
            this.textPassword.changeColleagueEnabled(false)
            this.buttonOk.changeColleagueEnabled(true)
        } else {
            // Login Mode
            this.textId.changeColleagueEnabled(true)
            this.idOrPasswordChanged()
        }
    }

    private fun idOrPasswordChanged() {
        // ID가 입력되지 않았을 경우
        // `비밀번호`, `OK 버튼` 무효화
        if (this.textId.text.isEmpty()) {
            this.textPassword.changeColleagueEnabled(false)
            this.buttonOk.changeColleagueEnabled(false)
            return
        }

        // `비밀번호` 텍스트 입력 유효화
        this.textPassword.changeColleagueEnabled(true)

        if (this.textPassword.text.isEmpty()) {
            // 비밀번호가 입력되지 않았을 경우
            // `OK 버튼` 무효화
            this.buttonOk.changeColleagueEnabled(false)
        } else {
            // `OK 버튼` 유효화
            this.buttonOk.changeColleagueEnabled(true)
        }
    }

    override fun actionPerformed(e: ActionEvent) {
        println(e)
        exitProcess(0)
    }
}
