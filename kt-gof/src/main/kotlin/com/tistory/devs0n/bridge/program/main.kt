package com.tistory.devs0n.bridge.program

import com.tistory.devs0n.bridge.program.os.MacOSFeature
import com.tistory.devs0n.bridge.program.program.CalculatorProgram

fun main() {
    CalculatorProgram(MacOSFeature()) // MacOS에서 돌아가는 Calculator 프로그램
    // 새로운 OS를 지원해야하는 경우
    // WindowsCalculatorProgram을 만드는 것이 아닌 OSFeature를 추가함
}
