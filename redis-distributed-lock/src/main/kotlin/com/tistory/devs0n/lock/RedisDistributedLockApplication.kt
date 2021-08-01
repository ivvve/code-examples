package com.tistory.devs0n.lock

import com.tistory.devs0n.lock.board.Board
import com.tistory.devs0n.lock.board.BoardRepository
import com.tistory.devs0n.lock.board.BoardService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import kotlin.concurrent.thread

@SpringBootApplication
class RedisDistributedLockApplication

fun main(args: Array<String>) {
    val ac = runApplication<RedisDistributedLockApplication>(*args)

    // initial data
    val boardRepository = ac.getBean(BoardRepository::class.java)
    val board1 = boardRepository.save(Board("Without Lock"))
    val board2 = boardRepository.save(Board("With Lock"))
    val board3 = boardRepository.save(Board("With Lock (AOP)"))

    // test
    val boardService = ac.getBean(BoardService::class.java)

    runWithoutLock(board1, boardService, 100)
    runWithLock(board2, boardService, 100)
    runWithLockAop(board3, boardService, 100)
}

fun runWithoutLock(board: Board, boardService: BoardService, times: Int) {
    repeat(times) {
        thread(start = true) {
            boardService.getBoardToRead(board.id!!)
        }
    }
}

fun runWithLock(board: Board, boardService: BoardService, times: Int) {
    repeat(times) {
        thread(start = true) {
            boardService.getBoardToReadWithLock(board.id!!)
        }
    }
}

fun runWithLockAop(board: Board, boardService: BoardService, times: Int) {
    repeat(times) {
        thread(start = true) {
            boardService.getBoardToReadWithLock(board.id!!)
        }
    }
}
