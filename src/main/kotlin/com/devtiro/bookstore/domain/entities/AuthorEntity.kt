package com.devtiro.bookstore.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name="author")
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_id_seq")
data class Author (
    @Id
    @Column(name="id")
    val id: Long?,

    @Column(name="name")
    val name: String,

    @Column(name="age")
    val age: Int,

    @Column(name="description")
    val description: String,

    @Column(name="image")
    val image: String,

    @ManyToOne(cascade = [CascadeType.DETACH])
    @JoinColumn(name="author_id")
    val authorEntity: AuthorEntity
)
