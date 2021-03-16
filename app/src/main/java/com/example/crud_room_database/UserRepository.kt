package com.example.crud_room_database

import androidx.lifecycle.LiveData
import com.example.crud_room_database.UserDatabase.UserDao
import com.example.crud_room_database.UserDatabase.UserEntity

class UserRepository(private val userDao: UserDao) {

    val getAll: LiveData<List<UserEntity>> = userDao.getAll()

    suspend fun addUser(user: UserEntity) {
        userDao.insertAll(user)
    }
}