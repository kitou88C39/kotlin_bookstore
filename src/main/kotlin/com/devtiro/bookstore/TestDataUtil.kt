package com.devtiro.bookstore

fun testAuthorDtoA(id: Long? = null) = AuthorDto(
    id = id,
    name = "John Doe",
    age = 30,
    description = "author-image.jpeg",
    image = "some-description.jpeg"
    )

fun testAuthorEntityA(id: Long? = null) = AuthorEntity(
    id = id,
    name = "John Doe",
    age = 30,
    description = "author-image.jpeg",
    image = "some-description.jpeg"
    )