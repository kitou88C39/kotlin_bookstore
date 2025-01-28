package com.devtiro.bookstore.services.impl

import com.devtiro.bookstore.repositories.AuthorRepository
import com.devtiro.bookstore.repositories.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException
import org.springframework.boot.test.context.Transactional
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annoatation.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@Transactional
class BookServiceImplTest @Autowired constructor(

    private val underTest: AuthorServiceImpl,
    private val bookRepository: BookRepository,
    private val authorRepository: AuthorRepository
){

    @Test
    fun `test that createUpdate throws IllegalStateException when Author does not exist`(){
        val authorSummary = AuthorSummary(id=999L)
        val bookRepository = testBookSummaryA(BOOK_A_ISBN, authorSummary)
        assertThrows<IllegalStateException> {
            underTest.createUpdate(BOOK_A_ISBN, bookRepository)
        }
    }

    @Test
    fun `test that createUpdate throws successfully creates book in the database`(){
        val saveDAuthor = authorRepository.save(testAuthorEntityA())
        assertThat(savedAuthor).isNotNull()

        val authorSummary = AuthorSummary(id=savedAuthor!!)
        val bookRepository = testBookSummaryA(BOOK_A_ISBN, authorSummary)
        val savedBook = underTest.createUpdate(BOOK_A_ISBN, bookRepository)
        assertThat(savedBook).isNotNull()

        val recalledBook = bookRepository.findByIdOrNull(BOOK_A_ISBN)
        assertThat(recalledBook).isNotNull()
        assertThat(recalledBook).isEqualTo(savedBook)
    }
}