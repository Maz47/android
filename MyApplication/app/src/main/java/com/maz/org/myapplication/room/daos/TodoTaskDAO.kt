package com.maz.org.myapplication.room.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.maz.org.myapplication.room.entities.TodoTask

@Dao
interface TodoTaskDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun create(todoTask: TodoTask)

    @Query("SELECT * FROM TodoTask WHERE id = :id")
    fun read(id: Int) : LiveData<TodoTask>

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun update(todoTask: TodoTask)

    @Query("DELETE FROM TodoTask WHERE id = :id")
    suspend fun delete(id: Int)

    @Query("SELECT * FROM TodoTask ORDER BY id ASC")
    fun getAllTodoTasks(): LiveData<List<TodoTask>>

}