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
        val savedAuthor = authorRepository.save(testAuthorEntityA())
        assertThat(savedAuthor).isNotNull()

        val authorSummary = AuthorSummary(id=savedAuthor!!)
        val bookRepository = testBookSummaryA(BOOK_A_ISBN, authorSummary)
        val (savedBook, isCreated) = underTest.createUpdate(BOOK_A_ISBN, bookRepository)
        assertThat(savedBook).isNotNull()

        val recalledBook = bookRepository.findByIdOrNull(BOOK_A_ISBN)
        assertThat(recalledBook).isNotNull()
        assertThat(recalledBook).isEqualTo(savedBook)
        assertThat(isCreated).isTrue()
    }

    @Test
    fun `test that createUpdate throws successfully update book in the database`(){
        val savedAuthor = authorRepository.save(testAuthorEntityA())
        assertThat(savedAuthor).isNotNull()

        val savedBook = bookRepository.save(testAuthorEntityA(BOOK_A_ISBN, saveAuthor))
        assertThat(savedBook).isNotNull()

        val authorSummary = AuthorSummary(id=savedAuthor!!)
        val bookRepository = testBookSummaryA(BOOK_A_ISBN, authorSummary)
        val (ipdateBook, isCreated) = underTest.createUpdate(BOOK_A_ISBN, bookRepository)
        assertThat(savedBook).isNotNull()

        val recalledBook = bookRepository.findByIdOrNull(BOOK_A_ISBN)
        assertThat(recalledBook).isNotNull()
        assertThat(isCreated).isFalse()
    }

    @Test
    fun `test that list returns an empty list when no book in the database`(){
        val result = underTest.list()
        assertThat(result).isEmpty()
    }

    @Test
    fun `test that list returns books list when no book in the database`(){
        val savedAuthor = authorRepository.save(testAuthorEntityA())
        assertThat(savedAuthor).isNotNull()

        val savedBook = bookRepository.save(testAuthorEntityA(BOOK_A_ISBN, savedAuthor))
        assertThat(savedBook).isNotNull()

        val result = underTest.list()
        assertThat(result).hasSize(1)
        assertThat(result.get[0]).isEqualTo(savedAuthor)
    }

    @Test
    fun `test that list returns no books when the author ID does not match`(){
        val savedAuthor = authorRepository.save(testAuthorEntityA())
        assertThat(savedAuthor).isNotNull()

        val savedBook = bookRepository.save(testAuthorEntityA(BOOK_A_ISBN, savedAuthor))
        assertThat(savedBook).isNotNull()

        underTest.list(authorId = savedAuthor.id!! + 1)
    }
}