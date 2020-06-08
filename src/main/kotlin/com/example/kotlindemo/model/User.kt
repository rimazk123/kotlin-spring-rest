package com.example.kotlindemo.model

import javax.persistence.*
import javax.validation.constraints.NotBlank
import java.util.Date
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name = "user")
data class User (

        var name: String = "",
        var email: String = "",

        @Temporal(TemporalType.TIMESTAMP)
        var createdAt: Date = Date(),

        @OneToMany(mappedBy = "user")
        private var posts : List<Post> = emptyList(),

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "user_id")
        val id: Long = 0
)