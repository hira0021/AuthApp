package com.example.authapp.domain.usecase

import com.example.authapp.data.repository.TodoRepository
import com.example.authapp.domain.Entity.Todo
import com.example.authapp.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TodoInteractor(private val todoRepository: TodoRepository): TodoUseCase {
    override suspend fun getTodos() = todoRepository.getAllTodo()
}