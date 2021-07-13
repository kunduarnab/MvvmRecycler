package com.arnabkundu.mvvmrecycler.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiInstance {
    private var retrofit: Retrofit? = null
    val instance:Retrofit?
        get() {
            if(retrofit==null){
                retrofit = Retrofit.Builder()
                    .baseUrl("https://reqres.in/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
}