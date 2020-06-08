package com.example.kotlindemo.model

import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.*

@Entity
data class Post(

        var title: String = "",
        var body: String = "",

        @ManyToOne
        @JoinColumn(name = "user_id", nullable = false)
        @OnDelete(action = OnDeleteAction.CASCADE)
        var user: User? = null,

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0

)