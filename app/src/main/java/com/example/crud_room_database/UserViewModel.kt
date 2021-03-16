package com.example.crud_room_database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.crud_room_database.UserDatabase.AppDataBase
import com.example.crud_room_database.UserDatabase.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {
    val getAll: LiveData<List<UserEntity>>
    private val repository: UserRepository

    init {
        val userDao = AppDataBase.getDatabase(
            application
        ).userDao()
        repository =
            UserRepository(userDao)
        getAll = repository.getAll
    }

    fun insertAll(user: UserEntity){
        viewModelScope.launch(Dispatchers.IO){
            repository.addUser(user)
        }
    }
}