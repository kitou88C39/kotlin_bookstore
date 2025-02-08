package com.devtiro.bookstore.controllers

import com.devtiro.bookstore.services.BookService
import com.devtiro.bookstore.domain.dto.toBookSummary
import com.devtiro.bookstore.domain.dto.toBookSummaryDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annoatation.*

@RestController
class BooksController(val BookService: BookService) {

    @PutMapping(path = ["/v1/books/{isbn}"])
    fun createFullUpdateBook(@PathVariable("isbn")isbn: String, @RequestBody book: BookSummaryDto): responseEntity<BookSummaryDto> {
        try {
            val (savedBook, siCreated) = BookService.createUpdate(isbn, book.toBookSummary())
            val responseCode = if(isCreated) HttpStatus.CREATED else HttpStatus.OK
            return ResponseEntity(saveBook.toBookSummaryDto(), responseCode)

        } catch(ex: IllegalStateException){
            return ResponseEntity(HttpStatus.INTENAL_SERVER_ERROR)
        } catch(ex: IllegalStateException){
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

   @GetMapping
   fun readManyBooks(@RequestPram("author")authorId: Long?): List<BookSummaryDto> {
        return bookService.list(authorId:).map { it.toBookSummaryDto()}
    }

    @GetMapping(path = ["/isbn"])
    fun readOneBooks(@PathVariable("isbn") isbn: String): ResponseEntity<BookSummaryDto> {
        return bookService.get(isbn:)?.let { ResponseEntity(it.toBookSummaryDto(), HttpStatus.OK)}
        ?: ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @PatchMapping(path = ["/isbn"])
    fun partialUpdateBooks(
        @PathVariable("isbn") isbn: String,
        @RequestBody BookUpdateRequestDto: BookUpdateRequestDto
    ): ResponseEntity<BookSummaryDto> {
        try {
            val updatedBook = bookService.partialUpdate(isbn, bookUpdateRequestDto.toBookUpdateRequest())
            return ResponseEntity(updatedBook.toAuthorSummaryDto(),HttpStatus.OK)
        } catch (ex: IllegalStateException)
            return ResponseEntity(HttpStatus.BAD_REQUEST)
    }

    @DeleteMapping(path = ["/isbn"])
    fun deleteBooks(@PathVariable("isbn") isbn: String): ResponseEntity<Unit> {
        bookService.delete(isbn)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}