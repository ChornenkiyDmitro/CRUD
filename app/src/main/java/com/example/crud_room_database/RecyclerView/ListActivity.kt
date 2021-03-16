package com.example.crud_room_database.RecyclerView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.crud_room_database.R
import com.example.crud_room_database.UserViewModel

class ListActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)


        val adapter = RecyclerAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.userRecyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        userViewModel.getAll.observe(this, Observer { user ->
            adapter.setData(user)
        })

    }
}