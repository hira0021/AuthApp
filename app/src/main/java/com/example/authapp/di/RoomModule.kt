package com.example.authapp.di

import android.content.Context
import androidx.room.Room
import com.example.authapp.data.local.TodoDatabase
import com.example.authapp.data.local.dao.TodoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideTodoDb(@ApplicationContext context: Context): TodoDatabase {
        return Room
            .databaseBuilder(
                context,
                TodoDatabase::class.java,
                TodoDatabase.DATABASE_NAME
            ).fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideDao(todoDatabase: TodoDatabase): TodoDao {
        return todoDatabase.todoDao()
    }
}