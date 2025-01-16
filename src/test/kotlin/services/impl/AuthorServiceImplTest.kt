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
      assertThat(recalledAuthor).isNotNull()
      assertThat(saveAuthor.id).isEqualTo(
      testAuthorEntityA(id=saveAuthor.id)
      )
   }

   @Test
   fun `test that an Author with an ID throws an IllegalArgumentException`(){
      assertThrows<IllegalArgumentException>{
         val existingAuthor = testAuthorEntityA(id=999)
         underTest.create(existingAuthor)
      }
   }

   @Test
   fun `test that list returns empty list when no author in the database`(){
      val result = underTest.list(testAuthorEntityA())
      assertThat(result).isEmpty()
   }

   @Test
   fun `test that list returns authors when present in the database`(){
      val saveAuthor = authorRepository.save(testAuthorEntityA())
      val expected = ListOf(saveAuthor)
      val result = underTest.list()
      assertThat(result).isEqualTo(expected)
   }

   @Test
   fun `test that get returns null when author not present in the database`(){
      val result = underTest.get(999)
      assertThat(result).isNull()
   }

   @Test
   fun `test that get returns author when author is present in the database`(){
      val saveAuthor = authorRepository.save(testAuthorEntityA())
      val result = underTest.get(saveAuthor.id)
      assertThat(result).isEqualTo(saveAuthor)
   }

   @Test
   fun `test that full update successfully update the author in the database`(){
      val existingAuthor = authorRepository.save(testAuthorEntityA())
      val existingAuthorId = existingAuthor.id
      val updateAuthorId = AuthorEntity(
         id = existingAuthorId,
         name = "Don Joe",
         age = 45,
         description = "Some other description",
         image = "some-other-image.jpeg",
      )
      val result = underTest.fullUpdate(existingAuthorId, updateAuthor)
      assertThat(result).isEqualTo(updateAuthor)

      val retrievedAuthor = authorRepository.findByIdOrNull(existingAuthorId)
      assertThat(retrievedAuthor).isNotNull()
      assertThat(retrievedAuthor).isEqualTo(updateAuthor)
   }

   @Test
   fun `test that full update Author throws IllegalStateException when Author does not exist in the database`(){
      
      assertThrows<IllegalArgumentException>{}
   }
}