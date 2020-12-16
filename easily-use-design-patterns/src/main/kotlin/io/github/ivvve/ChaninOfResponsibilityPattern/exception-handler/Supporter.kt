package io.github.ivvve.ChaninOfResponsibilityPattern.`exception-handler`

// Handler
abstract class Supporter(private val name: String) {
    var next: Supporter? = null

    // 다음 객체 Chain을 만듦
    fun setNext(next: Supporter): Supporter {
        this.next = next
        return next
    }

    // handle: 외부에 노출되는 처리 로직
    fun support(problem: Problem) {
        // 처리 가능한 지 확인
        val resolved = this.resolve(problem)

        if (resolved) {
            return this.done(problem) // 자기가 처리
        }

        // 다음애가 있으면 다음애가 처리
        if (this.next != null) {
            return this.next!!.support(problem)  // 다음 객체에 떠넘기기
        }

        // 실패....
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

// Concrete Handler
class NoSupporter(name: String) : Supporter(name) {
    override fun resolve(problem: Problem): Boolean {
        return false
    }
}

class LimitSupporter(name: String, private val limit: Int) : Supporter(name) {
    override fun resolve(problem: Problem): Boolean {
        return problem.number < this.limit
    }
}

class OddSupporter(name: String) : Supporter(name) {
    override fun resolve(problem: Problem): Boolean {
        return problem.number % 2 == 1
    }
}

class SpecialSupporter(name: String, private val number: Int) : Supporter(name) {
    override fun resolve(problem: Problem): Boolean {
        return this.number == problem.number
    }
}