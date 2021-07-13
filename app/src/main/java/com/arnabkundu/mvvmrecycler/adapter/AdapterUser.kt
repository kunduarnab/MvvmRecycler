package com.arnabkundu.mvvmrecycler.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arnabkundu.mvvmrecycler.databinding.ItemRowBinding
import com.arnabkundu.mvvmrecycler.model.Data
import com.arnabkundu.mvvmrecycler.model.User
import com.arnabkundu.mvvmrecycler.util.ItemOnClick

class AdapterUser(val c: Context,val listener:ItemOnClick)
    : RecyclerView.Adapter<AdapterUser.UserHolder>() {
    private val list:ArrayList<Data> = ArrayList<Data>()
    class UserHolder(private val binding: ItemRowBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(item:Data){
            binding.user = item
        }
    }

    fun setItem(ls:ArrayList<Data>){
        list.clear()
        list.addAll(ls)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRowBinding.inflate(inflater)
        return UserHolder(binding)
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            listener.onClick(item)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}