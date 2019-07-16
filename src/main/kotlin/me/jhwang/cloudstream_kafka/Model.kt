package me.jhwang.cloudstream_kafka

import com.fasterxml.jackson.annotation.JsonInclude
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.UpdateTimestamp
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "note")
@JsonInclude(JsonInclude.Include.NON_NULL)
@NamedQuery(
        name = "Note.findByTitle",
        query = "SELECT n FROM Note n where n.title like ?1"
)
data class Note (
        @Id
        @GeneratedValue(generator = "uuid2")
        @GenericGenerator(name = "uuid2", strategy = "uuid2")
        @Column(columnDefinition = "varchar(36)")
        var id: String = "",
        var title: String = "",
        var message: String = "",
        var location: String = "",

        @CreationTimestamp
        var created: Date = Date(),

        @UpdateTimestamp
        var modified: Date = Date()
        )