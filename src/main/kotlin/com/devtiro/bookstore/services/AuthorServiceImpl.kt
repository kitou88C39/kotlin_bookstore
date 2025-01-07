package com.devtiro.bookstore.services.impl

import com.devtiro.bookstore.services.AuthorService
import com.devtiro.bookstore.repositories.authorRepository
import com.devtiro.bookstore.services.AuthorService

class AuthorServiceImpl (val authorRepository: AuthorService){

   override fun save(AuthorEntity: AuthorEntity): AuthorEntity{
    TODO ("Not get implemented")
   }
}