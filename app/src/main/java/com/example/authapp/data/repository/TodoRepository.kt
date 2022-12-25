package com.example.authapp.data.repository

import com.example.authapp.data.remote.TodoApi
import com.example.authapp.domain.Entity.Todo
import com.example.authapp.domain.repository.ITodoRepository
import com.example.authapp.util.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TodoRepository @Inject constructor(
    private val todoRetrofit: TodoApi
): ITodoRepository {
    override suspend fun getAllTodo(): Flow<DataState<List<Todo>>> = flow {
        emit(DataState.Loading)
        delay(1000L)
        try {
            val networkTodos = todoRetrofit.getTodos()
            emit(DataState.Success(networkTodos))
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }
}