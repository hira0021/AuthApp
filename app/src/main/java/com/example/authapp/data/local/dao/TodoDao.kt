package com.example.authapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.authapp.data.local.entity.TodoCacheEntity

@Dao
interface TodoDao {

    @Query("SELECT * FROM todo_table")
    suspend fun getTodos(): List<TodoCacheEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(todoCacheEntity: TodoCacheEntity): Long

}