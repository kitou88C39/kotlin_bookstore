package com.devtiro.bookstore.domain.dto

data class BookUpdateRequestDto(
    var title: String? = null,
    var description: String? = null,
    var image: String? = null,
)