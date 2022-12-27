package com.example.authapp.data.remote.Api

import com.example.authapp.data.remote.entity.TodoNetworkEntity
import com.example.authapp.domain.entity.Todo
import retrofit2.http.GET

interface TodoApi {

    @GET("/todos")
    suspend fun getTodos(): List<TodoNetworkEntity>

}