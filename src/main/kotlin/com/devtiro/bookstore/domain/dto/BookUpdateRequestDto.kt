package com.devtiro.bookstore.domain.dto

data class BookUpdateRequestDto(
    var title: String?,
    var description: String?,
    var image: String?,
)