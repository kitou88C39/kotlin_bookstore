package com.devtiro.bookstore.services

import com.devtiro.bookstore.domain.entities.AuthorEntity

interface AuthorService {

    fun save(AuthorEntity: AuthorEntity): AuthorEntity

    fun list(): List<AuthorEntity>

    fun list(id: Long): AuthorEntity?

    fun fullUpdate(id: Long, authorEntity: AuthorEntity): AuthorEntity

    fun fullUpdate(id: Long, authorEntity: AuthorEntity): AuthorEntity
}
