package com.tistory.devson.pipeline

import com.google.gson.JsonParser

fun getTotalCpuPercent(metricJson: String): Double =
    JsonParser().parse(metricJson).asJsonObject
        .getAsJsonObject("system")
        .getAsJsonObject("cpu")
        .getAsJsonObject("total")
        .getAsJsonObject("norm")
        .getAsJsonPrimitive("pct").asDouble

fun getMetricName(metricJson: String): String =
    JsonParser().parse(metricJson).asJsonObject
        .getAsJsonObject("metricset")
        .getAsJsonPrimitive("name").asString

fun getHostTimestamp(metricJson: String): String {
    val metric = JsonParser().parse(metricJson).asJsonObject
    val result = metric.getAsJsonObject("host")
    result.add("timestamp", metric.get("@timestamp"))
    return result.toString()
}
