package com.devtiro.bookstore.repositories

import com.devtiro.bookstore.domain.Author
import org.springframework.data.jpa.repositories.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : JpaRepository<Book, Long?>{

}