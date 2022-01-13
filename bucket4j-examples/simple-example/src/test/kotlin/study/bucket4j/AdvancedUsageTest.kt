package study.bucket4j

import io.github.bucket4j.Bandwidth
import io.github.bucket4j.BlockingStrategy
import io.github.bucket4j.Bucket
import io.github.bucket4j.Bucket4j
import io.kotest.core.spec.style.DescribeSpec
import java.time.Duration
import java.util.concurrent.TimeUnit


class AdvancedUsageTest : DescribeSpec({
    /**
     * 분당 1,000회 허용을 주되, 초당 50회 제한을 추가한다.
     */
    it("Example of multiple bandwidth") {
        val bucket: Bucket = Bucket4j.builder()
            // 분당 1,000회 허용
            .addLimit(Bandwidth.simple(1000, Duration.ofMinutes(1)))
            // 초당 50회 초과 제한
            .addLimit(Bandwidth.simple(50, Duration.ofSeconds(1)))
            .build()


        while (true) {
            if (bucket.asScheduler().tryConsume(1, TimeUnit.HOURS.toNanos(1), BlockingStrategy.PARKING)) {
                println("Run!")
            }
        }
    }

    /**
     * 초기 토큰 수 지정하기
     */
    it("Specifying initial amount of tokens\n") {
        val initialTokens = 42

        val limit = Bandwidth
            .simple(1000, Duration.ofHours(1))
            .withInitialTokens(initialTokens.toLong()) // initial tokens

        val bucket: Bucket = Bucket4j.builder()
            .addLimit(limit)
            .build()
    }
})
