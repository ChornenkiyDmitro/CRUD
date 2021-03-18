package com.example.crud.database.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 1,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "surname")
    val surname: String,

    @ColumnInfo(name = "gender")
    val gender: String,

    @ColumnInfo(name = "age")
    val age: Int

)