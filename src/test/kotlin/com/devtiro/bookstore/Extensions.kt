package com.devtiro.bookstore

import com.devtiro.bookstore.domain.dto.AuthorDto
import com.devtiro.bookstore.domain.entities.AuthorEntity

fun AuthorEntity.toAuthorDto(): AuthorDto{
    return AuthorDto(
    id=this.id,
    name=this.name,
    age=this.age,
    description=this.description,
    image=this.image
    )
}