package com.devtiro.bookstore.controllers

import com.devtiro.bookstore.services.AuthorService
import com.devtiro.bookstore.services.BookService


import com.festerxml.jackson.databind.ObjectMapper
import com.ninjasquad.springmockk.MockBean
import org.hamcrest.CoreMatchers.equalTo
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.AutoConfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.put
import org.springframework.test.web.servlet.result.StatusResultMatchersDsl


@SpringBootTest
@AutoConfigureMockMvc
class BooksControllerTest @Autowired constructor　(
    private val mockMvc: MockMvc,
    @MockkBean val authorService: AuthorService
    ) {
    val objectMapper = ObjectMapper()

    @Test
    fun `test that createFullUpdateBook return HTTP 201 when book is created`(){
        assertThatUserCreatedUpdated(true){isCreated()}
    }

    @Test
    fun `test that createFullUpdateBook return HTTP 200 when book is updated`(){
        assertThatUserCreatedUpdated(false){isOk()}
    }

    private fun assertThatUserCreatedUpdated(isCreated: Boolean, statusCodeAssertion: StatusResultMatchersDsl.() -> Unit) {
        val isbn = "978-089-230342-0777"
        val author = testAuthorEntityA(id=1)
        val savedBook = testBookEntityA(isbn, author)

        val authorSummaryDto = testBookSummaryDtoA(id=1)
        val bookSummaryDto = testBookSummaryDtoA(isbn, authorSummaryDto)

        every {
            bookService.createUpdate(isbn, any())
        } answers {
            Pair(savedBook, isCreated)
        }

        mockMvc.put("/v1/books/${isbn}"){
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(bookSummaryDto)
        }.andExpect {
            status { statusCodeAssertion()}
        }
    }


    @Test
    fun `test that createFullUpdateBook returns HTTP 500 when author in the database does not have an ID`(){
        val isbn = "978-089-230342-0777"
        val author = testAuthorEntityA(id=1)
        val savedBook = testBookEntityA(isbn, author)

        val authorSummaryDto = testBookSummaryDtoA(id=1)
        val bookSummaryDto = testBookSummaryDtoA(isbn, authorSummaryDto)

        every {
            bookService.createUpdate(isbn, any())
        } answers {
            Pair(savedBook, true)
        }

        mockMvc.put("/v1/books/${isbn}"){
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(bookSummaryDto)
        }.andExpect {
            status { isInternalServerError()}
        }
    }

    @Test
    fun `test that createFullUpdateBook returns HTTP 400 when author does not exist`(){
        val isbn = "978-089-230342-0777"
        
        val authorSummaryDto = testBookSummaryDtoA(id=1)
        val bookSummaryDto = testBookSummaryDtoA(isbn, authorSummaryDto)

        every {
            bookService.createUpdate(isbn, any())
        } throws IllegalStateException()

        mockMvc.put("/v1/books/${isbn}"){
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(bookSummaryDto)
        }.andExpect {
            status { isBadRequest()}
        }
    }

    @Test
    fun `test that readManyBooks returns a list of books`(){
        val isbn = "978-089-230342-0777"
        
        every {
            bookService.list()
        } answers {
            listOf(testAuthorEntityA(isbn = isbn, testAuthorEntityA(id=1)))
        }
        
        mockMvc.get("/v1/books"){
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk()}
            content { jsonPath ( "$[0].isbn", equalTo(isbn))}
            content { jsonPath ( "$[0].title", equalTo(isbn))}
            content { jsonPath ( "$[0].image", equalTo("book-image.jpeg"))}
            content { jsonPath ( "$[0].author.id", equalTo(1))}
            content { jsonPath ( "$[0].author.name", equalTo("John Doe"))}
            content { jsonPath ( "$[0].author.image", equalTo("author-image.jpeg"))}
        }
    }
}