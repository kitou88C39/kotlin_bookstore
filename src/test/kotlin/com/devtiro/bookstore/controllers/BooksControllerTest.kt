package com.devtiro.bookstore.controllers

class BooksControllerTest @Autowired constructor(
    private val mockMvc: MockMvc,
    @MockBean val authorService: AuthorService
    ) {