package com.maz.org.todoapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_new_todo_task.*

class NewTodoTaskActivity : AppCompatActivity() {

    companion object {
        const val REPLY_EXTRA_TITLE = "com.maz47.android.todo.task.title"
        const val REPLY_EXTRA_DESCRIPTION = "com.maz47.android.todo.task.description"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_todo_task)
        title = "Add new Todo"

        back_button.setOnClickListener { finish() }
        save_btn.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(title_input.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            }
            if (!TextUtils.isEmpty(title_input.text)) {
                val title = title_input.text.toString()
                val description = description_input.text.toString()
                replyIntent.putExtra(REPLY_EXTRA_TITLE, title)
                replyIntent.putExtra(REPLY_EXTRA_DESCRIPTION, description)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }

    }

}
