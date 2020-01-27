package com.maz.org.myapplication.room.repositories

import androidx.lifecycle.LiveData
import com.maz.org.myapplication.room.daos.TodoTaskDAO
import com.maz.org.myapplication.room.entities.TodoTask

class TodoTaskRepository(private val todoTaskDAO: TodoTaskDAO) {

    val allTodoTasks: LiveData<List<TodoTask>> = todoTaskDAO.getAllTodoTasks()

    suspend fun create(todoTask: TodoTask) = todoTaskDAO.create(todoTask)

    suspend fun setData(todoTask: TodoTask) = todoTaskDAO.update(todoTask)

    fun getData(id: Int) = todoTaskDAO.read(id)

    suspend fun delete(id: Int) = todoTaskDAO.delete(id)

}