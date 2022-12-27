package com.example.authapp.data.local.entity

import com.example.authapp.domain.entity.Todo
import com.example.authapp.util.EntityMapper
import javax.inject.Inject

class TodoChaceMapper @Inject constructor() : EntityMapper<TodoCacheEntity, Todo> {
    override fun mapFromEntity(entity: TodoCacheEntity): Todo {
        return Todo(
            completed = entity.completed,
            id = entity.id,
            title = entity.title,
            userId = entity.userId
        )
    }

    override fun mapToEntity(domainModel: Todo): TodoCacheEntity {
        return TodoCacheEntity(
            completed = domainModel.completed,
            id = domainModel.id,
            title = domainModel.title,
            userId = domainModel.userId
        )
    }

    fun mapFromEntityList(entities: List<TodoCacheEntity>): List<Todo> {
        return entities.map { mapFromEntity(it) }
    }
}