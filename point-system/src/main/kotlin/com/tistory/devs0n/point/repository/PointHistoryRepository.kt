package com.tistory.devs0n.point.repository

import com.tistory.devs0n.point.model.PointHistory

interface PointHistoryRepository {
    fun save(history: PointHistory): PointHistory
}
