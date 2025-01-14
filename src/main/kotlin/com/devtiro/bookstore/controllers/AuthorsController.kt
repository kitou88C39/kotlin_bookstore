package com.devtiro.bookstore.controllers


import com.devtiro.bookstore.domain.dto.AuthorDto
import com.devtiro.bookstore.services.AuthorService
import com.devtiro.bookstore.services.toAuthorDto
import com.devtiro.bookstore.services.toAuthorEntity
import org.springframework.web.bind.annoatation.*

@RestController
@RequestMapping(path = ["/v1/authors"])
class AuthorController(private val authorService: AuthorService) {

    @PostMapping
    fun createAuthor(@RequestBody authorDto: AuthorDto): ResponseEntity<AuthorDto> {
        try {
            val createAuthor = authorService.create(
                .authorDto.toAtuthorEntity()
            ).toAtuthorDto()
            return ResponseEntity(createAuthor, HttpStatus.OK)
        } catch (ex: IllegalArgumentException) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @GetMapping
    fun readManyAuthor(): List<AuthorDto> {
        return authorService.list().map{it.toAtuthorDto()}
    }

    @GetMapping(path = ["/{id}"])
    fun readOneAuthor(@PathVariable("id") id: Long): ResponseEntity<AuthorDto> {
        val readOneAuthor = authorService.get(id)?.toAtuthorDto()
        return foundAuthor?.let {
            ResponseEntity(it, HttpStatus.OK)
        } ?: ResponseEntity(HttpStatus.NOT_FOUND)
    }
}