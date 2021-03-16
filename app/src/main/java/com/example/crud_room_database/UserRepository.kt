package com.example.crud_room_database

import com.example.crud_room_database.UserDatabase.UserDao
import com.example.crud_room_database.UserDatabase.UserEntity

//Todo AppDataBase
class UserRepository(private val userDao: UserDao) {

    fun addUser(user: UserEntity) = userDao.insertAll(user)

    fun getAllUser(): List<UserEntity> = userDao.getAll()
}