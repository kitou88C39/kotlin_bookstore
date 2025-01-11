package com.devtiro.bookstore.services.impl

import com.devtiro.bookstore.testAuthorEntityA
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annoatation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class AuthorServiceImplTest @Autowired constructor(
    private underTest: AuthorServiceImpl,
    private val authorRepository: authorRepository){

    @Test
    fun `test that save persists the Author in the database`(){
       val saveAuthor = underTest.save(testAuthorEntityA())
       assertThat(saveAuthor.id).isNotNull()

       val recalledAuthor = authorRepository.findById(saveAuthor.id)
    }
}