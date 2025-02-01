package com.devtiro.bookstore.repositories

import com.devtiro.bookstore.domain.BookEntity
import org.springframework.data.jpa.repositories.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : JpaRepository<Book, Long?> {

    fun findByAuthorEntityId(id: Long): List<BookEntity>
}