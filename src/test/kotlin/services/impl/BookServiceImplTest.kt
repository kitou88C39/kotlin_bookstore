package com.devtiro.bookstore.services.impl


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
}