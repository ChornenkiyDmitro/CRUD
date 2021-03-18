package com.example.crud

import android.app.Application
import androidx.room.Room
import com.example.crud.database.AppDataBase
import com.example.crud.database.entity.UserEntity

class CRUDApplication : Application() {

    private var crudDatabase: AppDataBase? = null

    override fun onCreate() {
        super.onCreate()
        initDataBase()
    }

    fun getDataBase() = this.crudDatabase

    private fun initDataBase() {
        crudDatabase = Room.databaseBuilder(this, AppDataBase::class.java, "crud_database")
            .allowMainThreadQueries()
            .build()
    }
}