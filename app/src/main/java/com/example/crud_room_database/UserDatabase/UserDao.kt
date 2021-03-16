package com.example.crud_room_database.UserDatabase

import android.os.FileObserver.DELETE
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Query("SELECT * FROM users WHERE id LIKE :id")
    fun findById(id: Int): UserEntity

    @Query("SELECT * FROM users ORDER BY id ASC")
    fun getAll(): List<UserEntity>

    @Query("DELETE FROM users WHERE id LIKE :id")
    fun deleteById(id: Int)

    @Query("DELETE FROM users ")
    fun deleteAll()

    @Insert
    fun insertAll(vararg user: UserEntity)

    @Update
    fun updateUser(vararg users : UserEntity)

}