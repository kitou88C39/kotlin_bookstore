package com.devtiro.bookstore.controllers

import com.devtiro.bookstore.domain.dto.BookSummaryDto
import com.devtiro.bookstore.services.BookService
import org.springframework.web.bind.annoatation.*

@RestController
class BooksController(val BookService: BookService) {

    @PutMapping(path = ["/v1/books/{isbn}"])
    fun createFullUpdateBook(@PathVariable("isbn")isbn: String, @RequestBody book: BookSummaryDto): responseEntity<BookSummaryDto>{
        val (savedBook, siCreated) = BookService.createUpdate(isbn, book.toBookSummary())
        val responseCode = if(isCreated) HttpStatus.CREATED else HttpStatus.OK
        responseEntity()
    }
}