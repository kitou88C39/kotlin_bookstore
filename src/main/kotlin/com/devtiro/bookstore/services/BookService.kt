package com.devtiro.bookstore.services

import com.devtiro.bookstore.domain.BookSummary

interface BookService {

    fun createUpdate(isbn: String, bookSummary: BookSummary)
}