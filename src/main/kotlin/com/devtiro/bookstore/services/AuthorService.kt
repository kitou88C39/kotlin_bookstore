package com.devtiro.bookstore.services

import com.devtiro.bookstore.domain.entities.AuthorEntity

interface AuthorService{

    fun save(AuthorEntity: AuthorEntity): AuthorEntity
}