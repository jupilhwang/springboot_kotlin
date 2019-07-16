package me.jhwang.cloudstream_kafka

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/notes")
@EnableAutoConfiguration
class NoteController {

    @GetMapping
    fun getNotes(): List<Note> {
        return listOf(
                Note( UUID.randomUUID().toString(),
                        "My First note",
                        "This is a message for the 1st note"),
                Note( UUID.randomUUID().toString(),
                        "My Second note",
                        "This is a message for the 2nd note")
        )
    }
    @PostMapping
    fun insertNode(@RequestBody note: Note): Note {
        note.id = UUID.randomUUID().toString()
        return note
    }


}