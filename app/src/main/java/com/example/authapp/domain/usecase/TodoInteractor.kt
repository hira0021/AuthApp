package com.example.authapp.domain.usecase

import com.example.authapp.data.local.TodoDatabase
import com.example.authapp.domain.repository.ITodoRepository
import javax.inject.Inject

class TodoInteractor @Inject constructor(
    private val todoRepository: ITodoRepository
): TodoUseCase {
    override suspend fun getTodos() = todoRepository.getAllTodo()
}