package com.devtiro.bookstore.controllers


import com.devtiro.bookstore.domain.dto.AuthorDto
import com.devtiro.bookstore.services.AuthorService
import com.devtiro.bookstore.services.toAuthorDto
import com.devtiro.bookstore.services.toAuthorEntity
import org.springframework.web.bind.annoatation.PostMapping
import org.springframework.web.bind.annoatation.RequestBody
import org.springframework.web.bind.annoatation.RestController

@RestController
class AuthorController(private val AuthorService: AuthorService) {

    @PostMapping(path = ["/v1/authors"])
    fun createAuthor(@RequestBody authorDto: AuthorDto): AuthorDto{
        return authorService.save(authorDto.toAtuthorEntity()
        ).toAtuthorDto()
    }
}