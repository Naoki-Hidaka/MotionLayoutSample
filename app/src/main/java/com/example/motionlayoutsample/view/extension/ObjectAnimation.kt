package com.example.motionlayoutsample.view.extension

import android.view.View
import android.view.animation.AnimationUtils
import android.view.animation.TranslateAnimation
import androidx.databinding.BindingAdapter
import com.example.motionlayoutsample.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

@BindingAdapter("delayAnimation")
fun View.animation(delay: Long) {
    visibility = View.INVISIBLE
    val slideInAnimation = TranslateAnimation(0F, 0F, 1000F, 0F)
    slideInAnimation.let {
        it.duration = 100
        it.fillAfter = true
    }

    postDelayed({
        startAnimation(slideInAnimation)
        visibility = View.VISIBLE
    }, delay)
}

@BindingAdapter("slideIn")
fun View.slideIn(delay: Long) {
    visibility = View.GONE
    val slideInAnimation = TranslateAnimation(1000F, 0F, 0F, 0F)
    slideInAnimation.let {
        it.duration = 300
        it.fillAfter = true
    }

    postDelayed({
        startAnimation(slideInAnimation)
        visibility = View.VISIBLE
    }, delay)
}

fun View.popUpButton(delay: Long) {
    val animator = AnimationUtils.loadAnimation(context, R.anim.popup_button)
    postDelayed({
        startAnimation(animator)
        visibility = View.VISIBLE
    }, delay)
}

fun View.shrinkingButton() {
    visibility = View.INVISIBLE
    val animator = AnimationUtils.loadAnimation(context, R.anim.shrinking_button)
    startAnimation(animator)
}
