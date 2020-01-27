package com.maz.org.myapplication.room

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.maz.org.myapplication.room.daos.TodoTaskDAO

public abstract class TodoDatabase : RoomDatabase() {

    abstract fun todoTaskDao() : TodoTaskDAO

    companion object {
        @Volatile
        private var INSTANCE : TodoDatabase? = null

        fun getDatabase(context: Context) : TodoDatabase {
            val tmpInstance = INSTANCE
            if (tmpInstance != null) return tmpInstance
            synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext, TodoDatabase::class.java, "todo_database").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}