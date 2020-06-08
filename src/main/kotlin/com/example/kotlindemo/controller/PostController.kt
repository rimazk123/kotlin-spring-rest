package com.example.kotlindemo.controller

import com.example.kotlindemo.model.Post
import com.example.kotlindemo.model.User
import com.example.kotlindemo.repository.PostRepository
import com.example.kotlindemo.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1")
class PostController {

    @Autowired
    lateinit var postRepository : PostRepository

    @Autowired
    lateinit var userRepository: UserRepository

    @GetMapping("/posts")
    fun getPosts() : List<Post> =
            postRepository.findAll()

    @PostMapping("/{userId}/posts")
    fun createNewPost(@PathVariable (value = "userId") userId: Long, @RequestBody post: Post) : Post {
        userRepository.findById(userId).map { post.user = it }
        return postRepository.save(post)
    }

    @GetMapping("/{userId}/posts")
    fun getUserPosts(@PathVariable (value = "userId") userId: Long) : List<Post> {
        val user = userRepository.findById(userId)
        return postRepository.findPostsByUser(user.get())
    }

}