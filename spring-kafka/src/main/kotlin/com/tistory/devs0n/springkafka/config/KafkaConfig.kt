package com.tistory.devs0n.springkafka.config

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.*

@EnableKafka
@Configuration
class KafkaConfig {
    // Consumer
    @Bean
    fun consumerFactory(): ConsumerFactory<String, String> {
        return DefaultKafkaConsumerFactory(
            mapOf(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to "127.0.0.1:9092,127.0.0.1:9093,127.0.0.1:9094", // Broker 설정 (separator ',')
                ConsumerConfig.GROUP_ID_CONFIG to "my_consumer", // Consumer Group 설정
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java,
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java,
            )
        )
    }

    @Bean
    fun kafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, String> {
        val kafkaListenerContainerFactory = ConcurrentKafkaListenerContainerFactory<String, String>()
        kafkaListenerContainerFactory.consumerFactory = this.consumerFactory()
        return kafkaListenerContainerFactory
    }

    // Producer
    @Bean
    fun producerFactory():ProducerFactory<String, String> {
        return DefaultKafkaProducerFactory(
            mapOf(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to "127.0.0.1:9092", // Broker 설정 (separator ',')
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java,
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java,
            )
        )
    }

    @Bean
    fun kafkaTemplate(): KafkaTemplate<String, String> {
        return KafkaTemplate(this.producerFactory())
    }
}
