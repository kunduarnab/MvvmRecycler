package com.arnabkundu.mvvmrecycler.api

import com.arnabkundu.mvvmrecycler.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiCalls {

    @GET("users")
    fun getUser(@Query("page") page:String):Call<User>
}