package me.jhwang.cloudstream_kafka

import org.hibernate.annotations.UpdateTimestamp
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.text.SimpleDateFormat
import java.util.*

@RestController
@RequestMapping("/notes")
@EnableAutoConfiguration
class NoteController {

    @Autowired
    lateinit var service: NoteService

    @GetMapping
    fun getNotes(): Iterable<NoteDTO> = service.getNotes()

    @GetMapping("/{id}")
    fun getNote(@PathVariable id: String): NoteDTO = service.getNote(id)

    @PostMapping
    fun createNode(@RequestBody note: NoteDTO) = service.createNote(note)

    @DeleteMapping("/{id}")
    fun deleteNote(@PathVariable id: String) = service.deleteNote(id)

    @PutMapping
    fun updateNode(@RequestBody note: NoteDTO) = service.updateNote(note)

    @GetMapping("/search/{date}")
    fun getNotesLaterThan(@PathVariable date: String): Iterable<NoteDTO> = service.getNotesLaterThan(SimpleDateFormat("YYYYMMdd").parse(date))

    @GetMapping("/title/{title}")
    fun findNotesByTitle(@PathVariable title: String): Iterable<NoteDTO> = service.findNotesByTitle(title)
}