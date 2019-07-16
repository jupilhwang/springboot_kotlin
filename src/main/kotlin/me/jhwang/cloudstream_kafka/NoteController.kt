package me.jhwang.cloudstream_kafka

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
    fun getNotes(): List<Note>  = service.getNotes()

    @PostMapping
    fun createNode(@RequestBody note: Note): Note  = service.createNote(note)

    @PutMapping
    fun updateNode(@RequestBody note: Note): Boolean = service.updateNode(note)

    @DeleteMapping
    fun deleteNode(id: String): Boolean = service.deleteNote(id)
}