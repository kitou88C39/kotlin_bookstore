package com.devtiro.bookstore.domain

import jakarta.persistence.Entity

@Entity
data class Author (val id: Long?, val name: String, val age: Int, val description: String, val image: String)