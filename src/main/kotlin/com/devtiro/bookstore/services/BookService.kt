package com.devtiro.bookstore.services

import com.devtiro.bookstore.domain.BookSummary
import com.devtiro.bookstore.domain.entity.BookEntity

interface BookService {

    fun createUpdate(isbn: String, bookSummary: BookSummary):Pair<BookEntity, Boolean>

    fun list(authorId: Long?): List<BookEntity>
}