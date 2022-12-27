package com.example.authapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.authapp.data.local.dao.TodoDao
import com.example.authapp.data.local.entity.TodoCacheEntity

@Database(entities = [TodoCacheEntity::class], version = 1)
abstract class TodoDatabase :RoomDatabase() {

    abstract fun todoDao(): TodoDao

    companion object {
        val DATABASE_NAME: String = "todo_db"
    }

}