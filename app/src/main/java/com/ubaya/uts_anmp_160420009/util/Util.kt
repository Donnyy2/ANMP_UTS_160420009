package com.ubaya.uts_anmp_160420009.util

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.ubaya.uts_anmp_160420009.R
import java.lang.Exception

fun ImageView.loadImage(url:String, progressBar:ProgressBar) {
    Picasso.get()
        .load(url)
        .resize(400,400)
        .centerCrop()
        .error(R.drawable.baseline_error_24)
        .into(this, object: Callback {
            override fun onSuccess() {
                progressBar.visibility = View.GONE
            }

            override fun onError(e: Exception?) {

            }

        })

}