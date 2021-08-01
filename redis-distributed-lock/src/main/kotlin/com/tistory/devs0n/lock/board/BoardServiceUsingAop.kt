package com.tistory.devs0n.lock.board

import com.tistory.devs0n.lock.aop.DistributedLock
import com.tistory.devs0n.lock.aop.LockParameter
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BoardServiceUsingAop(
    private val boardRepository: BoardRepository,
) {
    @DistributedLock
    @Transactional
    fun getBoardToRead(@LockParameter("board-id") boardId: Long): Board {
        val board = this.boardRepository.getById(boardId)
        board.hit()
        return this.boardRepository.save(board)
    }
}
