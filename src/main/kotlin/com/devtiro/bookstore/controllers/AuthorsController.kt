package com.devtiro.bookstore.controllers

import org.springframework.web.bind.annoatation.PostMapping
import org.springframework.web.bind.annoatation.RequestBody
import org.springframework.web.bind.annoatation.RestController

@RestController
class AuthorController {

    @PostMapping(path = ["/v1/authors"])
    fun createAuthor(@RequestBody AuthorEntity: AuthorDto): AuthorDto{

    }
}