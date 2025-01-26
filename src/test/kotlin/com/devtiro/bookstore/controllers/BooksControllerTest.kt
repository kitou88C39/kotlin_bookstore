package com.devtiro.bookstore.controllers


import com.devtiro.bookstore.services.AuthorService
import com.devtiro.bookstore.services.BookService
import com.festerxml.jackson.databind.ObjectMapper
import com.ninjasquad.springmockk.MockBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.AutoConfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc

@SpringBootTest
@AutoConfigureMockMvc
class BooksControllerTest @Autowired constructor　(
    private val mockMvc: MockMvc,
    @MockkBean val authorService: AuthorService
    ) {
    val objectMapper = ObjectMapper()

    @Test
    fun `test that createFullUpdateBook return HTTP 201 when book is created`(){
        val isbn = "978-089-230342-0777"

    every {
        authorService.save(any())
    } answers {
        firstArg()
    }
  }
}