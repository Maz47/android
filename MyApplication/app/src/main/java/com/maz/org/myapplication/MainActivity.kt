package com.maz.org.myapplication

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.maz.org.myapplication.utilities.ViewAnimator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var isRotated = false
    private var rotation = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "My Application"

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

        my_second_fab.setOnClickListener {
            Toast.makeText(this, "Event", Toast.LENGTH_LONG).show()
            ViewAnimator().rotateFab(my_fab, 0f)
            ViewAnimator().hideAdditionalFabs(my_second_fab)
            ViewAnimator().hideAdditionalFabs(my_third_fab)
            isRotated = false
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menuOne -> {
                Toast.makeText(this, "Menu one selected!", Toast.LENGTH_LONG).show()
                true
            }
            R.id.menuTwo -> {
                Toast.makeText(this, "Menu two selected!", Toast.LENGTH_LONG).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
