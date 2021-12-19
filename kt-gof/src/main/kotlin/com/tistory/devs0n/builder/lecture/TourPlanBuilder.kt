package com.tistory.devs0n.builder.lecture

import java.time.LocalDate

interface TourPlanBuilder {
    fun title(title: String): TourPlanBuilder

    fun nightsAndDays(nights: Int, days: Int): TourPlanBuilder

    fun startDate(startDate: LocalDate): TourPlanBuilder

    fun whereToStay(whereToStay: String): TourPlanBuilder

    fun addPlan(day: Int, plan: String): TourPlanBuilder

    // build method
    fun getPlan(): TourPlan
}
