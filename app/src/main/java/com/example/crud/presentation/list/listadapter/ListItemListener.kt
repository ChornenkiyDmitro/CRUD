package com.example.crud.presentation.list.listadapter

import com.example.crud.database.entity.UserEntity

interface ListItemListener {
    fun onUserClick(user: UserEntity)
    fun onUserLongClick(user: UserEntity, position: Int)
}