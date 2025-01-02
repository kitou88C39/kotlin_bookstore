package com.devtiro.bookstore.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name="books")
data class Book (
    @Id
    @Column(name="isbn")
    var isbn: String,

    @Column(name="title")
    var title: String,

    @Column(name="description")
    var description: String,

    @Column(name="image")
    var image: String,

    @ManyToOne(cascade=[CascadeType.DETACH])
    @JoinColumn(name="author_id")
    var author: Author
    )