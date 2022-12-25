package com.example.authapp.di

import com.example.authapp.data.repository.TodoRepository
import com.example.authapp.domain.usecase.TodoInteractor
import com.example.authapp.domain.usecase.TodoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideTodoUseCase(todoRepository: TodoRepository): TodoUseCase {
        return TodoInteractor(todoRepository)
    }

}