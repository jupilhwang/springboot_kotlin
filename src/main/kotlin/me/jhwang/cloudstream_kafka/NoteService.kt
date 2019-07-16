package me.jhwang.cloudstream_kafka

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service("Note Service")
class NoteService {

    @Autowired
    lateinit var repository: NoteRepository

//    fun getNotes(): Iterable<Note> = repository.findAll()
//    fun createNote(note: Note): Note = repository.save(note)
//    fun deleteNote(id: String) = repository.deleteById(id)
//    fun updateNote(note: Note): Note = repository.save(note)

    fun getNotes(): Iterable<NoteDTO> = repository.findAll().map { it -> NoteDTO(it) }
    fun getNote(id: String): NoteDTO = NoteDTO(repository.findById(id).get())
    fun createNote(noteDto: NoteDTO) = NoteDTO(
            repository.save(
                    Note(
                            title = noteDto.title,
                            message = noteDto.message,
                            location = noteDto.location
                    )
            )
    )
    fun deleteNote(id: String) = repository.deleteById(id)
    fun updateNote(noteDto: NoteDTO): NoteDTO {
        var note = repository.findById(noteDto.id).get()
        note.title = noteDto.title
        note.message = noteDto.message
        note.location = noteDto.location
        note.modified = Date()
        note = repository.save(note)
        return NoteDTO(note)
    }
    fun getNotesLaterThan(date: Date): Iterable<NoteDTO> = repository.findNoteLaterThan(date.time).map { it -> NoteDTO(it) }
    fun findNotesByTitle(title: String): Iterable<NoteDTO> = repository.findByTitle(title).map { it -> NoteDTO(it) }
}
