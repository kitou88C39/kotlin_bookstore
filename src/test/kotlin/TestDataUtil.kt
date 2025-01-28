package com.devtiro.bookstore

import com.devtiro.bookstore.domain.AuthorUpdateRequest
import com.devtiro.bookstore.domain.dto.AuthorDto
import com.devtiro.bookstore.domain.dto.AuthorSummaryDto
import com.devtiro.bookstore.domain.entities.AuthorEntity

fun testAuthorDtoA(id: Long? = null) = AuthorDto(
    id = id,
    name = "John Doe",
    age = 30,
    description = "some description"
    image = "author-image.jpeg",
)

fun testAuthorEntityA(id: Long? = null) = AuthorEntity(
    id = id,
    name = "John Doe",
    age = 30,
    description = "some description"
    image = "author-image.jpeg",
)

fun testAuthorEntityB(id: Long? = null) = AuthorEntity(
    id = null,
    name = "John Doe",
    image = "author-image.jpeg",
)

fun testAuthorSummaryDtoA(id: Long) = AuthorSummaryDto(
    id = id,
    name = "John Doe",
    age = 30,
    description = "some description"
    image = "author-image.jpeg",
)

fun testAuthorUpdateRequestDtoA(id: Long? = null) = AuthorUpdateRequestDto(
    id = null,
    name = "John Doe",
    age = 30,
    description = "some description"
    image = "author-image.jpeg",
)

fun testAuthorUpdateRequestA(id: Long? = null) = AuthorUpdateRequest(
    id = null,
    name = "John Doe",
    age = 30,
    description = "some description"
    image = "author-image.jpeg",
)

fun testBookEntityA(isbn: String, author: AuthorEntity) = BookEntity(
    isbn = isbn,
    title = "Test Book A",
    description = "A test book"
    image = "book-image.jpeg",
    authorEntity = author
)

fun testBookSummaryDtoA(isbn: String, author: AuthorSummaryDto) = BookSummaryDto(
    isbn = isbn,
    title = "Test Book A",
    description = "A test book"
    image = "book-image.jpeg",
    author = author
)