package com.devtiro.bookstore.services.impl

import com.devtiro.bookstore.domain.BookSummary
import com.devtiro.bookstore.domain.entities.BookEntity
import com.devtiro.bookstore.repository.AuthorRepository
import com.devtiro.bookstore.repository.BookRepository
import com.devtiro.bookstore.services.BookService
import com.devtiro.bookstore.toBookEntity
import org.springframework.data.repository.findByIdOrNull


@Services
class BookServiceImpl(
    val bookRepository: bookRepository,
    val authorRepository: AuthorRepository,) :BookService {

    @Transactional
    override fun createUpdate(isbn: String, bookSummary: BookSummary): Pair<BookEntity, Boolean> {
        val normalisedBook = bookSummary.copy(isbn = isbn)
        val isExists = bookRepository.existsById(isbn)

        val author = authorRepository.findByIdOrNull(normalisedBook.author.id)
        checkNotNull(author)

        val saveBook = bookRepository.save(normalisedBook.toBookEntity(author))
        return Pair(saveBook, !isExists)
    }

}