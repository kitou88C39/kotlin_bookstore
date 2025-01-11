package com.devtiro.bookstore.controllers


import com.devtiro.bookstore.domain.dto.AuthorDto
import com.devtiro.bookstore.services.AuthorService
import com.devtiro.bookstore.services.toAuthorDto
import com.devtiro.bookstore.services.toAuthorEntity
import org.springframework.web.bind.annoatation.*

@RestController
@RequestMapping(path = ["/v1/authors"])
class AuthorController(private val AuthorService: AuthorService) {

    @PostMapping(path = ["/v1/authors"])
    fun createAuthor(@RequestBody authorDto: AuthorDto): ResponseEntity<AuthorDto>{
        val createAuthor = authorService.save(authorDto.toAtuthorEntity()
        ).toAtuthorDto()
        return ResponseEntity(createAuthor, HttpStatus.CREATED)
    }
    @GetMapping(path = ["/v1/authors"])
    fun createAuthor(@RequestBody authorDto: AuthorDto): ResponseEntity<AuthorDto>{
        val createAuthor = authorService.save(authorDto.toAtuthorEntity()
        ).toAtuthorDto()
        return ResponseEntity(createAuthor, HttpStatus.CREATED)
    }
}