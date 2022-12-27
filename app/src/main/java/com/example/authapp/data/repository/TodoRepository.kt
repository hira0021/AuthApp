package com.example.authapp.data.repository

import android.util.Log
import com.example.authapp.data.local.dao.TodoDao
import com.example.authapp.data.local.entity.TodoChaceMapper
import com.example.authapp.data.remote.Api.TodoApi
import com.example.authapp.data.remote.entity.TodoNetworkMapper
import com.example.authapp.domain.entity.Todo
import com.example.authapp.domain.repository.ITodoRepository
import com.example.authapp.util.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TodoRepository @Inject constructor(
    private val todoDao: TodoDao,
    private val todoRetrofit: TodoApi,
    private val todoCacheMapper: TodoChaceMapper,
    private val todoNetworkMapper: TodoNetworkMapper
): ITodoRepository {
    override suspend fun getAllTodo(): Flow<DataState<List<Todo>>> = flow {
        emit(DataState.Loading)
        delay(1000L)
        try {
            val networkTodos = todoRetrofit.getTodos()
            val todos = todoNetworkMapper.mapFromEntityList(networkTodos)
            for (todo in todos) {
                todoDao.insertTodo(todoCacheMapper.mapToEntity(todo))
            }

            // TODO :: room engga diakses jika network request gagal, jadi sekarang gimana caranya agar
            // room diakses walaupun network request gagal
            val cachedTodo = todoDao.getTodos()
            emit(DataState.Success(todoCacheMapper.mapFromEntityList(cachedTodo)))
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }
}