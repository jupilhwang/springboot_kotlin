package me.jhwang.cloudstream_kafka

import org.springframework.data.repository.CrudRepository

interface NoteRepository: CrudRepository<Note, String>