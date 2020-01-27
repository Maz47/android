package com.maz.org.myapplication.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class TodoTask(val title: String, val description: String) {

    @PrimaryKey(autoGenerate = true)
    private val id: Int = 0

}