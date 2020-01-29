package com.maz.org.todoapplication.ui

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.maz.org.todoapplication.R
import com.maz.org.todoapplication.room.TodoTask
import kotlinx.android.synthetic.main.todo_task_layout.view.*

class TodoTaskListAdapter internal constructor(context: Context, var onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<TodoTaskListAdapter.TodoTaskViewHolder>(){

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var todoTasks = emptyList<TodoTask>()


    class TodoTaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val titleView : TextView = itemView.findViewById(R.id.title)
        private val completedIcon : ImageView = itemView.findViewById(R.id.completed_icon)
        //private val descriptionView : TextView = itemView.findViewById(R.id.description)
        //private val deleteBtn : Button = itemView.findViewById(R.id.delete_btn)
        //private val completeBtn : Button = itemView.findViewById(R.id.complete_btn)

        fun bind (todoTask: TodoTask, onItemClickListener: OnItemClickListener) {
            titleView.text = todoTask.title
            if (todoTask.completed) {
                completedIcon.setColorFilter(Color.GREEN)
                titleView.setTextColor(Color.GRAY)
            }
            if (!todoTask.completed) {
                completedIcon.setColorFilter(Color.RED)
                titleView.setTextColor(Color.WHITE)
            }
            itemView.setOnClickListener { onItemClickListener.onItemClicked(todoTask) }
            //descriptionView.text = todoTask.description
            //deleteBtn.setOnClickListener { onItemClickListener.onItemClicked(R.id.delete_btn, todoTask) }
            //completeBtn.setOnClickListener { onItemClickListener.onItemClicked(R.id.complete_btn, todoTask) }
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoTaskViewHolder {
        val itemView = inflater.inflate(R.layout.todo_task_layout, parent, false)
        return TodoTaskViewHolder(itemView)
    }

    override fun getItemCount(): Int = todoTasks.size

    override fun onBindViewHolder(holder: TodoTaskViewHolder, position: Int) {
        holder.bind(todoTasks[position], onItemClickListener)
    }

    internal fun setTodoTasks(todoTasks: List<TodoTask>) {
        this.todoTasks = todoTasks
        notifyDataSetChanged()
    }

}