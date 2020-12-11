package io.github.ivvve.ChaninOfResponsibilityPattern.`exception-handler`

abstract class Support(private val name: String) {
    var next: Support? = null

    // 다음 객체 Chain을 만듦
    fun setNext(next: Support): Support {
        this.next = next
        return next
    }

    // 외부에 노출되는 처리 로직
    fun support(problem: Problem) {
        val resolved = this.resolve(problem)

        if (resolved) {
            return this.done(problem)
        }

        if (this.next != null) {
            return this.next!!.support(problem)  // 다음 객체에 떠넘기기
        }

        this.fail(problem)
    }

    // 처리 가능 여부 확인
    protected abstract fun resolve(problem: Problem): Boolean

    // 요청 처리
    private fun done(problem: Problem) {
        println("[${this.name}] resolved [$problem]")
    }

    // 요청 처리 실패
    private fun fail(problem: Problem) {
        println("Failed to resolve $problem")
    }
}

class NoSupport(name: String) : Support(name) {
    override fun resolve(problem: Problem): Boolean {
        return false
    }
}

class LimitSupport(name: String, private val limit: Int) : Support(name) {
    override fun resolve(problem: Problem): Boolean {
        return problem.number < this.limit
    }
}

class OddSupport(name: String) : Support(name) {
    override fun resolve(problem: Problem): Boolean {
        return problem.number % 2 == 1
    }
}

class SpecialSupport(name: String, private val number: Int) : Support(name) {
    override fun resolve(problem: Problem): Boolean {
        return this.number == problem.number
    }
}