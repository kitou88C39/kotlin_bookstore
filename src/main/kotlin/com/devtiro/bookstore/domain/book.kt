package com.devtiro.bookstore.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

data class Book (var isbn: String, var title: String, var description: String, var image: String, var author: Author)