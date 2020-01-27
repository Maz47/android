package com.maz.org.myapplication.gui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.maz.org.myapplication.R
import com.maz.org.myapplication.room.entities.TodoTask
import kotlinx.android.synthetic.main.todo_task_item.view.*

class TodoTaskListAdapter internal constructor(context: Context) : RecyclerView.Adapter<TodoTaskListAdapter.TodoTaskViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var todoTasks = emptyList<TodoTask>()

    class TodoTaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private val titleView = itemView.findViewById<TextView>(R.id.title)

        fun bind (task: TodoTask) {
            titleView.text = task.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoTaskViewHolder {
        val itemView = inflater.inflate(R.layout.todo_task_item, parent, false)
        return TodoTaskViewHolder(itemView)
    }

    override fun getItemCount(): Int = todoTasks.size

    override fun onBindViewHolder(holder: TodoTaskViewHolder, position: Int) {
        holder.bind(todoTasks[position])
    }

    internal fun setTodoTasks(todoTasks: List<TodoTask>) {
        this.todoTasks = todoTasks
    }
}