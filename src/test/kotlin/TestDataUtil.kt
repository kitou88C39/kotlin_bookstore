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
    age = 30,
    description = "some description"
    image = "author-image.jpeg",
)