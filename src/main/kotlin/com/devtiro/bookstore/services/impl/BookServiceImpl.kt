package com.devtiro.bookstore.services.impl

import com.devtiro.bookstore.domain.BookSummary
import com.devtiro.bookstore.domain.entities.BookEntity
import com.devtiro.bookstore.services.BookService

class BookServiceImpl(val bookRepository: bookRepository) :BookService {

    override fun createUpdate(isbn: String, bookSummary: BookSummary): Pair<BookEntity, Boolean> {
        val normalisedBook = bookSummary.copy(isbn = isbn)
    }

}