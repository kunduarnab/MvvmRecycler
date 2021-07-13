package com.arnabkundu.mvvmrecycler.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arnabkundu.mvvmrecycler.R
import com.arnabkundu.mvvmrecycler.adapter.AdapterUser
import com.arnabkundu.mvvmrecycler.databinding.ActivityMainBinding
import com.arnabkundu.mvvmrecycler.model.Data
import com.arnabkundu.mvvmrecycler.util.Helper.toast
import com.arnabkundu.mvvmrecycler.util.ItemOnClick
import com.arnabkundu.mvvmrecycler.viewmodel.MyViewModel
import com.arnabkundu.mvvmrecycler.viewmodel.MyViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var viewModel:MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModel = ViewModelProvider(this,MyViewModelFactory(this))
            .get(MyViewModel::class.java)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = AdapterUser(this,object: ItemOnClick {
            override fun onClick(data: Data) {
                toast(data.id.toString())
            }
        })
        binding.recyclerView.adapter = adapter

        viewModel.userList.observe(this, Observer {
            adapter.setItem(it!!)
        })

        viewModel.fetchData()


    }
}