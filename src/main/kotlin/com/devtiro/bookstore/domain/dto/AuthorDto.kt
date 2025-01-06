package com.devtiro.bookstore.domain.dto

data class AuthorDto(
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
    val image: String)
