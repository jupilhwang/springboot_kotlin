package me.jhwang.cloudstream_kafka

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service("Note Service")
class NoteService {

    @Autowired
    lateinit var repository: NoteRepository

    fun getNotes(): Iterable<Note> = repository.findAll()
    fun createNote(note: Note): Note = repository.save(note)
    fun deleteNote(id: String) = repository.deleteById(id)
    fun updateNote(note: Note): Note = repository.save(note)
}
