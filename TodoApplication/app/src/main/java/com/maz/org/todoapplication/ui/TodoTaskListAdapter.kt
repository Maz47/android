package com.maz.org.todoapplication.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.maz.org.todoapplication.R
import com.maz.org.todoapplication.room.TodoTask

class TodoTaskListAdapter internal constructor(context: Context) : RecyclerView.Adapter<TodoTaskListAdapter.TodoTaskViewHolder>(){

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private val todoTasks = emptyList<TodoTask>()

    class TodoTaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val titleView : TextView = itemView.findViewById(R.id.title)
        private val descriptionView : TextView = itemView.findViewById(R.id.description)

        fun bind (todoTask: TodoTask) {
            titleView.text = todoTask.title
            descriptionView.text = todoTask.description
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoTaskViewHolder {
        val itemView = inflater.inflate(R.layout.todo_task_layout, parent, false)
        return TodoTaskViewHolder(itemView)
    }

    override fun getItemCount(): Int = todoTasks.size

    override fun onBindViewHolder(holder: TodoTaskViewHolder, position: Int) {
        holder.bind(todoTasks[position])
    }
}