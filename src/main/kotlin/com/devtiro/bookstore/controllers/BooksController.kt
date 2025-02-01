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
    fun createFullUpdateBook(@PathVariable("isbn")isbn: String, @RequestBody book: BookSummaryDto): responseEntity<BookSummaryDto>{
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

   @GetMapping(path = ["/v1/books"])
   fun readManyBooks(@RequestPram("author")authorId: Long?): List<BookSummaryDto> {
      return BookService.list(authorId:).map { it.toBookSummaryDto()}
    }
}