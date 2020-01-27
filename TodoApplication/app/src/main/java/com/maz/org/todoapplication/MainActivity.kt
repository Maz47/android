package com.maz.org.todoapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.maz.org.todoapplication.ui.TodoTaskListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview.adapter = TodoTaskListAdapter(this)
        recyclerview.layoutManager = LinearLayoutManager(this)

        fab_add.setOnClickListener {
            val intent = Intent(this, NewTodoTaskActivity::class.java)
            startActivity(intent)
        }
    }
}
