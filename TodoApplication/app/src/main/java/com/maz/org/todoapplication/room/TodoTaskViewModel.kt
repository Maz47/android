package com.maz.org.todoapplication.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TodoTaskViewModel(application: Application) : AndroidViewModel(application) {

    private val repository : TodoTaskRepository
    val allTodTasks : LiveData<List<TodoTask>>

    init {
        val todoTaskDAO = TodoDatabase.getDatabase(application, viewModelScope).todoTaskDAO()
        repository = TodoTaskRepository(todoTaskDAO)
        allTodTasks = repository.allTodoTasks
    }

    fun create(todoTask: TodoTask) = viewModelScope.launch {
        repository.create(todoTask)
    }
}