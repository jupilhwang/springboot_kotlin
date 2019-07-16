package me.jhwang.cloudstream_kafka

data class Note (
        var id: String = "",
        var title: String = "",
        var message: String,
        var location: String = ""
)