package com.tistory.devs0n.builder.lecture

import java.time.LocalDate

class DefaultTourPlanBuilder : TourPlanBuilder {
    private var title: String = ""
    private var nights: Int = 0
    private var days: Int = 0
    private var startDate: LocalDate = LocalDate.MIN
    private var whereToStay: String = ""
    private var plans: MutableList<TourPlan.DetailPlan> = mutableListOf()

    override fun title(title: String): TourPlanBuilder {
        this.title = title
        return this
    }

    override fun nightsAndDays(nights: Int, days: Int): TourPlanBuilder {
        this.nights = nights
        this.days = days
        return this
    }

    override fun startDate(startDate: LocalDate): TourPlanBuilder {
        this.startDate = startDate
        return this
    }

    override fun whereToStay(whereToStay: String): TourPlanBuilder {
        this.whereToStay = whereToStay
        return this
    }

    override fun addPlan(day: Int, plan: String): TourPlanBuilder {
        this.plans.add(TourPlan.DetailPlan(day, plan))
        return this
    }

    override fun getPlan(): TourPlan =
        TourPlan(this.title, this.nights, this.days, this.startDate, this.whereToStay, this.plans)
}
