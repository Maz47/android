package com.maz.org.myapplication.room

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.maz.org.myapplication.room.daos.TodoTaskDAO
import com.maz.org.myapplication.room.entities.TodoTask
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

public abstract class TodoDatabase : RoomDatabase() {

    abstract fun todoTaskDao() : TodoTaskDAO

    companion object {
        @Volatile
        private var INSTANCE : TodoDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope) : TodoDatabase {
            val tmpInstance = INSTANCE
            if (tmpInstance != null) return tmpInstance
            synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext, TodoDatabase::class.java, "todo_database").addCallback(TodoDatabaseCallback(scope)).build()
                INSTANCE = instance
                return instance
            }
        }
    }

    private class TodoDatabaseCallback(private val scope: CoroutineScope) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.todoTaskDao())
                }
            }
        }

        suspend fun populateDatabase(todoTaskDAO: TodoTaskDAO) {
            var todoTask = TodoTask("Dummy", "This is a Dummy Task!")
            todoTaskDAO.create(todoTask)
        }
    }
}