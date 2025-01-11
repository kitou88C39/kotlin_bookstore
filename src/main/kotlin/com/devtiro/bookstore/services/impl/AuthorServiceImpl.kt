package com.devtiro.bookstore.services.impl

import com.devtiro.bookstore.services.AuthorService
import com.devtiro.bookstore.repositories.authorRepository
import com.devtiro.bookstore.services.AuthorService
import org.springframework.stereotype.Service




@Service
class AuthorServiceImpl (val authorRepository: AuthorService){

   override fun save(AuthorEntity: AuthorEntity): AuthorEntity{
    return authorRepository.save(AuthorEntity)
   }
}