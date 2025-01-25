package com.devtiro.bookstore

import com.devtiro.bookstore.domain.dto.AuthorDto
import com.devtiro.bookstore.domain.entities.AuthorEntity

fun AuthorEntity.toAuthorDto() = AuthorDto(
    id=this.id,
    name=this.name,
    age=this.age,
    description=this.description,
    image=this.image
)

fun AuthorDto.toAuthorEntity() = AuthorEntity(
    id=this.id,
    name=this.name,
    age=this.age,
    description=this.description,
    image=this.image
)

fun AuthorUpdateRequestDto.toAuthorUpdateRequestDto() = AuthorUpdateRequest(
    id=this.id,
    name=this.name,
    age=this.age,
    description=this.description,
    image=this.image
)

fun BookSummary.toBookEntity(author: AuthorEntity) = BookEntity(
    isbn=this.isbn,
    title=this.title,
    description=this.description,
    image=this.image,
    authorEntity=this.authorEntity
)

fun BookSummary.toBookEntity(author: AuthorEntity) = BookEntity(
    isbn=this.isbn,
    title=this.title,
    description=this.description,
    image=this.image,
    authorEntity=this.authorEntity
)
