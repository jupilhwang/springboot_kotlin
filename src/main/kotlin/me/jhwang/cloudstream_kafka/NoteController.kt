package me.jhwang.cloudstream_kafka

import org.hibernate.annotations.UpdateTimestamp
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/notes")
@EnableAutoConfiguration
class NoteController {

    @Autowired
    lateinit var service: NoteService

    @GetMapping
    fun getNotes(): Iterable<NoteDTO> = service.getNotes()

    @PostMapping
    fun createNode(@RequestBody note: NoteDTO)  = service.createNote(note)

    @DeleteMapping ("/{id}")
    fun deleteNote(@PathVariable id: String) = service.deleteNote(id)

    @PutMapping
    fun updateNode(@RequestBody note: NoteDTO) = service.updateNote(note)
}