package me.jhwang.cloudstream_kafka

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import java.util.*

interface NoteRepository: CrudRepository<Note, String>  {

    @Query("from Note t where t.modified > ?1")
    fun findNoteLaterThan(date: Long): Iterable<Note>
}