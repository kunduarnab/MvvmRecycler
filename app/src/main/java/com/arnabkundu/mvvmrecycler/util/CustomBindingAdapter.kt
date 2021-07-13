package com.arnabkundu.mvvmrecycler.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("loadUrl")
fun ImageView.loadUrl(url:String){
    Picasso.get().load(url).into(this)
}

