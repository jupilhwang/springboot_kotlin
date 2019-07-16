package me.jhwang.cloudstream_kafka

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CloudstreamKafkaApplication

fun main(args: Array<String>) {
    runApplication<CloudstreamKafkaApplication>(*args)
}
