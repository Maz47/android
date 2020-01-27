package com.maz.org.myapplication.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class TodoTask(private val description: String, private val title: String) {

    @PrimaryKey(autoGenerate = true)
    private val id: Int = 0

}