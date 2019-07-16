package me.jhwang.cloudstream_kafka

data class Note (
        var id: String = "",
        var title: String = "",
        var message: String,
        var location: String = ""
)

data class Todo (
        var id: String = "",
        var title: String,
        var message: String,
        var schedule: Long,
        var location: String = ""
)