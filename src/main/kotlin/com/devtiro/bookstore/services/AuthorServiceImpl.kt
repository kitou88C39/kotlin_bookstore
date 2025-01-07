package com.devtiro.bookstore.services

import com.devtiro.bookstore.domain.entities.AuthorEntity

interface AuthorServiceImpl{

    fun save(AuthorEntity: AuthorEntity): AuthorEntity
}