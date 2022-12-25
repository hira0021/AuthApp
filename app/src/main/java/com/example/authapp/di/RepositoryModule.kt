package com.example.authapp.di

import com.example.authapp.data.remote.TodoApi
import com.example.authapp.data.repository.TodoRepository
import com.example.authapp.domain.repository.ITodoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideTodoRepository(
        retrofit: TodoApi
    ): ITodoRepository{
        return TodoRepository(retrofit)
    }

}