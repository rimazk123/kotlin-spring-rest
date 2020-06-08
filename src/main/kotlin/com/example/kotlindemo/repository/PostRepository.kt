package com.example.kotlindemo.repository

import com.example.kotlindemo.model.Post
import com.example.kotlindemo.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface PostRepository : JpaRepository<Post, Long> {
    fun findPostsByUser(user : User) : List<Post>
}