package com.maz.org.todoapplication.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class TodoTask(val title: String, val description: String) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}