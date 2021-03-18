package com.example.crud.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.crud.database.dao.UserDao
import com.example.crud.database.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun userDao(): UserDao
}