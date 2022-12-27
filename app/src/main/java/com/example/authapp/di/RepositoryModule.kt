package com.example.authapp.di

import com.example.authapp.data.local.dao.TodoDao
import com.example.authapp.data.local.entity.TodoChaceMapper
import com.example.authapp.data.remote.Api.TodoApi
import com.example.authapp.data.remote.entity.TodoNetworkMapper
import com.example.authapp.data.repository.TodoRepository
import com.example.authapp.domain.repository.ITodoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideTodoRepository(
        todoDao: TodoDao,
        retrofit: TodoApi,
        todoChaceMapper: TodoChaceMapper,
        todoNetworkMapper: TodoNetworkMapper
    ): ITodoRepository{
        return TodoRepository(todoDao, retrofit, todoChaceMapper, todoNetworkMapper)
    }

}