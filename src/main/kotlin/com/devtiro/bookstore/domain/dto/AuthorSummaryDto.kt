package com.devtiro.bookstore.domain.dto

data class AuthorSummaryDto(
    val id: Long,
    val name: String? = null,
    val image: String? = null
)
