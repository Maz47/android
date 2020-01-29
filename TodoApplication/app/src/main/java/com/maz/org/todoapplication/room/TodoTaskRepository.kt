package com.maz.org.todoapplication.room

import androidx.lifecycle.LiveData

class TodoTaskRepository(private val todoTaskDAO: TodoTaskDAO) {

    val allTodoTasks: LiveData<List<TodoTask>> = todoTaskDAO.getAllTodoTasks()

    suspend fun create(todoTask: TodoTask) = todoTaskDAO.create(todoTask)

    suspend fun update(id: Int, title: String, description: String, completed: Boolean) = todoTaskDAO.update(id, title, description, completed)

    suspend fun delete(id: Int) = todoTaskDAO.delete(id)

}