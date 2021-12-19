package com.tistory.devs0n.builder.lecture

import java.time.LocalDate

class TourPlan {
    var title: String = ""
    var nights: Int = 0
    var days: Int = 0
    var startDate: LocalDate = LocalDate.MIN
    var whereToStay: String = ""
    var plans: MutableList<DetailPlan> = mutableListOf()

    constructor(
        title: String, nights: Int, days: Int, startDate: LocalDate,
        whereToStay: String, plans: MutableList<DetailPlan>
    ) {
        this.title = title
        this.nights = nights
        this.days = days
        this.startDate = startDate
        this.whereToStay = whereToStay
        this.plans = plans
    }

    data class DetailPlan(
        val day: Int,
        val plan: String,
    )


    fun addPlan(day: Int, plan: String) {
        this.plans.add(DetailPlan(day, plan))
    }
}
