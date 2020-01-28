package com.maz.org.todoapplication.ui

import com.maz.org.todoapplication.room.TodoTask

interface OnItemClickListener {

    fun onItemClicked(todoTask: TodoTask)

}
