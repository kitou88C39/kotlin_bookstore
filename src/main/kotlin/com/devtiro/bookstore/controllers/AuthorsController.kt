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
        return try {
            val createAuthor = authorService.create(
                authorDto.toAtuthorEntity()
            ).toAtuthorDto()
            ResponseEntity(createAuthor, HttpStatus.CREATE)

        } catch (ex: IllegalArgumentException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
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

    @PutMapping(path = ["/{id}"])
    fun fullUpdateAuthor(@PathVariable("id") id:Long, @RequestBody authorDto: AuthorDto): ResponseEntity<AuthorDto> {
        return try {
            val updateAuthor = authorService.fullUpdate(id, authorDto.toAtuthorEntity())
            ResponseEntity(updateAuthor.toAtuthorDto(), HttpStatus.OK)

        } catch (ex: IllegalArgumentException) {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    @PatchMapping(path = ["/{id}"])
    fun partiaUpdateAuthor(@PathVariable("id") id:Long, @RequestBody authorUpdateRequest: AuthorUpdateRequest): ResponseEntity<AuthorDto> {
        return try {
            val updatedAuthor = authorService.fullUpdate(id, authorDto.toAtuthorEntity())
            ResponseEntity(updatedAuthor.toAtuthorDto(), HttpStatus.OK)

        } catch (ex: IllegalStateException) {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    @DeleteMapping(path = ["/{id}"])
    fun deleteAuthor(@PathVariable("id") id:Long): ResponseEntity<Unit> {
        return try {
            val updatedAuthor = authorService.fullUpdate(id, authorDto.toAtuthorEntity())
            ResponseEntity(updatedAuthor.toAtuthorDto(), HttpStatus.OK)

        } catch (ex: IllegalStateException) {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }
}