package me.jhwang.cloudstream_kafka

import org.springframework.stereotype.Service
import java.util.*

@Service("Note Service")
class NoteService {
    fun getNotes(): List<Note> = listOf (
            Note(UUID.randomUUID().toString(), "My first Note", "This is a message for the 1st notes"),
            Note(UUID.randomUUID().toString(), "My second Note", "This is a message for the 2nd notes")
    )

    fun createNote(note: Note): Note {
        note.id = UUID.randomUUID().toString()
        return note
    }

    fun deleteNote(id: String): Boolean = false
    fun updateNode(note: Note): Boolean = true
}