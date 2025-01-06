package com.devtiro.bookstore

import com.devtiro.bookstore.domain.dto.AuthorDto
import com.devtiro.bookstore.domain.entities.AuthorEntity

fun AuthorEntity.toAuthorDto(): AuthorDto{
    return AuthorDto()
}