package com.maz.org.todoapplication.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class TodoTask(val title: String) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    var description: String = ""
    var completed: Boolean = false

}