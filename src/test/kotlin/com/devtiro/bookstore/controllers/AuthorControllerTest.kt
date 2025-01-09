package com.devtiro.bookstore.controllers

import org.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.AutoConfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post

@SpringBootTest
@AutoConfigureMockMvc
class AuthorControllerTest @Autowired constructor(
    private val mockMvc: MockMvc,
    @MockBean val authorService: AuthorService
    ) {

    val objectMapper = ObjectMapper()

    @BeforeEach
    fun beforeEach()
    every {
        authorService.save(any())
    } answers {
        firstArg()
    }

    @Test
    fun `test that create Author saves the Author`(){
        every {
            authorService.save(any())
        } answers {
            firstArg()
        }


        mockMvc.post("/v1/authors"){
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(
                testAuthorDtoAuthorDto()
            )
    }
    val expected = AuthorEntity(
        id = null,
        name = "John Doe",
        age = 30,
        description = "author-image.jpeg",
        image = "some-description.jpeg"
    )
}
    @Test
    fun `test that create Author returns a HTTP 201 status on a successful create`(){
        mockMvc.post("/v1/authors"){
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(
                testAuthorDtoAuthorDto()
                )
        }.andExpect {
            status { isCreated() }
        }
    }
}
    