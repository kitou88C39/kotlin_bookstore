package com.devtiro.bookstore.domain.dto

data class BookDto(
    var isbn: String,
    var title: String,
    var description: String,
    var image: String,
    var author: Author
)