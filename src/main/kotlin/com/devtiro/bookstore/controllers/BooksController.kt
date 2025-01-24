package com.devtiro.bookstore.controllers

import org.springframework.web.bind.annoatation.*

@RestController
class BooksController {

    @PutMapping(path = ["/v1/books/{isbn}"])
    fun createFullUpdateBook(@PathVariable("isbn"):isbn String){

    }
}