package com.devtiro.bookstore.repositories

import org.springframework.data.jpa.repositories.JpaRepository

@Repository
interface AuthorRepository : JpaRepository<Author, Long?>{

}