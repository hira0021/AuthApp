package com.example.authapp.domain.usecase

import com.example.authapp.domain.Entity.Todo
import com.example.authapp.util.DataState
import kotlinx.coroutines.flow.Flow

interface TodoUseCase {
    suspend fun getTodos(): Flow<DataState<List<Todo>>>
}