package com.example.authapp.domain.repository

import com.example.authapp.domain.Entity.Todo
import com.example.authapp.util.DataState
import kotlinx.coroutines.flow.Flow

interface ITodoRepository {

    suspend fun getAllTodo(): Flow<DataState<List<Todo>>>

}