package com.tistory.devs0n.builder.lecture

//fun main() {
//    val tourPlan = TourPlan()
//    tourPlan.title = "칸쿤여행"
//    tourPlan.nights = 2
//    tourPlan.days = 3
//    tourPlan.startDate = LocalDate.of(2020, 12, 9)
//    tourPlan.whereToStay = "리조트"
//    tourPlan.addPlan(0, "체크인 이후 짐풀기")
//    tourPlan.addPlan(0, "저녁식사")
//    tourPlan.addPlan(1, "조식 부페에서 식사")
//    tourPlan.addPlan(1, "해변가 산책")
//    tourPlan.addPlan(1, "점심은 수영장 근처 음식점에서 먹기")
//    tourPlan.addPlan(1, "리조트 수영장에서 놀기")
//    tourPlan.addPlan(1, "저녁은 BBQ 식당에서 스테이크")
//    tourPlan.addPlan(2, "조식 부페에서 식사")
//    tourPlan.addPlan(2, "체크아웃")
//
//    val shortTrip = TourPlan()
//    shortTrip.title = "속초 여행"
//    shortTrip.startDate = LocalDate.of(2020, 12, 9)
//}

//fun main() {
//    val tourPlan = DefaultTourPlanBuilder()
//        .title("칸쿤여행")
//        .nightsAndDays(2, 3)
//        .startDate(LocalDate.of(2020, 12, 9))
//        .whereToStay("리조트")
//        .addPlan(0, "체크인 이후 짐풀기")
//        .addPlan(0, "저녁식사")
//        .addPlan(1, "조식 부페에서 식사")
//        .addPlan(1, "해변가 산책")
//        .addPlan(1, "점심은 수영장 근처 음식점에서 먹기")
//        .addPlan(1, "리조트 수영장에서 놀기")
//        .addPlan(1, "저녁은 BBQ 식당에서 스테이크")
//        .addPlan(2, "조식 부페에서 식사")
//        .addPlan(2, "체크아웃")
//        .getPlan()
//
//    val shortTrip = DefaultTourPlanBuilder()
//        .title("속초 여행")
//        .startDate(LocalDate.of(2020, 12, 9))
//        .getPlan()
//}

fun main() {
    val tourPlan = TourDirector(DefaultTourPlanBuilder()).cancunTrip()
    val shortTrip = TourDirector(DefaultTourPlanBuilder()).sokchoTrip()
}
