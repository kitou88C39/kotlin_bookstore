package com.devtiro.bookstore.domain

import jakarta.persistence.*

@Entity
@Table(name="author")
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_id_seq")
data class AuthorEntity (

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

    @ManyToOne(mappedBy = "authorEntity", cascade=[CascadeType.REMOVE])
    val BookEntities: List<BookEntity> = emptyList(),
)
