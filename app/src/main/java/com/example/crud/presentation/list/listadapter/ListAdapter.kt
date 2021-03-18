package com.example.crud.presentation.list.listadapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.crud.R
import com.example.crud.database.entity.UserEntity


class ListAdapter : RecyclerView.Adapter<ListViewHolder>() {

    private var userList = mutableListOf<UserEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(userList[position])
    }


    fun setData(user: List<UserEntity>) {
        Log.d("ListAdapter", "users = $user")
        userList.addAll(user)
        notifyDataSetChanged()
    }

}