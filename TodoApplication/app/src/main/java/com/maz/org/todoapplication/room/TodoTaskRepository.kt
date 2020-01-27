package com.maz.org.todoapplication.room

import androidx.lifecycle.LiveData

class TodoTaskRepository(private val todoTaskDAO: TodoTaskDAO) {

    val allTodoTasks: LiveData<List<TodoTask>> = todoTaskDAO.getAllTodoTasks()

    suspend fun create(todoTask: TodoTask) = todoTaskDAO.create(todoTask)

}