package com.maz.org.todoapplication.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [TodoTask::class], version = 1, exportSchema = false)
abstract class TodoDatabase : RoomDatabase() {

    abstract fun todoTaskDAO() : TodoTaskDAO

    private class TodoTaskListDatabaseCallback(private val scope: CoroutineScope) : RoomDatabase.Callback() {
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let {database ->
                scope.launch {
                    var todoTaskDAO = database.todoTaskDAO()
                    var todoTask = TodoTask("My Test", "This is a Test-Task for demonstration!")
                    todoTaskDAO.create(todoTask)
                }
            }
        }
    }

    companion object {
        @Volatile
        private var INSTANCE : TodoDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope) : TodoDatabase {
            val tmpInstance = INSTANCE
            if (null != tmpInstance) return tmpInstance
            synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext, TodoDatabase::class.java, "todo_database").addCallback(TodoTaskListDatabaseCallback(scope)).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}