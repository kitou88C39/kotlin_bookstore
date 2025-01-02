package com.devtiro.bookstore.domain

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class Author (
    @Id
    val id: Long?, val name: String, val age: Int, val description: String, val image: String)