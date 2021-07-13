package com.arnabkundu.mvvmrecycler.util

import android.content.Context
import android.widget.Toast

object Helper {
    fun Context.toast(msg:String){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
    }
}