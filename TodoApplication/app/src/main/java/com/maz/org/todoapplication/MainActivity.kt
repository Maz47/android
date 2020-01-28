package com.maz.org.todoapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.maz.org.todoapplication.room.TodoTask
import com.maz.org.todoapplication.room.TodoTaskViewModel
import com.maz.org.todoapplication.ui.TodoTaskListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var todoTaskViewModel: TodoTaskViewModel

    companion object {
        private const val REQUEST_NEW_TODO_TASK: Int = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = TodoTaskListAdapter(this)
        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(this)

        todoTaskViewModel = ViewModelProvider(this).get(TodoTaskViewModel::class.java)
        todoTaskViewModel.allTodTasks.observe(this, Observer {todoTasks ->
            todoTasks?.let { adapter.setTodoTasks(todoTasks) }
        })

        fab_add.setOnClickListener {
            val intent = Intent(this, NewTodoTaskActivity::class.java)
            startActivityForResult(intent, REQUEST_NEW_TODO_TASK)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_NEW_TODO_TASK && resultCode == Activity.RESULT_OK) {
            var title : String = ""
            var description : String = ""
            data?.getStringExtra(NewTodoTaskActivity.REPLY_EXTRA_TITLE)?.let { title = it }
            data?.getStringExtra(NewTodoTaskActivity.REPLY_EXTRA_DESCRIPTION)?.let { description = it }
            if (title.trim().isNotEmpty()) todoTaskViewModel.create(TodoTask(title, description))
        }
    }
}
