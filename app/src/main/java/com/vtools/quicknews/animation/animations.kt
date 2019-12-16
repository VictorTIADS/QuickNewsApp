package com.vtools.quicknews.animation

import android.view.View
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo

fun View.FadeIn(){
    this.visibility = View.VISIBLE
    YoYo.with(Techniques.FadeIn).duration(1000).playOn(this)
}
fun View.FadeOut(){
    this.visibility = View.GONE
    YoYo.with(Techniques.FadeOut).duration(500).playOn(this)
}
fun View.HideToUp(){
    YoYo.with(Techniques.SlideOutUp).onEnd {

    }.duration(500).playOn(this)
}
fun View.ShowFromUpToDown(){
    YoYo.with(Techniques.SlideInDown).duration(500).playOn(this)
}
