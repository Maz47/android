package com.maz.org.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.maz.org.myapplication.room.entities.TodoTask
import com.maz.org.myapplication.room.viewmodels.TodoTaskViewModel
import kotlinx.android.synthetic.main.activity_new_todo.*

class NewTodoActivity : AppCompatActivity() {

    private lateinit var todoTaskViewModel: TodoTaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_todo)

        title = "Add new Todo Task"

        todoTaskViewModel = ViewModelProviders.of(this).get(TodoTaskViewModel::class.java)

        cancel_btn.setOnClickListener {
            finish()
        }
        save_btn.setOnClickListener {view ->
            val title = title_input.toString()
            val description = description_input.toString()
            val task = TodoTask(title, description)
            todoTaskViewModel.create(task)
            finish()
        }
    }
}
