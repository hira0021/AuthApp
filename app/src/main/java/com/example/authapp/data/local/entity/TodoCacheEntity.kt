package com.example.authapp.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_table")
data class TodoCacheEntity(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "todo_id")
    val id: Int,

    @ColumnInfo(name = "todo_completed")
    val completed: Boolean,

    @ColumnInfo(name = "todo_title")
    val title: String,

    @ColumnInfo(name = "todo_user_id")
    val userId: Int

)
