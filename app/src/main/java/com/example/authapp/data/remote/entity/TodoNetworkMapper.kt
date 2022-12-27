package com.example.authapp.data.remote.entity

import com.example.authapp.domain.entity.Todo
import com.example.authapp.util.EntityMapper
import javax.inject.Inject

class TodoNetworkMapper @Inject constructor() : EntityMapper<TodoNetworkEntity, Todo> {
    override fun mapFromEntity(entity: TodoNetworkEntity): Todo {
        return Todo(
            completed = entity.completed,
            id = entity.id,
            title = entity.title,
            userId = entity.userId
        )
    }

    override fun mapToEntity(domainModel: Todo): TodoNetworkEntity {
        return TodoNetworkEntity(
            completed = domainModel.completed,
            id = domainModel.id,
            title = domainModel.title,
            userId = domainModel.userId
        )
    }

    fun mapFromEntityList(entities: List<TodoNetworkEntity>): List<Todo> {
        return entities.map { mapFromEntity(it) }
    }
}