package com.tistory.devson.pipeline

import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.StreamsBuilder
import org.apache.kafka.streams.StreamsConfig
import java.util.*


fun main() {

    var streams: KafkaStreams? = null
    Runtime.getRuntime().addShutdownHook(Thread { streams?.close() })

    val properties = Properties()
    properties[StreamsConfig.APPLICATION_ID_CONFIG] = "metric-streams-application"
    properties[StreamsConfig.BOOTSTRAP_SERVERS_CONFIG] = "127.0.0.1:9092"
    properties[StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG] = Serdes.String()::class.java
    properties[StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG] = Serdes.String()::class.java

    val streamsBuilder = StreamsBuilder()
    val metricStream = streamsBuilder.stream<String, String>("metric.all")
    val metricBranches = metricStream.branch(
        { _key, value -> getMetricName(value) == "cpu" },
        { _key, value -> getMetricName(value) == "memory" },
    )

    metricBranches[0].to("metric.cpu")
    metricBranches[0]
        .filter { _key, value -> 0.5 < getTotalCpuPercent(value) }
        .mapValues { value -> getHostTimestamp(value) }
        .to("metric.cpu.alert")

    metricBranches[1].to("metric.memory")

    streams = KafkaStreams(streamsBuilder.build(), properties).apply { this.start() }
}
