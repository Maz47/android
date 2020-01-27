package com.maz.org.myapplication.room.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.maz.org.myapplication.room.TodoDatabase
import com.maz.org.myapplication.room.entities.TodoTask
import com.maz.org.myapplication.room.repositories.TodoTaskRepository
import kotlinx.coroutines.launch

class TodoTaskViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: TodoTaskRepository

    val allTodoTasks: LiveData<List<TodoTask>>

    init {
        val todoTasksDao = TodoDatabase.getDatabase(application).todoTaskDao()
        repository = TodoTaskRepository(todoTasksDao)
        allTodoTasks = repository.allTodoTasks
    }

    fun create(todoTask: TodoTask) = viewModelScope.launch {
        repository.create(todoTask)
    }

    fun getData(id: Int) = viewModelScope.launch {
        repository.getData(id)
    }

    fun setData(todoTask: TodoTask) = viewModelScope.launch {
        repository.setData(todoTask)
    }

    fun delete(id: Int) = viewModelScope.launch {
        repository.delete(id)
    }

}