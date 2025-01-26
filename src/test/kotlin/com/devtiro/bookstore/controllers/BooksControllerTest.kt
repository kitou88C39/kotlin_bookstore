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
        val author = testAuthorEntityA(id=1)
        val savedBook = testBookEntityA(isbn, author)

        val authorSummaryDto = testBookSummaryDtoA(id=1)
        val bookSummaryDto = testBookSummaryDtoA(isbn, authorSummaryDto)

        every {
            BookService.createUpdate(isbn, any())
        } answers {
            Pair(savedBook, true)
        }

        mockMvc.put("/v1/books/${isbn}"){
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(bookSummaryDto)
        }.andExpect {
            status { isCreated()}
        }
    }

    private fun assertThatUserCreatedUpdated(isCreated: Boolean, statusCodeAssertion: StatusResultMatchersDsl.() -> Unit) {
        val isbn = "978-089-230342-0777"
        val author = testAuthorEntityA(id=1)
        val savedBook = testBookEntityA(isbn, author)

        val authorSummaryDto = testBookSummaryDtoA(id=1)
        val bookSummaryDto = testBookSummaryDtoA(isbn, authorSummaryDto)

        every {
            BookService.createUpdate(isbn, any())
        } answers {
            Pair(savedBook, true)
        }

        mockMvc.put("/v1/books/${isbn}"){
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(bookSummaryDto)
        }.andExpect {
            status { isCreated()}
        }
    }

    @Test
    fun `test that createFullUpdateBook returns HTTP 500 when author in the database does not have an ID`(){
        
    }
}
