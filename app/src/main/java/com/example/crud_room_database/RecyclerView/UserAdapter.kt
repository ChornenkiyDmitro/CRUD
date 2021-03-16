package com.example.crud_room_database.RecyclerView


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.crud_room_database.R
import com.example.crud_room_database.UserDatabase.UserEntity
import kotlinx.android.synthetic.main.list_item.view.*


class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var userList = emptyList<UserEntity>()

    class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(user: UserEntity){
            with(itemView){
                tvUserId.text = user.id.toString()
                tvUserName.text = user.name
                tvUserSurname.text = user.surname
                tvUserGender.text = user.gender
                tvUserAge.text = user.age.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.UserViewHolder {
      return  UserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
      holder.bind(userList[position])
    }
fun setData(user : List<UserEntity>){
    this.userList = user
    notifyDataSetChanged()
}

    override fun getItemCount(): Int {
        return userList.size
    }
}