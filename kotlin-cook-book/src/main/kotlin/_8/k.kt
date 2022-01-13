package _8

open class Money(amount: Long) {
    var amount: Long = amount
        protected set

    open fun add(other: Money): Money = Money(this.amount + other.amount)
}

class KoreanMoney(amount: Long) : Money(amount) {

    override fun add(other: Money): Money {
        this.amount += other.amount
        return Money(this.amount + other.amount)
    }
}

class Op1 {

}

class Ops(
    private
) {

}
