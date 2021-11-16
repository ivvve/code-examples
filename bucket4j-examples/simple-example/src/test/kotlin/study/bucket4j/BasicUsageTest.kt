package study.bucket4j

import io.github.bucket4j.Bandwidth
import io.github.bucket4j.Bucket4j
import io.github.bucket4j.Refill
import io.kotest.core.spec.style.DescribeSpec
import java.lang.management.ManagementFactory
import java.math.BigDecimal
import java.time.Duration
import java.util.concurrent.RejectedExecutionException
import java.util.concurrent.TimeUnit

// https://github.com/vladimir-bukhtoyarov/bucket4j/blob/master/doc-pages/basic-usage.md
class BasicUsageTest : DescribeSpec({
    /**
     * thread-pool executor를 사용할 때 RejectedExecutionException가 발생한 시기에
     * JVM의 모든 thread의 stacktrace를 출력하는 것이 모든 thread가 어디에 막혀있고 왜 thread-pool이 overflow 되었는지를 알기 위한 최고의 방법이 될 것이다.
     * 하지만 stacktrace를 얻는 것은 매우 비싼 작업이기에 10분에 1번이 넘게 실행되지 않길 원한다.
     */
    it("Example 1 - limiting the rate of heavy work") {
        // 10 분에 1회 limit 생성
        val limit = Bandwidth.simple(1, Duration.ofMinutes(1))
        // bucket 생성
        val bucket = Bucket4j.builder().addLimit(limit).build();

        try {
            throw RejectedExecutionException()
        } catch (e: RejectedExecutionException) {
            if (bucket.tryConsume(1)) {
                val stackTraces = ManagementFactory.getThreadMXBean().dumpAllThreads(true, true)
                stackTraces.forEach { println(it) }
            }
        }
    }

    /**
     * 외부 API를 통해 달러 <-> 유로 환율을 갱신해야한다고 했을 때,
     * 계약 상 API 1분에 100회를 초과하여 호출을 하면 API 제공자가 ip를 차단한다고 하자.
     */
    it("Example 2 - using bucket as scheduler") {
        val limit = Bandwidth.simple(100, Duration.ofMinutes(1))
        val bucket = Bucket4j.builder().addLimit(limit).build();

        var exchangeRate = BigDecimal.ONE

        while (true) {
            bucket.asScheduler().consume(1)

            exchangeRate = exchangeRate.add(BigDecimal.valueOf(0.0001))
            println("환율 API 호출 : 환율 - $exchangeRate")
        }
    }

    /**
     * 서비스의 API를 외부 개발자에게 제공할 때, 시스템이 overloading 되는 것을 방지하기 위해 API 제한을 둘 수 있다.
     *
     * bucket의 사이즈는 50이며, 초당 10회 리필이 된다.
     * 만약, client app이 초당 10회 호출하면, throttle이 걸리지 않고, 초당 10회 보다 잦게 호출하면 토큰을 다 소모하고 throttle이 걸릴 것이다.
     */
    it("Example 3 - limiting the rate of access to REST API") {
        val overdraft = 50L
        var refill = Refill.greedy(10, Duration.ofSeconds(1))
        val limit = Bandwidth.classic(overdraft, refill)
        val bucket = Bucket4j.builder().addLimit(limit).build() // bucket per session

        val probe = bucket.tryConsumeAndReturnRemaining(1)
        if (probe.isConsumed) {
            // filterChange.doFilter
        } else {
            // limit 초과
            // 오류 응답
            println(TimeUnit.NANOSECONDS.toSeconds(probe.nanosToWaitForRefill))
        }
    }
})
