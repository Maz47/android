package com.maz.org.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.maz.org.myapplication.gui.TodoTaskListAdapter
import com.maz.org.myapplication.room.viewmodels.TodoTaskViewModel
import com.maz.org.myapplication.utilities.ViewAnimator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var todoTaskViewModel: TodoTaskViewModel

    private var isRotated = false
    private var rotation = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "My Application"

        val adapter = TodoTaskListAdapter(this)
        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(this)

        todoTaskViewModel = ViewModelProvider(this).get(TodoTaskViewModel::class.java)
        todoTaskViewModel.allTodoTasks.observe(this, Observer { todoTasks ->
            todoTasks.let { adapter }
        })

        ViewAnimator().init(my_second_fab)
        ViewAnimator().init(my_third_fab)

        my_fab.setOnClickListener {
            if (isRotated) rotation = 0f
            if (!isRotated) rotation = 135f
            isRotated = !isRotated
            ViewAnimator().rotateFab(my_fab, rotation)
            if (isRotated) {
                ViewAnimator().showAdditionalFabs(my_second_fab)
                ViewAnimator().showAdditionalFabs(my_third_fab)
            }
            if (!isRotated) {
                ViewAnimator().hideAdditionalFabs(my_second_fab)
                ViewAnimator().hideAdditionalFabs(my_third_fab)
            }
        }

        my_second_fab.setOnClickListener {view ->
            ViewAnimator().rotateFab(my_fab, 0f)
            ViewAnimator().hideAdditionalFabs(my_second_fab)
            ViewAnimator().hideAdditionalFabs(my_third_fab)
            isRotated = false
            var intent = Intent(this, NewTodoActivity::class.java)
            startActivity(intent)
        }

        my_third_fab.setOnClickListener {
            Toast.makeText(this, "Song", Toast.LENGTH_LONG).show()
            ViewAnimator().rotateFab(my_fab, 0f)
            ViewAnimator().hideAdditionalFabs(my_second_fab)
            ViewAnimator().hideAdditionalFabs(my_third_fab)
            isRotated = false
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

}
