package com.example.authapp.data.remote

import com.example.authapp.domain.Entity.Todo
import retrofit2.Response
import retrofit2.http.GET

interface TodoApi {

    @GET("/todos")
    suspend fun getTodos(): List<Todo>

}