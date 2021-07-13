package com.arnabkundu.mvvmrecycler.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arnabkundu.mvvmrecycler.api.ApiCalls
import com.arnabkundu.mvvmrecycler.api.ApiInstance
import com.arnabkundu.mvvmrecycler.model.Data
import com.arnabkundu.mvvmrecycler.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyViewModel(c:Context) : ViewModel() {
    private var userMutableList = MutableLiveData<ArrayList<Data>?>()
    val userList : LiveData<ArrayList<Data>?>
        get() = userMutableList

    fun fetchData(){
        val apiInstance = ApiInstance.instance?.create(ApiCalls::class.java)
        val call: Call<User>? = apiInstance?.getUser("1")
        call?.enqueue(object:Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if(response.isSuccessful){
                    val item: User? = response.body()
                    userMutableList.postValue(item?.data as ArrayList<Data>?)
                }else{
                    userMutableList.postValue(null)
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                userMutableList.postValue(null)
            }

        })
    }

}