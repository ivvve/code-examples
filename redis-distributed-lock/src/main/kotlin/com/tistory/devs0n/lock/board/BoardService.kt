package com.tistory.devs0n.lock.board

import org.redisson.api.RedissonClient
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.concurrent.TimeUnit

@Service
class BoardService(
    private val boardRepository: BoardRepository,
    private val redissonClient: RedissonClient,
) {
    fun getBoardToReadWithLock(boardId: Long): Board {
        val lock = this.redissonClient.getLock("lock:board:$boardId")
        val locked = lock.tryLock(5, 5, TimeUnit.SECONDS)

        if (!locked) {
            throw RuntimeException("Unable to get Lock - ${lock.name}")
        }
        LOGGER.info("Succeeded to get Lock - ${lock.name}")


        try {
            return this.getBoardToRead(boardId)
        } finally {
            lock.unlock()
            LOGGER.info("Unlock the Lock - ${lock.name}")
        }
    }

    @Transactional
    fun getBoardToRead(boardId: Long): Board {
        val board = this.boardRepository.getById(boardId)
        board.hit()
        return this.boardRepository.save(board)
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(this::class.java)
    }
}
