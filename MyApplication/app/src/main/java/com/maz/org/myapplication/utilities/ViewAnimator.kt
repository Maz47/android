package com.maz.org.myapplication.utilities

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.view.View


class ViewAnimator {

    fun init(v: View) {
        v.visibility = View.GONE
        v.translationY = v.width.toFloat()
        v.alpha = 0f
    }

    fun rotateFab(v: View, rotation: Float) {
        v.animate().setDuration(150).setListener(object: AnimatorListenerAdapter() {}).rotation(rotation)
    }

    fun showAdditionalFabs(v: View) {
        v.visibility = View.VISIBLE
        v.alpha = 0f
        v.translationX = v.width.toFloat()
        v.animate().setDuration(150).translationX(0f).setListener(object : AnimatorListenerAdapter() {}).alpha(1f).start()
    }

    fun hideAdditionalFabs(v: View) {
        v.visibility = View.VISIBLE
        v.alpha = 1f
        v.translationX = 0f
        v.animate().setDuration(150).translationX(v.width.toFloat()).setListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
                v.visibility = View.GONE
                super.onAnimationEnd(animation)
            }
        }).alpha(0f).start()
    }

}