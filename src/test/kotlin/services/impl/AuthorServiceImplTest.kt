package com.devtiro.bookstore.services.impl

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annoatation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class AuthorServiceImplTest @Autowired constructor(private underTest: AuthorServiceImpl){
    @Test
    fun `test that save persists the Author in the database`(){
        underTest.save()
    }
}