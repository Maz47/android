package com.maz.org.todoapplication.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TodoTaskDAO {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun create(todoTask: TodoTask)

    @Query("SELECT * FROM TodoTask WHERE id = :id")
    fun read(id: Int) : LiveData<TodoTask>

    @Query("UPDATE TodoTask SET title = :title, description = :description, completed = :completed WHERE id = :id")
    suspend fun update(id: Int, title: String, description: String, completed: Boolean)

    @Query("DELETE FROM TodoTask WHERE id = :id")
    suspend fun delete(id: Int)

    @Query("SELECT * FROM TodoTask ORDER BY completed ASC, id ASC")
    fun getAllTodoTasks() : LiveData<List<TodoTask>>

}