package com.maz.org.myapplication

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.animation.Animation
import android.widget.Toast
import com.maz.org.myapplication.utilities.ViewAnimator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var isRotated = false
    var rotation = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ViewAnimator().init(my_second_fab)
        ViewAnimator().init(my_third_fab)

        my_fab.setOnClickListener {v ->
            if (isRotated) rotation = 0f
            if (!isRotated) rotation = 135f
            isRotated = !isRotated
            ViewAnimator().rotateFab(v, rotation)
            if (isRotated) {
                ViewAnimator().showAdditionalFabs(my_second_fab)
                ViewAnimator().showAdditionalFabs(my_third_fab)
            }
            if (!isRotated) {
                ViewAnimator().hideAdditionalFabs(my_second_fab)
                ViewAnimator().hideAdditionalFabs(my_third_fab)
            }
        }

        my_second_fab.setOnClickListener { Toast.makeText(this, "Event", Toast.LENGTH_LONG).show() }
        my_third_fab.setOnClickListener { Toast.makeText(this, "Song", Toast.LENGTH_LONG).show() }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

}
