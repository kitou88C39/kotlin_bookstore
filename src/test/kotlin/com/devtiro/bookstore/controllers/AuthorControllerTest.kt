package com.devtiro.bookstore.controllers

import org.springframework.boot.AutoConfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@AutoConfigureMockMvc
class AuthorControllerTest @Autowired constructor(val mockMvc: MockMvc){

    @Test
    fun `test that create Author returns a HTTP 201 status on a successful create`(){
        a
    }

}