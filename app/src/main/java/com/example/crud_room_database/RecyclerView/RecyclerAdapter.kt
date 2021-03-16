package com.example.crud_room_database.RecyclerView


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.crud_room_database.R
import com.example.crud_room_database.UserDatabase.UserEntity
import kotlinx.android.synthetic.main.list_item_template.view.*


class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.UserViewHolder>() {

    private var userList = emptyList<UserEntity>()

    class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.UserViewHolder {
      return  UserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_template, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.UserViewHolder, position: Int) {
      val currentItem = userList[position]
        holder.itemView.lt_tv_id.text = currentItem.id.toString()
        holder.itemView.lt_tv_name.text = currentItem.name
        holder.itemView.lt_tv_surname.text = currentItem.surname
        holder.itemView.lt_tv_gender.text = currentItem.gender
        holder.itemView.lt_tv_age.text = currentItem.age.toString()
    }
fun setData(user : List<UserEntity>){
    this.userList = user
    notifyDataSetChanged()
}

    override fun getItemCount(): Int {
        return userList.size
    }
}