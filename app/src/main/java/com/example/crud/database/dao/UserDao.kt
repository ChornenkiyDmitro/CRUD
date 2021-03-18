package com.example.crud.database.dao

import androidx.room.*
import com.example.crud.database.entity.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM users WHERE id LIKE :id")
    fun findById(id: Int): UserEntity

    @Query("SELECT * FROM users")
    fun getAll(): List<UserEntity>

    @Query("DELETE FROM users WHERE id LIKE :id")
    fun deleteById(id: Int)

    @Query("DELETE FROM users ")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg user: UserEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateUser(vararg users: UserEntity)

}