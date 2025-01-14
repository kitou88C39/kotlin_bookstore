package com.devtiro.bookstore.services.impl

import com.devtiro.bookstore.services.AuthorService
import com.devtiro.bookstore.repositories.authorRepository
import com.devtiro.bookstore.services.AuthorService
import org.springframework.stereotype.Service

@Service
class AuthorServiceImpl (private val authorRepository: authorRepository): AuthorService {

   override fun save(AuthorEntity: AuthorEntity): AuthorEntity {
      require(null == AuthorEntity.id)
      return authorRepository.save(AuthorEntity)
   }

   override fun list(): List<AuthorEntity> {
      return authorRepository.findAll()
   }

   override fun get(id: Long): AuthorEntity? {
      return authorRepository.findByIdOrNull(id)
   }

   override fun get(id: Long, authorEntity: AuthorEntity): AuthorEntity {
      check(authorRepository.existsById(id))
      val normalisedAuthor = authorEntity.copy(id=id)
   }

}