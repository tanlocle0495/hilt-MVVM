package com.loc.lt.android.mvvm.utils.extension

import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide

private fun ImageView.progressbar() = CircularProgressDrawable(context).apply {
    strokeWidth = 5f
    centerRadius = 30f
    start()
}

fun ImageView.networkImage(url: String) {
    Glide.with(this.context).load(url).placeholder(progressbar()).into(this)
}

fun ImageView.netWorkCircleImage(url: String) {
    Glide.with(this.context).load(url).placeholder(progressbar()).circleCrop().into(this)
}