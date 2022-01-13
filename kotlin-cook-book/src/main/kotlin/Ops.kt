import ops.U1Ops
import ops.U2Ops
import ops.U3Ops

class Ops(
    private val op1: U1Ops,
    private val op2: U2Ops,
    private val op3: U3Ops,
) {
    fun op1() = this.op1.op1()
    fun op2() = this.op2.op2()
    fun op3() = this.op3.op3()
}
