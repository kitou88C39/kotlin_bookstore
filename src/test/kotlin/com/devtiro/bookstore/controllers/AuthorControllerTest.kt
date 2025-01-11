package com.devtiro.bookstore.controllers

import com.ninjasquad.springmockk.MockBean
import io.mockk.empty
import io.mockk.verify
import org.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.AutoConfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post

private const val AUTHORS_BASE_URL = "/v1/authors"

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


        mockMvc.post("AUTHORS_BASE_URL"){
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
        image = "author-image.joeg",
        description = "author-image.jpeg"
    )
    verify{authorService.save(expected)}
}
    
@Test
    fun `test that list returns an empty list and HTTP 200 when no author in the data`(){
        mockMvc.get("AUTHORS_BASE_URL"){
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(
                testAuthorDtoAuthorDto()
                )
        }.andExpect {
            status { isOk() }
            content { json ( "{}")}
        }
    }
}
