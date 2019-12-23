package com.vtools.quicknews.animation

import android.view.View
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo

fun View.FadeIn() {
    this.visibility = View.VISIBLE
    YoYo.with(Techniques.FadeIn).duration(1000).playOn(this)
}

fun View.FadeOut() {
    this.visibility = View.GONE
    YoYo.with(Techniques.FadeOut).duration(500).playOn(this)
}

fun View.HideToLeft() {
    if (this.visibility != View.GONE) {
        YoYo.with(Techniques.SlideOutLeft).onEnd {
            this.visibility = View.GONE
        }.duration(500).playOn(this)

    }
}

fun View.ShowFromLeftToRight() {
    if (this.visibility != View.VISIBLE) {
        this.visibility = View.VISIBLE
        YoYo.with(Techniques.SlideInLeft).duration(500).playOn(this)
    }
}

fun View.PulseView() {
    YoYo.with(Techniques.Pulse).duration(400).playOn(this)
}
