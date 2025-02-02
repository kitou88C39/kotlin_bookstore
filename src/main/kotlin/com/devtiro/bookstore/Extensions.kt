package com.devtiro.bookstore

import com.devtiro.bookstore.domain.dto.AuthorDto
import com.devtiro.bookstore.domain.dto.BookSummaryDto
import com.devtiro.bookstore.domain.entities.AuthorEntity
import com.devtiro.bookstore.domain.entities.BookEntity

fun AuthorEntity.toAuthorDto() = AuthorDto(
    id=this.id,
    name=this.name,
    age=this.age,
    description=this.description,
    image=this.image
)

fun AuthorEntity.toAuthorSummaryDto(): AuthorSummaryDto{
    val authorId = this.id ?:throw InvalidAuthorException()
    checkNotNull(authorId)
    return AuthorSummaryDto(
        id=this.id,
        name=this.name,
        image=this.image
    )
}

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

fun AuthorSummaryDto.toAuthorSummary() = AuthorSummary(
    id=this.id,
    name=this.name,
    image=this.image
)

fun BookSummaryDto.toBookEntity(author: AuthorEntity) = BookSummary(
    isbn=this.isbn,
    title=this.title,
    description=this.description,
    image=this.image,
    author=this.author.toAuthorSummary()
)

fun BookEntity.toBookSummaryDto() = BookSummaryDto(
    isbn=this.isbn,
    title=this.title,
    description=this.description,
    image=this.image,
    author=this.authorEntityDto()
)

fun BookUpdateRequestDto.toBookUpdateRequest() = BookUpdateRequest(
    title=this.title,
    description=this.description,
    image=this.image
)