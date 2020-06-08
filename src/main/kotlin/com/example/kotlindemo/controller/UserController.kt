package com.example.kotlindemo.controller

import com.example.kotlindemo.model.User
import com.example.kotlindemo.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/api/v1")
class UserController {

    @Autowired
    lateinit var userRepository: UserRepository

    @GetMapping("/users")
    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }


    @PostMapping("/users")
    fun createNewUser(@RequestBody user: User): User =
            userRepository.save(user)


}